package text.bwie.mabiao.kuangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {


    private EditText mZh;
    private EditText mMM;
    private ImageView mT;
    private TextView mZhuCe;
    private TextView mY;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayouid() {
        return R.layout.activity_register;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }
    @Override
    public void initView() {
        mZh = findViewById(R.id.ed_zh);
        mMM = findViewById(R.id.ed_mm);
        mT = findViewById(R.id.img_t);
        mT.setOnClickListener(this);
        mZhuCe = findViewById(R.id.tv_yy);
        mZhuCe.setOnClickListener(this);
        mY = findViewById(R.id.tv_y);
        mY.setOnClickListener(this);
        initZiTi();
    }

    /**
     * --------------------------------设置Edit里面的字体大小-----------------------------------------------
     */
    private void initZiTi() {
        // 新建一个可以添加属性的文本对象
        SpannableString ss = new SpannableString("请输入手机号");
        // 新建一个属性对象,设置文字的大小
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(15,true);
        // 附加属性到文本
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置hint
        mZh.setHint(new SpannedString(ss)); // 一定要进行转换,否则属性会消失

        // 新建一个可以添加属性的文本对象
        SpannableString sa = new SpannableString("输入大小写和数字，密码不能超过8位");
        // 新建一个属性对象,设置文字的大小
        AbsoluteSizeSpan as = new AbsoluteSizeSpan(15,true);
        // 附加属性到文本
        sa.setSpan(as, 0, sa.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置hint
        mMM.setHint(new SpannedString(sa)); // 一定要进行转换,否则属性会消失

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
            case R.id.img_t:
                finish();
                break;
            case R.id.tv_yy:
                finish();
                break;
            case R.id.tv_y:
                startActivitys(RecommendActivity.class,null);
                break;
        }
    }
}
