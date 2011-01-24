package models.exceptions;
import play.exceptions.PlayException;

public class WrongCredentials extends PlayException {
    public String getErrorTitle(){
        return "wrong credentials";
    }

    public String getErrorDescription(){
        return "wrong credentials";
    }
}
