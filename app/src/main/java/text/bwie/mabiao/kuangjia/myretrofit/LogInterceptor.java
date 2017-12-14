package text.bwie.mabiao.kuangjia.myretrofit;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.app.Myapp;
import text.bwie.mabiao.kuangjia.utils.SPutils;
import text.bwie.mabiao.kuangjia.utils.VersionUtils;

/**
 * Created by mabiao on 2017/11/24.
 */

public class LogInterceptor implements Interceptor {
public int versionCode;
    public static String TAG = "LogInterceptor";
   SPutils sPutils=new SPutils("msg");
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String token = sPutils.getString("token", null);
        System.out.println(request.method() + "开始添加公共参数222222222"+token);
//        String token = (String) SharePrefrenceUtils.getData(SharePrefrenceBack.String, "token");
        try {
            Context context = Myapp.context;
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionCode = pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        HttpUrl url= null;
        try {
            url = request.url()
                    .newBuilder()
                    .addQueryParameter("source","android")
                    .addQueryParameter("appVersion",String.valueOf(VersionUtils.getVersoncode()))
                    .addQueryParameter("token",token)
                    .build();

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if ("POST".equals(request.method())) {
            System.out.println(request.method() + "开始添加公共参数3333333333"+request.body().toString());
            if (request.body() instanceof FormBody) {
                System.out.println("FormBody开始添加公共参数");
                FormBody.Builder builder = new FormBody.Builder();
                FormBody body = (FormBody) request.body();
                for (int i = 0; i < body.size(); i++) {
                    builder.add(body.encodedName(i), body.encodedValue(i));
                }
                body = builder.add("source", "android")
                        .add("appVersion", String.valueOf(versionCode))
                        .add("token", token+"")
                        .build();
                System.out.println("开始添加公共参数55555" );
                request = request.newBuilder().post(body)
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control","max-age="+3600*24*30)
                        .build();
            }
            else if(request.body() instanceof MultipartBody)
            {
                System.out.println("MultipartBody开始添加公共参数"+token+request.url());
                MultipartBody body = (MultipartBody) request.body();
                List<MultipartBody.Part> parts1 = body.parts();


                MultipartBody.Builder builder=new MultipartBody.Builder().setType(MultipartBody.FORM);
                builder.addFormDataPart("source","android")
                        .addFormDataPart("appVersion",versionCode+"")
                        .addFormDataPart("token",token+"");
                List<MultipartBody.Part> parts = body.parts();
                for (MultipartBody.Part part : parts) {
                    builder.addPart(part);
                }
                request=request.newBuilder().post(builder.build())
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control","max-age="+3600*24*30)
                        .build();
            }
        }
//        System.out.println(chain.proceed(request).body().string()+"==========chain============");
        return chain.proceed(request);
    }

}
