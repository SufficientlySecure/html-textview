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

        text.setHtmlFromString("<h2>Hello world</h2><ul><li>cats</li><li>dogs Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet Lorem ipsum dolor sit amet</li></ul><br/><ol><li>first</li><li>second<ol><li>second - first<br/>newline</li></ol></li></ol><br/><img src=\"cat\"/><br/><br/>A very long text follows below and it contains bold parts. This can cause a crash <a href=\"http://code.google.com/p/android/issues/detail?id=35466\">on some Android versions</a> when using a normal TextView, but our implementation should workaround that bug.<br/><br/>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>", new HtmlTextView.LocalImageGetter());
    }

}
