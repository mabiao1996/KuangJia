package text.bwie.mabiao.kuangjia.base;

import android.app.Activity;
import android.content.Intent;
import android.content.Loader;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by mabiao on 2017/11/14.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity{
    public P presenter;
    public abstract P initPresenter();
    public abstract int getLayouid();
    public abstract void init(Bundle savedInstanceState);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(getLayouid());
       if(NoTile()){
           if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
               //透明状态栏
               getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
               //透明导航栏
               getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
           }
       }

        presenter=initPresenter();
         initView();
         initData();
        init(savedInstanceState);
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
        if(presenter!=null){
            presenter.deatach();
        }
    }
    public abstract void initView();
    public abstract void initData();
    protected abstract boolean NoTile();

}
