package text.bwie.mabiao.kuangjia.base;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * Created by mabiao on 2017/11/30.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    public T presenter;
    private FragmentActivity mActivity;

    public abstract T initpresenter();
    protected abstract int getLayoutId();
    protected abstract void initView(View view);
    private boolean isFirst=true;
    protected abstract void initData();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
              if(getLayoutId()!=0) {
                  View inflate = LayoutInflater.from(mActivity).inflate(getLayoutId(), null);
                  ViewGroup parent = (ViewGroup) inflate.getParent();
                  if (parent != null) {
                      parent.removeView(inflate);
                  }
                  return inflate;
              }
              else{
                  return super.onCreateView(inflater, container, savedInstanceState);
              }



    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isFirst=true;
        presenter=initpresenter();
        initView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        if(isFirst){
            initData();
            isFirst=false;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(presenter!=null){
            presenter.deatach();
        }
    }
    /**
     * 页面跳转
     * @param tClass
     * @param bundle
     */
    public  void  startActivitys(Class<?> tClass,Bundle bundle){
        Intent intent=new Intent(mActivity,tClass);
        if(bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 吐司
     * @param s
     */
    public void getToast(String s){
        Toast.makeText(mActivity,s,Toast.LENGTH_SHORT).show();
    }


}
