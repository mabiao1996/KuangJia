package text.bwie.mabiao.kuangjia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import text.bwie.mabiao.kuangjia.R;

/**
 * Created by mabiao on 2017/12/1.
 */

public class ReMenAdapter extends XRecyclerView.Adapter<ReMenAdapter.MyViewHould>{
    private Context context;

    public ReMenAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ReMenAdapter.MyViewHould onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragments1_item, parent,false);
        MyViewHould my=new MyViewHould(view);
        return my;
    }
    @Override
    public void onBindViewHolder(ReMenAdapter.MyViewHould holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 5;
    }
    public class MyViewHould extends RecyclerView.ViewHolder {
        public MyViewHould(View itemView) {
            super(itemView);
        }
    }
}
