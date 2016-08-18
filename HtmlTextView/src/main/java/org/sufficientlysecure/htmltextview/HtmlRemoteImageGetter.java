/*
 * Copyright (C) 2014-2016 Dominik Schürmann <dominik@dominikschuermann.de>
 * Copyright (C) 2013 Antarix Tandon
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
 * This class was deprecated in favor of HtmlHttpImageGetter
 *
 */
@Deprecated
public final class HtmlRemoteImageGetter extends HtmlHttpImageGetter {

    public HtmlRemoteImageGetter(TextView textView) {
        super(textView);
    }

    public HtmlRemoteImageGetter(TextView textView, String baseUrl) {
        super(textView, baseUrl);
    }

    public HtmlRemoteImageGetter(TextView textView, String baseUrl, boolean matchParentWidth) {
        super(textView, baseUrl, matchParentWidth);
    }

}
