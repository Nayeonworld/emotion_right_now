package kr.nayeon.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class ActionActivity extends Activity {
    SeekBar happy_sb, sad_sb, angry_sb, tim_sb, sen_sb;
    Button send;
    int brightness = 50;
    DBManager db;
    int v_happy=brightness, v_angry=brightness, v_sad=brightness, v_sen=brightness, v_tim=brightness;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        db = new DBManager(getApplicationContext(),"Data.db",null,1);
        ActionBar actionBar = getActionBar();
        Drawable d=getResources().getDrawable(R.drawable.bar_font);
        getActionBar().setBackgroundDrawable(d);
        actionBar.show();
        send=(Button)findViewById(R.id.btn_send);
        happy_sb = (SeekBar)findViewById(R.id.happy_seekBar);
        angry_sb = (SeekBar)findViewById(R.id.angry_seekBar);
        sad_sb=(SeekBar)findViewById(R.id.sad_seekBar);
        tim_sb=(SeekBar)findViewById(R.id.timidity_seekBar);
        sen_sb=(SeekBar)findViewById(R.id.sensitive_seekBar);
        happy_sb.setProgress(brightness);
        angry_sb.setProgress(brightness);
        sad_sb.setProgress(brightness);
        tim_sb.setProgress(brightness);
        sen_sb.setProgress(brightness);
        happy_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selected(1,progress);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                //드래그를 시작할때 실행되는 메소드
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                //드래그를 완료했음을 표시

            }
        });
        angry_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                selected(2,progress);
            }
            public void onStartTrackingTouch(SeekBar seekBar){
                //드래그를 시작할때 실행되는 메소드
            }
            public void onStopTrackingTouch(SeekBar seekBar){
                //드래그를 완료했음을 표시
            }
        });
        sad_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                selected(3,progress);
            }
            public void onStartTrackingTouch(SeekBar seekBar){
                //드래그를 시작할때 실행되는 메소드
            }
            public void onStopTrackingTouch(SeekBar seekBar){
                //드래그를 완료했음을 표시
            }
        });
        sen_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                selected(4,progress);
            }
            public void onStartTrackingTouch(SeekBar seekBar){
                //드래그를 시작할때 실행되는 메소드
            }
            public void onStopTrackingTouch(SeekBar seekBar){
                //드래그를 완료했음을 표시
            }
        });
        tim_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                selected(5,progress);
            }
            public void onStartTrackingTouch(SeekBar seekBar){
                //드래그를 시작할때 실행되는 메소드
            }
            public void onStopTrackingTouch(SeekBar seekBar){
                //드래그를 완료했음을 표시
            }
        });
    }
    public void send (View v){
        db.insert("insert into DATA (happy, angry, sad, sen, tim) values("+v_happy+", "+v_angry+", "+v_sad+", "+v_sen+", "+v_tim+");");
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);
        finish();
        db.close();

    }

    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void selected(int e,int value){
        switch (e){
            case 1: {
                v_happy=value;
                break;
            }
            case 2: {
                v_angry=value;
                break;
            }
            case 3: {
                v_sad=value;
                break;
            }
            case 4: {
                v_sen=value;
                break;
            }
            case 5: {
                v_tim=value;
                break;
            }
        }
     }
}
