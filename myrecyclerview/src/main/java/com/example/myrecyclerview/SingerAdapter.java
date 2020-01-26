package com.example.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ViewHolder> {
     // ViewHolder는 각각의 아이템에 대한 view를 담아두는 역할
     // View안에 들어가있는 것들에 대한 작업 (데이터 설정 등)을 함

    Context context;
    OnItemClickListener listener;

    // ListView에서는 item을 위한 view를 보관했다면,
    // RelativeView에서는 item을 위한 data만 보관한다.
    // data를 보관할 list
    ArrayList<SingerItem> items = new ArrayList<SingerItem>();

    //item View를 저장하는 viewHolder클래
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TextView textView2;
        // click event를 처리할 것이기 때문에
        OnItemClickListener listener;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);

            // 각각의 item에 대한 view가 클릭됐을 때,
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClickListener(ViewHolder.this, v, position);
                    }
                }
            });
        }

        // data
        public void setItem(SingerItem item) {
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }

        public void setOnItemClickListener (OnItemClickListener listener) {
            this.listener = listener;
        }
    }

    // recyclerView의 click 이벤트를 처리하는 리스너도 직접 구현해줘야 함
    // onItemClick 인터페이스와, 함수 선언
    public static interface OnItemClickListener {
        public void onItemClickListener(ViewHolder holder, View view, int positiion);
    }


    // 생성자에서 context를 전달받
    public SingerAdapter(Context context) {
        this.context = context;
    }

    // on(시점) viewHolder가 생성되는 시점
    // ViewHolder는 view를 담고있음
    // 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.singer_item, parent, false);
        return new ViewHolder(itemView);
    }

    // ViewHolder와 data(item)이 결합되는 시점
    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SingerItem item = items.get(position); // 몇번째까지 보여야하는지
        holder.setItem(item); //viewholder에 들어가있는 view에 data 설정

        holder.setOnItemClickListener(listener);

    }

    // item의 개수가 몇 개 인가?
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(SingerItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<SingerItem> items) {
        this.items = items;
    }

    public SingerItem getItem(int position) {
        return items.get(position);
    }

    //event
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
