package com.xyh.holdon.utils;

        import android.content.Context;
        import android.content.SharedPreferences;

/**
 * Created by xyh on 2017/3/10.
 */

public class SharedPreUtil {

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key, value).commit();
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defValue);
    }

    public static void setString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key, value).commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defValue);
    }

    public static void setInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(key, value).commit();
    }
}
