package com.example.mytoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "위치가 바뀐 토스트", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200); // Gravity는 토스트의 위치
                toast.show(); // 토스트 메시지가 나타남
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 메모리 인플레이션 == 메모리 객체화 , 최상위 객체를 인플레이션
                // LayoutInflater는 xml에 정의된 Resource들을 View의 형태로 반환해
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toastborder, (ViewGroup) findViewById(R.id.toast_layout_root));

                TextView  text = layout.findViewById(R.id.text); //text뷰 찾기
                text.setText("모양을 바꾼 토스트입니다.");

                // getApplicationContext()는 activity와 달리 스타일이 없음
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, -100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);

                toast.show();




            }
        });
    }
}
