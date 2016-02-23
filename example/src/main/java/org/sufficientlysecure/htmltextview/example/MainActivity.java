package org.sufficientlysecure.htmltextview.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.sufficientlysecure.htmltextview.ClickableTableSpan;
import org.sufficientlysecure.htmltextview.DrawTableLinkSpan;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import static org.sufficientlysecure.htmltextview.example.WebViewActivity.EXTRA_TABLE_HTML;

public class MainActivity extends Activity {

    // The html table(s) are individually passed through to the ClickableTableSpan implementation
    // presumably for a WebView activity.
    class ClickableTableSpanImpl extends ClickableTableSpan {
        @Override
        public ClickableTableSpan newInstance() {
            return new ClickableTableSpanImpl();
        }

        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra(EXTRA_TABLE_HTML, getTableHtml());
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HtmlTextView text = (HtmlTextView) findViewById(R.id.html_text);
        text.setClickableTableSpan(new ClickableTableSpanImpl());
        DrawTableLinkSpan drawTableLinkSpan = new DrawTableLinkSpan();
        drawTableLinkSpan.setTableLinkText("[tap for table]");
        text.setDrawTableLinkSpan(drawTableLinkSpan);
        text.setHtmlFromString(
                "<h2>Hello world</h2>" +
                        "<table>" +
                        "   <tr>" +
                        "       <th>Header 1</th>" +
                        "       <th>Header 2</th>" +
                        "   </tr>" +
                        "   <tr>" +
                        "       <td>mo data</td>" +
                        "       <td>mo problems</td>" +
                        "   </tr>" +
                        "</table>" +
                        "<br/>" +
                        "<ul>" +
                        "   <li>cats</li>" +
                        "   <li>dogs Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet Lorem" +
                        "   ipsum dolor sit amet</li>" +
                        "</ul>" +
                        "<br/>" +
                        "<ol>" +
                        "   <li>first</li>" +
                        "   <li>second" +
                        "       <ol>" +
                        "           <li>second - first" +
                        "           <br/>newline" +
                        "           </li>" +
                        "       </ol>" +
                        "   </li>" +
                        "</ol>" +
                        "<table>" +
                        "   <tr>" +
                        "       <th>Month</th>" +
                        "       <th>Savings</th>" +
                        "   </tr>" +
                        "   <tr>" +
                        "       <td>January</td>" +
                        "       <td>$100</td>" +
                        "   </tr>" +
                        "   <tr>" +
                        "       <td>" +
                        "               <TABLE>" +
                        "           <TR>" +
                        "                       <TH>Header 1</TH>" +
                        "                       <TH>Header 2</TH>" +
                        "           </TR>" +
                        "           <TR>" +
                        "           <TD>1st cell</TD>" +
                        "           <TD>2nd cell</TD>" +
                        "           </TR>" +
                        "           </TABLE>" +
                        "       </td>" +
                        "       <td>yo dawg</td>" +
                        "   </tr>" +
                        "</table>" +
                        "<br/>" +
                        "<img src=\"cat\"/>" +
                        "<br/>A very long text follows below and it contains bold parts. This can" +
                        "cause a crash " +
                        "<a href=\"http://code.google.com/p/android/issues/detail?id=35466\">on some" +
                        " Android versions</a> when using a normal TextView, but our implementation " +
                        "should workaround that bug." +
                        "<br/>" +
                        "<br/>" +
                        "Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>Lo<b>remips</b>umdol<b>orsita</b>metLorem<b>ipsu</b>mdo<b>lorsit</b>ametLoremip<b>sumdolorsitamet.</b>",
                new HtmlTextView.LocalImageGetter());
    }
}
