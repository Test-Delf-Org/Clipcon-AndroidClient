package com.sprout.clipcon.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.sprout.clipcon.R;


public class TopService extends Service {
    private View m_View;
    private WindowManager m_WindowManager;
    private WindowManager.LayoutParams  m_Params;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println(" 에러 테스트 1 ");

        // top_view 레이아웃을 생성하여 뷰 출력.
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_View = mInflater.inflate(R.layout.top_button, null);
        m_View.setOnTouchListener(onTouchListener);

        m_Params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_TOAST,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        m_Params.gravity = Gravity.LEFT | Gravity.TOP;
        m_Params.horizontalMargin = 0.1f;
        m_Params.verticalMargin = 0.05f;

        System.out.println(" 에러 테스트 2 ");

        m_WindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        m_WindowManager.addView(m_View, m_Params);

        System.out.println(" 에러 테스트 3 ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // 생성 된 레이아웃 제거.
        m_WindowManager.removeView(m_View);
        m_WindowManager = null;
    }

    // 터치 이벤트.
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch(event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;

                case MotionEvent.ACTION_MOVE:
                    break;

                case MotionEvent.ACTION_UP:
                    break;
            }

            return false;
        }
    };

    public void onImageBtnTest(View v) {
        Toast.makeText(getApplicationContext(), "top Image button pressed", Toast.LENGTH_SHORT).show();

    }
}