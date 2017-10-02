package org.sufficientlysecure.htmltextview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.text.Html;

import java.io.InputStream;
import java.util.Scanner;

final class HtmlTextViewImpl {
    private final HtmlTextViewDelegate delegate;

    @Nullable
    private ClickableTableSpan clickableTableSpan;

    @Nullable
    private DrawTableLinkSpan drawTableLinkSpan;

    private boolean removeFromHtmlSpace = true;

    /**
     * http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
     */
    @NonNull
    private static String convertStreamToString(@NonNull final InputStream is) {
        final Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    /**
     * Html.fromHtml sometimes adds extra space at the bottom.
     * This methods removes this space again.
     * See https://github.com/SufficientlySecure/html-textview/issues/19
     */
    @Nullable
    private static CharSequence removeHtmlBottomPadding(@Nullable CharSequence text) {
        if (text == null) {
            return null;
        }

        while (text.length() > 0 && text.charAt(text.length() - 1) == '\n') {
            text = text.subSequence(0, text.length() - 1);
        }
        return text;
    }

    public HtmlTextViewImpl(final HtmlTextViewDelegate delegate) {
        this.delegate = delegate;
    }

    public boolean isRemoveFromHtmlSpace() {
        return removeFromHtmlSpace;
    }

    @Nullable
    public ClickableTableSpan getClickableTableSpan() {
        return clickableTableSpan;
    }

    @Nullable
    public DrawTableLinkSpan getDrawTableLinkSpan() {
        return drawTableLinkSpan;
    }

    public void setRemoveFromHtmlSpace(final boolean removeFromHtmlSpace) {
        this.removeFromHtmlSpace = removeFromHtmlSpace;
    }

    public void setClickableTableSpan(@Nullable final ClickableTableSpan clickableTableSpan) {
        this.clickableTableSpan = clickableTableSpan;
    }

    public void setDrawTableLinkSpan(@Nullable final DrawTableLinkSpan drawTableLinkSpan) {
        this.drawTableLinkSpan = drawTableLinkSpan;
    }

    public void setHtml(@RawRes final int resId) {
        setHtml(resId, null);
    }

    public void setHtml(@NonNull final String html) {
        setHtml(html, null);
    }

    public void setHtml(@RawRes final int resId, @Nullable final Html.ImageGetter imageGetter) {
        InputStream inputStreamText = delegate.openRawResource(resId);
        setHtml(convertStreamToString(inputStreamText), imageGetter);
    }

    public void setHtml(@NonNull String html, @Nullable final Html.ImageGetter imageGetter) {
        final HtmlTagHandler htmlTagHandler = new HtmlTagHandler(delegate.getPaint());
        htmlTagHandler.setClickableTableSpan(clickableTableSpan);
        htmlTagHandler.setDrawTableLinkSpan(drawTableLinkSpan);

        html = htmlTagHandler.overrideTags(html);

        if (removeFromHtmlSpace) {
            delegate.setText(
                    removeHtmlBottomPadding(Html.fromHtml(html, imageGetter, htmlTagHandler)));
        } else {
            delegate.setText(Html.fromHtml(html, imageGetter, htmlTagHandler));
        }

        // make links work
        delegate.setMovementMethod(LocalLinkMovementMethod.getInstance());
    }
}
