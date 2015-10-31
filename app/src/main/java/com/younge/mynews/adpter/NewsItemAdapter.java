package com.younge.mynews.adpter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.younge.mynews.CrawlData.NewsItem;
import com.younge.mynews.R;

import java.util.List;


/**
 * Created by younge on 2015/10/30 0030.
 */
public class NewsItemAdapter extends BaseAdapter{


    private LayoutInflater mInflater;
    private List<NewsItem> mDatas;



    public NewsItemAdapter(Context context, List<NewsItem> datas)
    {
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    public void addAll(List<NewsItem> mDatas)
    {
        this.mDatas.addAll(mDatas);
    }

    @Override
    public int getCount()
    {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.item_news, null);
            holder = new ViewHolder();

            holder.mContent = (TextView) convertView.findViewById(R.id.id_content);
            holder.mTitle = (TextView) convertView.findViewById(R.id.id_title);
            holder.mDate = (TextView) convertView.findViewById(R.id.id_date);
            holder.mImg = (SimpleDraweeView) convertView.findViewById(R.id.id_newsImg);

            convertView.setTag(holder);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }
        NewsItem newsItem = mDatas.get(position);
        holder.mTitle.setText(newsItem.getTitle());
        holder.mContent.setText(newsItem.getContent());
        holder.mDate.setText(newsItem.getDate());
        if (newsItem.getImgLink() != null)
        {
            holder.mImg.setVisibility(View.VISIBLE);
            Uri uri = Uri.parse(newsItem.getImgLink());
            holder.mImg.setImageURI(uri);
        } else
        {
            holder.mImg.setVisibility(View.GONE);
        }

        return convertView;
    }

    private final class ViewHolder
    {
        TextView mTitle;
        TextView mContent;
        SimpleDraweeView mImg;
        TextView mDate;
    }
}
