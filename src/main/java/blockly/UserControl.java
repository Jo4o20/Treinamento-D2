package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class UserControl {

public static final int TIMEOUT = 300;

/**
 *
 * @author João Gabriel De Lima Castro
 * @since 16/10/2024, 09:28:18
 *
 */
public static Var getLoggedUserId() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;

   public Var call() throws Exception {
    lista =
    cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select \n	u.id \nfrom \n	User u  \nwhere \n	u.normalizedUserName = :normalizedUserName"),Var.valueOf("normalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));
    return
cronapi.list.Operations.getFirst(lista);
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param email
 * @param isMobile
 *
 * @author João Gabriel De Lima Castro
 * @since 16/10/2024, 09:28:18
 *
 */
public static Var resetPassword(@ParamMetaData(description = "email", id = "53fc1de9") Var email, @ParamMetaData(description = "isMobile", id = "b11110b2") Var isMobile) throws Exception {
 return new Callable<Var>() {

   private Var username = Var.VAR_NULL;
   private Var password = Var.VAR_NULL;

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.defaultResetPassword(email,
Var.valueOf("https://acesso.cronapp.io/img/header.png"),
Var.valueOf("https://acesso.cronapp.io/img/footer.png"), isMobile);
   }
 }.call();
}

/**
 *
 * Descreva esta função...
 *
 * @param username
 * @param email
 * @param password
 *
 * @author João Gabriel De Lima Castro
 * @since 16/10/2024, 09:28:18
 *
 */
public static Var signUp(@ParamMetaData(description = "username", id = "b7d52451") Var username, @ParamMetaData(description = "email", id = "36bc1157") Var email, @ParamMetaData(description = "password", id = "097625e0") Var password) throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    return
cronapi.authentication.Operations.defaultSignUp(
cronapi.map.Operations.createObjectMapWith(Var.valueOf("username",username) , Var.valueOf("name",username) , Var.valueOf("email",email) , Var.valueOf("password",password)));
   }
 }.call();
}

/**
 *
 * @author João Gabriel De Lima Castro
 * @since 16/10/2024, 09:28:18
 *
 */
public static Var verifyAdmin() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item =
    cronapi.database.Operations.query(Var.valueOf("app.entity.UserRole"),Var.valueOf("select \n	u \nfrom \n	UserRole u  \nwhere \n	u.user.normalizedUserName = :userNormalizedUserName AND \n	u.role.normalizedName = \'administrators\'"),Var.valueOf("userNormalizedUserName",
    cronapi.text.Operations.normalize(
    cronapi.util.Operations.getCurrentUserName())));
    return
cronapi.database.Operations.hasElement(item);
   }
 }.call();
}

}

