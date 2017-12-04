package text.bwie.mabiao.kuangjia.view;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.base.BaseView;

/**
 * Created by mabiao on 2017/12/2.
 */

public interface TuPianView extends BaseView, LoginView {

    void Success(ResponseBody value);
    void Error(Throwable e);
}
