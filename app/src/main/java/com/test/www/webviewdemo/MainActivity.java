package com.test.www.webviewdemo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.HttpAuthHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    private static final String TOKEN = "Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImM1YjI1N2M0NzRkM2U5MTViYjcyYWUwOGJmNGRhOGZlZTkyMWJlYTIwM2VlMGU4NTZkYjBhZDdlZDA5YTczMmQyZWM1MzA3ZjYxOTFiNGZjIn0.eyJhdWQiOiIzIiwianRpIjoiYzViMjU3YzQ3NGQzZTkxNWJiNzJhZTA4YmY0ZGE4ZmVlOTIxYmVhMjAzZWUwZTg1NmRiMGFkN2VkMDlhNzMyZDJlYzUzMDdmNjE5MWI0ZmMiLCJpYXQiOjE1MjEwNTQ3OTAsIm5iZiI6MTUyMTA1NDc5MCwiZXhwIjo0Njc2NzI4MzkwLCJzdWIiOiI2NDEwMTc2MjIiLCJzY29wZXMiOltdfQ.b2G2shOUMA_s05Ol_PPFGCDW5vYGPuBALWOXWZcgs7_ArgisqGHge8x5ggUFtKe2K7bwKuBy2w6GfNsX6qLUztJlqvWppRgImitBtsu7xRQix_d1rGdzySZzrO6kr5UxpHqCYz4KkNhOy6ILZQKNpwp5vRujyfd6eKoMDEPSWdh4qbxXjw3CPHKHOu-vGJobN_csHC9nimVCWAdikROnWb9jQTmjylyWGKzSEWMvKLXDL4YuWcjGrPkm3bTK3hwHLl2oTnlCzZJ8Poomyid-O_O4Pjrj06H3a_gIjYJk8idDDSjUiwBdWQwwl8sHIFs9BoKoNXRLTpaH-TXwnjdYC0k7S0n6eiCtX7oVmvLToBMKezPcdX7cm3tszTrjP3QYBKchItB7QMEUl8Bn7bRnNxdRgT_w9CVx5KlbGT_gyf8Q01iKVGuDdVe9TzcNM96nLIonCpzjZ6p-wgH8EcMy2p3MHyuLTvnSCZJP3RPdm2PsPEGq_ZG6LNnBlcubavMFr6cUVudZqilvC_WapzM8mQKM8RASnMiVVRtiHaeZzK2XOCnJO7GtPBb9qBkdxfBdBK2oa_KoJ0AMa1Dw4xxIUMBX_jQkNv_N_oLnPapGbrRZZYyzMjYd_NCyTtcqB4j-g2ZoB_O496xlvOyqvFlqNd9-9YffaHj_Xma8EYgNCic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);


        Map<String, String> header = new HashMap<>();
        header.put("Authorization", TOKEN);
        String url = "https://ezhalha.com.sa/api/v2/servicesPeices?lang=en";

        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(url, header);

    }


    /*======================================================*/
    private class MyWebViewClient extends WebViewClient {


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            Map<String, String> header = new HashMap<>();
            header.put("Authorization", TOKEN);
            webView.loadUrl(url, header);

            return true;
        }

        @Override
        public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
            //here goes your url authentications if any
            handler.proceed("Authorization", TOKEN);
        }


    }
    /*======================================================*/

}
