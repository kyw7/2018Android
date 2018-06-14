package com.example.kywlater.myapplication;


import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by 16911 on 2018/06/14.
 */

public class passwordEditText extends android.support.v7.widget.AppCompatEditText {
    private Drawable imgClear;
    private Context mContext;
    private boolean swi=true;
    public passwordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    private void init() {
        imgClear = mContext.getResources().getDrawable(R.drawable.can);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setDrawable();
            }
        });
    }
    private void setDrawable(){
        if (length() < 1)
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        else
            setCompoundDrawablesWithIntrinsicBounds(null, null, imgClear, null);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(imgClear != null && event.getAction() == MotionEvent.ACTION_UP)
        {
            int eventX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 100;
            //在这里添加事件
            Drawable drawable=getResources().getDrawable(R.drawable.can);
            Drawable drawable2=getResources().getDrawable(R.drawable.cannot);
            float sp= getResources().getDrawable(R.drawable.search2).getIntrinsicWidth();
            if(event.getX()>this.getWidth()-sp) {
                if (swi == true) {
                    this.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable2, null);
                    swi = false;
                    this.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    this.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
                    swi = true;
                    //this.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    this.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            String s=this.getText().toString();
            Log.d("sas",s);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
