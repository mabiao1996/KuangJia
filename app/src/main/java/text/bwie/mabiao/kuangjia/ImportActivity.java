package text.bwie.mabiao.kuangjia;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.myretrofit.BaseRequest;
import text.bwie.mabiao.kuangjia.presenter.LoginPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.LoginView;

public class ImportActivity extends BaseActivity implements View.OnClickListener, LoginView {


    private TextView mZhuCe;
    private EditText mZhangHao;
    private EditText mMiMa;
    private LoginPresenter loginPresenter;
    private LinearLayout mLogin;
    private ImageView mTui;
    private TextView mW;
    private SPutils sp;

    @Override
    public BasePresenter initPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }

    @Override
    public int getLayouid() {
        return R.layout.activity_import;
    }

    @Override
    public void init(Bundle savedInstanceState) {
    }

    /**
     * -----------------------------------获取控件-------------------------------------------------------
     */
    @Override
    public void initView() {
        mZhuCe = findViewById(R.id.tv_zhuce);
        mZhuCe.setOnClickListener(this);
        mZhangHao = findViewById(R.id.ed_zhanghao);
        mMiMa = findViewById(R.id.ed_mima);
        mLogin = findViewById(R.id.ll_x);
        mLogin.setOnClickListener(this);
        mTui = findViewById(R.id.img_tui);
        mTui.setOnClickListener(this);
        mW = findViewById(R.id.tv_w);
        mW.setOnClickListener(this);
        sp = new SPutils("msg");
    }
    @Override
    public void initData() {
    }
    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tv_zhuce:
                startActivitys(RegisterActivity.class,null);
                break;
            case R.id.ll_x:
                loginPresenter.login(ImportActivity.this,mZhangHao.getText().toString().trim(),mMiMa.getText().toString().trim());
                break;
            case R.id.img_tui:
                finish();
                break;
            case R.id.tv_w:
                 startActivitys(ForgetActivity.class,null);
                break;
        }
    }

    /**
     * --------------------------------登录返回数据----------------------------------------------------------
     */
    @Override
    public void showLoading() {
    }
    @Override
    public void hideLoading() {
    }
    @Override
    public void showFailure(String msg) {
        System.out.println("showFailure------------------------"+msg);
    }
    @SuppressLint("CommitPrefEdits")
    @Override
    public void success(String msg,int uid,String token) {
        System.out.println("success------------------------"+msg);
       sp.putInt("uid",uid);
       sp.putSting("token",token);
        startActivitys(RecommendActivity.class,null);
    }

    @Override
    public void fialure(String msg) {
        System.out.println("fialure------------------------"+msg);
        Toast.makeText(ImportActivity.this,"账号或密码输入错误",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void huoqu(HuoQuBean bean) {

    }
}
