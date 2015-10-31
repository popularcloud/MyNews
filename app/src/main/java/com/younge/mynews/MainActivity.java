package com.younge.mynews;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.viewpagerindicator.TabPageIndicator;
import com.younge.mynews.CrawlData.CommonException;
import com.younge.mynews.CrawlData.NewsItem;
import com.younge.mynews.CrawlData.NewsItemBiz;
import com.younge.mynews.adpter.TabAdapter;

import java.util.List;

public class MainActivity extends FragmentActivity {

    private TabPageIndicator mIndicator;
    private ViewPager mViewPager;
    private TabAdapter mAdapter;
    private ImageView hader_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initContentView();
    }

    private void initContentView() {
        mIndicator = (TabPageIndicator) findViewById(R.id.id_indicator);
        mViewPager = (ViewPager) findViewById(R.id.id_pager);
        hader_image = (ImageView) findViewById(R.id.header_image);
        mAdapter = new TabAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mIndicator.setViewPager(mViewPager, 0);

        hader_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NewsItemBiz biz = new NewsItemBiz();
                final int currentPage = 1;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                List<NewsItem> newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YEJIE, currentPage);
                            } catch (CommonException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            }
        });
    }


    }
