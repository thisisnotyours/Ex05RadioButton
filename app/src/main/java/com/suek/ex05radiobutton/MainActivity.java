package com.suek.ex05radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rbKor, rbChi, rbJap;
    TextView tv;
    RatingBar ratingBar;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg= findViewById(R.id.rg);
        rbKor= findViewById(R.id.rb_Kor);
        rbChi= findViewById(R.id.rb_Chi);
        rbJap= findViewById(R.id.rb_Jan);
        tv= findViewById(R.id.tv);

        rbChi.setChecked(true);    //자바에서 체크상태 변경설정 가능!   체크버튼을 Korea 에서 China 로 바꿈


        // 2) 라디오그룹안의 라디오버튼의 체크상태가 변경되는 것을 듣는 리스너 객체 생성 및 설정
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               RadioButton rb= findViewById(checkedId);
               String s =rb.getText().toString();
               tv.setText(s);

           }
       });

        // 3) RatingBar 변경 리스너 생성 및 설정
        ratingBar= findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv.setText(rating + "점");
            }
        });

    }//onCreate method..


    // 1)
    public void clickBtn(View v){
        // 1.1) 체크되어 있는 RadioButton 찾아오기
        int id= rg.getCheckedRadioButtonId();
        RadioButton rb= findViewById(id);

        // 1.2) 체크된 라이도버튼의 글씨를 얻어와서 텍스트뷰에 보여주기
        tv.setText(rb.getText().toString());

    }
}
