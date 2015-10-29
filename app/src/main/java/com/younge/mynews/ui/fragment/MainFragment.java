package com.younge.mynews.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.younge.mynews.R;
import com.younge.mynews.adpter.TabAdapter;

/**
 * Created by younge on 2015/10/29 0029.
 */
public class MainFragment extends Fragment {

    private int newsType = 0;

    public MainFragment(int newsType)
    {
        this.newsType = newsType;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_item_fragment_main, null);
        TextView tip = (TextView) view.findViewById(R.id.id_tip);
        tip.setText(TabAdapter.TITLES[newsType]);
        return view;
    }
}
