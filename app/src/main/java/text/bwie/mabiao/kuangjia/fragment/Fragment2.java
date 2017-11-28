package text.bwie.mabiao.kuangjia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;

/**
 * Created by mabiao on 2017/11/27.
 */

public class Fragment2 extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment2, null);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
        initData();
    }

    private void initData() {

    }
    private void initView() {

    }
}
