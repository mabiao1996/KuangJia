package text.bwie.mabiao.kuangjia.model.videomodel;

import okhttp3.ResponseBody;

/**
 * Created by mabiao on 2017/12/6.
 */

public interface MyVideoJieKou {

    void Videochenggong(ResponseBody value);
    void Videoshibai(Throwable e);

}
