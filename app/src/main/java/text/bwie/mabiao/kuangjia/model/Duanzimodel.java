package text.bwie.mabiao.kuangjia.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.bean.DuanZiBean;
import text.bwie.mabiao.kuangjia.myretrofit.ResultCallback;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/11/30.
 */

public class Duanzimodel {

    public void duanzi(int page, String token, final Callback callback){
        Map<String,String> map=new HashMap<>();
        map.put("page",page+"");
        map.put("token",token);
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.DUANZIURL, map, new ResultCallback<DuanZiBean>() {
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
            public void onNext(ResponseBody responseBody, DuanZiBean duanZiBean) throws IOException {
                callback.huoquxinxi(duanZiBean);
            }
        });

    }
    public interface Callback{
    void huoquxinxi(DuanZiBean duanZiBean);

    }


}
