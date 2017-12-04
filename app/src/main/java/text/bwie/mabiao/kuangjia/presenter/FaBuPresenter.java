package text.bwie.mabiao.kuangjia.presenter;

import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.base.BaseView;
import text.bwie.mabiao.kuangjia.bean.FaBuBean;
import text.bwie.mabiao.kuangjia.model.FaBumodel;
import text.bwie.mabiao.kuangjia.view.FaBuView;
import text.bwie.mabiao.kuangjia.view.LoginView;

/**
 * Created by mabiao on 2017/12/1.
 */

public class FaBuPresenter extends BasePresenter<FaBuView> implements FaBumodel.Fa {
    private FaBumodel faBumodel;
    public FaBuPresenter(FaBuView mView) {
        super(mView);
        faBumodel=new FaBumodel();
    }

    public void fabu(String uid,String content){
        faBumodel.fabu(uid,content,this);
    }
    @Override
    public void fabuduanzi(FaBuBean faBuBean)
    {
         mView.fabuduanzi(faBuBean);
    }
}
