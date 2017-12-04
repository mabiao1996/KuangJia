package text.bwie.mabiao.kuangjia.myretrofit;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

/**
 * Created by mabiao on 2017/12/1.
 */

public interface ApiService {

    @POST()
    @Headers("Accept:*")
    Observable<ResponseBody> upload(@Url String path, @Body RequestBody file);

}
