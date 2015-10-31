package com.younge.mynews.CrawlData;

/**
 * Created by younge on 2015/10/30 0030.
 * 异常类
 */
public class CommonException extends Exception{

    public CommonException() {
        super();
    }
    public CommonException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CommonException(String message)
    {
        super(message);
    }

    public CommonException(Throwable cause)
    {
        super(cause);
    }
}
