package text.bwie.mabiao.kuangjia.presenter;

import android.content.Context;
import android.widget.Toast;

import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.model.LoginCallback;
import text.bwie.mabiao.kuangjia.model.LoginModel;
import text.bwie.mabiao.kuangjia.view.LoginView;

/**
 * Created by mabiao on 2017/11/29.
 */

public class LoginPresenter extends BasePresenter<LoginView> implements LoginCallback {

    private LoginModel loginModel;
    public LoginPresenter(LoginView mView) {
        super(mView);
        loginModel=new LoginModel();

    }
    public void login(Context context, String mobile, String pwd)
    {
        if(mobile.equals("")){
            Toast.makeText(context,"账号不能为空",Toast.LENGTH_LONG).show();
        }
        if(pwd.equals("")){
            Toast.makeText(context,"密码不能为空",Toast.LENGTH_LONG).show();
        }
        loginModel.login(mobile,pwd,this);
    }
    public void huoqu(int uid)
    {
        loginModel.huoqu(uid,this);
    }
    /**
     * ------------------------登陆返回--------------------------------------------
     * @param msg
     * @param uid
     * @param token
     */
    @Override
    public void success(String msg, int uid,String token) {
        mView.success(msg,uid,token);
    }
    @Override
    public void fialure(String msg) {
        mView.fialure(msg);
    }
    /**
     * ------------------------获取信息返回--------------------------------------------
     * @param
     */
    @Override
    public void shuju(HuoQuBean bean) {
    mView.huoqu(bean);
    }
}
