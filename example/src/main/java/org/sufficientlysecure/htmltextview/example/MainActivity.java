package org.sufficientlysecure.htmltextview.example;

import android.app.Activity;
import android.os.Bundle;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HtmlTextView text = (HtmlTextView) findViewById(R.id.html_text);

        text.setHtmlFromString("<h2>Hello world</h2><ul><li>cats</li><li>dogs</li></ul><br/><img src=\"cat\"/>", true);
    }

}
