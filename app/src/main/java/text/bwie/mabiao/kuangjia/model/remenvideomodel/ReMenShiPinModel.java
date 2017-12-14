package text.bwie.mabiao.kuangjia.model.remenvideomodel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.bean.RemenVidwoBean;
import text.bwie.mabiao.kuangjia.myretrofit.ResultCallback;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/12/14.
 */

public class ReMenShiPinModel implements IReMenModel {
    @Override
    public void getShipin(String page, final MyRemenJiekou remenJiekou) {
        Map<String,String> map=new HashMap<>();
        map.put("page",page);
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.REMENVIDEOURL, map, new ResultCallback<RemenVidwoBean>() {
            @Override
            public void onError(Throwable throwable) {
                remenJiekou.RemenShiBai(throwable);
            }
            @Override
            public void onTokenFail() {
            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onNext(ResponseBody responseBody, RemenVidwoBean remenVidwoBean) throws IOException {
                   remenJiekou.RemenChengGong(remenVidwoBean);
            }
        });
    }
}
