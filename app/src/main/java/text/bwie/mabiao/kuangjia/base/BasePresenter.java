package text.bwie.mabiao.kuangjia.base;

/**
 * Created by mabiao on 2017/11/15.
 */

public class BasePresenter<V> {
    private V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }
    public void deatach(){
        this.mView=null;
    }
}

