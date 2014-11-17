package com.jhancarlos.consumingbookswebservice.views;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jhancarlos.consumingbookswebservice.R;
import com.jhancarlos.consumingbookswebservice.models.NavigationDrawerItem;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class NavigationDrawerItemView extends RelativeLayout {

    final Resources res;
    @InjectView(R.id.itemRR)
    RelativeLayout rr;
    @InjectView(R.id.navigationDrawerItemTitleTV)
    TextView itemTitleTV;
    @InjectView(R.id.navigationDrawerItemIconIV)
    ImageView itemIconIV;


    public NavigationDrawerItemView(Context context) {
        super(context);
        res = context.getResources();

    }

    public NavigationDrawerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        res = context.getResources();
    }

    public NavigationDrawerItemView(Context context, AttributeSet attrs,
                                    int defStyle) {
        super(context, attrs, defStyle);
        res = context.getResources();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    public void bindTo(NavigationDrawerItem item) {
        requestLayout();
        if (item.isMainItem()) {
            itemTitleTV.setText(item.getItemName());
            itemTitleTV.setTextSize(22);
            itemIconIV.setVisibility(View.GONE);
        } else {
            itemTitleTV.setText(item.getItemName());
            itemTitleTV.setTextSize(14);
            itemIconIV.setImageDrawable(getIcon(item.getItemIcon()));
            itemIconIV.setVisibility(View.VISIBLE);
            rr.setBackgroundColor(res.getColor(R.color.grey_background));
        }

        if (item.isSelected()) {
            itemTitleTV.setTypeface(null, Typeface.BOLD);
        } else {
            itemTitleTV.setTypeface(null, Typeface.NORMAL);
        }

    }

    private Drawable getIcon(int res) {
        return getContext().getResources().getDrawable(res);
    }
}
