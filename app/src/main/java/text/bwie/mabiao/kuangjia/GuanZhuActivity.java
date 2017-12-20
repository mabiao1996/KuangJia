package text.bwie.mabiao.kuangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import text.bwie.mabiao.kuangjia.adapter.GuanZhuLeiBiaoAdapter;
import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.GuanZhuLIEBiaoBean;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.presenter.GuanZhuLieBiaoPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.GuanZhuLieBiaoView;

public class GuanZhuActivity extends BaseActivity implements GuanZhuLieBiaoView {

    private XRecyclerView mRecycler;
    private GuanZhuLieBiaoPresenter guanZhuLieBiaoPresenter;
    private SPutils sPutils;
    private List<GuanZhuLIEBiaoBean.DataBean> list;
    private GuanZhuLeiBiaoAdapter guanZhuLeiBiaoAdapter;

    @Override
    public BasePresenter initPresenter() {
        guanZhuLieBiaoPresenter = new GuanZhuLieBiaoPresenter(this);
        return guanZhuLieBiaoPresenter;
    }
    @Override
    public int getLayouid() {
        return R.layout.activity_guan_zhu                                            ;
    }
    @Override
    public void init(Bundle savedInstanceState) {

    }
    @Override
    public void initView() {
        mRecycler = findViewById(R.id.my_focuson_recyclerview);
        list = new ArrayList<>();
        sPutils = new SPutils("msg");
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
    @Override
    public void initData() {
        int uid = sPutils.getInt("uid", 0);
        guanZhuLieBiaoPresenter.getGuanZhu(uid+"");
    }

    @Override
    protected boolean NoTile() {
        return true;
    }
    /**
     * ----------------------------------------返回结果--------------------------------------------------
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
    public void onError(Throwable throwable) {
        getToast("登录失败请重新登录");
    }
    @Override
    public void onTokenFail() {
    getToast("登录失效请重新登录");
    }
    @Override
    public void onNext(GuanZhuLIEBiaoBean guanZhuLIEBiaoBean) {
        List<GuanZhuLIEBiaoBean.DataBean> data = guanZhuLIEBiaoBean.data;
        list.addAll(data);
        if(guanZhuLeiBiaoAdapter==null){
            guanZhuLeiBiaoAdapter = new GuanZhuLeiBiaoAdapter(GuanZhuActivity.this,list);
            mRecycler.setLayoutManager(new LinearLayoutManager(this));
            mRecycler.setAdapter(guanZhuLeiBiaoAdapter);
        }else {
            guanZhuLeiBiaoAdapter.notifyDataSetChanged();
        }
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
