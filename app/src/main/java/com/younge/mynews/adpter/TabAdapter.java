package com.younge.mynews.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.younge.mynews.ui.fragment.MainFragment;

/**
 * Created by younge on 2015/10/29 0029.
 */
public class TabAdapter extends FragmentPagerAdapter{

    public static final String[] TITLES = new String[] { "业界", "移动", "研发", "程序员杂志", "云计算" };
    private static final String TAG = "TabAdapter";

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new MainFragment(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        Log.e(TAG,"position="+position+";position/TITLES.length="+position % TITLES.length);
        return TITLES[position % TITLES.length];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }
}
