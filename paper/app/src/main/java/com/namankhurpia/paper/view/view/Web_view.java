package com.namankhurpia.paper.view.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.namankhurpia.paper.R;

public class Web_view extends AppCompatActivity {

    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        final String value = getIntent().getExtras().getString("url");

        mWebView =(WebView)findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        Toast.makeText(getApplicationContext(), "PDFs may take time to load",Toast.LENGTH_LONG).show();
        mWebView.loadUrl("https://docs.google.com/viewer?url="+value);


    }
}
