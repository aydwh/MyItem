package com.bwie.myitem.bean;

import com.bwie.library.net.ResponseBean;

import java.util.List;

/**
 * 1.类的用途
 * 2.@author:weihuanhuan
 * 3.@ 2017/1/3.
 */

public class WechatBean extends ResponseBean{

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-01-05","title":"【视频】关于2017的20个预言","description":"微云","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/WeoB4682U9h31A89u5lo1jnsyCJljfeKlphceESu3nT3crVNq1QfGiaGNBADY1CuEwCqj70PDTzQjP2GdCoTJUA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/HlM0xF8BxmATFF-L-V7QAA"},{"ctime":"2017-01-05","title":"层次越高的人，往往计较得越少","description":"有书","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/GtWwdCwkv7G5nGRFwHe0bkIEOwrziaqDHW6CkDFGNJfRXl55aVv7nyPukFyDF7qQsf7BUTozic1Xl0XRfDZLT8CA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/bJHxoMmGdMCy6tfL3Kwltg"},{"ctime":"2017-01-04","title":"［大话水浒2］《水浒传》中的神灵扮演什么角色？","description":"小宝说书","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/O7tsV8GMS9n5c8wz8zbfM3nZ4QKyuK8kg1miaYicdRSDTs9QCUzZQ4Kia7ZfT6gNZspJkauzKH3FtU0UGtjpqjKcA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/Kb1m4LcYW7j4FyqnoeUFJw"},{"ctime":"2017-01-04","title":"这大概是百度大脑诞生2年来最正式的一次大考","description":"深几度","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/ZVoaibkuWvjZ0ZotNMicsEAV0zOREiakpbhAIoQ0RLLQJpT21MnkKlHdy0fDicNLxyU6GiaC2wYvGu6fKAXs2FLcG2g/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/svEkXM_nx13k-vmR4c35Zw"},{"ctime":"2017-01-04","title":"未来简史：本书只适合高智商且勇敢的人","description":"中信书店","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/nqelflZYRc7OrkYxwhHZvQicwnG7LJQ3s3nz2fiaCMFx1pgNxmyveUxPkVpkpHNpnMKAOLmz2uOdNex4dGlkDExQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/GHPl131MXZDMoIp1lg6C2Q"},{"ctime":"2017-01-04","title":"体验了下微信小程序，感受到了腾讯的野心。","description":"差评","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/yZPTcMGWibvtfOSUMkd7NjQF88nkSDKNFLyRMXTbeMqex5T6CCfY2FFEnMz5uia4SARSNpicUIrBib2rC8E6zPiaLkA/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/6t8YEOzkUezWJO7Y9v3qnw"},{"ctime":"2017-01-04","title":"如何度过20岁开头的穷苦日子","description":"新世相","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/5ROs96OaibImYXialxp8GBuWdAmCbvdZ5f8zEjPQOr49PIVUdkVcIVgpVJtBeP5Y7AIueBbwk1qhnX10eZnp7icrA/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/BsWITk-EI9LYz7dhyg3icQ"},{"ctime":"2017-01-02","title":"发财树也能开花，花朵还很漂亮！","description":"流意盆栽","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/5hX4zhRicEEHxTdyFibfe1xrbcI1qaAs6yOnY31L6v02T96VxCR3GcZhEwS956NLAFpLLktN34R4baaBauWg4N5A/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/yficc0tDfgFIoKGxhJZMsg"},{"ctime":"2017-01-02","title":"很多事都是后知后觉，比如喝水、添衣和想你。","description":"我要WhatYouNeed","picUrl":"http://mmbiz.qpic.cn/mmbiz_png/zynprs47B4RfDAH6Os3rIFOwzVHGR37yywpmwm7icwJ2q2OgylXt1v1c4pXv2GZl863Oh5tP5FMLubT5uQnxT8Q/0?wx_fmt=png","url":"http://mp.weixin.qq.com/s/psvCdmdncjAeYov_dzmQOQ"},{"ctime":"2017-01-02","title":"这个神奇的眼罩只需戴19分钟，比做大保健还舒服！","description":"差评","picUrl":"http://mmbiz.qpic.cn/mmbiz_jpg/yZPTcMGWibvucibXtEFAYXic59vNKADwhjicATjicbIic68bZvGnPCXWicf7IkOPhLmYaBj8sJvHIBDbY3XNbDw2EQiaOQ/0?wx_fmt=jpeg","url":"http://mp.weixin.qq.com/s/j9uTFY5Bw0wYWRBCmSssmA"}]
     */

    public int code;
    public String msg;
    /**
     * ctime : 2017-01-05
     * title : 【视频】关于2017的20个预言
     * description : 微云
     * picUrl : http://mmbiz.qpic.cn/mmbiz_png/WeoB4682U9h31A89u5lo1jnsyCJljfeKlphceESu3nT3crVNq1QfGiaGNBADY1CuEwCqj70PDTzQjP2GdCoTJUA/0?wx_fmt=png
     * url : http://mp.weixin.qq.com/s/HlM0xF8BxmATFF-L-V7QAA
     */

    public List<NewslistBean> newslist;

    public static class NewslistBean {
        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;
    }
}
