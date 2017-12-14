package text.bwie.mabiao.kuangjia.view;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.base.BaseView;

/**
 * Created by mabiao on 2017/12/6.
 */

public interface VideoViews extends BaseView, LoginView {
    void Videochenggong(ResponseBody value);
    void Videoshibai(Throwable e);

}
