package text.bwie.mabiao.kuangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import io.reactivex.annotations.NonNull;
import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView mLogin;
    private ImageView mT;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
    @Override
    public int getLayouid() {
        return R.layout.activity_login;
    }
    @Override
    public void init(Bundle savedInstanceState) {

    }
    @Override
    public void initView() {
        mLogin = findViewById(R.id.tv_login);
        mLogin.setOnClickListener(this);
        mT = findViewById(R.id.iv_t);
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
            case R.id.tv_login:
                startActivitys(ImportActivity.class, null);
                break;
            case R.id.iv_t:
                    finish();
                break;
        }
    }
}
