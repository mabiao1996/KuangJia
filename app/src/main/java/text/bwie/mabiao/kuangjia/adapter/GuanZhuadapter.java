package text.bwie.mabiao.kuangjia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import text.bwie.mabiao.kuangjia.R;

/**
 * Created by mabiao on 2017/12/4.
 */

public class GuanZhuadapter extends XRecyclerView.Adapter<GuanZhuadapter.MyViewHoulde> {
    private Context context;
    public GuanZhuadapter(Context context) {
        this.context = context;
    }
    @Override
    public GuanZhuadapter.MyViewHoulde onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fragments2_guanzhu_item, parent, false);
        MyViewHoulde my=new MyViewHoulde(view);
        return my;
    }

    @Override
    public void onBindViewHolder(GuanZhuadapter.MyViewHoulde holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHoulde extends RecyclerView.ViewHolder {
        public MyViewHoulde(View itemView) {
            super(itemView);
        }
    }
}
