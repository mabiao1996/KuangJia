package text.bwie.mabiao.kuangjia.bean;

/**
 * Created by mabiao on 2017/11/29.
 */

public class LoginBean {


    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-29T19:26:32","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/129.jpg","latitude":null,"longitude":null,"mobile":"13803814923","money":0,"nickname":"若水","password":"123456","praiseNum":null,"token":"4E6C5F55324B82C686ABC24149001343","uid":129,"userId":null,"username":"13803814923"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-11-29T19:26:32
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/129.jpg
         * latitude : null
         * longitude : null
         * mobile : 13803814923
         * money : 0
         * nickname : 若水
         * password : 123456
         * praiseNum : null
         * token : 4E6C5F55324B82C686ABC24149001343
         * uid : 129
         * userId : null
         * username : 13803814923
         */

        public Object age;
        public Object appkey;
        public Object appsecret;
        public String createtime;
        public Object email;
        public Object fans;
        public Object follow;
        public int gender;
        public String icon;
        public Object latitude;
        public Object longitude;
        public String mobile;
        public int money;
        public String nickname;
        public String password;
        public Object praiseNum;
        public String token;
        public int uid;
        public Object userId;
        public String username;
    }
}
