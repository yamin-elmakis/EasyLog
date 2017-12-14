package lib.yamin.easylog;

/**
 * Created by Yamin on 13-Dec-17.
 */

public abstract class EasyLogFormatter {

    public abstract String format(String classname, String methodName, int lineNumber);
}