package text.bwie.mabiao.kuangjia.presenter;

import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.LunBoTuBean;
import text.bwie.mabiao.kuangjia.bean.ShiPinBean;
import text.bwie.mabiao.kuangjia.model.LunBoModel;
import text.bwie.mabiao.kuangjia.view.LunBoView;

/**
 * Created by mabiao on 2017/12/5.
 */

public class LunBoPresenter extends BasePresenter<LunBoView> implements LunBoModel.GetLunBoTu, LunBoModel.ShiPinJieKou {

    private LunBoModel lunBoModel;
    public LunBoPresenter(LunBoView mView) {
        super(mView);
        lunBoModel=new LunBoModel();
    }

    public void  getLunBo(){
    lunBoModel.lunbo(this);

    }

    public void FaShiPin(String uid, String type, String page){
        lunBoModel.shipin(uid,type,page,this);

    }
    @Override
    public void onNext(LunBoTuBean lunBoTuBean) {
        mView.onNext(lunBoTuBean);
    }
    @Override
    public void onError(Throwable throwable) {
     mView.onError(throwable);
    }

    @Override
    public void shipinchenggong(ShiPinBean shiPinBean) {
        mView.shipinchenggong(shiPinBean);
    }
    @Override
    public void shipinshibai(Throwable throwable) {
      mView.shipinshibai(throwable);
    }
}
