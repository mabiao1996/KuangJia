package text.bwie.mabiao.kuangjia.bean;

import java.util.List;

/**
 * Created by mabiao on 2017/12/18.
 */

public class GuanZhuLIEBiaoBean {

    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-18T10:45:46","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/15131486893501.jpg","latitude":null,"longitude":null,"mobile":"15297526557","money":0,"nickname":"beautiful","password":"123456","praiseNum":null,"token":"D9C75CAADF0EE4C106A4C4D9B4DE1B19","uid":170,"userId":null,"username":"15297526557"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-17T20:05:45","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","latitude":null,"longitude":null,"mobile":"15810672623","money":0,"nickname":"小狼","password":"123456","praiseNum":null,"token":"28C3793F9AB8E555D523C46D8D867998","uid":150,"userId":null,"username":"15810672623"},{"age":null,"appkey":"ca37aa09e5365f3e","appsecret":"0B24FB0C1AE2494A5EB9643D293FBDD5","createtime":"2017-12-18T14:20:47","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1513510357310image.jpg","latitude":null,"longitude":null,"mobile":"13051089902","money":null,"nickname":"soul","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"E3498601C8D3A37869C60836790A63A1","uid":2956,"userId":null,"username":"13051089902"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-18T10:45:46
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/15131486893501.jpg
         * latitude : null
         * longitude : null
         * mobile : 15297526557
         * money : 0
         * nickname : beautiful
         * password : 123456
         * praiseNum : null
         * token : D9C75CAADF0EE4C106A4C4D9B4DE1B19
         * uid : 170
         * userId : null
         * username : 15297526557
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
