package text.bwie.mabiao.kuangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

public class ChengGongActivity extends BaseActivity {


    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayouid() {
        return R.layout.activity_cheng_gong;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected boolean NoTile() {
        return false;
    }
}
