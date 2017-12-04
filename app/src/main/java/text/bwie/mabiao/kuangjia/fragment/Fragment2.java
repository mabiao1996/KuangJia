package text.bwie.mabiao.kuangjia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.adapter.Fragment2Adapter;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.DuanZiBean;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;
import text.bwie.mabiao.kuangjia.presenter.DuanZiPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.DuanZiView;

/**
 * Created by mabiao on 2017/11/27.
 */

public class Fragment2 extends BaseFragment implements DuanZiView, XRecyclerView.LoadingListener {

    private XRecyclerView mXrv;
    private DuanZiPresenter duanZiPresenter;
    private SPutils sp;
    private List<DuanZiBean.DataBean> list=new ArrayList<>();
    private Fragment2Adapter ap;
    private int num=1;

    @Override
    public BasePresenter initpresenter() {
        duanZiPresenter = new DuanZiPresenter(this);
        return duanZiPresenter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment2;
    }

    @Override
    protected void initView(View view) {
        mXrv = view.findViewById(R.id.xrv);
        sp = new SPutils("msg");
        mXrv.setLoadingListener(this);
   mXrv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }
    @Override
    protected void initData() {
      duanZiPresenter.HuoQuDuanZi(num,sp.getString("token",null));
    }
    /**
     * -----------------------------------请求返回值---------------------------------------------------------------
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
    public void huoqu(HuoQuBean bean) {
    }
    @Override
    public void huoquxinxi(DuanZiBean duanZiBean) {
        List<DuanZiBean.DataBean> data = duanZiBean.data;
        list.addAll(data);
        if(ap==null){
            ap = new Fragment2Adapter(getActivity(),list);
            mXrv.setLayoutManager(new LinearLayoutManager(getActivity()));
            mXrv.setAdapter(ap);
        }else{
            ap.notifyDataSetChanged();
        }
    }

    @Override
    public void onRefresh() {
        num=1;
        if(list!=null){
            list.clear();
           initData();
        }
   stop();
    }

    private void stop(){
        mXrv.refreshComplete();
        mXrv.loadMoreComplete();
    }

    @Override
    public void onLoadMore() {
        num++;
       initData();
        stop();
    }
}
