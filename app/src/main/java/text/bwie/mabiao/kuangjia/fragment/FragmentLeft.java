package text.bwie.mabiao.kuangjia.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import text.bwie.mabiao.kuangjia.GuanZhuActivity;
import text.bwie.mabiao.kuangjia.LoginActivity;
import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.SheZhiActivity;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;
import text.bwie.mabiao.kuangjia.presenter.LoginPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.LoginView;

/**
 * Created by mabiao on 2017/11/28.
 */

public class FragmentLeft extends BaseFragment implements View.OnClickListener, LoginView {
    private LinearLayout mXia;
    private LinearLayout mSheZhi;
    private CircleRoundImageView mTou;
    private TextView mNiCheng;
    private SPutils sp;
    private LoginPresenter loginPresenter;
    private String token;
    private LinearLayout mGuanZhu;

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public BasePresenter initpresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.leftfragment;
    }
    /**
     * ---------------------------------------------获取控件---------------------------------------------------------
     */
    @Override
    protected void initView(View view) {
        sp = new SPutils("msg");
        mXia = view.findViewById(R.id.ll_xia);
        mSheZhi = view.findViewById(R.id.ll_shezhi);
        mXia.setOnClickListener(this);
        mSheZhi.setOnClickListener(this);
        mTou = view.findViewById(R.id.cv_tou);
        mNiCheng = view.findViewById(R.id.tv_nicheng);
        mGuanZhu = view.findViewById(R.id.left_ll_guanzhu);
        mGuanZhu.setOnClickListener(this);
        token = sp.getString("token", null);
        if(token==null){
            Glide.with(getActivity()).load(R.mipmap.weidenglu).into(mTou);
            mNiCheng.setText("请登录");
        }

    }
    /**
     *  ---------------------------------------------获取请求操作---------------------------------------------------------
     */
    @Override
    protected void initData() {
        loginPresenter = new LoginPresenter(this);
        int uid = sp.getInt("uid", 0);
        loginPresenter.huoqu(uid);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ll_xia:
                if(token==null){
                    Intent intent=new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }else{
                    Intent inten=new Intent(getActivity(), SheZhiActivity.class);
                    startActivity(inten);
                }
                break;
            case R.id.ll_shezhi:
                Intent inten=new Intent(getActivity(), SheZhiActivity.class);
                startActivity(inten);
                break;
            case R.id.left_ll_guanzhu:
                startActivitys(GuanZhuActivity.class,null);
                break;

        }
    }
    /**
     * -----------------------------------获取返回值------------------------------------
     */
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
    public void huoqu( HuoQuBean bean) {
        Glide.with(getActivity()).load(bean.data.icon).into(mTou);
        mNiCheng.setText(bean.data.nickname);
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqq"+bean.data.nickname);
    }


}
