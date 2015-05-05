/*
 * Copyright (C) 2013-2015 Dominik Schürmann <dominik@dominikschuermann.de>
 * Copyright (C) 2013-2015 Juha Kuitunen
 * Copyright (C) 2013 Mohammed Lakkadshaw
 * Copyright (C) 2007 The Android Open Source Project
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

import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.AlignmentSpan;
import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;

import org.xml.sax.XMLReader;

import java.util.Stack;

/**
 * Some parts of this code are based on android.text.Html
 */
public class HtmlTagHandler implements Html.TagHandler {
    /**
     * Keeps track of lists (ol, ul). On bottom of Stack is the outermost list
     * and on top of Stack is the most nested list
     */
    Stack<String> lists = new Stack<>();
    /**
     * Tracks indexes of ordered lists so that after a nested list ends
     * we can continue with correct index of outer list
     */
    Stack<Integer> olNextIndex = new Stack<>();
    /**
     * List indentation in pixels. Nested lists use multiple of this.
     */
    private static final int indent = 10;
    private static final int listItemIndent = indent * 2;
    private static final BulletSpan bullet = new BulletSpan(indent);

    private static class Ul {
    }

    private static class Ol {
    }

    private static class Code {
    }

    private static class Center {
    }

    private static class Strike {
    }

    @Override
    public void handleTag(final boolean opening, final String tag, Editable output, final XMLReader xmlReader) {
        if (opening) {
            // opening tag
            if (HtmlTextView.DEBUG) {
                Log.d(HtmlTextView.TAG, "opening, output: " + output.toString());
            }

            if (tag.equalsIgnoreCase("ul")) {
                lists.push(tag);
            } else if (tag.equalsIgnoreCase("ol")) {
                lists.push(tag);
                olNextIndex.push(1);
            } else if (tag.equalsIgnoreCase("li")) {
                if (output.length() > 0 && output.charAt(output.length() - 1) != '\n') {
                    output.append("\n");
                }
                String parentList = lists.peek();
                if (parentList.equalsIgnoreCase("ol")) {
                    start(output, new Ol());
                    output.append(olNextIndex.peek().toString()).append(". ");
                    olNextIndex.push(olNextIndex.pop() + 1);
                } else if (parentList.equalsIgnoreCase("ul")) {
                    start(output, new Ul());
                }
            } else if (tag.equalsIgnoreCase("code")) {
                start(output, new Code());
            } else if (tag.equalsIgnoreCase("center")) {
                start(output, new Center());
            } else if (tag.equalsIgnoreCase("s") || tag.equalsIgnoreCase("strike")) {
                start(output, new Strike());
            }
        } else {
            // closing tag
            if (HtmlTextView.DEBUG) {
                Log.d(HtmlTextView.TAG, "closing, output: " + output.toString());
            }

            if (tag.equalsIgnoreCase("ul")) {
                lists.pop();
            } else if (tag.equalsIgnoreCase("ol")) {
                lists.pop();
                olNextIndex.pop();
            } else if (tag.equalsIgnoreCase("li")) {
                if (lists.peek().equalsIgnoreCase("ul")) {
                    if (output.length() > 0 && output.charAt(output.length() - 1) != '\n') {
                        output.append("\n");
                    }
                    // Nested BulletSpans increases distance between bullet and text, so we must prevent it.
                    int bulletMargin = indent;
                    if (lists.size() > 1) {
                        bulletMargin = indent - bullet.getLeadingMargin(true);
                        if (lists.size() > 2) {
                            // This get's more complicated when we add a LeadingMarginSpan into the same line:
                            // we have also counter it's effect to BulletSpan
                            bulletMargin -= (lists.size() - 2) * listItemIndent;
                        }
                    }
                    BulletSpan newBullet = new BulletSpan(bulletMargin);
                    end(output, Ul.class, false,
                            new LeadingMarginSpan.Standard(listItemIndent * (lists.size() - 1)),
                            newBullet);
                } else if (lists.peek().equalsIgnoreCase("ol")) {
                    if (output.length() > 0 && output.charAt(output.length() - 1) != '\n') {
                        output.append("\n");
                    }
                    int numberMargin = listItemIndent * (lists.size() - 1);
                    if (lists.size() > 2) {
                        // Same as in ordered lists: counter the effect of nested Spans
                        numberMargin -= (lists.size() - 2) * listItemIndent;
                    }
                    end(output, Ol.class, false, new LeadingMarginSpan.Standard(numberMargin));
                }
            } else if (tag.equalsIgnoreCase("code")) {
                end(output, Code.class, false, new TypefaceSpan("monospace"));
            } else if (tag.equalsIgnoreCase("center")) {
                end(output, Center.class, true, new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER));
            } else if (tag.equalsIgnoreCase("s") || tag.equalsIgnoreCase("strike")) {
                end(output, Strike.class, false, new StrikethroughSpan());
            }
        }
    }

    /**
     * Mark the opening tag by using private classes
     */
    private void start(Editable output, Object mark) {
        int len = output.length();
        output.setSpan(mark, len, len, Spannable.SPAN_MARK_MARK);

        if (HtmlTextView.DEBUG) {
            Log.d(HtmlTextView.TAG, "len: " + len);
        }
    }

    /**
     * Modified from {@link android.text.Html}
     */
    private void end(Editable output, Class kind, boolean paragraphStyle, Object... replaces) {
        Object obj = getLast(output, kind);
        // start of the tag
        int where = output.getSpanStart(obj);
        // end of the tag
        int len = output.length();

        output.removeSpan(obj);

        if (where != len) {
            int thisLen = len;
            // paragraph styles like AlignmentSpan need to end with a new line!
            if (paragraphStyle) {
                output.append("\n");
                thisLen++;
            }
            for (Object replace : replaces) {
                output.setSpan(replace, where, thisLen, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }

            if (HtmlTextView.DEBUG) {
                Log.d(HtmlTextView.TAG, "where: " + where);
                Log.d(HtmlTextView.TAG, "thisLen: " + thisLen);
            }
        }
    }

    /**
     * Get last marked position of a specific tag kind (private class)
     */
    private static Object getLast(Editable text, Class kind) {
        Object[] objs = text.getSpans(0, text.length(), kind);
        if (objs.length == 0) {
            return null;
        } else {
            for (int i = objs.length; i > 0; i--) {
                if (text.getSpanFlags(objs[i - 1]) == Spannable.SPAN_MARK_MARK) {
                    return objs[i - 1];
                }
            }
            return null;
        }
    }

} 
