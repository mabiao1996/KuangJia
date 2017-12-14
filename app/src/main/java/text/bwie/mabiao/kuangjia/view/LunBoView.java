package text.bwie.mabiao.kuangjia.view;

import text.bwie.mabiao.kuangjia.bean.LunBoTuBean;
import text.bwie.mabiao.kuangjia.bean.ShiPinBean;

/**
 * Created by mabiao on 2017/12/5.
 */

public interface LunBoView extends LoginView {
    void onNext(LunBoTuBean lunBoTuBean);
    void onError(Throwable throwable);
    void shipinchenggong(ShiPinBean shiPinBean);
    void shipinshibai(Throwable throwable);
}
