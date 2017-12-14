package text.bwie.mabiao.kuangjia.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.adapter.ReMenAdapter;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.bean.LunBoTuBean;
import text.bwie.mabiao.kuangjia.bean.ShiPinBean;
import text.bwie.mabiao.kuangjia.presenter.LoginPresenter;
import text.bwie.mabiao.kuangjia.presenter.LunBoPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.LunBoView;

/**
 * Created by mabiao on 2017/11/28.
 */

public class Fragments1 extends BaseFragment implements LunBoView, XRecyclerView.LoadingListener {

    private XRecyclerView mXrecy;
    private List<String> list;
    private View inflate;
    private LunBoPresenter lunBoPresenter;
    private SPutils sp;
   private int s=1;
   private List<ShiPinBean.DataBean> l=new ArrayList<>();
    private ReMenAdapter reMenAdapter;
    private int uid;

    @Override
    public BasePresenter initpresenter() {
        lunBoPresenter = new LunBoPresenter(this);
        return lunBoPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragments1;
    }

    @Override
    protected void initView(View view) {
        list=new ArrayList<>();
        mXrecy = view.findViewById(R.id.xrecy);
        mXrecy.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.lunbotu_item, null);
        mXrecy.addHeaderView(inflate);
        mXrecy.setLoadingListener(this);
        sp = new SPutils("msg");

    }
    @Override
    protected void initData() {
        lunBoPresenter.getLunBo();
        uid = sp.getInt("uid", 0);
        lunBoPresenter.FaShiPin(uid +"",1+"",s+"");
    }

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
    public void onNext(LunBoTuBean lunBoTuBean) {
        List<LunBoTuBean.DataBean> data = lunBoTuBean.data;
        for (LunBoTuBean.DataBean datum : data) {
            list.add(datum.icon);
        }
        XBanner mXbanner = inflate.findViewById(R.id.xbanner);
        mXbanner.setData(list,null);
        mXbanner.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(list.get(position)).into((ImageView) view);
            }
        });

    }
    @Override
    public void onError(Throwable throwable) {
    }

    @Override
    public void shipinchenggong(ShiPinBean shiPinBean) {
        List<ShiPinBean.DataBean> data = shiPinBean.data;
        l.addAll(data);
       if(reMenAdapter==null){
           reMenAdapter = new ReMenAdapter(getActivity(),l);
           mXrecy.setLayoutManager(new LinearLayoutManager(getActivity()));
           mXrecy.setAdapter(reMenAdapter);
       
       }else{
           reMenAdapter.notifyDataSetChanged();
       }
    }
    @Override
    public void shipinshibai(Throwable throwable) {
        getToast("失败");
    }

    @Override
    public void success(String msg, int uid, String token) {

    }
    @Override
    public void fialure(String msg) {

    }

    @Override
    public void huoqu(HuoQuBean bean) {

    }

    @Override
    public void onRefresh() {
        s=1;
        if(l!=null){
            l.clear();
            lunBoPresenter.FaShiPin(uid+"",1+"",s+"");
        }
        stop();
    }
    @Override
    public void onLoadMore() {
        s++;
        lunBoPresenter.FaShiPin(uid+"",1+"",s+"");
      stop();
    }
    public void stop(){
        mXrecy.refreshComplete();
        mXrecy.loadMoreComplete();
    }
}
