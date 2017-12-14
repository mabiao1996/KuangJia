package text.bwie.mabiao.kuangjia.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;
import java.util.Random;

import text.bwie.mabiao.kuangjia.R;
import text.bwie.mabiao.kuangjia.VideoBoFangActivity;
import text.bwie.mabiao.kuangjia.bean.RemenVidwoBean;
import text.bwie.mabiao.kuangjia.bean.ShiPinBean;

/**
 * Created by mabiao on 2017/12/14.
 */

public class VideoReMenadapter extends XRecyclerView.Adapter<VideoReMenadapter.MyViewHould> {
    private Context context;
    private List<RemenVidwoBean.DataBean> list;

    public VideoReMenadapter(Context context, List<RemenVidwoBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VideoReMenadapter.MyViewHould onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_fragment1_adapter, parent, false);
        MyViewHould my=new MyViewHould(view);
        return my;
    }

    @Override
    public void onBindViewHolder(final VideoReMenadapter.MyViewHould holder, int position) {
        final RemenVidwoBean.DataBean dataBean = list.get(position);
        String videoUrl = dataBean.videoUrl;
        final String replace = videoUrl.replace("https://www.zhaoapi.cn/", "http://120.27.23.105/");
        ViewGroup.LayoutParams layoutParams=holder.mImg.getLayoutParams();
        Random random=new Random();
        int i = random.nextInt(400);
        layoutParams.height=400+i;
        Glide.with(context).load(dataBean.cover).into(holder.mImg);
        holder.mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(context, VideoBoFangActivity.class);
            intent.putExtra("shipin",dataBean.videoUrl);
            context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHould extends RecyclerView.ViewHolder {

        private final ImageView mImg;

        public MyViewHould(View itemView) {
            super(itemView);
            mImg = itemView.findViewById(R.id.video_fragment1_img);
        }
    }
}
