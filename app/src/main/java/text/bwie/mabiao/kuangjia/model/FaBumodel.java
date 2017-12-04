package text.bwie.mabiao.kuangjia.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.bean.FaBuBean;
import text.bwie.mabiao.kuangjia.myretrofit.ResultCallback;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/12/1.
 */

public class FaBumodel {

    public void fabu(String uid, String content, final Fa fa)
    {
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("content",content);
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.FABUURL, map, new ResultCallback<FaBuBean>() {
            @Override
            public void onError(Throwable throwable) {
                System.out.println("sssssssssssssssssssssssssssssss"+throwable);
            }
            @Override
            public void onTokenFail() {

            }
            @Override
            public void onComplete() {

            }
            @Override
            public void onNext(ResponseBody responseBody, FaBuBean faBuBean) throws IOException {
                 fa.fabuduanzi(faBuBean);
            }
        });
    }

    public interface Fa{
        void fabuduanzi(FaBuBean faBuBean);
    }

}
