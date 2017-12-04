package text.bwie.mabiao.kuangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;
import text.bwie.mabiao.kuangjia.presenter.LoginPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.LoginView;

public class SheZhiActivity extends BaseActivity implements View.OnClickListener, LoginView {


    private TextView mTd;
    private SPutils sp;
    private LoginPresenter loginPresenter;
    private TextView mNicheng;
    private CircleRoundImageView mTou;
    private String token;


    @Override
    public BasePresenter initPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }

    @Override
    public int getLayouid() {
        return R.layout.activity_she_zhi;
    }
    @Override
    public void init(Bundle savedInstanceState) {
    }
    @Override
    public void initView() {
        mTd = findViewById(R.id.tv_td);
        mNicheng = findViewById(R.id.shezhi_nicheng);
        mTou = findViewById(R.id.shezhi_tou);
        mTd.setOnClickListener(this);
        sp = new SPutils("msg");
        int uid = sp.getInt("uid", 0);
        token = sp.getString("token", null);
        loginPresenter.huoqu(uid);
           if(token ==null){
               Glide.with(this).load(R.mipmap.weidenglu).into(mTou);
               mNicheng.setText("昵称");
           }
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
            case R.id.tv_td:
                sp.remover("uid");
                sp.remover("token");
                if(token==null){
                    getToast("请先登录");
                }else{
                    startActivitys(LoginActivity.class,null);
                }
                break;
        }
    }

    @Override
    public void showLoading() {
    }
    @Override
    public void hideLoading() {
    }
    @Override
    public void showFailure(String msg) {
    }
    @Override
    public void success(String msg, int uid, String token) {
    }
    @Override
    public void fialure(String msg) {
    }
    @Override
    public void huoqu(HuoQuBean bean) {
        HuoQuBean.DataBean data = bean.data;
        Glide.with(this).load(data.icon).into(mTou);
        mNicheng.setText(data.nickname);

    }
}
