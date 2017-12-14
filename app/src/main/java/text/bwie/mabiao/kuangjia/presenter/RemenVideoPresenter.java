package text.bwie.mabiao.kuangjia.presenter;

import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.RemenVidwoBean;
import text.bwie.mabiao.kuangjia.model.remenvideomodel.MyRemenJiekou;
import text.bwie.mabiao.kuangjia.model.remenvideomodel.ReMenShiPinModel;
import text.bwie.mabiao.kuangjia.view.LoginView;
import text.bwie.mabiao.kuangjia.view.ReMenVideoView;

/**
 * Created by mabiao on 2017/12/14.
 */

public class RemenVideoPresenter extends BasePresenter<ReMenVideoView> implements MyRemenJiekou {
    ReMenShiPinModel reMenShiPinModel;
    public RemenVideoPresenter(ReMenVideoView mView) {
        super(mView);
        reMenShiPinModel=new ReMenShiPinModel();
    }
    public void RemenSHipin(String page){
        reMenShiPinModel.getShipin(page,this);
    }
    @Override
    public void RemenChengGong(RemenVidwoBean remenVidwoBean) {
        mView.RemenChengGong(remenVidwoBean);
    }
    @Override
    public void RemenShiBai(Throwable throwable) {
          mView.RemenShiBai(throwable);
    }
}
