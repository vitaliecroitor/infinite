package md.vcroitor.licenta.client.helper;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Vitalie Croitor
 * Date: 5/4/13
 * Time: 5:15 PM
 */
public class Logger {

    private static final StringBuffer buf = new StringBuffer();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
    public static String TAG = "unu";
    public boolean DEBUG = true;
    private boolean android;
    private Class<?> clazz = null;

    public Logger() {
        this(true);
    }

    public Logger(Class<?> class1) {
        this(true);
        clazz = class1;
    }

    public Logger(String tag) {
        this(true, tag);
    }

    public Logger(boolean android) {
        this.android = android;
    }

    public Logger(boolean android, String tag) {
        this.android = android;
        TAG = tag;
    }

    public void v(Class<?> clazz, String... text) {
        if (!DEBUG) {
            return;
        }
        if (android) {
            Log.w(TAG, prepareLog(clazz, text));
        } else {
            System.out.println(prepareLog(clazz, text));
        }

    }

    public void v(String... text) {
        if (!DEBUG) {
            return;
        }

        v(clazz, text);
    }

    public void i(Class<?> clazz, String... text) {
        if (!DEBUG) {
            return;
        }
        if (android) {
            Log.i(TAG, prepareLog(clazz, text));
        } else {
            System.out.println(prepareLog(clazz, text));
        }
    }

    public void i(String... text) {
        if (!DEBUG) {
            return;
        }
        i(clazz, text);
    }

    public void d(Class<?> clazz, String... text) {
        if (!DEBUG) {
            return;
        }
        d(clazz, false, text);
    }

    public void d(String... text) {
        if (!DEBUG) {
            return;
        }
        d(clazz, text);
    }

    /**
     * @param clazz
     * @param showTime
     * @param text
     */
    public void d(Class<?> clazz, boolean showTime, String... text) {
        if (!DEBUG) {
            return;
        }
        if (showTime) {
            String log = prepareLog(clazz, text);
            if (android) {
                Log.d(TAG, prepareLog(clazz, dateFormat.format(new Date()), "|", log));
            } else {
                System.out.println(prepareLog(clazz, dateFormat.format(new Date()), "|", log));
            }
        } else {
            if (android) {
                Log.d(TAG, prepareLog(clazz, text));
            } else {
                String log = prepareLog(clazz, text);
                System.out.println(log);
            }
        }
    }

    public void d(boolean showTime, String... text) {
        if (!DEBUG) {
            return;
        }
        d(clazz, showTime, text);
    }

    public void w(Class<?> clazz, String... text) {
        if (!DEBUG) {
            return;
        }
        if (android) {
            Log.w(TAG, prepareLog(clazz, text));
        } else {
            System.out.println(prepareLog(clazz, text));
        }
    }

    public void w(String... text) {
        if (!DEBUG) {
            return;
        }
        w(clazz, text);
    }

    public void e(Class<?> clazz, String... text) {
        if (!DEBUG) {
            return;
        }
        if (android) {
            Log.e(TAG, prepareLog(clazz, text));
        } else {
            System.err.println(prepareLog(clazz, text));
        }
    }

    public void e(String... text) {
        if (!DEBUG) {
            return;
        }
        e(clazz, text);
    }

    public void e(Class<?> clazz, Throwable e, String... text) {
        if (!DEBUG) {
            return;
        }
        if (android) {
            Log.e(TAG, prepareLog(clazz, text), e);
        } else {
            System.err.println(prepareLog(clazz, text));
        }
    }

    public void e(Throwable e, String... text) {
        if (!DEBUG) {
            return;
        }
        e(clazz, e, text);
    }

    public String prepareLog(Class<?> clazz, String... text) {

        buf.setLength(0);
        if (clazz != null) {
            buf.append(clazz.getSimpleName()).append("| ");
        }
        for (int i = 0; i < text.length; i++) {
            buf.append(text[i]);
        }
        return buf.toString();
    }

    public boolean isAndroid() {

        return android;
    }

    public void setAndroid(boolean android) {
        this.android = android;
    }
}
