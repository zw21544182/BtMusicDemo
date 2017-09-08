package zw.btmusicdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zw.btmusicdemo.R;
import zw.btmusicdemo.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void click(View v) {
        switch (v.getId()) {
            case R.id.button1:
                setMusicType(MusicType.FIRST);
                toast("点击了按钮1");
                break;
            case R.id.button2:
                setMusicType(MusicType.SECOND);
                toast("点击了按钮2");
                break;
            case R.id.button3:
                setMusicType(MusicType.THIRD);
                toast("点击了按钮3");
                break;
        }
    }
}
