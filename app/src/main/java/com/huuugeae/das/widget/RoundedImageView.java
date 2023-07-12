package com.huuugeae.das.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.huuugeae.das.R;

public class RoundedImageView extends AppCompatImageView {
    private float cornerRadius;
    private Path path;
    private RectF rectF;

    public RoundedImageView(Context context) {
        super(context);
        init();
    }

    public RoundedImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundedImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        cornerRadius = getResources().getDimension(R.dimen.dp_5);
        path = new Path();
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rectF.set(0, 0, getWidth(), getHeight());
        path.reset();
        path.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
