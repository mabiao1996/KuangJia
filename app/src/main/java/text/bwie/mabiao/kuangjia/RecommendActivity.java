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

import org.w3c.dom.Text;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;
import text.bwie.mabiao.kuangjia.fragment.Fragment1;
import text.bwie.mabiao.kuangjia.fragment.Fragment2;
import text.bwie.mabiao.kuangjia.fragment.Fragment3;

public class RecommendActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton mTuiJian;
    private RadioButton mDuanZi;
    private RadioButton mShiPin;
    private TextView mTitle;
    private CircleRoundImageView mXCR;
    private ImageView mBj;
    @Override
    public BasePresenter initPresenter() {
        return null;
    }
    @Override
    public int getLayouid() {
        return R.layout.activity_recommend;
    }
    @Override
    public void init(Bundle savedInstanceState) {
        initDianji();
    }

    private void initDianji() {
        mXCR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecommendActivity.this,"点击",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initView() {
        mTuiJian = findViewById(R.id.rb_tuijian);
        mDuanZi = findViewById(R.id.rb_duanzi);
        mShiPin = findViewById(R.id.rb_shipin);
        mTitle = findViewById(R.id.tv_title);
        mXCR = findViewById(R.id.img_xcr);
        mBj = findViewById(R.id.img_bj);

        mTuiJian.setOnClickListener(this);
        mDuanZi.setOnClickListener(this);
        mShiPin.setOnClickListener(this);
    }
    @Override
    public void initData() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment1()).commit();
        mTitle.setText("编辑");
        mTuiJian.setChecked(true);
        mTuiJian.setTextColor(getResources().getColor(R.color.colorXuanZi));
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
                mTuiJian.setTextColor(getResources().getColor(R.color.colorXuanZi));
                mDuanZi.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mShiPin.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                break;
            case R.id.rb_duanzi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment2()).commit();
                mTitle.setText("段子");
                mTuiJian.setChecked(false);
                mShiPin.setChecked(false);
                mDuanZi.setChecked(true);
                mDuanZi.setTextColor(getResources().getColor(R.color.colorXuanZi));
                mTuiJian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mShiPin.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                break;
            case R.id.rb_shipin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,new Fragment3()).commit();
                mTitle.setText("视频");
                mTuiJian.setChecked(false);
                mShiPin.setChecked(true);
                mDuanZi.setChecked(false);
                mDuanZi.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mTuiJian.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mShiPin.setTextColor(getResources().getColor(R.color.colorXuanZi));
                break;
        }

    }
}
