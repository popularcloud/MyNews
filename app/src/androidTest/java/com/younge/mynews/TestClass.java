package com.younge.mynews;

import android.test.InstrumentationTestCase;

import com.younge.mynews.CrawlData.CommonException;
import com.younge.mynews.CrawlData.NewsItem;
import com.younge.mynews.CrawlData.NewsItemBiz;

import java.lang.Exception;
import java.util.List;


public class TestClass extends InstrumentationTestCase{


    public void test() throws Exception{
        NewsItemBiz biz = new NewsItemBiz();
        int currentPage = 1;
        try
        {
            /**
             * 业界
             */
            List<NewsItem> newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YEJIE, currentPage);
           // if(newsItems != null){
            for (NewsItem item : newsItems)
            {
                System.out.println(item);
            }
            //}

            System.out.println("----------------------");
            /**
             * 程序员杂志
             */
            newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_CHENGXUYUAN, currentPage);
           // if(newsItems != null) {
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }
           // }
            System.out.println("----------------------");
            /**
             * 研发
             */
            newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YANFA, currentPage);
           // if(newsItems != null) {
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }
           // }
            System.out.println("----------------------");
            /**
             * 移动
             */
            newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YIDONG, currentPage);
           // if(newsItems != null) {
                for (NewsItem item : newsItems) {
                    System.out.println(item);
                }
           // }
            System.out.println("----------------------");

        } catch (CommonException e)
        {
            e.printStackTrace();
        }
    }

}