package com.huuugeae.das.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.Constants;
import com.adjust.sdk.webbridge.AdjustBridge;
import com.huuugeae.das.R;
import com.huuugeae.das.util.EventUtils;
import com.huuugeae.das.util.XLog;

import org.json.JSONException;
import org.json.JSONObject;

public class WebViewActivity extends AppCompatActivity {
    private static final String TAG = "WebViewActivity";
    private WebView wv;
    private String url;

    public static final String PACKAGE_NAME = "getPackageName";//获取安卓包名
    public static final String DEVICE_ID = "getDeviceId";//获取设备id,
    public static final String SET_ORIENTATION = "setOrientation";//切换横竖屏dir(竖屏V 横屏H)
    public static final String ADJUST_LOG_EVENT = "adjustlogEvent";//aj统计 其中获取其中的三个字段typetoken，tObjData，tCurrencyType
    public static final String GET_ADJUST_KEY = "getAdJustKey";//获取aj数据 返回值为json
    public static final String COPY_TO_CLIPBOARD  = "COPY_TO_CLIPBOARD";//需要复制返回的JSON字符串中的content字段的内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            url = bundle.getString("URL");
        }
        wv = findViewById(R.id.webview);
        WebSettings webSettings = wv.getSettings();
        //加载本地中的html文件
//        wv.loadUrl("file:///android_asset/web.html");

        //设置支持js否则有些网页无法打开
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
//设置自适应屏幕
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(false); // 缩放至屏幕的大小
        //缩放操作
        webSettings.setSupportZoom(false); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportMultipleWindows(true);

        //TODO constans 版本问题 暂时注释
//        webSettings.setUserAgentString(EventUtils.getUseragent(this, Constants.VERSION,Constants.DEVICE_NUMBER));
//其他细节操作
//缓存模式如下：
//LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        //LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        //LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        //LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //webview缓存设置
        webSettings.setAllowFileAccess(true); //设置可以访问本地文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setDatabaseEnabled(true);//是否开启数据库缓存
        wv.addJavascriptInterface(new MyJavascriptInterface(this), "android");

        wv.setWebViewClient(new MyClient());
        wv.setWebChromeClient(new MyWebChromeClient());
        AdjustBridge.registerAndGetInstance(getApplication(), wv);
        //加载网络url
        wv.loadUrl(url);
    }

    class MyClient extends WebViewClient {
        //监听到页面发生跳转的情况，默认打开web浏览器
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            //在webView中加载要打开的链接
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        //页面开始加载
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e(TAG, "onPageStarted: ");
        }

        //页面加载完成的回调方法
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.e(TAG, "onPageFinished: ");
            //在webView中加载js代码
            wv.loadUrl("javascript:alert('hello')");
        }
    }

    class MyWebChromeClient extends WebChromeClient {
        //监听网页进度 newProgress进度值在0-100
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        //设置Activity的标题与 网页的标题一致
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //如果用户按的是返回键 并且WebView页面可以返回
        if (keyCode == event.KEYCODE_BACK && wv.canGoBack()) {
            //让WebView返回
            wv.goBack();
            return true;
        }
        //如果WebView不能返回 则调用默认的onKeyDown方法 退出Activity
        return super.onKeyDown(keyCode, event);
    }

    public class MyJavascriptInterface {
        private Context context;

        public MyJavascriptInterface(Context context) {
            this.context = context;
        }

        @JavascriptInterface
        public String callJava(String nameString, String message) {
            switch (nameString) {
                case PACKAGE_NAME:
                    XLog.e("mousse","callJava----PACKAGE_NAME");
                    return context.getApplicationContext().getPackageName();


                case DEVICE_ID:
                    XLog.e("mousse","callJava----DEVICE_ID");
                    return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);


                case SET_ORIENTATION:
                    XLog.e("mousse","callJava----SET_ORIENTATION");
                    try {
                        JSONObject jsonObject = new JSONObject(message);
                        String dir = jsonObject.getString("dir");
                        if (dir.equals("V")) {
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
                        } else {
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;

                case ADJUST_LOG_EVENT:
                    XLog.e("mousse","callJava----ADJUST_LOG_EVENT");
                    try {
                        JSONObject mJsonObjData = new JSONObject(message);
                        String typeToken = mJsonObjData.getString("typetoken");
                        String tCurrencyType = mJsonObjData.getString("tCurrencyType");
                        String jsonData = mJsonObjData.getString("tObjData");
                        AdjustEvent adjustEvent = new AdjustEvent(typeToken);
                        if (tCurrencyType != null && !tCurrencyType.equals("")) {
                            adjustEvent.setRevenue(Double.parseDouble(jsonData), tCurrencyType);
                        }
                        Adjust.trackEvent(adjustEvent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case GET_ADJUST_KEY:

                    XLog.e("mousse","callJava----GET_ADJUST_KEY");
                    try {
                        AdjustAttribution attribution = Adjust.getAttribution();
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("trackerName", attribution.trackerName);
                        jsonObject.put("trackerToken", attribution.trackerToken);
                        jsonObject.put("adid", attribution.adid);
                        jsonObject.put("clickLabel", attribution.clickLabel);
                        return jsonObject.toString();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;

                case COPY_TO_CLIPBOARD:
                    try {
                        JSONObject jsonObject = new JSONObject(message);
                        String content = jsonObject.getString("content");
                        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        clipboardManager.setText(content);
                        clipboardManager.setPrimaryClip(ClipData.newPlainText(null,content));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
            }

            return "";

        }
    }


}
