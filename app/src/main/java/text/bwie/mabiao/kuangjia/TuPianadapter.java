package text.bwie.mabiao.kuangjia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import text.bwie.mabiao.kuangjia.bean.DuanZiBean;

/**
 * Created by mabiao on 2017/11/30.
 */
public class TuPianadapter extends RecyclerView.Adapter<TuPianadapter.MyViewHould> {
    private Context context;
    private String[] list;

    public TuPianadapter(Context context,String[] list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public TuPianadapter.MyViewHould onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tupianitem,null);
        MyViewHould my=new MyViewHould(view);
        return my;
    }

    @Override
    public void onBindViewHolder(TuPianadapter.MyViewHould holder, int position) {
        String s = list[position];
            Glide.with(context).load(s).into(holder.mTu);
    }
    @Override
    public int getItemCount() {
        return list.length;
    }
    public class MyViewHould extends RecyclerView.ViewHolder {

        private final ImageView mTu;

        public MyViewHould(View itemView) {
            super(itemView);
            mTu = itemView.findViewById(R.id.img_tu);
        }
    }
}
