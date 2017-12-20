package text.bwie.mabiao.kuangjia.view;

import text.bwie.mabiao.kuangjia.bean.GuanZhuLIEBiaoBean;

/**
 * Created by mabiao on 2017/12/18.
 */

public interface GuanZhuLieBiaoView extends LoginView{
    void onError(Throwable throwable);
    void onTokenFail();
    void onNext(GuanZhuLIEBiaoBean guanZhuLIEBiaoBean);
}
