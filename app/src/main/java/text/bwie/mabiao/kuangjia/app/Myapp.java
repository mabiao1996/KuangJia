package text.bwie.mabiao.kuangjia.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.MobclickAgent;

import text.bwie.mabiao.kuangjia.base.Baselication;

import static com.igexin.sdk.GTServiceManager.context;

/**
 * Created by mabiao on 2017/11/14.
 */

public class Myapp extends Baselication {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "f8bffb44fb", false);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType. E_UM_NORMAL);
        LeakCanary.install(this);


    }
}
