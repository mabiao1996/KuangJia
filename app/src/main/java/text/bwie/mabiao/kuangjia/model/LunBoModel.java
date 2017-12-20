package text.bwie.mabiao.kuangjia.model;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.bean.DianZanBean;
import text.bwie.mabiao.kuangjia.bean.LunBoTuBean;
import text.bwie.mabiao.kuangjia.bean.ShiPinBean;
import text.bwie.mabiao.kuangjia.myretrofit.ResultCallback;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/12/5.
 */

public class LunBoModel {

    public void lunbo(final GetLunBoTu lunBoTu){
        Map<String,String> map=new HashMap<>();
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.LUNBOURL, map, new ResultCallback<LunBoTuBean>() {
            @Override
            public void onError(Throwable throwable) {
                lunBoTu.onError(throwable);
            }
            @Override
            public void onTokenFail() {
            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onNext(ResponseBody responseBody, LunBoTuBean lunBoTuBean) throws IOException {
                lunBoTu.onNext(lunBoTuBean);
            }
        });
    }
    public interface GetLunBoTu{
        void onNext(LunBoTuBean lunBoTuBean);
        void onError(Throwable throwable);
    }

    public void shipin(String uid, String type, String page, final ShiPinJieKou shiPinJieKou){
       Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("type",type);
        map.put("page",page);
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.HUOQUSHIPINURL, map, new ResultCallback<ShiPinBean>() {
            @Override
            public void onError(Throwable throwable) {
             shiPinJieKou.shipinshibai(throwable);
                System.out.println("qwertyuioplkjhgfdsazxcvbn]df[sldskmdskldmclksdmclksmsclk+失败");
            }
            @Override
            public void onTokenFail() {
            }
            @Override
            public void onComplete() {

            }
            @Override
            public void onNext(ResponseBody responseBody, ShiPinBean shiPinBean) throws IOException {
            shiPinJieKou.shipinchenggong(shiPinBean);
                System.out.println("qwertyuioplkjhgfdsazxcvbn]df[sldskmdskldmclksdmclksmsclk+成功");
            }
        });

    }

    public interface ShiPinJieKou{
        void shipinchenggong(ShiPinBean shiPinBean);
        void shipinshibai(Throwable throwable);
    }

    public void  DianZan(String uid, String followId, final getDianzan dian){

        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("followId",followId);
        System.out.println("throwable===============cross========");
        RetrofitFactory.getInstence().createBaseApi().requestData(Myapi.DIANZANURL, map, new ResultCallback<DianZanBean>() {
            @Override
            public void onError(Throwable throwable) {
                System.out.println("throwable==============="+throwable.toString());
                dian.DianZanShiBai(throwable);
            }
            @Override
            public void onTokenFail() {

            }
            @Override
            public void onComplete() {
            }
            @Override
            public void onNext(ResponseBody responseBody, DianZanBean dianZanBean) throws IOException {
                System.out.println("throwable===============sucess========");
                dian.DianZanChengGong(dianZanBean);
            }
        });
    }

    public interface getDianzan{
        void DianZanChengGong( DianZanBean dianZanBean);
        void DianZanShiBai(Throwable throwable);
    }


}
