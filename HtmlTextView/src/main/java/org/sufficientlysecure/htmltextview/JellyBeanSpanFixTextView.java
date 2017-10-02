/*
 * Copyright (C) 2013 Dominik Schürmann <dominik@dominikschuermann.de>
 * Copyright (C) 2012 Pierre-Yves Ricau <py.ricau@gmail.com>
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

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * <p/>
 * A {@link android.widget.TextView} that insert spaces around its text spans where needed to prevent
 * {@link IndexOutOfBoundsException} in {@link #onMeasure(int, int)} on Jelly Bean.
 * <p/>
 * When {@link #onMeasure(int, int)} throws an exception, we try to fix the text by adding spaces
 * around spans, until it works again. We then try removing some of the added spans, to minimize the
 * insertions.
 * <p/>
 * The fix is time consuming (a few ms, it depends on the size of your text), but it should only
 * happen once per text change.
 * <p/>
 * See http://code.google.com/p/android/issues/detail?id=35466
 * <p/>
 * From https://gist.github.com/pyricau/3424004 with fix from comments
 */
public class JellyBeanSpanFixTextView extends TextView {
    private final JellyBeanSpanFix jellyBeanSpanFix = new JellyBeanSpanFix(new Delegate());

    public JellyBeanSpanFixTextView(
            final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    public JellyBeanSpanFixTextView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public JellyBeanSpanFixTextView(final Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        jellyBeanSpanFix.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private /*inner*/ class Delegate implements JellyBeanSpanFixDelegate {
        @SuppressLint("WrongCall")
        @Override
        public void superOnMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
            JellyBeanSpanFixTextView.super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

        @Override
        public void setText(final CharSequence text) {
            JellyBeanSpanFixTextView.this.setText(text);
        }

        @Override
        public CharSequence getText() {
            return JellyBeanSpanFixTextView.this.getText();
        }
    }
}
