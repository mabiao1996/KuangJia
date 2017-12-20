package text.bwie.mabiao.kuangjia.bean;

import java.util.List;

/**
 * Created by mabiao on 2017/12/8.
 */

public class ShiPinBean {


    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151269622766220171208091557.jpg","createTime":"2017-12-08T09:23:47","favoriteNum":0,"latitude":"40.040909","localUri":null,"longitude":"116.300428","playNum":null,"praiseNum":0,"uid":3028,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512615058350image.jpg","nickname":"13","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512696227662sccvideo.mp4","wid":197,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151269584485020171208091557.jpg","createTime":"2017-12-08T09:17:24","favoriteNum":0,"latitude":"40.040909","localUri":null,"longitude":"116.300428","playNum":null,"praiseNum":0,"uid":3028,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512615058350image.jpg","nickname":"13","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512695844850sccvideo.mp4","wid":196,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151269551486520171208091129.jpg","createTime":"2017-12-08T09:11:54","favoriteNum":0,"latitude":"40.040909","localUri":null,"longitude":"116.300428","playNum":null,"praiseNum":0,"uid":3028,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512615058350image.jpg","nickname":"13","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512695514865sccvideo.mp4","wid":195,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512695492193215628ekxkvk5xnhx35ccm.jpg","createTime":"2017-12-08T09:11:32","favoriteNum":0,"latitude":"40.04045210099616","localUri":null,"longitude":"116.30003466083213","playNum":null,"praiseNum":0,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512179089975avator_thump.jpg","nickname":"李灿灿","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512695492193PictureSelector_20171208_091033.mp4","wid":194,"workDesc":"夜光"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512695479928215628ekxkvk5xnhx35ccm.jpg","createTime":"2017-12-08T09:11:19","favoriteNum":0,"latitude":"40.04045210096649","localUri":null,"longitude":"116.30003464079894","playNum":null,"praiseNum":0,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512179089975avator_thump.jpg","nickname":"李灿灿","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512695479928PictureSelector_20171208_091033.mp4","wid":193,"workDesc":"夜光"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15126527940211512173357013.jpeg","createTime":"2017-12-07T21:19:54","favoriteNum":0,"latitude":"40.040461","localUri":null,"longitude":"116.300046","playNum":null,"praiseNum":0,"uid":86,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/86.jpg","nickname":"GUODONG.","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15126527940211507345866218.mp4","wid":192,"workDesc":"在人间"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151265022566220171207203644.jpg","createTime":"2017-12-07T20:37:05","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":null,"praiseNum":0,"uid":675,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512306825287image2017120311306.png","nickname":"zyk","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512650225662psvideo.mp4","wid":191,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151265021949020171207203644.jpg","createTime":"2017-12-07T20:36:59","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":null,"praiseNum":0,"uid":675,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512306825287image2017120311306.png","nickname":"zyk","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512650219490psvideo.mp4","wid":190,"workDesc":null},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151264912663120171206_200500.jpg","createTime":"2017-12-07T20:18:46","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"50","playNum":null,"praiseNum":0,"uid":77,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512203571490dsf.jpg","nickname":"若水","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15126491266311511879626537.mp4","wid":189,"workDesc":"11"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/151264885311520171207201239.jpg","createTime":"2017-12-07T20:14:13","favoriteNum":0,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":null,"praiseNum":0,"uid":675,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512306825287image2017120311306.png","nickname":"zyk","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512648853115psvideo.mp4","wid":188,"workDesc":null}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/151269622766220171208091557.jpg
         * createTime : 2017-12-08T09:23:47
         * favoriteNum : 0
         * latitude : 40.040909
         * localUri : null
         * longitude : 116.300428
         * playNum : null
         * praiseNum : 0
         * uid : 3028
         * user : {"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512615058350image.jpg","nickname":"13","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1512696227662sccvideo.mp4
         * wid : 197
         * workDesc : null
         */

        public int commentNum;
        public String cover;
        public String createTime;
        public int favoriteNum;
        public String latitude;
        public Object localUri;
        public String longitude;
        public Object playNum;
        public int praiseNum;
        public int uid;
        public UserBean user;
        public String videoUrl;
        public int wid;
        public Object workDesc;
        public List<?> comments;
        public boolean falg =false;
        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : null
             * icon : https://www.zhaoapi.cn/images/1512615058350image.jpg
             * nickname : 13
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public String follow;
            public String icon;
            public String nickname;
            public String praiseNum;
        }
    }
}
