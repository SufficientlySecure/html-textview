/*
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
