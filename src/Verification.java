public class Verification {
    public static boolean checkData(String login, String password, String confirmPassword) {
        try {
            if (checkLogAndPass(login) == true && checkLogAndPass(password) == true && checkConfPass(password, confirmPassword) == true) {
                return true;
            }
        } catch (WrongLoginException e) {
            System.out.println("login или password имеют больше 20 символов");
        } catch (WrongPasswordException e) {
            System.out.println("password и confirmPassword разные");
        }
        return false;
    }

    public static boolean checkLogAndPass(String log) {
        if (log.length() > 20) {
            throw new WrongLoginException();
        }
        if (!log.matches("[_A-Za-z0-9]+")) {
            return false;
        }
        return true;
    }
    public static boolean checkConfPass(String pass, String confPass){
        if(!pass.equals(confPass)){
            throw new WrongPasswordException();
        }
        return true;
    }
}
