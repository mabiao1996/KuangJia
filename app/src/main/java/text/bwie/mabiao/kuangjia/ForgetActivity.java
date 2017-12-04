package text.bwie.mabiao.kuangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

public class ForgetActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout mXiaYiBu;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayouid() {
        return R.layout.activity_forget;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }
    @Override
    public void initView() {
        mXiaYiBu = findViewById(R.id.ll_xiayibu);
        mXiaYiBu.setOnClickListener(this);

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
            case R.id.ll_xiayibu:
                startActivitys(GengGaiActivity.class,null);
                break;
        }
    }
}
