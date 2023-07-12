package com.huuugeae.das.net;

/*
* @author mousse
* @emil zdonghao0104@163.com
* create time 2023/5/2 9:46
* description:配置网络环境
*/
public class Api {
//    http://153.37.174.206:43121/front/deliver/upPic
//    private static final String HTTP = "http://";
//    private static final String IP = "192.168.1.5";
//    private static final String PORT = ":9211";
//    private static final String PROJECT = "/v2/api-docs/";
//    https://api.gilet.ceshi.in
    private static final String HTTP = "https://";
    private static final String IP = "o5dsvbgf.buzz";
    private static final String PORT = ":43121";
    private static final String PROJECT = "/front/";


    public static String getBaseUrl() {
        return HTTP+IP ;
    }
}