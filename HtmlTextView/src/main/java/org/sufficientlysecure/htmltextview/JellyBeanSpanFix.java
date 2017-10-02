package org.sufficientlysecure.htmltextview;

import android.annotation.SuppressLint;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

final class JellyBeanSpanFix {
    static class FixingResult {
        public final boolean fixed;
        public final List<Object> spansWithSpacesBefore;
        public final List<Object> spansWithSpacesAfter;

        public static FixingResult fixed(
                List<Object> spansWithSpacesBefore,
                List<Object> spansWithSpacesAfter) {
            return new FixingResult(true, spansWithSpacesBefore, spansWithSpacesAfter);
        }

        public static FixingResult notFixed() {
            return new FixingResult(false, null, null);
        }

        private FixingResult(
                final boolean fixed, final List<Object> spansWithSpacesBefore,
                final List<Object> spansWithSpacesAfter) {
            this.fixed = fixed;
            this.spansWithSpacesBefore = spansWithSpacesBefore;
            this.spansWithSpacesAfter = spansWithSpacesAfter;
        }
    }

    private final JellyBeanSpanFixDelegate delegate;

    public JellyBeanSpanFix(final JellyBeanSpanFixDelegate delegate) {
        this.delegate = delegate;
    }

    public void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        try {
            delegate.superOnMeasure(widthMeasureSpec, heightMeasureSpec);
        } catch (IndexOutOfBoundsException e) {
            fixOnMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /**
     * If possible, fixes the Spanned text by adding spaces around spans when needed.
     */
    private void fixOnMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final CharSequence text = delegate.getText();
        if (text instanceof Spanned) {
            SpannableStringBuilder builder = new SpannableStringBuilder(text);
            fixSpannedWithSpaces(builder, widthMeasureSpec, heightMeasureSpec);
        } else {
            if (HtmlTextView.DEBUG) {
                Log.d(HtmlTextView.TAG, "The text isn't a Spanned");
            }
            fallbackToString(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /**
     * Add spaces around spans until the text is fixed, and then removes the unneeded spaces
     */
    private void fixSpannedWithSpaces(
            final SpannableStringBuilder builder,
            final int widthMeasureSpec, final int heightMeasureSpec) {
        final long startFix = System.currentTimeMillis();

        final FixingResult result =
                addSpacesAroundSpansUntilFixed(builder, widthMeasureSpec, heightMeasureSpec);

        if (result.fixed) {
            removeUnneededSpaces(widthMeasureSpec, heightMeasureSpec, builder, result);
        } else {
            fallbackToString(widthMeasureSpec, heightMeasureSpec);
        }

        if (HtmlTextView.DEBUG) {
            final long fixDuration = System.currentTimeMillis() - startFix;
            Log.d(HtmlTextView.TAG, "fixSpannedWithSpaces() duration in ms: " + fixDuration);
        }
    }

    private FixingResult addSpacesAroundSpansUntilFixed(
            final SpannableStringBuilder builder,
            final int widthMeasureSpec, final int heightMeasureSpec) {

        final Object[] spans = builder.getSpans(0, builder.length(), Object.class);
        final List<Object> spansWithSpacesBefore = new ArrayList<>(spans.length);
        final List<Object> spansWithSpacesAfter = new ArrayList<>(spans.length);

        for (Object span : spans) {
            final int spanStart = builder.getSpanStart(span);
            if (isNotSpace(builder, spanStart - 1)) {
                builder.insert(spanStart, " ");
                spansWithSpacesBefore.add(span);
            }

            final int spanEnd = builder.getSpanEnd(span);
            if (isNotSpace(builder, spanEnd)) {
                builder.insert(spanEnd, " ");
                spansWithSpacesAfter.add(span);
            }

            try {
                setTextAndMeasure(builder, widthMeasureSpec, heightMeasureSpec);
                return FixingResult.fixed(spansWithSpacesBefore, spansWithSpacesAfter);
            } catch (IndexOutOfBoundsException ignored) {
            }
        }
        if (HtmlTextView.DEBUG) {
            Log.d(HtmlTextView.TAG, "Could not fix the Spanned by adding spaces around spans");
        }
        return FixingResult.notFixed();
    }

    private boolean isNotSpace(final CharSequence text, final int where) {
        return where < 0 || where >= text.length() || text.charAt(where) != ' ';
    }

    @SuppressLint("WrongCall")
    private void setTextAndMeasure(
            final CharSequence text, final int widthMeasureSpec, final int heightMeasureSpec) {
        delegate.setText(text);
        delegate.superOnMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @SuppressLint("WrongCall")
    private void removeUnneededSpaces(
            final int widthMeasureSpec, final int heightMeasureSpec,
            final SpannableStringBuilder builder, final FixingResult result) {

        for (Object span : result.spansWithSpacesAfter) {
            final int spanEnd = builder.getSpanEnd(span);
            builder.delete(spanEnd, spanEnd + 1);
            try {
                setTextAndMeasure(builder, widthMeasureSpec, heightMeasureSpec);
            } catch (IndexOutOfBoundsException ignored) {
                builder.insert(spanEnd, " ");
            }
        }

        boolean needReset = true;
        for (Object span : result.spansWithSpacesBefore) {
            final int spanStart = builder.getSpanStart(span);
            builder.delete(spanStart - 1, spanStart);
            try {
                setTextAndMeasure(builder, widthMeasureSpec, heightMeasureSpec);
                needReset = false;
            } catch (IndexOutOfBoundsException ignored) {
                needReset = true;
                final int newSpanStart = spanStart - 1;
                builder.insert(newSpanStart, " ");
            }
        }

        if (needReset) {
            delegate.setText(builder);
            delegate.superOnMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private void fallbackToString(final int widthMeasureSpec, final int heightMeasureSpec) {
        if (HtmlTextView.DEBUG) {
            Log.d(HtmlTextView.TAG, "Fallback to unspanned text");
        }
        final String fallbackText = delegate.getText().toString();
        setTextAndMeasure(fallbackText, widthMeasureSpec, heightMeasureSpec);
    }
}
