package text.bwie.mabiao.kuangjia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

/**
 * Created by mabiao on 2017/11/27.
 */

public class Fragment1 extends BaseFragment implements View.OnClickListener {


    private LinearLayout mLRemen;
    private TextView mTvRemen;
    private View mVRemen;
    private LinearLayout mLGuanzhu;
    private TextView mTvGuanzhu;
    private View mVGuanzhu;

    @Override
    public BasePresenter initpresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment1;
    }
    /**
     *   --------------------------------------------获取控件---------------------------------------------------------------
     */
    @Override
    protected void initView(View view) {
        mLRemen = view.findViewById(R.id.ll_remen);
        mTvRemen = view.findViewById(R.id.tv_remen);
        mVRemen = view.findViewById(R.id.v_remen);
        mLGuanzhu = view.findViewById(R.id.ll_guanzhu);
        mTvGuanzhu = view.findViewById(R.id.tv_guanzhu);
        mVGuanzhu = view.findViewById(R.id.v_guanzhu);
        mLRemen.setOnClickListener(this);
        mLGuanzhu.setOnClickListener(this);
        mTvRemen.setTextColor(getResources().getColor(R.color.colorXuanZi));
        mVRemen.setVisibility(View.VISIBLE);
        getChildFragmentManager().beginTransaction().replace(R.id.fl_re,new Fragments1()).commit();


    }
    protected void initData() {

    }
    @Override
    public void onClick(View v)
    {
       switch (v.getId())
       {
           case R.id.ll_remen:
               mTvRemen.setTextColor(getResources().getColor(R.color.colorXuanZi));
               mVRemen.setVisibility(View.VISIBLE);
               mTvGuanzhu.setTextColor(getResources().getColor(R.color.colorWeiXuan));
               mVGuanzhu.setVisibility(View.INVISIBLE);
                getChildFragmentManager().beginTransaction().replace(R.id.fl_re,new Fragments1()).commit();
               break;
           case R.id.ll_guanzhu:
               mTvGuanzhu.setTextColor(getResources().getColor(R.color.colorXuanZi));
               mVGuanzhu.setVisibility(View.VISIBLE);
               mTvRemen.setTextColor(getResources().getColor(R.color.colorWeiXuan));
               mVRemen.setVisibility(View.INVISIBLE);
               getChildFragmentManager().beginTransaction().replace(R.id.fl_re,new Fragments2()).commit();
               break;
       }
    }
}
