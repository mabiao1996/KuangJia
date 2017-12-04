package text.bwie.mabiao.kuangjia.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.bean.HuoQuBean;
import text.bwie.mabiao.kuangjia.bean.LoginBean;
import text.bwie.mabiao.kuangjia.myretrofit.BaseRequest;
import text.bwie.mabiao.kuangjia.myretrofit.ResultCallback;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/11/29.
 */

public class LoginModel implements ILoginModel {
    /**
     * -------------------------------------登录请求-----------------------------------------------------
     * @param mobile
     * @param pwd
     * @param loginCallback
     */

    @Override
    public void login(String mobile, String pwd, final LoginCallback loginCallback) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",pwd);
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.LOGINURL, map, new ResultCallback<LoginBean>() {
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onTokenFail() {
            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onNext(ResponseBody responseBody, LoginBean loginBean) throws IOException {
               if(loginBean.code.equals("0")){
                   loginCallback.success(loginBean.msg,loginBean.data.uid,loginBean.data.token);
                   System.out.println("ssssssssssssss"+loginBean.data.uid+"sssssssssssss"+loginBean.data.token);
               }
            }
        });
    }
    /**
     * -------------------------------------获取信息请求-----------------------------------------------------
     * @param uid
     * @param
     * @param loginCallback
     */
    @Override
    public void huoqu(int uid, final LoginCallback loginCallback) {
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid+"");
        System.out.println("mapmap:"+map);
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.HUOQUURL, map, new ResultCallback<HuoQuBean>() {
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onTokenFail() {
            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onNext(ResponseBody responseBody, HuoQuBean bean) throws IOException {
            loginCallback.shuju(bean);
            }
        });
    }
}
