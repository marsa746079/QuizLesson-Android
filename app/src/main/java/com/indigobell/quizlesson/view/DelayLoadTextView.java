package com.indigobell.quizlesson.view;


import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;

public class DelayLoadTextView extends TextView {
    private static final int TIMEOUT_MESSAGE = 1;

    private String delayLoadText;
    private int delayLoadCount;

    public DelayLoadTextView(Context context) {
        super(context);
    }

    public DelayLoadTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DelayLoadTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
    }

    public void start() {
        handler.sendEmptyMessage(TIMEOUT_MESSAGE);
    }

    // 文字列を一文字ずつ出力するハンドラ
    private Handler handler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            // 文字列を配列に１文字ずつセット
            char data[] = delayLoadText.toCharArray();
            if (delayLoadCount < data.length){
                if (msg.what == TIMEOUT_MESSAGE) {
                    String ch = String.valueOf(data[delayLoadCount]);
                    String newText = getText() + ch;
                    setText(newText);
                    handler.sendEmptyMessageDelayed(TIMEOUT_MESSAGE, 100);
                    delayLoadCount++;
                } else {
                    super.dispatchMessage(msg);
                }
            }
        }
    };
}
