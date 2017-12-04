package text.bwie.mabiao.kuangjia.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.adapter.ReMenAdapter;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

/**
 * Created by mabiao on 2017/11/28.
 */

public class Fragments1 extends BaseFragment{

    private XRecyclerView mXrecy;

    @Override
    public BasePresenter initpresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragments1;
    }

    @Override
    protected void initView(View view) {
        mXrecy = view.findViewById(R.id.xrecy);
        mXrecy.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }
    @Override
    protected void initData() {
        ReMenAdapter reMenAdapter=new ReMenAdapter(getActivity());
      mXrecy.setLayoutManager(new LinearLayoutManager(getActivity()));
      mXrecy.setAdapter(reMenAdapter);

    }
}
