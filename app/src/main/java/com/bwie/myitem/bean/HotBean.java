package com.bwie.myitem.bean;

import com.bwie.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/5.
 */

public class HotBean extends ResponseBean{

    /**
     * news_id : 9118326
     * url : http://news-at.zhihu.com/api/2/news/9118326
     * thumbnail : http://pic3.zhimg.com/323f26997f46f07c9400806b02f1851e.jpg
     * title : 一年里最适合换工作的时候，可能就是这两个月了
     */

    public List<RecentBean> recent;

    public static class RecentBean {
        public int news_id;
        public String url;
        public String thumbnail;
        public String title;
    }
}
