package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recyclerView xml에서 먼저 선언 후, 가져오기
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // 어떤 Layoutmanager를 채택해 그릴지를 선
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // 개발자가 직접 adapter 구현
        final SingerAdapter adapter = new SingerAdapter(getApplicationContext());

        // adater에 item추가
        adapter.addItem(new SingerItem("소녀시대", "010-0000-0000"));
        adapter.addItem(new SingerItem("걸스데이", "010-1000-0000"));
        adapter.addItem(new SingerItem("여자친구", "010-2000-0000"));

        // recyclerView에 adapter 설정
        recyclerView.setAdapter(adapter);
        // adpater야, item을 클릭했을 때의 처리를 네가 해주렴
        // setOnItemClickListener는 Adapter에서 개발자가 직접 만든 함수
        adapter.setOnItemClickListener(new SingerAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(SingerAdapter.ViewHolder holder, View view, int positiion) {
                SingerItem item = adapter.getItem(positiion);

                Toast.makeText(getApplicationContext(), "아이템 선택됨 : " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
