package zw.btmusicdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import zw.btmusicdemo.util.SoundPoolUtil;

/**
 * Created by zhongwang on 2017/9/8.
 * 可以设置按钮点击音效的基类activity
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {
    private SoundPoolUtil soundPoolUtil;
    private int soundId = 0;
    //默认播放 music1
    private MusicType musicType = MusicType.FIRST;

    /**
     * 设置点击按钮音乐类型
     *
     * @param musicType FIRST SECOND THIRD三个参数
     */
    public void setMusicType(MusicType musicType) {
        this.musicType = musicType;
    }

    /**
     * 定义枚举来限定按钮音乐类型
     */
    public enum MusicType {
        FIRST, SECOND, THIRD
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        soundPoolUtil = SoundPoolUtil.getInstance(this);
    }

    /**
     * 在该方法中调用setMusicType来控制点击音乐类型
     * @param v
     */
    public abstract void click(View v);

    @Override
    public void onClick(View v) {
        click(v);
        switch (musicType) {
            case FIRST:
                soundId = 1;
                break;
            case SECOND:
                soundId = 2;
                break;
            case THIRD:
                soundId = 3;
                break;
        }
        soundPoolUtil.play(soundId);
    }

    public void toast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
