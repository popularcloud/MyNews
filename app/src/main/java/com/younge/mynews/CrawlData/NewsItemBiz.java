package com.younge.mynews.CrawlData;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by younge on 2015/10/30 0030.
 */
public class NewsItemBiz {

    private static final String TAG = "NewsItemBiz";

    public List<NewsItem> getNewsItems(int newsType,int currentPage) throws CommonException{

        String urlStr = URLUtil.generateUrl(newsType, currentPage);

        Log.d(TAG,"访问地址为："+urlStr);
        String htmlStr = DataUtil.doGet(urlStr);
       // Log.d(TAG,"返回的数据为："+htmlStr);

        List<NewsItem> newsItems = new ArrayList<NewsItem>();
        NewsItem newsItem = null;

        Document doc = Jsoup.parse(htmlStr);
        Elements units = doc.getElementsByClass("unit");

        for (int i = 0;i < units.size();i++){
            newsItem = new NewsItem();
            newsItem.setNewsType(newsType);

            Element unit_ele = units.get(i);

            //标题和链接
            Element h1_ele = unit_ele.getElementsByTag("h1").get(0);
            Element h1_a_ele = h1_ele.child(0);
            String title = h1_a_ele.text();
            String href = h1_a_ele.attr("href");

            newsItem.setLink(href);
            newsItem.setTitle(title);

            //发布时间
            Element h4_ele = unit_ele.getElementsByTag("h4").get(0);
            Element ago_ele = h4_ele.getElementsByClass("ago").get(0);
            String date = ago_ele.text();

            newsItem.setDate(date);

            //图片和内容
            Element dl_ele = unit_ele.getElementsByTag("dl").get(0);// dl
            Element dt_ele = dl_ele.child(0);// dt
            try
            {// 可能没有图片
                Element img_ele = dt_ele.child(0);
                String imgLink = img_ele.child(0).attr("src");
                newsItem.setImgLink(imgLink);
            } catch (IndexOutOfBoundsException e)
            {

            }
            Element content_ele = dl_ele.child(1);// dd
            String content = content_ele.text();
            newsItem.setContent(content);
            newsItems.add(newsItem);
        }
        Log.d(TAG,"封装的集合为："+newsItems);
        return newsItems;
    }
}
