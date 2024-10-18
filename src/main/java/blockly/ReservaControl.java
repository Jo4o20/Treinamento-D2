package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ReservaControl {

public static final int TIMEOUT = 300;

/**
 *
 * @param Entidade<app.entity.Reserva>
 *
 * @author João Gabriel De Lima Castro
 * @since 15/10/2024, 09:31:29
 *
 */
public static void afterDelete(@ParamMetaData(description = "Entidade", id = "4e5d7f40") Var Entidade) throws Exception {
  new Callable<Var>() {

   private Var objetoVagaReservada = Var.VAR_NULL;
   private Var statusVagaReservada = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoVagaReservada =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    statusVagaReservada =
    cronapi.database.Operations.getField(objetoVagaReservada,
    Var.valueOf("this[0].status"));
    cronapi.database.Operations.updateField(objetoVagaReservada,
    Var.valueOf("status"),
    Var.valueOf("aberto"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Entidade<app.entity.Reserva>
 *
 * @author João Gabriel De Lima Castro
 * @since 15/10/2024, 09:31:29
 *
 */
public static void afterInsert(@ParamMetaData(description = "Entidade", id = "4e5d7f40") Var Entidade) throws Exception {
  new Callable<Var>() {

   private Var objetoVagaReservada = Var.VAR_NULL;
   private Var statusVagaReservada = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoVagaReservada =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    statusVagaReservada =
    cronapi.database.Operations.getField(objetoVagaReservada,
    Var.valueOf("this[0].status"));
    cronapi.database.Operations.updateField(objetoVagaReservada,
    Var.valueOf("status"),
    Var.valueOf("fechado"));
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @param Entidade<app.entity.Reserva>
 *
 * @author João Gabriel De Lima Castro
 * @since 15/10/2024, 09:31:29
 *
 */
public static void beforeInsert(@ParamMetaData(description = "Entidade", id = "bfe7ae48") Var Entidade) throws Exception {
  new Callable<Var>() {

   private Var objetoVaga = Var.VAR_NULL;
   private Var periodosAtivos = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoVaga =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Vaga"),Var.valueOf("select \n	v \nfrom \n	Vaga v  \nwhere \n	v.id = :id"),Var.valueOf("id",
    cronapi.conversion.Operations.toString(
    cronapi.object.Operations.getObjectField(
    cronapi.object.Operations.getObjectField(Entidade,
    Var.valueOf("vaga")),
    Var.valueOf("id")))));
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(objetoVaga,
    Var.valueOf("this[0].status")).equals(
    Var.valueOf("fechado"))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Essa vaga já está sendo ocupada"));
    }
    periodosAtivos =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"));
    if (
    cronapi.database.Operations.hasElement(periodosAtivos).getObjectAsBoolean()) {
        cronapi.database.Operations.updateField(Entidade,
        Var.valueOf("periodo"),
        cronapi.database.Operations.getField(periodosAtivos, Var.valueOf("this[0].periodo")));
    } else {
        cronapi.util.Operations.throwException(
        Var.valueOf("Contate um administrador. Não é possível fazer reservas no momento."));
    }
    if (
    cronapi.list.Operations.getFirst((
    cronapi.database.Operations.query(Var.valueOf("app.entity.Reserva"),Var.valueOf("select \n	r.ativo \nfrom \n	Reserva r  \nwhere \n	r.user.normalizedUserName = :userNormalizedUserName"),Var.valueOf("userNormalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName()))))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("Você só pode reservar uma vaga por vez."));
    } else {
        cronapi.database.Operations.updateField(Entidade,
        Var.valueOf("ativo"),
        Var.VAR_TRUE);
    }
   return Var.VAR_NULL;
   }
 }.call();
}

}

