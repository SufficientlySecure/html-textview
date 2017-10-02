package org.sufficientlysecure.htmltextview;

interface JellyBeanSpanFixDelegate {
    void superOnMeasure(final int widthMeasureSpec, final int heightMeasureSpec);

    void setText(final CharSequence text);

    CharSequence getText();
}
