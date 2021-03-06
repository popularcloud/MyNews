package com.younge.mynews.CrawlData;

/**
 * Created by younge on 2015/10/30 0030.
 * 文章类
 */
public class NewsItem {

    /**
     * 编号
     */
    private int id;
    /**
     * 标题
     */
    private String title;
    /**
     * 链接
     */
    private String link;
    /**
     * 发布日期
     */
    private String date;
    /**
     * 图片的链接
     */
    private String imgLink;
    /**
     * 内容
     */
    private String content;
    /**
     * 类型
     *
     */
    private int newsType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNewsType() {
        return newsType;
    }

    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }

    @Override
    public String toString()
    {
        return "NewsItem [id=" + id + ", title=" + title + ", link=" + link + ", date=" + date + ", imgLink=" + imgLink
                + ", content=" + content + ", newsType=" + newsType + "]";
    }

}
