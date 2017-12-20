package text.bwie.mabiao.kuangjia.myretrofit;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.app.Myapp;

import static android.os.AsyncTask.execute;

/**
 * Created by mabiao on 2017/11/24.
 */

public class RetrofitFactory
{
    public volatile static RetrofitFactory retrofitFactory;
    private final Retrofit retrofit;
    private final Gson gson;
    private APIFunction apiFunction;
    private ApiService apiService;
    private RetrofitFactory (){
        gson = new Gson();
        File file=new File("mnt/sdcard/biao");
       Cache cache=new Cache(file,1024*1024);
             OkHttpClient httpClient=new OkHttpClient.Builder()
                     .addInterceptor(new LogInterceptor())
                     .cache(cache)
                     .sslSocketFactory(createSSLSocketFactory())
                     .hostnameVerifier(new TrustAllHostnameVerifier())
                     .connectTimeout(10, TimeUnit.SECONDS)
                     .readTimeout(10, TimeUnit.SECONDS)
                     .writeTimeout(10, TimeUnit.SECONDS)
                     .retryOnConnectionFailure(false)
                     .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Myapi.QIANURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                 .client(httpClient)
                .build();
         }
         public RetrofitFactory createBaseApi(){
             apiFunction = create(APIFunction.class);
             return this;
         }
         public RetrofitFactory createServiceApi(){
             apiService = create(ApiService.class);
             return this;
         }


    public <T> T create(final Class<T> service1){
        if(service1==null){
            throw new RuntimeException("service为空!!!");
        }
        return retrofit.create(service1);
    }
    public void requestData(String url, final Map<String,String> map, final ResultCallback callback)
    {
        Observable<ResponseBody> baseRequestObservable=apiFunction.getRequest(url,map);
        baseRequestObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseBody body) {
                        try {

                            String string=body.string();
                            try {
                                JSONObject jsonObject=new JSONObject(string);
                                String code = jsonObject.getString("code");
                                String msg = jsonObject.optString("msg");
                                System.out.println(code+"throwable============"+msg);
                                if(code.equals("2")){
                                    callback.onTokenFail();
                                }else if(code.equals("0")){
                                    Object o = gson.fromJson(string, callback.type);
                                    callback.onNext(body,o);
                                }
                                else {
//                                    String msg = jsonObject.optString("msg");
                                    System.out.println("throwable============"+msg);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.e("错误：",e+"");
                        callback.onError(e);
                    }
                    @Override
                    public void onComplete() {
                      callback.onComplete();
                    }
                });
    }
    /**
     * --------------------------上传照片------------------------------------------------
     */
    public void uploadTou(String path, RequestBody file, final MyCallBack myCallBack){
        Observable<ResponseBody> upload = apiService.upload(path, file);
       upload.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<ResponseBody>() {
                   @Override
                   public void onSubscribe(Disposable d) {
                   }
                   @Override
                   public void onNext(ResponseBody body) {
                      myCallBack.onSuccess(body);
                   }

                   @Override
                   public void onError(Throwable e) {
                   myCallBack.onError(e);
                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }


    /**
     * 信任所有https的请求的安全证书
     */
    private static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class TrustAllHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new TrustAllCerts()}, new SecureRandom());

            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
        }

        return ssfFactory;
    }
         public static RetrofitFactory getInstence()
         {
             if(retrofitFactory==null)
             {
             synchronized (RetrofitFactory.class)
             {
                 if(retrofitFactory==null)
                 {
                    retrofitFactory=new RetrofitFactory();
                 }
             }
             }
             return retrofitFactory;

    }




}
