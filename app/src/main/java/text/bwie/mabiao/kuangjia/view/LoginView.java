package text.bwie.mabiao.kuangjia.view;

import text.bwie.mabiao.kuangjia.base.BaseView;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;

/**
 * Created by mabiao on 2017/11/29.
 */

public interface LoginView extends BaseView {
    void success(String msg,int uid,String token);
    void  fialure(String msg);
    void huoqu(HuoQuBean bean);
}
