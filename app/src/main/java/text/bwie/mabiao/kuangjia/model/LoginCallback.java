package text.bwie.mabiao.kuangjia.model;

import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.myretrofit.BaseRequest;

/**
 * Created by mabiao on 2017/11/29.
 */

public interface LoginCallback {
    void success(String msg,int uid,String token);
    void fialure(String msg);
    void shuju( HuoQuBean bean);

}
