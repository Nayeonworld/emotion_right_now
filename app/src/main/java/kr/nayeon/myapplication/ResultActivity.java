package kr.nayeon.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends Activity {
    ImageView img_feeling;
    TextView  num_feeling,t_happy,t_angry,t_sad,t_sen,t_tim;
    DBManager db;
    int happy,angry,sad,sen,tim,count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        img_feeling = (ImageView)findViewById(R.id.img_my_feeling);
        num_feeling = (TextView)findViewById(R.id.text_my_feeling);
        t_happy = (TextView)findViewById(R.id.happy_text);
        t_angry = (TextView)findViewById(R.id.angry_text);
        t_sad = (TextView)findViewById(R.id.sad_text);
        t_sen = (TextView)findViewById(R.id.sen_text);
        t_tim = (TextView)findViewById(R.id.tim_text);
        db = new DBManager(getApplicationContext(),"Data.db",null,1);
        ActionBar actionBar = getActionBar();
        Drawable d=getResources().getDrawable(R.drawable.bar_font);
        getActionBar().setBackgroundDrawable(d);
        actionBar.show();
        happy=db.PrintHappy();
        angry = db.PrintAngry();
        sad=db.PrintSad();
        sen = db.PrintSen();
        tim = db.PrintTim();
        count = db.GetCount();
        int max_index=5,max=0;
        String max_str="";
        int arr[]={db.PrintHappy(),db.PrintAngry(),db.PrintSad(),db.PrintSen(),db.PrintTim()};
        for(int i=0;i<5;i++){
            if(max<arr[i]){
                max=arr[i];
                max_index = i;
            }
        }
        switch(max_index) {
            case 0:{
                img_feeling.setImageResource(R.drawable.haapy);break;
            }
            case 1:{
                img_feeling.setImageResource(R.drawable.angry);break;
            }
            case 2:{
                img_feeling.setImageResource(R.drawable.sad);break;
            }
            case 3:{
                img_feeling.setImageResource(R.drawable.sensitive);break;
            }
            case 4:{
                img_feeling.setImageResource(R.drawable.timidity);break;
            }
        }
        System.out.println("count : "+count);
        if(count!=0) {
            t_happy.setText(""+happy / count);
            t_angry.setText(""+angry / count);
            t_sad.setText(""+sad / count);
            t_sen.setText(""+sen / count);
            t_tim.setText(""+tim / count);
        }

    }
    public void onBackPressed() {
        Intent intent = new Intent(this, ActionActivity.class);
        startActivity(intent);
        finish();
        db.close();
    }

}
