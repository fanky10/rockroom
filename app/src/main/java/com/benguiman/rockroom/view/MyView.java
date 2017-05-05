package com.benguiman.rockroom.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * @author benjamin.massello on 4/6/17.
 */

public class MyView extends android.support.v7.widget.AppCompatImageView {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getContext().obtainStyledAttributes(attrs, new int[10]);
    }
}
