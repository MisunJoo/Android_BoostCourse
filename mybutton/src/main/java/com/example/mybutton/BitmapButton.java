package com.example.mybutton;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

// button을 생성하는 java resource
public class BitmapButton extends AppCompatButton {

    /* 두 개의 필수 생성자가 필요하다 */
    // java source 파일에서 new button을 만들 때
    public BitmapButton(Context context) {
        super(context);

        init(context);
    }

    // xml파일에서 new button을 만들 때
    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // 배경이미지 설정
    private void init(Context context) {
        setBackgroundResource(R.drawable.title_bitmap_button_normal);

        // cmn + p  파라미터 보는 단축
        // unit은 dp단위
        // pixel 단위로 지정됨

        float textSize = getResources().getDimension(R.dimen.text_size);
        setTextSize(textSize);
        setTextColor(Color.WHITE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN :
                setBackgroundResource(R.drawable.title_bitmap_button_clicked);
                break;
            case MotionEvent.ACTION_UP :
                setBackgroundResource(R.drawable.title_bitmap_button_normal);
                break;
        }

        // 다시 그려주세요 ! 이미지가 바뀌었으니
        invalidate();

        return true;

    }
}
