package lib.yamin.easylog;

/**
 * Created by Yamin on 13-Dec-17.
 */
public class DefaultFormatter extends EasyLogFormatter {

    @Override
    public String format(String classname, String methodName, int lineNumber) {
        return String.format("%s: %s(): %s => ", classname, methodName, lineNumber);
    }
}