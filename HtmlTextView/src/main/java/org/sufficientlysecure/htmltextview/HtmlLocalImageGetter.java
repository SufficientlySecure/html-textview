/*
 * Copyright (C) 2014-2016 Dominik Schürmann <dominik@dominikschuermann.de>
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

import android.widget.TextView;

/**
 *
 * This class was deprecated in favor of HtmlResImageGetter
 *
 */
@Deprecated
public final class HtmlLocalImageGetter extends HtmlHttpImageGetter {

    public HtmlLocalImageGetter(TextView textView) {
        super(textView);
    }

    public HtmlLocalImageGetter(TextView textView, String baseUrl) {
        super(textView, baseUrl);
    }

    public HtmlLocalImageGetter(TextView textView, String baseUrl, boolean matchParentWidth) {
        super(textView, baseUrl, matchParentWidth);
    }

}
