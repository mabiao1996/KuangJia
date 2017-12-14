package text.bwie.mabiao.kuangjia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;

import text.bwie.mabiao.kuangjia.base.BaseActivity;
import text.bwie.mabiao.kuangjia.base.BasePresenter;

public class VideoBoFangActivity extends BaseActivity {


    private RelativeLayout mRl;
    private String shipin;
    private PlayerView playerView;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayouid() {
        return R.layout.activity_video_bo_fang;
    }
    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        mRl = findViewById(R.id.bofang_rl);
        Intent intent=getIntent();
        shipin = intent.getStringExtra("shipin");
        System.out.println("shipin视频"+shipin);
        String replace = shipin.replace("https://www.zhaoapi.cn/", "http://120.27.23.105/");
        View inflate = LayoutInflater.from(this).inflate(R.layout.simple_player_view_player, mRl);
        playerView = new PlayerView(this,inflate)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(replace)
                .startPlay();

}

    @Override
    public void initData() {

    }

    @Override
    protected boolean NoTile() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerView.stopPlay();
    }
}
