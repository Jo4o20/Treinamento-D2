package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class LogicaServidor {

public static final int TIMEOUT = 300;

/**
 *
 * @param x
 *
 * @author João Gabriel De Lima Castro
 * @since 14/10/2024, 09:32:18
 *
 */
public static Var ConverterDecimal(@ParamMetaData(description = "x", id = "cae7aed8") Var x) throws Exception {
 return new Callable<Var>() {

   private Var i = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var j_start = Var.VAR_NULL;
   private Var j_end = Var.VAR_NULL;
   private Var j_inc = Var.VAR_NULL;
   private Var mapaRomano = Var.VAR_NULL;

   public Var call() throws Exception {
    resposta =
    Var.valueOf(0);
    mapaRomano =
    cronapi.map.Operations.createObjectMapWith(Var.valueOf("I",
    Var.valueOf(1)) , Var.valueOf("V",
    Var.valueOf(5)) , Var.valueOf("X",
    Var.valueOf(10)) , Var.valueOf("L",
    Var.valueOf(50)) , Var.valueOf("C",
    Var.valueOf(100)) , Var.valueOf("D",
    Var.valueOf(500)) , Var.valueOf("M",
    Var.valueOf(1000)));
    j_start =
    Var.valueOf(1);
    j_end =
    Var.valueOf(x.length());
    j_inc =
    Var.valueOf(1);
    if (j_start.greaterThan(j_end)) {
        j_inc.multiply(-1);
    }
    for (j = Var.valueOf(j_start);
        j_inc.getObjectAsInt() >= 0 ? j.getObjectAsLong() <= j_end.getObjectAsLong() : j.getObjectAsLong()  >= j_end.getObjectAsLong();
    j.inc(j_inc))  {
        if (
        Var.valueOf(
        Var.valueOf(i.compareTo((
        cronapi.math.Operations.subtract(
        Var.valueOf(x.length()),
        Var.valueOf(1)))) < 0).getObjectAsBoolean() &&
        Var.valueOf(
        cronapi.map.Operations.getMapField(mapaRomano,
        Var.valueOf(cronapi.text.Operations.getLetter(x,j))).compareTo(
        cronapi.map.Operations.getMapField(mapaRomano,
        Var.valueOf(cronapi.text.Operations.getLetter(x,(
        cronapi.math.Operations.sum(j,
        Var.valueOf(1))))))) < 0).getObjectAsBoolean()).getObjectAsBoolean()) {
            resposta =
            cronapi.math.Operations.subtract(resposta,
            cronapi.map.Operations.getMapField(mapaRomano,
            Var.valueOf(cronapi.text.Operations.getLetter(x,j))));
        } else {
            resposta =
            cronapi.math.Operations.sum(resposta,
            cronapi.map.Operations.getMapField(mapaRomano,
            Var.valueOf(cronapi.text.Operations.getLetter(x,j))));
        }
    } // end for
    return resposta;
   }
 }.call();
}

/**
 *
 * @param entrada
 *
 * @author João Gabriel De Lima Castro
 * @since 14/10/2024, 09:32:18
 *
 */
public static Var Executar(@ParamMetaData(description = "entrada", id = "09664cea") Var entrada) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
Var.valueOf(ConverterDecimal(entrada));
   }
 }.call();
}

/**
 *
 * @param x
 *
 * @author João Gabriel De Lima Castro
 * @since 14/10/2024, 09:32:18
 *
 */
public static Var Two_Sum(@ParamMetaData(description = "x", id = "c276f600") Var x) throws Exception {
 return new Callable<Var>() {

   private Var i = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_end = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;
   private Var lista = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var j_start = Var.VAR_NULL;
   private Var j_end = Var.VAR_NULL;
   private Var j_inc = Var.VAR_NULL;

   public Var call() throws Exception {
    lista =
    cronapi.list.Operations.getListFromText(
    Var.valueOf("2,7,11,15"),
    Var.valueOf(","));
    resposta =
    Var.valueOf("-1");
    i_start =
    Var.valueOf(1);
    i_end =
    cronapi.list.Operations.size(lista);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        j_start =
        Var.valueOf(2);
        j_end =
        cronapi.list.Operations.size(lista);
        j_inc =
        Var.valueOf(1);
        if (j_start.greaterThan(j_end)) {
            j_inc.multiply(-1);
        }
        for (j = Var.valueOf(j_start);
            j_inc.getObjectAsInt() >= 0 ? j.getObjectAsLong() <= j_end.getObjectAsLong() : j.getObjectAsLong()  >= j_end.getObjectAsLong();
        j.inc(j_inc))  {
            if (
            Var.valueOf(x.equals((
            cronapi.math.Operations.sum(
            cronapi.list.Operations.get(lista, i),
            cronapi.list.Operations.get(lista, j))))).getObjectAsBoolean()) {
                resposta =
                Var.valueOf(
                Var.valueOf("[").getObjectAsString() +
                i.getObjectAsString() +
                Var.valueOf(",").getObjectAsString() +
                j.getObjectAsString() +
                Var.valueOf("]").getObjectAsString());
            }
        } // end for
    } // end for
    return resposta;
   }
 }.call();
}

/**
 *
 * @param x
 *
 * @author João Gabriel De Lima Castro
 * @since 14/10/2024, 09:32:18
 *
 */
public static Var converteRomano(@ParamMetaData(description = "x", id = "8ace8cc3") Var x) throws Exception {
 return new Callable<Var>() {

   private Var entrada = Var.VAR_NULL;
   private Var stringReversa = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_end = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var lista = Var.VAR_NULL;
   private Var resposta = Var.VAR_NULL;
   private Var j = Var.VAR_NULL;
   private Var j_start = Var.VAR_NULL;
   private Var j_end = Var.VAR_NULL;
   private Var j_inc = Var.VAR_NULL;

   public Var call() throws Exception {
    return resposta;
   }
 }.call();
}

/**
 *
 * @param x
 *
 * @author João Gabriel De Lima Castro
 * @since 14/10/2024, 09:32:18
 *
 */
public static Var ispalindrome(@ParamMetaData(description = "x", id = "59f70238") Var x) throws Exception {
 return new Callable<Var>() {

   private Var stringReversa = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_end = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    stringReversa =
    Var.valueOf("");
    i_start =
    Var.valueOf(x.length());
    i_end =
    Var.valueOf(1);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        stringReversa =
        Var.valueOf(
        stringReversa.getObjectAsString() +
        Var.valueOf(cronapi.text.Operations.getLetter(x,i)).getObjectAsString());
    } // end for
    item =
    Var.VAR_FALSE;
    if (
    Var.valueOf(x.equals(stringReversa)).getObjectAsBoolean()) {
        item =
        Var.VAR_TRUE;
    }
    return item;
   }
 }.call();
}

/**
 *
 * @param x
 *
 * @author João Gabriel De Lima Castro
 * @since 14/10/2024, 09:32:18
 *
 */
public static Var ispalindrome2(@ParamMetaData(description = "x", id = "59f70238") Var x) throws Exception {
 return new Callable<Var>() {

   private Var stringReversa = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var i_start = Var.VAR_NULL;
   private Var i_end = Var.VAR_NULL;
   private Var i_inc = Var.VAR_NULL;

   public Var call() throws Exception {
    stringReversa =
    Var.valueOf("");
    i_start =
    Var.valueOf(x.length());
    i_end =
    Var.valueOf(1);
    i_inc =
    Var.valueOf(1);
    if (i_start.greaterThan(i_end)) {
        i_inc.multiply(-1);
    }
    for (i = Var.valueOf(i_start);
        i_inc.getObjectAsInt() >= 0 ? i.getObjectAsLong() <= i_end.getObjectAsLong() : i.getObjectAsLong()  >= i_end.getObjectAsLong();
    i.inc(i_inc))  {
        stringReversa =
        Var.valueOf(
        stringReversa.getObjectAsString() +
        Var.valueOf(cronapi.text.Operations.getLetter(x,i)).getObjectAsString());
    } // end for
    if (
    Var.valueOf(x.equals(stringReversa)).getObjectAsBoolean()){
      return
    Var.VAR_TRUE;
    }
    return
Var.VAR_FALSE;
   }
 }.call();
}

}

