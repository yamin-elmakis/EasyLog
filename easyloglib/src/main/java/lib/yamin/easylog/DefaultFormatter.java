package lib.yamin.easylog;

import java.util.Locale;

/**
 * Created by Yamin on 13-Dec-17.
 */
public class DefaultFormatter extends EasyLogFormatter {

    @Override
    public String format(String classname, String methodName, int lineNumber) {
        return String.format(Locale.getDefault(), "[%s][%s()][%d]=> ", classname, methodName, lineNumber);
    }
}