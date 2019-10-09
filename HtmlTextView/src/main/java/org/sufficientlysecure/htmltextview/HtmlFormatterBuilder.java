package org.sufficientlysecure.htmltextview;

import android.text.Html.ImageGetter;
import androidx.annotation.Nullable;

public class HtmlFormatterBuilder {

    private String html;
    private ImageGetter imageGetter;
    private ClickableTableSpan clickableTableSpan;
    private DrawTableLinkSpan drawTableLinkSpan;
    private float indent = 24.0f;
    private boolean removeTrailingWhiteSpace = true;

    public String getHtml() {
        return html;
    }

    public ImageGetter getImageGetter() {
        return imageGetter;
    }

    public ClickableTableSpan getClickableTableSpan() {
        return clickableTableSpan;
    }

    public DrawTableLinkSpan getDrawTableLinkSpan() {
        return drawTableLinkSpan;
    }

    public float getIndent() {
        return indent;
    }

    public boolean isRemoveTrailingWhiteSpace() {
        return removeTrailingWhiteSpace;
    }

    public HtmlFormatterBuilder setHtml(@Nullable final String html) {
        this.html = html;
        return this;
    }

    public HtmlFormatterBuilder setImageGetter(@Nullable final ImageGetter imageGetter) {
        this.imageGetter = imageGetter;
        return this;
    }

    public HtmlFormatterBuilder setClickableTableSpan(@Nullable final ClickableTableSpan clickableTableSpan) {
        this.clickableTableSpan = clickableTableSpan;
        return this;
    }

    public HtmlFormatterBuilder setDrawTableLinkSpan(@Nullable final DrawTableLinkSpan drawTableLinkSpan) {
        this.drawTableLinkSpan = drawTableLinkSpan;
        return this;
    }

    public HtmlFormatterBuilder setIndent(final float indent) {
        this.indent = indent;
        return this;
    }

    public HtmlFormatterBuilder setRemoveTrailingWhiteSpace(final boolean removeTrailingWhiteSpace) {
        this.removeTrailingWhiteSpace = removeTrailingWhiteSpace;
        return this;
    }
}