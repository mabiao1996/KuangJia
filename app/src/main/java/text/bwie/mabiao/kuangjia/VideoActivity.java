package text.bwie.mabiao.kuangjia;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;
import text.bwie.mabiao.kuangjia.utils.SPutils;

public class VideoActivity extends BaseActivity implements View.OnClickListener {

    private List<LocalMedia> selectList = new ArrayList<>();
    private ImageView mIng;
    private RelativeLayout mRl;
    private LinearLayout mFanHui;
    private ImageView mAnJian;
    private Button mQueDing;
    private SPutils sp;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }
    @Override
    public int getLayouid() {
        return R.layout.activity_video;

    }
    @Override
    public void init(Bundle savedInstanceState) {
    }
    @Override
    public void initView() {
        mIng = findViewById(R.id.video_img);
        mRl = findViewById(R.id.video_rl);
        mFanHui = findViewById(R.id.video_ll_fanhui);
        mAnJian = findViewById(R.id.video_anjian);
        mQueDing = findViewById(R.id.video_queding);
        mAnJian.setOnClickListener(this);
        mQueDing.setOnClickListener(this);
        sp = new SPutils("video");

    }
    @Override
    public void initData() {

    }
    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.video_anjian:
                PictureSelector.create(VideoActivity.this)
                        .openGallery(PictureMimeType.ofVideo())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                        // .theme()主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                        .maxSelectNum(1)//最大图片选择数量 int
                        .minSelectNum(1)// 最小选择数量 int
                        .imageSpanCount(4)// 每行显示个数 int
                        .selectionMode( PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .previewImage(true)// 是否可预览图片 true or false
                        .previewVideo(true)// 是否可预览视频 true or false
                        .enablePreviewAudio(false) // 是否可播放音频 true or false
                        .isCamera(true)// 是否显示拍照按钮 true or false
                        .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                        .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                        .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                        //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                        .enableCrop(false)// 是否裁剪 true or false
                        .compress(true)// 是否压缩 true or false
                        .glideOverride(400,400)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                        .withAspectRatio(3,2)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                        .hideBottomControls(true)// 是否显示uCrop工具栏，默认不显示 true or false
                        .isGif(true)// 是否显示gif图片 true or false
                        // .compressSavePath(getPath())//压缩图片保存地址
                        .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                        .circleDimmedLayer(true)// 是否圆形裁剪 true or false
                        .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                        .showCropGrid(true)// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
                        .openClickSound(false)// 是否开启点击声音 true or false
                        .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                        .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                        //.cropCompressQuality()// 裁剪压缩质量 默认90 int
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        .synOrAsy(true)//同步true或异步false 压缩 默认同步
                        // .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
                        .rotateEnabled(true) // 裁剪是否可旋转图片 true or false
                        .scaleEnabled(true)// 裁剪是否可放大缩小图片 true or false
                        .videoQuality(1)// 视频录制质量 0 or 1 int
                        .videoMaxSecond(15)// 显示多少秒以内的视频or音频也可适用 int
                        .videoMinSecond(10)// 显示多少秒以内的视频or音频也可适用 int
                        .recordVideoSecond(25)//视频秒数录制 默认60s int
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
                break;
            case R.id.video_queding:
                    startActivitys(MiaoShuActivity.class,null);
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩
                    RelativeLayout rela= findViewById(R.id.video_rl);
                    View inflate = LayoutInflater.from(this).inflate(R.layout.simple_player_view_player, rela);
                    PlayerView playerVie=new PlayerView(this,inflate)
                            .setScaleType(PlayStateParams.fitparent)
                            .hideMenu(true)
                            .forbidTouch(false)
                            .setPlaySource(selectList.get(0).getPath())
                            .startPlay();
                    if(selectList.get(0).getPath()==null){
                        mIng.setVisibility(View.VISIBLE);
                        mRl.setVisibility(View.GONE);
                    }else{
                        mIng.setVisibility(View.GONE);
                        mRl.setVisibility(View.VISIBLE);
                        sp.putSting("path",selectList.get(0).getPath());
                    }
                    break;
            }
        }
    }

}
