package text.bwie.mabiao.kuangjia.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import java.util.List;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.adapter.Fragment4Adapter;
import text.bwie.mabiao.kuangjia.base.BaseFragment;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.GuanZhuLIEBiaoBean;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.presenter.GuanZhuLieBiaoPresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.view.GuanZhuLieBiaoView;

/**
 * Created by mabiao on 2017/12/19.
 */

public class Fragment4 extends BaseFragment implements View.OnClickListener, GuanZhuLieBiaoView {

    private Button mBut;
    private ExpandableListView mListView;

    //创建组的数组
    String group[]={"聊天","联系人"};
    //创建子对象的二维数组
    private String[][] child;
    private GuanZhuLieBiaoPresenter guanZhuLieBiaoPresenter;
    private SPutils sPutils;
    private Fragment4Adapter fragment4Adapter;
    private String[] name;


    @Override
    public BasePresenter initpresenter() {
        guanZhuLieBiaoPresenter = new GuanZhuLieBiaoPresenter(this);
        return guanZhuLieBiaoPresenter;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment4;
    }
    @Override
    protected void initView(View view) {
        mListView = view.findViewById(R.id.fragment4_list1);
        mBut = view.findViewById(R.id.fragment4_but);
        mBut.setOnClickListener(this);
        sPutils = new SPutils("msg");
    }
    @Override
    protected void initData() {

        int uid = sPutils.getInt("uid", 0);
        guanZhuLieBiaoPresenter.getGuanZhu(uid+"");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.fragment4_but:
                break;
        }
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
    public void onError(Throwable throwable) {

    }

    @Override
    public void onTokenFail() {

    }

    @Override
    public void onNext(GuanZhuLIEBiaoBean guanZhuLIEBiaoBean) {
        List<GuanZhuLIEBiaoBean.DataBean> data = guanZhuLIEBiaoBean.data;
        name = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            name[i]=data.get(i).nickname;
        }
        child = new String[][]{{"单聊","多人聊天"},
                    name};
        fragment4Adapter = new Fragment4Adapter(getActivity(),group,child);
        mListView.setAdapter(fragment4Adapter);

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
