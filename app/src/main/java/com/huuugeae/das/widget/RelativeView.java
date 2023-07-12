package com.huuugeae.das.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huuugeae.das.R;


public class RelativeView extends RelativeLayout {
    private ImageView titleBarBack;
    private ImageView titleBarMore;
    private TextView titleBarTitle;
    private String titleName;
    private int mColor = Color.BLUE;
    private int mTextColor = Color.WHITE;

    public RelativeView(Context context) {
        super(context);
        initView(context);
    }


    public RelativeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.RelativeView);
        mColor = mTypedArray.getColor(R.styleable.RelativeView_title_bg, Color.BLUE);
        titleName = mTypedArray.getString(R.styleable.RelativeView_title_text);
        mTypedArray.recycle();
        initView(context);
        setTitle(titleName);
    }

    public RelativeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_relative, this, true);
        titleBarBack = (ImageView) findViewById(R.id.title_bar_back);
        titleBarMore = (ImageView) findViewById(R.id.title_bar_more);
        titleBarTitle = (TextView) findViewById(R.id.title_bar_title);
    }

    public void setTitle(String titleName) {
        if (!TextUtils.isEmpty(titleName)) {
            titleBarTitle.setText(titleName);
        }
    }

    public void setBackListener(OnClickListener onClickListener) {
        titleBarBack.setOnClickListener(onClickListener);
    }

    public void setMoreListener(OnClickListener onClickListener) {
        titleBarMore.setOnClickListener(onClickListener);
    }
}
