package text.bwie.mabiao.kuangjia;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.igexin.sdk.PushManager;
import com.umeng.analytics.MobclickAgent;

public class MainActivity extends AppCompatActivity {
    private int a=0;
    private int b=6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(),text.bwie.mabiao.kuangjia.service.DemoPushService.class);
     /*   int c = b/ a;
        System.out.println("sssssss"+c);*/

        // com.getui.demo.DemoIntentService 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(),text.bwie.mabiao.kuangjia.service.DemoIntentService.class);

        MobclickAgent.setDebugMode( true );
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


}
