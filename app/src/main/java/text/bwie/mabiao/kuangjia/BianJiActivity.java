package text.bwie.mabiao.kuangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

public class BianJiActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mVideo;
    private LinearLayout mBianJi;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
    @Override
    public int getLayouid() {
        return R.layout.activity_bian_ji;
    }
    @Override
    public void init(Bundle savedInstanceState) {

    }
    @Override
    public void initView() {
        mVideo = findViewById(R.id.ll_video);
        mBianJi = findViewById(R.id.ll_bianji);
        mVideo.setOnClickListener(this);
        mBianJi.setOnClickListener(this);
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
        switch (v.getId()){
            case R.id.ll_video:
                break;

            case R.id.ll_bianji:
                startActivitys(ShuRuActivity.class,null);
                break;

        }

    }
}
