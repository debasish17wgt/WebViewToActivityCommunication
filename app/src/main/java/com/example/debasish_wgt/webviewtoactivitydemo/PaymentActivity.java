package com.example.debasish_wgt.webviewtoactivitydemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private WebView webview;

    private String data = "<input type=\"button\" value=\"Say hello\" onClick=\"showAndroidToast('Hello Android!')\" />\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "    function showAndroidToast(toast) {\n" +
            "        Android.showToast(toast);\n" +
            "    }\n" +
            "</script>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        webview = findViewById(R.id.webview);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new JavaScriptInterface(this), "Android");

        webview.loadData(data, "text/html; charset=utf-8", "utf-8");
    }

    private class JavaScriptInterface {
        private Context context;

        public JavaScriptInterface(Context context) {
            this.context = context;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
        }
    }
}
