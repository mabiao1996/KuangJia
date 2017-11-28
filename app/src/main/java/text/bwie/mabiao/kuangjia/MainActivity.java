package text.bwie.mabiao.kuangjia;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.igexin.sdk.PushManager;
import com.umeng.analytics.MobclickAgent;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.service.DemoIntentService;
import text.bwie.mabiao.kuangjia.service.DemoPushService;

public class MainActivity extends BaseActivity {

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayouid() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(),DemoPushService.class);

        // com.getui.demo.DemoIntentService 为第三方自定义的推送服务事件接收类
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(),DemoIntentService.class);


        MobclickAgent.setDebugMode( true );
    }

    @Override
    public void initView() {

h.sendEmptyMessageDelayed(1000,3000);
    }
    @Override
    public void initData() {
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
Handler h=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        int what = msg.what;
        if(what==1000){
            Intent intent=new Intent(MainActivity.this,RecommendActivity.class);
            startActivity(intent);
            finish();
        }

    }
};
    @Override
    protected void onDestroy() {
        super.onDestroy();
        h.removeCallbacksAndMessages(null);
    }
}
