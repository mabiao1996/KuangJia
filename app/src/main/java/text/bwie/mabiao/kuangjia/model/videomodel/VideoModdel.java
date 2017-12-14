package text.bwie.mabiao.kuangjia.model.videomodel;

import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.api.Myapi;
import text.bwie.mabiao.kuangjia.myretrofit.MyCallBack;
import text.bwie.mabiao.kuangjia.myretrofit.RetrofitFactory;

/**
 * Created by mabiao on 2017/12/6.
 */

public class VideoModdel implements IVideoModel {


    @Override
    public void VideoShang(String uid, String content,String path, List<LocalMedia> list,String jingdu,String weidu, final MyVideoJieKou jieKou) {
        MultipartBody.Builder multi=new MultipartBody.Builder();
        if(list!=null&list.size()>0){
            for (int i = 0; i <list.size() ; i++) {
                LocalMedia localMedia = list.get(i);
                File file=new File(localMedia.getPath());
                if(file.exists()){
                    multi.addFormDataPart("coverFile",file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"),file));
                }
            }
        }
        File file2=new File(path);
        multi.addFormDataPart("videoFile",file2.getName(), RequestBody.create(MediaType.parse("application/octet-stream"),file2));
        multi.addFormDataPart("uid",uid);
        System.out.println("uid============="+uid);
        multi.addFormDataPart("videoDesc",content);
        multi.addFormDataPart("latitude",weidu);
        multi.addFormDataPart("longitude",jingdu);
        MultipartBody m=multi.build();
     RetrofitFactory.getInstence().createServiceApi().uploadTou(Myapi.FASHIPINURL, m, new MyCallBack() {
         @Override
         public void onError(Throwable e) {
          jieKou.Videoshibai(e);
         }
         @Override
         public void onSuccess(ResponseBody value) {
           jieKou.Videochenggong(value);
         }
     });

    }
}
