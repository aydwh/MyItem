package com.bwie.myitem.bean.tvbean;

import com.bwie.library.net.ResponseBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gaojian on 2017/1/12.
 */

public class ShowTvBean extends ResponseBean{


    public String announcement;
    public String category_id;
    public String category_name;
    public int follow;
    public boolean forbid_status;
    public boolean hidden;
    public String intro;
    public boolean is_star;
    public String last_play_at;
    public LiveBean live;
    public String nick;
    public int no;
    public String play_at;
    public boolean play_status;
    public boolean police_forbid;
    public int screen;
    public String slug;
    public String status;
    public String thumb;
    public String title;
    public int uid;
    public String video_quality;
    public int view;
    public int watermark;
    public String watermark_pic;
    public int weight;
    public List<?> admins;
    public List<?> hot_word;
    public List<?> notice;
    public List<?> rank_curr;
    public List<RankTotalBean> rank_total;
    public List<RankWeekBean> rank_week;
    public List<RoomLinesBean> room_lines;
    public List<?> tab;

    public static class LiveBean {

        public WsBean ws;

        public static class WsBean {


            public String def_mobile;
            public String def_pc;
            public FlvBean flv;
            public HlsBean hls;
            public String name;
            public String v;

            public static class FlvBean {


                public int main_mobile;
                public int main_pc;
                @SerializedName("3")
                public SanBean san;
                @SerializedName("4")
                public SiBean si;
                @SerializedName("5")
                public WuBean wu;

                public static class SanBean {

                    public String name;
                    public String src;
                }

                public static class SiBean {


                    public String name;
                    public String src;
                }

                public static class WuBean {


                    public String name;
                    public String src;
                }
            }

            public static class HlsBean {

                public int main_mobile;
                public int main_pc;
                @SerializedName("3")
                public SanBeanX san;
                @SerializedName("4")
                public SiBeanX si;
                @SerializedName("5")
                public WuBeanX wu;

                public static class SanBeanX {

                    public String name;
                    public String src;
                }

                public static class SiBeanX {


                    public String name;
                    public String src;
                }

                public static class WuBeanX {


                    public String name;
                    public String src;
                }
            }
        }
    }

    public static class RankTotalBean {


        public String avatar;
        public String icon;
        public int rank;
        public int score;
        public String send_nick;
        public String send_uid;
    }

    public static class RankWeekBean {


        public String avatar;
        public String icon;
        public int rank;
        public int score;
        public String send_nick;
        public String send_uid;
    }

    public static class RoomLinesBean {


        public String def_mobile;
        public String def_pc;
        public FlvBeanX flv;
        public HlsBeanX hls;
        public String name;
        public String v;

        public static class FlvBeanX {


            public int main_mobile;
            public int main_pc;
            public SanBeanXX san;
            public SiBeanXX si;
            public WuBeanXX wu;

            public static class SanBeanXX {


                public String name;
                public String src;
            }

            public static class SiBeanXX {


                public String name;
                public String src;
            }

            public static class WuBeanXX {


                public String name;
                public String src;
            }
        }

        public static class HlsBeanX {


            public int main_mobile;
            public int main_pc;
            public SanBeanXXX san;
            public SiBeanXXX si;
            public WuBeanXXX wu;

            public static class SanBeanXXX {


                public String name;
                public String src;
            }

            public static class SiBeanXXX {


                public String name;
                public String src;
            }

            public static class WuBeanXXX {


                public String name;
                public String src;
            }
        }
    }
}
