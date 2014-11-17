package com.jhancarlos.consumingbookswebservice.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.jhancarlos.consumingbookswebservice.R;
import com.jhancarlos.consumingbookswebservice.models.NavigationDrawerItem;
import com.jhancarlos.consumingbookswebservice.views.adapters.NavigationDrawerAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class NavigationDrawerView extends BetterViewAnimator {

    private final NavigationDrawerAdapter adapter;
    @InjectView(R.id.leftDrawerListView)
    ListView leftDrawerListView;


    public NavigationDrawerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        adapter = new NavigationDrawerAdapter(context);
    }

    public void replaceWith(List<NavigationDrawerItem> items) {
        adapter.replaceWith(items);
        setDisplayedChildId(R.id.leftDrawerListView);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
        leftDrawerListView.setAdapter(adapter);
    }

    public NavigationDrawerAdapter getAdapter() {
        return adapter;
    }
}
