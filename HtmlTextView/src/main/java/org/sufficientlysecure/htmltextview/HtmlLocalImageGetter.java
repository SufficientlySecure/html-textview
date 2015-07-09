/*
 * Copyright (C) 2014 Dominik Schürmann <dominik@dominikschuermann.de>
 * Copyright (C) 2014 drawk
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
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;

/**
 * Copied from http://stackoverflow.com/a/22298833
 */
public class HtmlLocalImageGetter implements Html.ImageGetter {
    Context c;

    public HtmlLocalImageGetter(Context c) {
        this.c = c;
    }

    public Drawable getDrawable(String source) {
        int id = c.getResources().getIdentifier(source, "drawable", c.getPackageName());

        if (id == 0) {
            // the drawable resource wasn't found in our package, maybe it is a stock android drawable?
            id = c.getResources().getIdentifier(source, "drawable", "android");
        }

        if (id == 0) {
            // prevent a crash if the resource still can't be found
            Log.e(HtmlTextView.TAG, "source could not be found: " + source);
            return null;
        } else {
            Drawable d = c.getResources().getDrawable(id);
            d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            return d;
        }
    }

}