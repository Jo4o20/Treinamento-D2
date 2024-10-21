package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class PeriodoControl {

public static final int TIMEOUT = 300;

/**
 *
 * @param Periodo<app.entity.Periodo>
 *
 * @author João Gabriel De Lima Castro
 * @since 16/10/2024, 09:43:34
 *
 */
public static void beforeInsert(@ParamMetaData(description = "Periodo", id = "5bbe2dcd") Var Periodo) throws Exception {
  new Callable<Var>() {

   private Var periodoGerado = Var.VAR_NULL;
   private Var cosultaPeriodo = Var.VAR_NULL;
   private Var periodoAtivo = Var.VAR_NULL;

   public Var call() throws Exception {
    if (
    Var.valueOf(!
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("datainicial"))).equals(
    cronapi.dateTime.Operations.getMonth(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("datafinal"))))).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf("O mês das datas precisa ser o mesmo para um único período"));
    }
    periodoGerado =
    Var.VAR_NULL;
    if (
    Var.valueOf(
    Var.valueOf(
    cronapi.conversion.Operations.convert(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("periodo")),
    Var.valueOf("INTEGER")).compareTo(
    Var.valueOf(1)) >= 0).getObjectAsBoolean() &&
    Var.valueOf(
    cronapi.conversion.Operations.convert(
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("periodo")),
    Var.valueOf("INTEGER")).compareTo(
    Var.valueOf(12)) <= 0).getObjectAsBoolean()).getObjectAsBoolean()) {
        periodoGerado =
        Var.valueOf(
        cronapi.object.Operations.getObjectField(Periodo,
        Var.valueOf("periodo")).getObjectAsString() +
        Var.valueOf("/").getObjectAsString() +
        cronapi.conversion.Operations.toString(
        cronapi.dateTime.Operations.getYear(
        cronapi.object.Operations.getObjectField(Periodo,
        Var.valueOf("datafinal")))).getObjectAsString());
        cronapi.database.Operations.updateField(Periodo,
        Var.valueOf("periodo"), periodoGerado);
    } else {
        cronapi.util.Operations.throwException(
        Var.valueOf("O peíodo válido é apenas entre 1 e 12"));
    }
    cosultaPeriodo =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.periodo = :periodo"),Var.valueOf("periodo",periodoGerado));
    if (
    cronapi.database.Operations.hasElement(cosultaPeriodo).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf(
        Var.valueOf("Período ").getObjectAsString() +
        periodoGerado.getObjectAsString() +
        Var.valueOf(" já existe. Tente outro.").getObjectAsString()));
    }
    periodoAtivo =
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.ativo = true"));
    if (
    Var.valueOf(
    cronapi.database.Operations.getField(periodoAtivo,
    Var.valueOf("this[0].ativo")).getObjectAsBoolean() &&
    cronapi.object.Operations.getObjectField(Periodo,
    Var.valueOf("ativo")).getObjectAsBoolean()).getObjectAsBoolean()) {
        cronapi.util.Operations.throwException(
        Var.valueOf(
        Var.valueOf("Apenas um período pode ser ativo por vez. O período ").getObjectAsString() +
        cronapi.database.Operations.getField(periodoAtivo,
        Var.valueOf("this[0].periodo")).getObjectAsString() +
        Var.valueOf(" já está ativo.").getObjectAsString()));
    }
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @author João Gabriel De Lima Castro
 * @since 16/10/2024, 09:43:34
 *
 */
public static Var verifyPeriodoAtivo() throws Exception {
 return new Callable<Var>() {

   private Var periodoAtivo = Var.VAR_NULL;
   private Var isAdmin = Var.VAR_NULL;

   public Var call() throws Exception {
    periodoAtivo =
    cronapi.database.Operations.hasElement(
    cronapi.database.Operations.query(Var.valueOf("app.entity.Periodo"),Var.valueOf("select \n	p \nfrom \n	Periodo p  \nwhere \n	p.ativo = true")));
    isAdmin =
    cronapi.util.Operations.callBlockly(Var.valueOf("blockly.UserControl:verifyAdmin"));
    return
Var.valueOf(periodoAtivo
.negate().getObjectAsBoolean() && isAdmin.getObjectAsBoolean());
   }
 }.call();
}

}

