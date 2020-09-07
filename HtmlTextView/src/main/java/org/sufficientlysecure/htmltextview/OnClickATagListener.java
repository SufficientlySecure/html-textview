package org.sufficientlysecure.htmltextview;

import android.view.View;

import androidx.annotation.Nullable;

/**
 * This listener can define what happens when the a tag is clicked
 */
public interface OnClickATagListener {
    /**
     * Notifies of anchor tag click events.
     * @param widget - the {@link HtmlTextView} instance
     * @param spannedText - the string value of the text spanned
     * @param href - the url for the anchor tag
     * @return indicates whether the click event has been handled
     */
    boolean onClick(View widget, String spannedText, @Nullable String href);
}
