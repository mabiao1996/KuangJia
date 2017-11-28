package text.bwie.mabiao.kuangjia.myretrofit;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by mabiao on 2017/11/24.
 */

public interface APIFunction {
    @FormUrlEncoded
    @POST("{type}")
    Observable<BaseRequest> getRequest(@Path("type")String path, @FieldMap Map<String,String> map);

}
