package com.younge.mynews.ui.fragment;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.younge.mynews.CrawlData.CommonException;
import com.younge.mynews.CrawlData.NewsItem;
import com.younge.mynews.CrawlData.NewsItemBiz;
import com.younge.mynews.R;
import com.younge.mynews.adpter.NewsItemAdapter;

import java.util.ArrayList;
import java.util.List;

import me.maxwin.view.IXListViewLoadMore;
import me.maxwin.view.IXListViewRefreshListener;
import me.maxwin.view.XListView;

/**
 * Created by younge on 2015/10/29 0029.
 */
public class MainFragment extends Fragment implements IXListViewRefreshListener, IXListViewLoadMore {

    private int newsType = 0;
    private XListView mXListView;
    private NewsItemAdapter mAdapter;
    /**
     * 数据
     */
    private List<NewsItem> mDatas = new ArrayList<NewsItem>();
    /**
     * 当前页面
     */
    private int currentPage = 1;
    /**
     * 处理新闻的业务类
     */
    private NewsItemBiz mNewsItemBiz;


    public MainFragment(int newsType)
    {
        this.newsType = newsType;
        mNewsItemBiz = new NewsItemBiz();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdapter = new NewsItemAdapter(getActivity(), mDatas);
        /**
         * 初始化
         */
        mXListView = (XListView) getView().findViewById(R.id.id_xlistView);
        mXListView.setAdapter(mAdapter);
        mXListView.setPullRefreshEnable(this);
        mXListView.setPullLoadEnable(this);
        //mXListView.NotRefreshAtBegin();
        /**
         * 进来时直接刷新
         */
        mXListView.startRefresh();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_item_fragment_main, null);

        /*TextView tip = (TextView) view.findViewById(R.id.id_tip);
        tip.setText(TabAdapter.TITLES[newsType]);*/
        return view;
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMore() {

    }

    /**
     * 刷新
     */
    @Override
    public void onRefresh() {
        new LoadDatasTask().execute();
    }

    /**
     * 记载数据的异步任务
     * @author zhy
     *
     */
    class LoadDatasTask extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected Void doInBackground(Void... params)
        {
            try
            {
                List<NewsItem> newsItems = mNewsItemBiz.getNewsItems(newsType, currentPage);
                mDatas = newsItems;
            } catch (CommonException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            mAdapter.addAll(mDatas);
            mAdapter.notifyDataSetChanged();
            mXListView.stopRefresh();
        }

    }
}
