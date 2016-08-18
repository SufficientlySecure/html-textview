/*
 * Copyright (C) 2016 Andhie Wong <andhiewong@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sufficientlysecure.htmltextview.example;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.sufficientlysecure.htmltextview.DrawTableLinkSpan;
import org.sufficientlysecure.htmltextview.HtmlResImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;
import org.sufficientlysecure.htmltextview.example.databinding.ActivityDataBindingExampleBinding;

public class DataBindingExampleActivity extends Activity {

    // layout_name + binding, generated class
    private ActivityDataBindingExampleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_example);

        // create dummy item
        NewsItem item = new NewsItem();
        item.setHtml("<p>Interdum et malesuada <b>some bold text in here</b> fames ac ante ipsum primis in faucibus.</p>");

        // in XML we declared a variable newsItem, data binding generated the set method
        // once set, all fields/values/views are updated accordingly
        binding.setNewsItem(item);

        // if you have set an android:id in XML, data binding do the 'findViewById()'
        DrawTableLinkSpan drawTableLinkSpan = new DrawTableLinkSpan();
        drawTableLinkSpan.setTableLinkText("[tap for table]");
        binding.htmlText.setDrawTableLinkSpan(drawTableLinkSpan);
    }

    /**
     * This method will be used by data binding when we use app:html in XML.
     * BindingAdapters only need to be declared once and usable in the whole app.
     * Its better to put all BindingAdapters in a single Java file.
     *
     * @param view The {@link HtmlTextView}
     * @param html The value from {@link NewsItem#getHtml()}
     */
    @BindingAdapter({"html"})
    public static void displayHtml(HtmlTextView view, @Nullable String html) {
        view.setHtml(html, new HtmlResImageGetter(view));
    }

    /**
     * A plain old Java object that holds a HTML string.
     */
    public static class NewsItem {

        private String html;

        public void setHtml(String html) {
            this.html = html;
        }

        /**
         * This method is called by data binding as we declared app:html="@{newsItem.html}"
         *
         * @return the HTML string that will be set into {@link HtmlTextView}
         */
        public String getHtml() {
            return html;
        }
    }
}
