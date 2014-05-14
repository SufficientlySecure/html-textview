# HtmlTextView for Android

HtmlTextView is an extended TextView component for Android, which can load HTML and converts it into Spannable for displaying it.
It is a replacement for usage of the WebView component, which behaves strange on some Android versions, flickers while loading, etc.

## Tags supported by Android ([history of Html class](https://github.com/android/platform_frameworks_base/commits/master/core/java/android/text/Html.java))
* ``<p>``
* ``<div>`` handled exactly like ``<p>``
* ``<br>``
* ``<b>``
* ``<i>``
* ``<strong>`` ([bug on some Android versions: generates italic](https://code.google.com/p/android/issues/detail?id=3473))
* ``<em>`` ([bug on some Android versions: generates bold](https://code.google.com/p/android/issues/detail?id=3473))
* ``<u>``
* ``<strike>``
* ``<tt>``
* ``<dfn>``
* ``<sub>``
* ``<sup>``
* ``<blockquote>``
* ``<cite>``
* ``<big>``
* ``<small>``
* ``<font size="..." color="..." face="...">``
* ``<h1>``, ``<h2>``, ``<h3>``, ``<h4>``, ``<h5>``, ``<h6>``
* ``<a href="...">``
* ``<img src="...">``

## Extended support by HtmlTextView
* ``<ul>``
* ``<ol>``
* ``<dd>``
* ``<li>``
* ``<code>``
* ``<center>``

The library also includes a workaround to prevent TextView from crashing on [specific Android versions](http://code.google.com/p/android/issues/detail?id=35466) and the possibility to load images from local drawables folder or from the Internet.

This library is kept tiny without external dependencies.
I am using it to provide Help/About Activities in my apps.

## Example

```java
HtmlTextView text = new HtmlTextView(this);

// loads html from string and displays cat_pic.png from the app's drawable folder
text.setHtmlFromString("<h2>Hello wold</h2><ul><li>cats</li><li>dogs</li></ul><img src=\"cat_pic\"/>", true);
```
or
```java
HtmlTextView text = new HtmlTextView(this);

// loads html from string and displays http://www.example.com/cat_pic.png from the Internet
text.setHtmlFromString("<h2>Hello wold</h2><ul><li>cats</li><li>dogs</li></ul><img src=\"http://www.example.com/cat_pic.png\"/>", false);
```
or
```java
HtmlTextView text = new HtmlTextView(this);

// loads html from raw resource, i.e., a html file in res/raw/, this allows translatable resource (e.g., res/raw-de/ for german)
text.setHtmlFromRawResource(this, R.raw.help, true);
```

## Use library as Gradle dependency (Android library project)

1. Copy the cloned folder to your project and define it in your ``settings.gradle`` with ``include ':html-textview'``
2. Add dependency ``compile project(':html-textview')`` to your project's ``build.gradle``.

## License
Apache License v2

See LICENSE for full license text.

## Authors
- This library was put together by Dominik Schürmann
- Original [TagHandler](https://gist.github.com/mlakkadshaw/5983704) developed by [Mohammed Lakkadshaw](http://blog.mohammedlakkadshaw.com/)
- Original [UrlImageGetter](https://gist.github.com/Antarix/4167655) developed by Antarix Tandon
- Original [LocalImageGetter](http://stackoverflow.com/a/22298833) developed by drawk
- [JellyBeanSpanFixTextView](https://gist.github.com/pyricau/3424004) (with fix from comment) developed by Pierre-Yves Ricau

## Contributions

Feel free to fork and do pull requests. I am more than happy to merge them.
Please do not introduce external dependencies.
