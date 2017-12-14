package text.bwie.mabiao.kuangjia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;

/**
 * Created by mabiao on 2017/11/27.
 */

public class Fragment3 extends BaseFragment implements View.OnClickListener {


    private LinearLayout mLReMen;
    private TextView mReMen;
    private View mVRemen;
    private LinearLayout mLFuJin;
    private TextView mFuJin;
    private View mVFuJin;
    private FragmentVideo1 f1;
    private FragmentVideo2 f2;

    @Override
    public BasePresenter initpresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment3;
    }
    @Override
    protected void initView(View view) {
        mLReMen = view.findViewById(R.id.video_ll_remen);
        mReMen = view.findViewById(R.id.video_remen);
        mVRemen = view.findViewById(R.id.video_v_remen);
        mLFuJin = view.findViewById(R.id.video_ll_fujin);
        mFuJin = view.findViewById(R.id.video_fujin);
        mVFuJin = view.findViewById(R.id.video_v_fujin);
        mLReMen.setOnClickListener(this);
        mLFuJin.setOnClickListener(this);
        f1 = new FragmentVideo1();
        f2 = new FragmentVideo2();
        mReMen.setTextColor(getResources().getColor(R.color.colorXuanZi));
        mVRemen.setVisibility(View.VISIBLE);
       getChildFragmentManager().beginTransaction().add(R.id.video_re, f1).commit();
        getChildFragmentManager().beginTransaction().add(R.id.video_re, f2).commit();
       getChildFragmentManager().beginTransaction().show(f1).commit();
        getChildFragmentManager().beginTransaction().hide(f2).commit();

    }
    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.video_ll_remen:
                mReMen.setTextColor(getResources().getColor(R.color.colorXuanZi));
                mVRemen.setVisibility(View.VISIBLE);
                mFuJin.setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mVFuJin.setVisibility(View.INVISIBLE);
                getChildFragmentManager().beginTransaction().show(f1).commit();
                getChildFragmentManager().beginTransaction().hide(f2).commit();
                break;
            case R.id.video_ll_fujin:
                mFuJin.setTextColor(getResources().getColor(R.color.colorXuanZi));
                mVFuJin.setVisibility(View.VISIBLE);
                mReMen .setTextColor(getResources().getColor(R.color.colorWeiXuan));
                mVRemen.setVisibility(View.INVISIBLE);
                getChildFragmentManager().beginTransaction().show(f2).commit();
                getChildFragmentManager().beginTransaction().hide(f1).commit();
                break;
        }
    }
}
