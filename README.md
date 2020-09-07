# Project stopped

This project has been stopped. 4.0 is the last release.

Feel free to fork this project and take over maintaining.

# HtmlTextView for Android

HtmlTextView is an extended TextView component for Android, which can load **very simple** HTML by converting it into Android Spannables for viewing.

In addition to a small set of HTML tags, the library allows to load images from the local drawables folder or from the Internet.

This library is kept tiny without external dependencies.

## How to import

Add this to your build.gradle:

```
repositories {
    jcenter()
}

dependencies {
    compile 'org.sufficientlysecure:html-textview:4.0'
}
```

## Example

```java
<org.sufficientlysecure.htmltextview.HtmlTextView
            android:id="@+id/html_text"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:textAppearance="@android:style/TextAppearance.Small" />
```

```java
HtmlTextView htmlTextView = (HtmlTextView) view.findViewById(R.id.html_text);

// loads html from string and displays cat_pic.png from the app's drawable folder
htmlTextView.setHtml("<h2>Hello wold</h2><ul><li>cats</li><li>dogs</li></ul><img src=\"cat_pic\"/>",
    new HtmlResImageGetter(htmlTextView));
```

or

```java
HtmlTextView htmlTextView = (HtmlTextView) view.findViewById(R.id.html_text);

// loads html from string and displays cat_pic.png from the app's assets folder
htmlTextView.setHtml("<h2>Hello wold</h2><ul><li>cats</li><li>dogs</li></ul><img src=\"cat_pic\"/>",
    new HtmlAssetsImageGetter(htmlTextView));
```

or

```java
HtmlTextView htmlTextView = (HtmlTextView) view.findViewById(R.id.html_text);

// loads html from string and displays http://www.example.com/cat_pic.png from the Internet
htmlTextView.setHtml("<h2>Hello wold</h2><img src=\"http://www.example.com/cat_pic.png\"/>",
    new HtmlHttpImageGetter(htmlTextView));
```

or

```java
HtmlTextView htmlTextView = (HtmlTextView) view.findViewById(R.id.html_text);

// loads html from raw resource, i.e., a html file in res/raw/,
// this allows translatable resource (e.g., res/raw-de/ for german)
htmlTextView.setHtml(R.raw.help, new HtmlHttpImageGetter(htmlTextView));
```

or


```java
<TextView
    android:id="@+id/html_text"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:textAppearance="@android:style/TextAppearance.Small" />
```

```java
TextView htmlTextView = (TextView) view.findViewById(R.id.html_text);

// loads html from string and displays cat_pic.png from the app's drawable folder
Spanned formattedHtml = HtmlFormatter.formatHtml(new HtmlFormatterBuilder().setHtml("<h2>Hello wold</h2><ul><li>cats</li><li>dogs</li></ul><img src=\"cat_pic\"/>").setImageGetter(new HtmlResImageGetter(htmlTextView.getContext())));
htmlTextView.setText(formattedHtml);
```

## Supported HTML tags

### Tags supported by Android ([history of Html class](https://github.com/android/platform_frameworks_base/commits/master/core/java/android/text/Html.java))
* ``<p>``
* ``<div>`` handled exactly like ``<p>``
* ``<br>``
* ``<b>``
* ``<i>``
* ``<strong>`` ([bug on some Android versions: generates italic](https://code.google.com/p/android/issues/detail?id=3473))
* ``<em>`` ([bug on some Android versions: generates bold](https://code.google.com/p/android/issues/detail?id=3473))
* ``<u>``
* ``<tt>``
* ``<dfn>``
* ``<sub>``
* ``<sup>``
* ``<blockquote>``
* ``<cite>``
* ``<big>``
* ``<small>``
* ``<font color="..." face="...">``
* ``<h1>``, ``<h2>``, ``<h3>``, ``<h4>``, ``<h5>``, ``<h6>``
* ``<a href="...">``
* ``<img src="...">``

### Extended support by HtmlTextView
* ``<ul>``
* ``<ol>``
* ``<li>``
* ``<code>``
* ``<center>``
* ``<strike>``

### Support for HTML tables
HtmlTextView now supports HTML tables (to a limited extent) by condensing the text into a link which developers are able to render in a native WebView. To take advantage of the feature you'll need to:

1. implement a `ClickableTableSpan` which provides access to the table HTML (which can be forwarded to a WebView)

2. provide a `DrawTableLinkSpan` which defines what the table link should look like (i.e. text, text color, text size)

Take a look at the project's [sample app](https://github.com/SufficientlySecure/html-textview/blob/master/example/src/main/java/org/sufficientlysecure/htmltextview/example/MainActivity.java) for an example.

### Support for A tag click listener
```
textView.setOnClickATagListener(new OnClickATagListener() {

    @Override
    public void onClick(View widget, @Nullable String href) {
        Toast.makeText(MainActivity.this, href, Toast.LENGTH_SHORT).show();
    }
});
```


We recognize the standard table tags:

* ``<table>``
* ``<tr>``
* ``<th>``
* ``<td>``

as well as the tags extended by HtmlTextView. However, support doesn’t currently extend to tags natively supported by Android (e.g. ``<b>``, ``<big>``, ``<h1>``) which means tables will not include the extra styling.

### Changelog

#### 4.0
* [A tag click enhancements](https://github.com/SufficientlySecure/html-textview/pull/191)
* [Blockquote styling feature](https://github.com/SufficientlySecure/html-textview/pull/189)
* [Image placeholder](https://github.com/SufficientlySecure/html-textview/pull/186)
* Removed deprecated functions

#### 3.9
* Add A tag click listener

#### 3.8
* Add HtmlFormatter for use with standard TextView

#### 3.7
* Fix [#166](https://github.com/SufficientlySecure/html-textview/issues/166)
* Migrated to AndroidX

#### 3.6
* Improve and fix indentions

#### 3.5
* Allow image compression

#### 3.4
* Fix textIsSelectable

#### 3.3
* Fix text cutting bug
* Prevent EmptyStackException when processing malformed li tags

#### 3.2
* Indenting entries of ordered lists the same way as of unordered lists
* Fix OutOfMemory

#### 3.1
* Override handling of ``<ul>`` ``<ol>`` and ``<li>`` tags done by newer versions of Android SDK (removes empty lines between items)

#### 3.0
* Removed deprecated methods and classes
* Fix out of bounds issue

#### 2.0
* Introduce better API

## License
Apache License v2

See LICENSE for full license text.

## Authors
- This library was put together by Dominik Schürmann
- Original [HtmlTagHandler](https://gist.github.com/mlakkadshaw/5983704) developed by [Mohammed Lakkadshaw](http://blog.mohammedlakkadshaw.com/)
- Original [HtmlHttpImageGetter](https://gist.github.com/Antarix/4167655) developed by Antarix Tandon
- Original [HtmlResImageGetter](http://stackoverflow.com/a/22298833) developed by drawk
- [JellyBeanSpanFixTextView](https://gist.github.com/pyricau/3424004) (with fix from comment) developed by Pierre-Yves Ricau
- [Table support](https://github.com/SufficientlySecure/html-textview/pull/33) added by Richard Thai
- [setRemoveFromHtmlSpace](https://github.com/SufficientlySecure/html-textview/pull/37) added by [Derek Smith](https://github.com/derekcsm)

## Contributions

Feel free to fork and do pull requests. I am more than happy to merge them.
Please do not introduce external dependencies.
