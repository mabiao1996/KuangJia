package text.bwie.mabiao.kuangjia.presenter;

import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.GuanZhuLIEBiaoBean;
import text.bwie.mabiao.kuangjia.model.GuanZhuLieBiaoModel;
import text.bwie.mabiao.kuangjia.view.GuanZhuLieBiaoView;

/**
 * Created by mabiao on 2017/12/18.
 */

public class GuanZhuLieBiaoPresenter extends BasePresenter<GuanZhuLieBiaoView> implements GuanZhuLieBiaoModel.LieBiaoGuanZhu {
    GuanZhuLieBiaoModel guanZhuLieBiaoModel;
    public GuanZhuLieBiaoPresenter(GuanZhuLieBiaoView mView) {
        super(mView);
        guanZhuLieBiaoModel=new GuanZhuLieBiaoModel();
    }
    public void getGuanZhu(String uid){
        guanZhuLieBiaoModel.getGuanZhu(uid,this);

    }

    @Override
    public void onError(Throwable throwable) {
        mView.onError(throwable);
    }
    @Override
    public void onTokenFail() {
        mView.onTokenFail();
    }
    @Override
    public void onNext(GuanZhuLIEBiaoBean guanZhuLIEBiaoBean) {
        mView.onNext(guanZhuLIEBiaoBean);
    }
}
