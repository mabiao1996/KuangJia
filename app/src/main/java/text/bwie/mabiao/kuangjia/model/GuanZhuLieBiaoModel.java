package text.bwie.mabiao.kuangjia.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.bean.GuanZhuLIEBiaoBean;
import text.bwie.mabiao.kuangjia.myretrofit.ResultCallback;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/12/18.
 */

public class GuanZhuLieBiaoModel {

    public void getGuanZhu(String uid, final LieBiaoGuanZhu guanZhu){
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.GUANZHULIEBIAOURL, map, new ResultCallback<GuanZhuLIEBiaoBean>() {
            @Override
            public void onError(Throwable throwable) {
              guanZhu.onError(throwable);
            }
            @Override
            public void onTokenFail() {
                guanZhu.onTokenFail();
            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onNext(ResponseBody responseBody, GuanZhuLIEBiaoBean guanZhuLIEBiaoBean) throws IOException {
              guanZhu.onNext(guanZhuLIEBiaoBean);
            }
        });
    }
    public interface LieBiaoGuanZhu{
        void onError(Throwable throwable);
        void onTokenFail();
        void onNext(GuanZhuLIEBiaoBean guanZhuLIEBiaoBean);
    }

}
