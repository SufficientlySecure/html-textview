package org.sufficientlysecure.htmltextview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.text.Html;

public interface IHtmlTextView {
    String TAG = "HtmlTextView";
    boolean DEBUG = false;

    /**
     * Loads HTML from a raw resource, i.e., a HTML file in res/raw/.
     * This allows translatable resource (e.g., res/raw-de/ for german).
     * The containing HTML is parsed to Android's Spannable format and then displayed.
     *
     * @param resId for example: R.raw.help
     *
     * @see #setHtml(int, Html.ImageGetter)
     * @see #setHtml(String)
     * @see #setHtml(String, Html.ImageGetter)
     */
    void setHtml(@RawRes int resId);

    /**
     * Parses String containing HTML to Android's Spannable format and displays it in this TextView.
     * Using the implementation of Html.ImageGetter provided.
     *
     * @param html String containing HTML, for example: "<b>Hello world!</b>"
     *
     * @see #setHtml(int)
     * @see #setHtml(int, Html.ImageGetter)
     * @see #setHtml(String, Html.ImageGetter)
     */
    void setHtml(@NonNull String html);

    /**
     * Loads HTML from a raw resource, i.e., a HTML file in res/raw/.
     * This allows translatable resource (e.g., res/raw-de/ for german).
     * The containing HTML is parsed to Android's Spannable format and then displayed.
     *
     * @param resId for example: R.raw.help
     * @param imageGetter for fetching images.
     *
     * @see #setHtml(int)
     * @see #setHtml(String)
     * @see #setHtml(String, Html.ImageGetter)
     */
    void setHtml(@RawRes int resId, @Nullable Html.ImageGetter imageGetter);

    /**
     * Parses String containing HTML to Android's Spannable format and displays it in this TextView.
     * Using the implementation of Html.ImageGetter provided.
     *
     * @param html String containing HTML, for example: "<b>Hello world!</b>"
     * @param imageGetter for fetching images.
     *
     * @see #setHtml(int)
     * @see #setHtml(int, Html.ImageGetter)
     * @see #setHtml(String)
     */
    void setHtml(@NonNull String html, @Nullable Html.ImageGetter imageGetter);

    /**
     * Note that this must be called before setting text for it to work
     */
    void setRemoveFromHtmlSpace(boolean removeFromHtmlSpace);

    void setClickableTableSpan(@Nullable ClickableTableSpan clickableTableSpan);

    void setDrawTableLinkSpan(@Nullable DrawTableLinkSpan drawTableLinkSpan);
}
