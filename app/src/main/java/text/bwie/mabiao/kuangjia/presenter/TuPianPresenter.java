package text.bwie.mabiao.kuangjia.presenter;

import android.content.Context;
import android.widget.Toast;

import com.luck.picture.lib.entity.LocalMedia;

import java.util.List;

import okhttp3.ResponseBody;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.model.TuPianModel;
import text.bwie.mabiao.kuangjia.view.LoginView;
import text.bwie.mabiao.kuangjia.view.TuPianView;

/**
 * Created by mabiao on 2017/12/2.
 */

public class TuPianPresenter extends BasePresenter<TuPianView> implements TuPianModel.MyLoadle {
    private TuPianModel tuPianModel;
    public TuPianPresenter(TuPianView mView) {
        super(mView);
        tuPianModel=new TuPianModel();
    }

    public void TuPian(Context context, String uid, String content, List<LocalMedia> list){
        if(content.equals("")){
            Toast.makeText(context,"不能发布空文字",Toast.LENGTH_SHORT).show();
        }
        tuPianModel.Tupian(uid,content,list,this);

    }

    @Override
    public void Success(ResponseBody value) {
         mView.Success(value);
    }

    @Override
    public void Error(Throwable e) {
      mView.Error(e);
    }
}
