package org.sufficientlysecure.htmltextview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineBackgroundSpan;

import androidx.annotation.NonNull;

public class DesignQuoteSpan implements LeadingMarginSpan, LineBackgroundSpan {

    private int backgroundColor,stripColor;
    private float stripeWidth,gap;
    DesignQuoteSpan(int backgroundColor,
                    int stripColor,
                    float stripWidth,
                    float gap){

        this.backgroundColor=backgroundColor;
        this.stripColor=stripColor;
        this.stripeWidth=stripWidth;
        this.gap=gap;

    }

    @Override
    public int getLeadingMargin(boolean first) {
        return (int)(stripeWidth + gap);
    }

    @Override
    public void drawLeadingMargin(Canvas c,
                                  Paint p,
                                  int x,
                                  int dir,
                                  int top,
                                  int baseline,
                                  int bottom,
                                  CharSequence text,
                                  int start,
                                  int end,
                                  boolean first,
                                  Layout layout) {

        Paint.Style style=p.getStyle();
        int paintColor=p.getColor();
        p.setStyle(Paint.Style.FILL);
        p.setColor(stripColor);
        c.drawRect((float)x,(float)top,x+dir * stripeWidth,(float)bottom,p);
        p.setStyle(style);
        p.setColor(paintColor);

    }

    @Override
    public void drawBackground(@NonNull Canvas canvas,
                               @NonNull Paint paint,
                               int left,
                               int right,
                               int top,
                               int baseline,
                               int bottom,
                               @NonNull CharSequence text,
                               int start,
                               int end,
                               int lineNumber) {
        int paintColor=paint.getColor();
        paint.setColor(backgroundColor);
        canvas.drawRect((float)left,(float)top,(float)right,(float)bottom,paint);
        paint.setColor(paintColor);
    }
}
