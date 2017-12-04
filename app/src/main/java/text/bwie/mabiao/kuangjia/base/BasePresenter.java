package text.bwie.mabiao.kuangjia.base;

import text.bwie.mabiao.kuangjia.view.LoginView;

/**
 * Created by mabiao on 2017/11/15.
 */

public class BasePresenter<V extends LoginView> {
    public V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }
    public void deatach(){
        this.mView=null;
    }
}

