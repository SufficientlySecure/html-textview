package org.sufficientlysecure.htmltextview;

import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HtmlFormatter {

    private HtmlFormatter() {
    }

    public static Spanned formatHtml(@NonNull HtmlFormatterBuilder builder) {
        return formatHtml(builder.getHtml(), builder.getImageGetter(), builder.getClickableTableSpan(), builder.getDrawTableLinkSpan(), builder.getIndent(), builder.isRemoveTrailingWhiteSpace());
    }

    public static Spanned formatHtml(@Nullable String html, ImageGetter imageGetter, ClickableTableSpan clickableTableSpan, DrawTableLinkSpan drawTableLinkSpan, float indent, boolean removeTrailingWhiteSpace) {
        final HtmlTagHandler htmlTagHandler = new HtmlTagHandler();
        htmlTagHandler.setClickableTableSpan(clickableTableSpan);
        htmlTagHandler.setDrawTableLinkSpan(drawTableLinkSpan);
        htmlTagHandler.setListIndentPx(indent);

        html = htmlTagHandler.overrideTags(html);

        Spanned formattedHtml;
        if (removeTrailingWhiteSpace) {
            formattedHtml = removeHtmlBottomPadding(Html.fromHtml(html, imageGetter, htmlTagHandler));
        } else {
            formattedHtml = Html.fromHtml(html, imageGetter, htmlTagHandler);
        }

        return formattedHtml;
    }

    /**
     * Html.fromHtml sometimes adds extra space at the bottom.
     * This methods removes this space again.
     * See https://github.com/SufficientlySecure/html-textview/issues/19
     */
    @Nullable
    private static Spanned removeHtmlBottomPadding(@Nullable Spanned text) {
        if (text == null) {
            return null;
        }

        while (text.length() > 0 && text.charAt(text.length() - 1) == '\n') {
            text = (Spanned) text.subSequence(0, text.length() - 1);
        }
        return text;
    }
}
