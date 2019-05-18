package cn.mcandroid.test19;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class webView extends Activity {
    private LinearLayout so;
    private WebView wv;
    private Button btn_action;
    private EditText ed_webview;
    private  LinearLayout ll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        ll=(LinearLayout)findViewById(R.id.ll);
        so=(LinearLayout)findViewById(R.id.so);
        wv=(WebView)findViewById(R.id.wv);
        btn_action=(Button)findViewById(R.id.btn_action);
        ed_webview=(EditText)findViewById(R.id.ed_webview);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://www.mcandroid.cn");
        wv.setWebViewClient(new MyWebViewClient() );
        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.baidu.com/s?wd="+ed_webview.getText().toString();
                wv.loadUrl(url);
                wv.getSettings().setJavaScriptEnabled(true);
                wv.setWebViewClient(new MyWebViewClient() );
                }
        });

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getKeyCode()==KeyEvent.KEYCODE_BACK&&wv.canGoBack()){
            wv.goBack();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wv.clearCache(true);
    }

    private class  MyWebViewClient extends WebViewClient{
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if(!url.equals("http://www.mcandroid.cn/")){
                so.setVisibility(View.GONE);
            }

        }
    }
}
