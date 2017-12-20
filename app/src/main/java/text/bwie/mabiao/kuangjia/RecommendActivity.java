package text.bwie.mabiao.kuangjia;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kson.slidingmenu.SlidingMenu;

import org.w3c.dom.Text;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;
import text.bwie.mabiao.kuangjia.fragment.Fragment1;
import text.bwie.mabiao.kuangjia.fragment.Fragment2;
import text.bwie.mabiao.kuangjia.fragment.Fragment3;
import text.bwie.mabiao.kuangjia.fragment.Fragment4;
import text.bwie.mabiao.kuangjia.fragment.FragmentLeft;
import text.bwie.mabiao.kuangjia.presenter.LoginPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.LoginView;

public class RecommendActivity extends BaseActivity implements View.OnClickListener, LoginView {
    private RadioButton mTuiJian;
    private RadioButton mDuanZi;
    private RadioButton mShiPin;
    private TextView mTitle;
    private CircleRoundImageView mXCR;
    private ImageView mBj;
    private SlidingMenu slidingMenu;
    private LoginPresenter loginPresenter;
    private SPutils sp;
    private RadioButton mFaXian;

    @Override
    public BasePresenter initPresenter() {
        loginPresenter = new LoginPresenter(this);
        return loginPresenter;
    }
    @Override
    public int getLayouid() {
        return R.layout.activity_recommend;
    }
    @Override
    public void init(Bundle savedInstanceState) {
        initMenu();
        initDianji();
    }

    private void initMenu() {
        slidingMenu = new SlidingMenu(this);
        //添加做菜单
        slidingMenu.setMenu(R.layout.framentleft);
         getSupportFragmentManager().beginTransaction().replace(R.id.left_fl,new FragmentLeft()).commit();
        //设置左滑动
        slidingMenu.setMode(SlidingMenu.LEFT);
        //设置滑动的屏幕范围，该设置为边缘区域都可以滑动
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        slidingMenu.setBehindOffsetRes(R.dimen.SlidingMenuRes);
        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
    }
    private void initDianji() {
        mXCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              slidingMenu.showMenu();
            }
        });
    }

    @Override
    public void initView() {
        mTuiJian = findViewById(R.id.rb_tuijian);
        mDuanZi = findViewById(R.id.rb_duanzi);
        mShiPin = findViewById(R.id.rb_shipin);
        mFaXian = findViewById(R.id.rb_faxian);
        mTitle = findViewById(R.id.tv_title);
        mXCR = findViewById(R.id.img_xcr);
        mBj = findViewById(R.id.img_bj);
        sp = new SPutils("msg");

        mBj.setOnClickListener(this);
        mTuiJian.setOnClickListener(this);
        mDuanZi.setOnClickListener(this);
        mShiPin.setOnClickListener(this);
        mFaXian.setOnClickListener(this);
        String token = sp.getString("token", null);
        if(token==null){
            Glide.with(RecommendActivity.this).load(R.mipmap.weidenglu).into(mXCR);
        }

    }
    @Override
    public void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment1()).commit();
        mTitle.setText("编辑");
        mTuiJian.setChecked(true);
        mTuiJian.setTextColor(getResources().getColor(R.color.colorXuanZi));
        int uid = sp.getInt("uid", 0);
        loginPresenter.huoqu(uid);
    }
    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_tuijian:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment1()).commit();
                mTitle.setText("编辑");
                mTuiJian.setChecked(true);
                mDuanZi.setChecked(false);
                mShiPin.setChecked(false);
                mFaXian.setChecked(false);
                mTuiJian.setTextColor(getResources().getColor(R.color.colorXuanZi));
                mDuanZi.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mShiPin.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mFaXian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                break;
            case R.id.rb_duanzi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment2()).commit();
                mTitle.setText("段子");
                mTuiJian.setChecked(false);
                mShiPin.setChecked(false);
                mDuanZi.setChecked(true);
                mFaXian.setChecked(false);
                mDuanZi.setTextColor(getResources().getColor(R.color.colorXuanZi));
                mTuiJian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mShiPin.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mFaXian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                break;
            case R.id.rb_shipin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment3()).commit();
                mTitle.setText("视频");
                mTuiJian.setChecked(false);
                mShiPin.setChecked(true);
                mDuanZi.setChecked(false);
                mFaXian.setChecked(false);
                mDuanZi.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mTuiJian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mShiPin.setTextColor(getResources().getColor(R.color.colorXuanZi));
                mFaXian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                break;
            case R.id.rb_faxian:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment4()).commit();
                mTitle.setText("发现");
                mTuiJian.setChecked(false);
                mShiPin.setChecked(false);
                mDuanZi.setChecked(false);
                mFaXian.setChecked(true);
                mDuanZi.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mTuiJian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mShiPin.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mFaXian.setTextColor(getResources().getColor(R.color.colorXuanZi));

                break;
            case R.id.img_bj:
                    startActivitys(BianJiActivity.class,null);
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
        String icon = bean.data.icon;
        Glide.with(RecommendActivity.this).load(icon).into(mXCR);
    }
}
