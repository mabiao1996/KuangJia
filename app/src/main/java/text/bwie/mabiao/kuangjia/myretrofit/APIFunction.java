package text.bwie.mabiao.kuangjia.myretrofit;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by mabiao on 2017/11/24.
 */

public interface APIFunction {
    @FormUrlEncoded
    @POST()
    @Headers("Accept:*")
    Observable<ResponseBody> getRequest(@Url String path, @FieldMap Map<String,String> map);

}
