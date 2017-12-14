package text.bwie.mabiao.kuangjia.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.bean.ShiPinBean;
import text.bwie.mabiao.kuangjia.comment.CircleRoundImageView;

/**
 * Created by mabiao on 2017/12/1.
 */

public class ReMenAdapter extends XRecyclerView.Adapter<ReMenAdapter.MyViewHould>{
    private Context context;
    private List<ShiPinBean.DataBean> list;
    public ReMenAdapter(Context context,List<ShiPinBean.DataBean> list) {
        this.context = context;
        this.list=list;
    }
    @Override
    public ReMenAdapter.MyViewHould onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragments1_item, parent,false);
        MyViewHould my=new MyViewHould(view);
        return my;
    }
    @Override
    public void onBindViewHolder(final ReMenAdapter.MyViewHould holder, int position) {
        final ShiPinBean.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.user.icon).into(holder.mTou);
        holder.mTitle.setText(dataBean.user.nickname);
        holder.mTime.setText(dataBean.createTime);
        String workDesc = (String) dataBean.workDesc;
        holder.mShuo.setText(workDesc);
        final String replace = dataBean.videoUrl.replace("https://www.zhaoapi.cn/", "http://120.27.23.105/");
        Glide.with(context).load(dataBean.cover).into(holder.mFengMian);
        holder.mFengMian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mFengMian.setVisibility(View.GONE);
                holder.mShiPin.setVisibility(View.VISIBLE);
                System.out.println("视频"+replace);
                View inflate = LayoutInflater.from(context).inflate(R.layout.simple_player_view_player, holder.mShiPin);
                PlayerView playerView=new PlayerView((Activity) context,inflate)
                        .setScaleType(PlayStateParams.fitparent)
                        .hideMenu(true)
                        .forbidTouch(false)
                        .setPlaySource(replace)
                        .startPlay();
            }
        });



    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHould extends RecyclerView.ViewHolder {

        private final CircleRoundImageView mTou;
        private final TextView mTitle;
        private final TextView mTime;
        private final ImageView mJia;
        private final TextView mShuo;
        private final RelativeLayout mShiPin;
        private final ImageView mXin;
        private final TextView mTvXin;
        private final ImageView mXing;
        private final TextView mTvXing;
        private final ImageView mFenXiang;
        private final TextView mTvFenXiang;
        private final ImageView mPingLun;
        private final TextView mTvPingLun;
        private final TextView mMingZi;
        private final TextView mRemen;
        private final ImageView mFengMian;

        public MyViewHould(View itemView) {
            super(itemView);
            mTou = itemView.findViewById(R.id.recommend_item_tou);
            mTitle = itemView.findViewById(R.id.recommend_title);
            mTime = itemView.findViewById(R.id.recommend_time);
            mJia = itemView.findViewById(R.id.img_jia);
            mShuo = itemView.findViewById(R.id.tv_shuo);
            mShiPin = itemView.findViewById(R.id.rv_shipin);
            mXin = itemView.findViewById(R.id.img_xin);
            mTvXin = itemView.findViewById(R.id.tv_xin);
            mXing = itemView.findViewById(R.id.img_xing);
            mTvXing = itemView.findViewById(R.id.tv_xing);
            mFenXiang = itemView.findViewById(R.id.img_fenxiang);
            mTvFenXiang = itemView.findViewById(R.id.tv_fenxiang);
            mPingLun = itemView.findViewById(R.id.img_pinglun);
            mTvPingLun = itemView.findViewById(R.id.tv_pinglun);
            mMingZi = itemView.findViewById(R.id.remen_tv_mingzi);
            mRemen = itemView.findViewById(R.id.remen_pinglun);
            mFengMian = itemView.findViewById(R.id.img_fengmian);
        }
    }
}
