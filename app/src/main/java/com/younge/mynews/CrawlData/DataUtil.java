package com.younge.mynews.CrawlData;

import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by younge on 2015/10/30 0030.
 */
public class DataUtil {

    private static final String TAG = "DataUtil";

    public static String doGet(String urlStr) throws CommonException{
        StringBuffer sb = new StringBuffer();
        try
        {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            if (conn.getResponseCode() == 200)
            {
                InputStream is = conn.getInputStream();
                int len = 0;
                byte[] buf = new byte[1024];

                while ((len = is.read(buf)) != -1)
                {
                    sb.append(new String(buf, 0, len, "UTF-8"));
                }

                is.close();
            } else
            {
                throw new CommonException("访问网络失败！");
            }

        } catch (Exception e)
        {
            throw new CommonException("访问网络失败！");
        }
       // Log.d(TAG, "返回的数据为：" + sb.toString());
        return sb.toString();
    }
}
