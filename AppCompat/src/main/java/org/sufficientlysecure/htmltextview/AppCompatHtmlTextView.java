/*
 * Copyright (C) 2013-2014 Dominik Schürmann <dominik@dominikschuermann.de>
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

package org.sufficientlysecure.htmltextview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.text.Html;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.util.AttributeSet;

import java.io.InputStream;

public class AppCompatHtmlTextView extends AppCompatJellyBeanSpanFixTextView implements IHtmlTextView {
    private final HtmlTextViewImpl impl = new HtmlTextViewImpl(new Delegate());

    public AppCompatHtmlTextView(
            @NonNull final Context context, @Nullable final AttributeSet attrs,
            @AttrRes final int defStyle) {
        super(context, attrs, defStyle);
    }

    public AppCompatHtmlTextView(@NonNull final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AppCompatHtmlTextView(@NonNull final Context context) {
        super(context);
    }

    /**
     * @see IHtmlTextView#setHtml(int)
     */
    @Override
    public void setHtml(@RawRes final int resId) {
        impl.setHtml(resId);
    }

    /**
     * @see IHtmlTextView#setHtml(String)
     */
    @Override
    public void setHtml(@NonNull final String html) {
        impl.setHtml(html);
    }

    /**
     * @see IHtmlTextView#setHtml(int, Html.ImageGetter)
     */
    @Override
    public void setHtml(@RawRes final int resId, @Nullable final Html.ImageGetter imageGetter) {
        impl.setHtml(resId, imageGetter);
    }

    /**
     * @see IHtmlTextView#setHtml(String, Html.ImageGetter)
     */
    @Override
    public void setHtml(@NonNull final String html, @Nullable final Html.ImageGetter imageGetter) {
        impl.setHtml(html, imageGetter);
    }

    /**
     * @see IHtmlTextView#setRemoveFromHtmlSpace(boolean)
     */
    @Override
    public void setRemoveFromHtmlSpace(final boolean removeFromHtmlSpace) {
        impl.setRemoveFromHtmlSpace(removeFromHtmlSpace);
    }

    /**
     * @see IHtmlTextView#setClickableTableSpan(ClickableTableSpan)
     */
    @Override
    public void setClickableTableSpan(@Nullable final ClickableTableSpan clickableTableSpan) {
        impl.setClickableTableSpan(clickableTableSpan);
    }

    /**
     * @see IHtmlTextView#setDrawTableLinkSpan(DrawTableLinkSpan)
     */
    @Override
    public void setDrawTableLinkSpan(@Nullable final DrawTableLinkSpan drawTableLinkSpan) {
        impl.setDrawTableLinkSpan(drawTableLinkSpan);
    }

    private /*inner*/ class Delegate implements HtmlTextViewDelegate {
        @Override
        public void setText(final CharSequence text) {
            AppCompatHtmlTextView.this.setText(text);
        }

        @Override
        public TextPaint getPaint() {
            return AppCompatHtmlTextView.this.getPaint();
        }

        @Override
        public void setMovementMethod(final MovementMethod movementMethod) {
            AppCompatHtmlTextView.this.setMovementMethod(movementMethod);
        }

        @Override
        public InputStream openRawResource(@RawRes final int resId) {
            return AppCompatHtmlTextView.this.getResources().openRawResource(resId);
        }
    }
}
