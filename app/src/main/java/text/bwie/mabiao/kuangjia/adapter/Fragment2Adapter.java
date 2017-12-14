package text.bwie.mabiao.kuangjia.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.TuPianadapter;
import text.bwie.mabiao.kuangjia.bean.DuanZiBean;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;

/**
 * Created by mabiao on 2017/11/30.
 */

public class Fragment2Adapter extends XRecyclerView.Adapter<Fragment2Adapter.MyViewHould> {
    private Context context;
    private List<DuanZiBean.DataBean> list;
    public Fragment2Adapter(Context context, List<DuanZiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public Fragment2Adapter.MyViewHould onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment2item, parent,false);
        MyViewHould my=new MyViewHould(view);
        return my;
    }
    @Override
    public void onBindViewHolder(MyViewHould holder, int position) {
        DuanZiBean.DataBean dataBean = list.get(position);
        RequestOptions options = new RequestOptions();
        options.placeholder(R.mipmap.ic_launcher_round);
        Glide.with(context).load(dataBean.user.icon).apply(options).into(holder.mXcr);
        holder.mMingZi.setText(dataBean.user.nickname);
        holder.mShiJian.setText(dataBean.createTime);
        holder.mContent.setText(dataBean.content);

            String imgUrls = (String) dataBean.imgUrls;
            if(imgUrls!=null&&imgUrls.length()>0) {
                holder.mRv.setVisibility(View.VISIBLE);
                String[] split = imgUrls.split("\\|");
                TuPianadapter tuPianadapter = new TuPianadapter(context, split);
                holder.mRv.setLayoutManager(new GridLayoutManager(context, 3));
                holder.mRv.setAdapter(tuPianadapter);
            }else{
                holder.mRv.setVisibility(View.GONE);
            }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHould extends RecyclerView.ViewHolder {
        private final TextView mMingZi;
        private final CircleRoundImageView mXcr;
        private final TextView mShiJian;
        private final ImageView mDongHua;
        private final TextView mContent;
        private final RecyclerView mRv;

        public MyViewHould(View itemView) {
            super(itemView);
            mXcr = itemView.findViewById(R.id.im_crv);
            mMingZi = itemView.findViewById(R.id.tv_mingzi);
            mShiJian = itemView.findViewById(R.id.tv_shijian);
            mDongHua = itemView.findViewById(R.id.img_donghua);
            mContent = itemView.findViewById(R.id.tv_content);
            mRv = itemView.findViewById(R.id.rv);
        }
    }

}
