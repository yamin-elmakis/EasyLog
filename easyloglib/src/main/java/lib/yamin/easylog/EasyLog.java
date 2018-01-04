package lib.yamin.easylog;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * uses the log version with Throwable to use the printlns function for long messages
 *
 * accept Object so if the showLogs = false it won't waist a toString() on a complex Object
 */
public class EasyLog {
    private static String tag = "EasyLog";
    private static String defaultText = "Here";
    private static boolean showLogs = false;
    private static int CLASS_LEVEL = 5;
    private static EasyLogFormatter formatter = new DefaultFormatter();

    public static void showLogs(boolean debug) {
        showLogs = debug;
    }

    public static void setTag(String pTag) {
        tag = pTag;
    }

    public static void setFormatter(EasyLogFormatter logFormatter) {
        formatter = logFormatter;
    }

    public static String getDefaultText() {
        return defaultText;
    }

    public static void setDefaultText(String defaultText) {
        EasyLog.defaultText = defaultText;
    }

    public static void v() {
        if (showLogs) {
            logV(defaultText, null);
        }
    }

    public static void v(Object msg) {
        if (showLogs) {
            logV(msg == null ? "null" : msg.toString(), null);
        }
    }

    public static void v(Object msg, Throwable throwable) {
        if (showLogs) {
            logV(msg == null ? "null" : msg.toString(), throwable);
        }
    }

    public static void v(@NonNull Throwable throwable) {
        if (showLogs) {
            logV(throwable.getMessage(), throwable);
        }
    }

    private static void logV(String msg, @Nullable Throwable throwable) {
        String log = getPath() + msg;
        Log.v(tag, log, throwable);
    }

    public static void d() {
        if (showLogs) {
            logD(defaultText, null);
        }
    }

    public static void d(Object msg) {
        if (showLogs) {
            logD(msg == null ? "null" : msg.toString(), null);
        }
    }

    public static void d(Object msg, Throwable throwable) {
        if (showLogs) {
            logD(msg == null ? "null" : msg.toString(), throwable);
        }
    }

    public static void d(@NonNull Throwable throwable) {
        if (showLogs) {
            logD(throwable.getMessage(), throwable);
        }
    }

    private static void logD(String msg, @Nullable Throwable throwable) {
        String log = getPath() + msg;
        Log.d(tag, log, throwable);
    }

    public static void i() {
        if (showLogs) {
            logI(defaultText, null);
        }
    }

    public static void i(Object msg) {
        if (showLogs) {
            logI(msg == null ? "null" : msg.toString(), null);
        }
    }

    public static void i(Object msg, Throwable throwable) {
        if (showLogs) {
            logI(msg == null ? "null" : msg.toString(), throwable);
        }
    }

    public static void i(@NonNull Throwable throwable) {
        if (showLogs) {
            logI(throwable.getMessage(), throwable);
        }
    }

    private static void logI(String msg, @Nullable Throwable throwable) {
        String log = getPath() + msg;
        Log.i(tag, log, throwable);
    }

    public static void w() {
        if (showLogs) {
            logW(defaultText, null);
        }
    }

    public static void w(Object msg) {
        if (showLogs) {
            logW(msg == null ? "null" : msg.toString(), null);
        }
    }

    public static void w(Object msg, Throwable throwable) {
        if (showLogs) {
            logW(msg == null ? "null" : msg.toString(), throwable);
        }
    }

    public static void w(@NonNull Throwable throwable) {
        if (showLogs) {
            logW(throwable.getMessage(), throwable);
        }
    }

    private static void logW(String msg, @Nullable Throwable throwable) {
        String log = getPath() + msg;
        Log.w(tag, log, throwable);
    }

    public static void e() {
        if (showLogs) {
            logE(defaultText, null);
        }
    }

    public static void e(Object msg) {
        if (showLogs) {
            logE(msg == null ? "null" : msg.toString(), null);
        }
    }

    public static void e(Object msg, Throwable throwable) {
        if (showLogs) {
            logE(msg == null ? "null" : msg.toString(), throwable);
        }
    }

    public static void e(@NonNull Throwable throwable) {
        if (showLogs) {
            logE(throwable.getMessage(), throwable);
        }
    }

    private static void logE(String msg, @Nullable Throwable throwable) {
        String log = getPath() + msg;
        Log.e(tag, log, throwable);
    }

    private static String getPath() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length <= CLASS_LEVEL)
            return "";

        StackTraceElement element = stackTrace[CLASS_LEVEL];

        String fullClassName = element.getClassName();
        String[] split = fullClassName.split("\\.");
        String simpleClassName = split[split.length - 1];

        return formatter.format(simpleClassName, element.getMethodName(), element.getLineNumber());
    }
}