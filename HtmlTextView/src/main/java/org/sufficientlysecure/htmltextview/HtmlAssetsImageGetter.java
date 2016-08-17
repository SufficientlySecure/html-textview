package org.sufficientlysecure.htmltextview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Assets Image Getter
 * 
 * Load image from assets folder
 *
 * @author <a href="mailto:daniel@passos.me">Daniel Passos</a>
 */
public class HtmlAssetsImageGetter implements Html.ImageGetter {

    private final Context context;

    public HtmlAssetsImageGetter(Context context) {
        this.context = context;
    }

    public HtmlAssetsImageGetter(TextView textView) {
        this.context = textView.getContext();
    }

    @Override
    public Drawable getDrawable(String source) {

        try {
            InputStream inputStream = context.getAssets().open(source);
            Drawable d = Drawable.createFromStream(inputStream, null);
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            return d;
        } catch (IOException e) {
            // prevent a crash if the resource still can't be found
            Log.e(HtmlTextView.TAG, "source could not be found: " + source);
            return null;
        }

    }

}
