package text.bwie.mabiao.kuangjia.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.app.Myapp;

/**
 * Created by mabiao on 2017/11/29.
 */

public class VersionUtils {
    private static int versionCode;

    public static int getVersoncode() throws PackageManager.NameNotFoundException {
        if (Myapp.context != null) {
            versionCode = Myapp.context.getPackageManager().getPackageInfo(Myapp.context.getPackageName(), 0).versionCode;
        }
        return  versionCode;
    }
}