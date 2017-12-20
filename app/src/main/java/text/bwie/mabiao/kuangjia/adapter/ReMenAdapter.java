package text.bwie.mabiao.kuangjia.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
    public DianjiShiJian dianjiShiJian;
    public getFenXiang fenXiang;
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
    public void onBindViewHolder(final ReMenAdapter.MyViewHould holder, final int position) {
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

        if(dataBean.falg){
            Glide.with(context).load(R.mipmap.yitaojian).into(holder.mJia);
            holder.mWei.setVisibility(View.VISIBLE);
            holder.mLian.setVisibility(View.VISIBLE);
            holder.mXie.setVisibility(View.VISIBLE);
        }else{
            Glide.with(context).load(R.mipmap.yitaojia).into(holder.mJia);
            holder.mWei.setVisibility(View.GONE);
            holder.mLian.setVisibility(View.GONE);
            holder.mXie.setVisibility(View.GONE);
        }


        holder.mJia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dataBean.falg==false){
                    Glide.with(context).load(R.mipmap.yitaojian).into(holder.mJia);
                    holder.mWei.setVisibility(View.VISIBLE);
                    holder.mLian.setVisibility(View.VISIBLE);
                    holder.mXie.setVisibility(View.VISIBLE);
                    ObjectAnimator  xuan=ObjectAnimator.ofFloat( holder.mJia,"rotation",360,0);
                    xuan.setDuration(1000);
                    xuan.start();
                    ObjectAnimator  alphaAnimator=ObjectAnimator.ofFloat( holder.mWei,"alpha",0f,1f);
                    ObjectAnimator  rotationXAnimator=ObjectAnimator.ofFloat( holder.mWei,"rotation",360,0);
                    ObjectAnimator  translationXAnimator=ObjectAnimator.ofFloat( holder.mWei,"translationX",0,-50);
                    AnimatorSet animatorSet=new AnimatorSet();
                    animatorSet.play(translationXAnimator).with(alphaAnimator).with(rotationXAnimator);
                    animatorSet.setDuration(1000);
                    animatorSet.start();

                    ObjectAnimator  alphaAnimator2=ObjectAnimator.ofFloat( holder.mLian,"alpha",0f,1f);
                    ObjectAnimator  rotationXAnimator2=ObjectAnimator.ofFloat( holder.mLian,"rotation",360,0);
                    ObjectAnimator  translationXAnimator2=ObjectAnimator.ofFloat( holder.mLian,"translationX",0,-100);
                    AnimatorSet animatorSet2=new AnimatorSet();
                    animatorSet2.play(translationXAnimator2).with(alphaAnimator2).with(rotationXAnimator2);
                    animatorSet2.setDuration(1000);
                    animatorSet2.start();

                    ObjectAnimator  alphaAnimator3=ObjectAnimator.ofFloat( holder.mXie,"alpha",0f,1f);
                    ObjectAnimator  rotationXAnimator3=ObjectAnimator.ofFloat( holder.mXie,"rotation",360,0);
                    ObjectAnimator  translationXAnimator3=ObjectAnimator.ofFloat( holder.mXie,"translationX",0,-150);
                    AnimatorSet animatorSet3=new AnimatorSet();
                    animatorSet3.play(translationXAnimator3).with(alphaAnimator3).with(rotationXAnimator3);
                    animatorSet3.setDuration(1000);
                    animatorSet3.start();
                    dataBean.falg=true;
                }
                else
                {
                    Glide.with(context).load(R.mipmap.yitaojia).into(holder.mJia);
                    ObjectAnimator  xuan1=ObjectAnimator.ofFloat(holder.mJia,"rotation",0,360);
                    xuan1.setDuration(1000);
                    xuan1.start();
                    ObjectAnimator  alphaAnimator1=ObjectAnimator.ofFloat(holder.mWei,"alpha",1f,0f);
                    ObjectAnimator  rotationXAnimator1=ObjectAnimator.ofFloat(holder.mWei,"rotation",0,360);
                    ObjectAnimator  translationXAnimator1=ObjectAnimator.ofFloat(holder.mWei,"translationX",-50,0);
                    AnimatorSet animatorSet1=new AnimatorSet();
                    animatorSet1.play(translationXAnimator1).with(alphaAnimator1).with(rotationXAnimator1);
                    animatorSet1.setDuration(1000);
                    animatorSet1.start();

                    ObjectAnimator  alphaAnimator21=ObjectAnimator.ofFloat(holder.mLian,"alpha",1f,0f);
                    ObjectAnimator  rotationXAnimator21=ObjectAnimator.ofFloat(holder.mLian,"rotation",0,360);
                    ObjectAnimator  translationXAnimator21=ObjectAnimator.ofFloat(holder.mLian,"translationX",-100,0);
                    AnimatorSet animatorSet21=new AnimatorSet();
                    animatorSet21.play(translationXAnimator21).with(alphaAnimator21).with(rotationXAnimator21);
                    animatorSet21.setDuration(1000);
                    animatorSet21.start();

                    ObjectAnimator  alphaAnimator31=ObjectAnimator.ofFloat(holder.mXie,"alpha",1f,0f);
                    ObjectAnimator  rotationXAnimator31=ObjectAnimator.ofFloat(holder.mXie,"rotation",0,360);
                    ObjectAnimator  translationXAnimator31=ObjectAnimator.ofFloat(holder.mXie,"translationX",-150,0);
                    AnimatorSet animatorSet31=new AnimatorSet();
                    animatorSet31.play(translationXAnimator31).with(alphaAnimator31).with(rotationXAnimator31);
                    animatorSet31.setDuration(1000);
                    animatorSet31.start();
                    dataBean.falg=false;
                }

                }

        });
/**
 * -----------------------------------------------关注----------------------------------------------------
 */
        final int uid = dataBean.uid;
        holder.mXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dianjiShiJian.DianZan(v,position,uid);

            }
        });
/**
 * --------------------------------分享----------------------------------------------------------
  */
        holder.mFenXiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fenXiang.FenXiang(v,position,uid);
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
        private final ImageView mJia;
        private final ImageView mXie;
        private final ImageView mLian;
        private final ImageView mWei;

        public MyViewHould(View itemView) {
            super(itemView);
            mTou = itemView.findViewById(R.id.recommend_item_tou);
            mTitle = itemView.findViewById(R.id.recommend_title);
            mTime = itemView.findViewById(R.id.recommend_time);
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

            mJia = itemView.findViewById(R.id.img_jia);
            mXie = itemView.findViewById(R.id.img_xie);
            mLian = itemView.findViewById(R.id.img_lian);
            mWei = itemView.findViewById(R.id.img_wei);
        }
    }

    /**
     * -------------------------------------------------关注-------------------------------------------------------
     * @param dianjiShiJian
     */
    public void setDianjiShiJian(DianjiShiJian dianjiShiJian) {
        this.dianjiShiJian = dianjiShiJian;
    }

    public interface DianjiShiJian{
        void DianZan(View v, int position,int uid);
    }
    /**
     * -----------------------------------------分享---------------------------------------------
     */

    public void setFenXiang(getFenXiang fenXiang) {
        this.fenXiang = fenXiang;
    }

    public interface getFenXiang{
        void FenXiang(View v, int position,int uid);
    }



}
