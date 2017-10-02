package org.sufficientlysecure.htmltextview;

import android.support.annotation.RawRes;
import android.text.TextPaint;
import android.text.method.MovementMethod;

import java.io.InputStream;

interface HtmlTextViewDelegate {
    void setText(final CharSequence text);

    TextPaint getPaint();

    void setMovementMethod(final MovementMethod movementMethod);

    InputStream openRawResource(@RawRes final int resId);
}
