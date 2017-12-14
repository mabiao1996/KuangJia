package text.bwie.mabiao.kuangjia.fragment;

import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.adapter.VideoReMenadapter;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.bean.LunBoTuBean;
import text.bwie.mabiao.kuangjia.bean.RemenVidwoBean;
import text.bwie.mabiao.kuangjia.bean.ShiPinBean;
import text.bwie.mabiao.kuangjia.presenter.LunBoPresenter;
import text.bwie.mabiao.kuangjia.presenter.RemenVideoPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.LunBoView;
import text.bwie.mabiao.kuangjia.view.ReMenVideoView;

/**
 * Created by mabiao on 2017/12/13.
 */

public class FragmentVideo1 extends BaseFragment implements XRecyclerView.LoadingListener, ReMenVideoView {

    private XRecyclerView mXrv;
    private int s=1;
    private List<RemenVidwoBean.DataBean> list;
    private VideoReMenadapter videoReMenadapter;
    private RemenVideoPresenter remenVideoPresenter;
    @Override
    public BasePresenter initpresenter() {
        remenVideoPresenter = new RemenVideoPresenter(this);
        return remenVideoPresenter;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragmentvideo1;
    }
    @Override
    protected void initView(View view) {
        mXrv = view.findViewById(R.id.fragment1_xrv);
        list = new ArrayList<>();
        mXrv.setLoadingListener(this);
    }
    @Override
    protected void initData() {
        remenVideoPresenter.RemenSHipin(s+"");
    }

    /**
     * 上拉下拉
     */
    @Override
    public void onRefresh() {
   if(list!=null){
       list.clear();
       s=1;
       initData();
   }
   stop();
    }
    @Override
    public void onLoadMore() {
          s++;
          initData();
          stop();
    }
    public void stop(){
        mXrv.refreshComplete();
        mXrv.loadMoreComplete();
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
    public void RemenChengGong(RemenVidwoBean remenVidwoBean) {
        List<RemenVidwoBean.DataBean> data = remenVidwoBean.data;
        list.addAll(data);
        if(videoReMenadapter==null){
            videoReMenadapter = new VideoReMenadapter(getActivity(),list);
            mXrv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            mXrv.setAdapter(videoReMenadapter);
        }else{
            videoReMenadapter.notifyDataSetChanged();
        }

    }

    @Override
    public void RemenShiBai(Throwable throwable) {

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
}
