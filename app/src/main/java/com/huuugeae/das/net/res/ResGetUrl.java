package com.huuugeae.das.net.res;

public class ResGetUrl {


    /**
     * successdata : {"name":"Huuuge777","wapurl":"https://api.gilet.ceshi.in/spbet.html","iswap":1,"splash":"","downurl":"","version":0,"webview_set":"SPBET","wsd_version":null,"developer_info":null,"commit_check_time":null,"check_result_time":null,"suspend_time":null}
     * code : 0
     */

    private SuccessdataBean successdata;
    private int code;

    public SuccessdataBean getSuccessdata() {
        return successdata;
    }

    public void setSuccessdata(SuccessdataBean successdata) {
        this.successdata = successdata;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class SuccessdataBean {
        /**
         * name : Huuuge777
         * wapurl : https://api.gilet.ceshi.in/spbet.html
         * iswap : 1
         * splash :
         * downurl :
         * version : 0
         * webview_set : SPBET
         * wsd_version : null
         * developer_info : null
         * commit_check_time : null
         * check_result_time : null
         * suspend_time : null
         */

        private String name;
        private String wapurl;
        private int iswap;
        private String splash;
        private String downurl;
        private int version;
        private String webview_set;
        private Object wsd_version;
        private Object developer_info;
        private Object commit_check_time;
        private Object check_result_time;
        private Object suspend_time;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWapurl() {
            return wapurl;
        }

        public void setWapurl(String wapurl) {
            this.wapurl = wapurl;
        }

        public int getIswap() {
            return iswap;
        }

        public void setIswap(int iswap) {
            this.iswap = iswap;
        }

        public String getSplash() {
            return splash;
        }

        public void setSplash(String splash) {
            this.splash = splash;
        }

        public String getDownurl() {
            return downurl;
        }

        public void setDownurl(String downurl) {
            this.downurl = downurl;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getWebview_set() {
            return webview_set;
        }

        public void setWebview_set(String webview_set) {
            this.webview_set = webview_set;
        }

        public Object getWsd_version() {
            return wsd_version;
        }

        public void setWsd_version(Object wsd_version) {
            this.wsd_version = wsd_version;
        }

        public Object getDeveloper_info() {
            return developer_info;
        }

        public void setDeveloper_info(Object developer_info) {
            this.developer_info = developer_info;
        }

        public Object getCommit_check_time() {
            return commit_check_time;
        }

        public void setCommit_check_time(Object commit_check_time) {
            this.commit_check_time = commit_check_time;
        }

        public Object getCheck_result_time() {
            return check_result_time;
        }

        public void setCheck_result_time(Object check_result_time) {
            this.check_result_time = check_result_time;
        }

        public Object getSuspend_time() {
            return suspend_time;
        }

        public void setSuspend_time(Object suspend_time) {
            this.suspend_time = suspend_time;
        }
    }
}
