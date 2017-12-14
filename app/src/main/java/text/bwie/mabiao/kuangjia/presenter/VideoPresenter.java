package text.bwie.mabiao.kuangjia.presenter;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.model.videomodel.MyVideoJieKou;
import text.bwie.mabiao.kuangjia.model.videomodel.VideoModdel;
import text.bwie.mabiao.kuangjia.view.VideoViews;

/**
 * Created by mabiao on 2017/12/6.
 */

public class VideoPresenter extends BasePresenter<VideoViews> implements MyVideoJieKou {
   private VideoModdel videoModdel;
    public VideoPresenter(VideoViews mView) {
        super(mView);
        videoModdel=new VideoModdel();
    }
    public void VideoShangChuan(String uid, String content,String path ,List<LocalMedia> list , String jingdu, String weidu){
      videoModdel.VideoShang(uid,content,path,list,jingdu,weidu,this);
    }

    @Override
    public void Videochenggong(ResponseBody value) {
        mView.Videochenggong(value);
    }

    @Override
    public void Videoshibai(Throwable e) {
      mView.Videoshibai(e);
    }
}
