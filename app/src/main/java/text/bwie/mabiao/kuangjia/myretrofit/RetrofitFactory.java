package text.bwie.mabiao.kuangjia.myretrofit;

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
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mabiao on 2017/11/24.
 */

public class RetrofitFactory
{
    public volatile static RetrofitFactory retrofitFactory;
    private final Retrofit retrofit;

    private RetrofitFactory (){
             OkHttpClient httpClient=new OkHttpClient.Builder()
                     .addInterceptor(new LogInterceptor())
                     .sslSocketFactory(createSSLSocketFactory())
                     .hostnameVerifier(new TrustAllHostnameVerifier())
                     .connectTimeout(10, TimeUnit.SECONDS)
                     .readTimeout(10, TimeUnit.SECONDS)
                     .writeTimeout(10, TimeUnit.SECONDS)
                     .retryOnConnectionFailure(false)
                     .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
         }
   public void request(String path, Map<String,String> map, Consumer<BaseRequest> consumer)
   {
       APIFunction apiFunction = retrofit.create(APIFunction.class);
       Observable<BaseRequest> request = apiFunction.getRequest(path, map);
       request.subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(consumer);

   }
    public void request(String path, Map<String,String> map, Observer<BaseRequest> observer)
    {
        APIFunction apiFunction = retrofit.create(APIFunction.class);
        Observable<BaseRequest> request = apiFunction.getRequest(path, map);
        request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
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

         private static RetrofitFactory getInstence()
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
