package text.bwie.mabiao.kuangjia.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.bean.GuanZhuLIEBiaoBean;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;

/**
 * Created by mabiao on 2017/12/18.
 */

public class GuanZhuLeiBiaoAdapter extends XRecyclerView.Adapter<GuanZhuLeiBiaoAdapter.MyViewHouder> {
    private Context context;
    private List<GuanZhuLIEBiaoBean.DataBean> list;

    public GuanZhuLeiBiaoAdapter(Context context, List<GuanZhuLIEBiaoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public GuanZhuLeiBiaoAdapter.MyViewHouder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.guanzhuliebiao_item, parent, false);
        MyViewHouder myViewHouder=new MyViewHouder(view);
        return myViewHouder;
    }

    @Override
    public void onBindViewHolder(GuanZhuLeiBiaoAdapter.MyViewHouder holder, int position) {
        Glide.with(context).load(list.get(position).icon).into(holder.mCr);
        holder.mName.setText(list.get(position).nickname);
        holder.mTime.setText(list.get(position).createtime);

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHouder extends RecyclerView.ViewHolder {

        private final CircleRoundImageView mCr;
        private final TextView mName;
        private final TextView mTime;

        public MyViewHouder(View itemView) {
            super(itemView);
            mCr = itemView.findViewById(R.id.guanzhuliebiao_cr);
            mName = itemView.findViewById(R.id.guanzhuliebiao_name);
            mTime = itemView.findViewById(R.id.guanzhuliebiao_time);
        }
    }
}
