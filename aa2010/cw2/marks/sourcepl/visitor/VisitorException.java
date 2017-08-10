package visitor;
import java.lang.String;

public class VisitorException extends Exception {
    public String message;
    VisitorException(String m)  { message=m; }
}