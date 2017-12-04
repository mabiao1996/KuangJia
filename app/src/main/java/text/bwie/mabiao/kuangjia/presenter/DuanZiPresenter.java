package text.bwie.mabiao.kuangjia.presenter;

import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.DuanZiBean;
import text.bwie.mabiao.kuangjia.model.Duanzimodel;
import text.bwie.mabiao.kuangjia.view.DuanZiView;

/**
 * Created by mabiao on 2017/11/30.
 */

public class DuanZiPresenter extends BasePresenter<DuanZiView> implements Duanzimodel.Callback {
    private Duanzimodel duanzimodel;

    public DuanZiPresenter(DuanZiView mView) {
        super(mView);
        duanzimodel=new Duanzimodel();
    }

    public void HuoQuDuanZi(int page,String token){
        duanzimodel.duanzi(page,token,this);
    }
    @Override
    public void huoquxinxi(DuanZiBean duanZiBean) {
       mView.huoquxinxi(duanZiBean);
    }
}
