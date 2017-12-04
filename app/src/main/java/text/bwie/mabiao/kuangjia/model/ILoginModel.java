package text.bwie.mabiao.kuangjia.model;

/**
 * Created by mabiao on 2017/11/29.
 */

public interface ILoginModel {

    void login(String mobile,String pwd,LoginCallback loginCallback);
    void huoqu(int uid,LoginCallback loginCallback);

}
