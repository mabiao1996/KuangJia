package text.bwie.mabiao.kuangjia.model;

import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Multipart;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.myretrofit.MyCallBack;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/12/2.
 */

public class TuPianModel {

    public void Tupian(String uid, String content, List<LocalMedia> list, final MyLoadle myLoadle){
        MultipartBody.Builder builder=new MultipartBody.Builder();
        if(list!=null&&list.size()>0){
            for (LocalMedia localMedia : list) {
                File file=new File(localMedia.getPath());
                if(file.exists()){
                    builder.addFormDataPart("jokeFiles",file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"),file));
                }
            }
        }
        builder.addFormDataPart("uid",uid);
        builder.addFormDataPart("content",content);
        MultipartBody build=builder.build();
     RetrofitFactory.getInstence().createServiceApi().uploadTou(Myapi.FABUURL, build, new MyCallBack() {
         @Override
         public void onError(Throwable e) {
         myLoadle.Error(e);
         }
         @Override
         public void onSuccess(ResponseBody value) {
          myLoadle.Success(value);
         }
     });
    }
    public interface MyLoadle{
        void Success(ResponseBody value);
        void Error(Throwable e);
    }


}
