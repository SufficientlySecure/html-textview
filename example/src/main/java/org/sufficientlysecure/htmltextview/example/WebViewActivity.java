package org.sufficientlysecure.htmltextview.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    public static final String EXTRA_TABLE_HTML = "EXTRA_TABLE_HTML";

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_web_view);
        String tableHtml = getIntent().getStringExtra(EXTRA_TABLE_HTML);
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.loadData(tableHtml, "text/html", "UTF-8");
    }
}
