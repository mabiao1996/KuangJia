package text.bwie.mabiao.kuangjia.model.videomodel;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

/**
 * Created by mabiao on 2017/12/6.
 */

public interface IVideoModel {

    void VideoShang(String uid,String content,String path, List<LocalMedia> list ,String jingdu,String weidu,MyVideoJieKou jieKou);
}
