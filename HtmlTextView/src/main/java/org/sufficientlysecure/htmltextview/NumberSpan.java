package org.sufficientlysecure.htmltextview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/**
 * Class to use Numbered Lists in TextViews.
 * The span works the same as {@link android.text.style.BulletSpan} and all lines of the entry have
 * the same leading margin.
 *
 * Originally written by <a href="https://github.com/imbryk">Leszek Mzyk</a>,
 * modified for {@link org.sufficientlysecure.htmltextview.HtmlTagHandler} by <a href="https://github.com/mosberger">Dominik Mosberger</a>
 */
public class NumberSpan implements LeadingMarginSpan {
    private final String mNumber;
    private int mTextWidth;

    public NumberSpan(int number) {
        mNumber = Integer.toString(number).concat(". ");
    }

    @Override
    public int getLeadingMargin(boolean first) {
        return mTextWidth;
    }

    @Override
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline,
                                  int bottom, CharSequence text, int start, int end,
                                  boolean first, Layout l) {
        if (text instanceof Spanned) {
            int spanStart = ((Spanned) text).getSpanStart(this);
            if (spanStart == start) {
                mTextWidth = (int) p.measureText(mNumber);
                c.drawText(mNumber, x, baseline, p);
            }
        }
    }
}
