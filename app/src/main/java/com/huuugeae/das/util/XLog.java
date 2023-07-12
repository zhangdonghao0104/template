package com.huuugeae.das.util;

import android.util.Log;


public class XLog {
    private static boolean isLogEnable = true;
    private static boolean isWriteLog = true;

    private static Object obj = new Object();

    private long fileSize = 100000;//日志文件的大小，默认0.1M

    private static String tag = "smart-recyclable---->";

    public static void debug(boolean isEnable) {
        debug(tag, isEnable);
    }
    //文件名称

    //文件路径

    public static void debug(String logTag, boolean isEnable) {
        tag = logTag;
        isLogEnable = isEnable;
    }

    public static void v(String msg) {
        v(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isLogEnable) Log.v(tag, msg);
        if (isWriteLog) writeLogFile(msg);
    }

    public static void d(String msg) {
        d(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isLogEnable) Log.d(tag, msg);
        if (isWriteLog) writeLogFile(msg);
    }

    public static void i(String msg) {
        i(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (isLogEnable) Log.i(tag, msg);
        if (isWriteLog) writeLogFile(msg);
    }

    public static void w(String msg) {
        w(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (isLogEnable) Log.w(tag, msg);
        if (isWriteLog) writeLogFile(msg);
    }

    public static void e(String msg) {
        e(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isLogEnable) Log.e(tag, msg);
        if (isWriteLog) writeLogFile(msg);
    }

    public static void printStackTrace(Throwable t) {
        if (isLogEnable && t != null) t.printStackTrace();
    }

    public static void writeLogFile(String msg) {
//        synchronized (obj) {
//            try {
//                File file = new File(filePath, fileName);
//                FileWriter fw = null;
//                if (file.exists()) {
//                    if (file.length() >10000)
//                        fw = new FileWriter(file, false);
//                    else
//                        fw = new FileWriter(file, true);
//                } else
//                    fw = new FileWriter(file, false);
//
//                Date d = new Date();
//                SimpleDateFormat s = new SimpleDateFormat("MM-dd HH:mm:ss SSS");
//                String dateStr = s.format(d);
//
//                fw.write(String.format("[%s] %s", dateStr, msg));
//                fw.write(13);
//                fw.write(10);
//                fw.flush();
//                fw.close();
//            } catch (Throwable ex) {
//                ex.printStackTrace();
//            }
//        }
    }
}