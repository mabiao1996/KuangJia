package text.bwie.mabiao.kuangjia.base;

import android.app.Activity;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by mabiao on 2017/11/14.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{
    public P presenter;
    public abstract P initPresenter();
    public abstract int getLayouid();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(getLayouid());
         presenter=initPresenter();
         initView();
         initData();

    }

    /**
     * 页面跳转
     * @param tClass
     * @param bundle
     */
    public  void  startActivitys(Class<?> tClass,Bundle bundle){
        Intent intent=new Intent(BaseActivity.this,tClass);
           if(bundle!=null){
               intent.putExtras(bundle);
           }
           startActivity(intent);
    }
    //防止内存泄漏
    private boolean mFlag;
    @Override
    protected void onResume() {
        super.onResume();
        //记住当前的BaseActivity
        if(mFlag){
            initData();
            mFlag=false;
        }
    }
    /**
     * 吐司
     * @param s
     */
    public void getToast(String s){
        Toast.makeText(BaseActivity.this,s,Toast.LENGTH_SHORT).show();
}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.deatach();
    }
    public abstract void initView();
    public abstract void initData();

}
