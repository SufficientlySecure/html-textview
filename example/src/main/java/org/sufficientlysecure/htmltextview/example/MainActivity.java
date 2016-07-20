package org.sufficientlysecure.htmltextview.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.sufficientlysecure.htmltextview.ClickableTableSpan;
import org.sufficientlysecure.htmltextview.DrawTableLinkSpan;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import static org.sufficientlysecure.htmltextview.example.WebViewActivity.EXTRA_TABLE_HTML;

public class MainActivity extends Activity {

    // The html table(s) are individually passed through to the ClickableTableSpan implementation
    // presumably for a WebView activity.
    class ClickableTableSpanImpl extends ClickableTableSpan {
        @Override
        public ClickableTableSpan newInstance() {
            return new ClickableTableSpanImpl();
        }

        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra(EXTRA_TABLE_HTML, getTableHtml());
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HtmlTextView text = (HtmlTextView) findViewById(R.id.html_text);

        text.setRemoveFromHtmlSpace(true);
        text.setClickableTableSpan(new ClickableTableSpanImpl());
        DrawTableLinkSpan drawTableLinkSpan = new DrawTableLinkSpan();
        drawTableLinkSpan.setTableLinkText("[tap for table]");
        text.setDrawTableLinkSpan(drawTableLinkSpan);
        text.setHtmlFromString(testRemoteImageHtml,new HtmlTextView.RemoteImageGetter(true));
    }


    String testRemoteImageHtml = " <div class=\"rich_media_inner\">\n" +
            "                        <div id=\"page-content\">\n" +
            "                <div class=\"rich_media_area_primary\" id=\"img-content\">\n" +
            "                    <h2 class=\"rich_media_title\" id=\"activity-name\">\n" +
            "                        开发者常用的十款Chrome插件 \n" +
            "                    </h2>\n" +
            "                    <div class=\"rich_media_meta_list\">\n" +
            "                        \t\t\t\t\t\t                        <em class=\"rich_media_meta rich_media_meta_text\" id=\"post-date\">2016-06-28</em>\n" +
            "\n" +
            "                                                <em class=\"rich_media_meta rich_media_meta_text\">稀土掘金</em>\n" +
            "                                                <a class=\"rich_media_meta rich_media_meta_link rich_media_meta_nickname\" href=\"/account/androidtrending\" id=\"post-user\">Android程序员</a>\n" +
            "                        <span class=\"rich_media_meta rich_media_meta_text rich_media_meta_nickname\">Android程序员</span>\n" +
            "\n" +
            "                        <div class=\"profile_container\" id=\"js_profile_qrcode\" style=\"display:none;\">\n" +
            "                            <div class=\"profile_inner\">\n" +
            "                                <strong class=\"profile_nickname\">Android程序员</strong>\n" +
            "                                <img alt=\"\" class=\"profile_avatar\" id=\"js_profile_qrcode_img\" src=\"\"/>\n" +
            "\n" +
            "                                <p class=\"profile_meta\">\n" +
            "                                <label class=\"profile_meta_label\">微信号</label>\n" +
            "                                <span class=\"profile_meta_value\">androidtrending</span>\n" +
            "                                </p>\n" +
            "\n" +
            "                                <p class=\"profile_meta\">\n" +
            "                                <label class=\"profile_meta_label\">功能介绍</label>\n" +
            "                                <span class=\"profile_meta_value\">Android开发最佳实践、一线经验分享、技术前沿，最好用的Android开发工具、服务、开源项目。</span>\n" +
            "                                </p>\n" +
            "                                \n" +
            "                            </div>\n" +
            "                            <span class=\"profile_arrow_wrp\" id=\"js_profile_arrow_wrp\">\n" +
            "                                <i class=\"profile_arrow arrow_out\"></i>\n" +
            "                                <i class=\"profile_arrow arrow_in\"></i>\n" +
            "                            </span>\n" +
            "                        </div>\n" +
            "                    </div>\n" +
            "                    \n" +
            "                    \n" +
            "                    \n" +
            "                    \n" +
            "                                                            \n" +
            "                                                            \n" +
            "                    \n" +
            "                    <div class=\"rich_media_content \" id=\"js_content\">\n" +
            "                        \n" +
            "\n" +
            "                        \n" +
            "                        <blockquote><p>本文是稀土掘金投稿，虽然其中有倔金的私货，是篇推广文，但我看过后认为内容确实不错，有些好插件还是第一次知道，对我很有帮助，考虑过后还是决定推荐给大家，最近我比较关注各种提高开发效率的工具与技巧，今后看到这样主题的内容，也会多多推荐给大家：）</p></blockquote><p style=\"margin: 1.2em 0px !important;\">在掘金的第十二期沸点活动中，掘金上的开发者们纷纷亮出了自己正在使用的 Chrome 插件，这里面有开发利器，也有各种实用工具。我们筛选出了评论中的各种 Chrome 开发插件，各位开发者们，快来看看，有没有你需要的工具吧。</p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">1. <a>掘金 Chrome 插件</a>:帮你发现干货</h3><p style=\"margin: 1.2em 0px !important;\"><span style=\"font-size: 14px; color: rgb(0, 122, 170);\">http://gold.xitu.io/extension/</span></p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.7217391304347827\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibyPQslkRSfGdXmNYAyw6pogtePiaGz7ibgp9pEXo78CYvI3EiaWclu65hw/0?wx_fmt=jpeg\"/><br/>不管你是开发者、设计师还是产品经理，想必每天都需要阅读大量的行业相关文章，这就需要我们浏览大量的互联网站点去寻找我们需要的内容。抛开繁复的筛选成本不说，「比特级」的内容都会压得你喘不过气来。<br/></p><p style=\"margin: 1.2em 0px !important;\">掘金为了解决这个问题，开发了掘金 Chrome 插件，掘金 Chrome 插件聚合了国内外优质的互联网站点内容，在节省你的筛选成本的同时，帮你发现好内容。</p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.6260869565217392\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGib5JPaEvgK332Bd9EHA1XoJqqsibRhzyusj3KN5AUZTW8TzzUicvtM1x3w/0?wx_fmt=jpeg\"/><br/><img data-ratio=\"0.6260869565217392\" data-type=\"gif\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibsmK5XSc9gKJALaLdibtO3ibVe8Qtz5Gpw6zbmWjlj45ia1dYvT3m9W6zA/0?wx_fmt=gif\"/><br/></p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">2. <a>Postman</a>：强大的 API & HTTP 请求调试工具</h3><p style=\"margin: 1.2em 0px !important;\"><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop</span></p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.5\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibGrZBX2YYIS7LQIibNzaT1t9RlZSpCF6HQNH2nMhLVdzj47fjCPYWiaiaQ/0?wx_fmt=jpeg\"/><br/></p><p>相信 Postman 对于掘金上的各位开发者来说，一定不会陌生，这是一款强大的 API & HTTP 请求调试工具，Postman 不仅可以调试简单的 HTML、CSS 以及脚本等简单的网页基本信息，这款 Chrome 插件甚至还能发送几乎所有的 HTTP 请求，可谓是 Web 开发者的一大利器。</p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.6260869565217392\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGib0hJgTvSJ6089MpVKF9fHicjCIpTbG9PZntreLhAcAFdxI94pria17WYg/0?wx_fmt=jpeg\"/><br/></p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">3. <a>BuiltWith Technology Profiler</a>：你的网站，用了什么技术栈？</h3><p style=\"margin: 1.2em 0px !important;\"><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://chrome.google.com/webstore/detail/builtwith-technology-prof/dapjbgnjinbpoindlpdmhochffioedbn?hl=zh-CN</span></p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.5934782608695652\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGib8A6hu6uAJZQVtmr9fKWJWUSTQfbricOibuQuGvVPKWxKliceTEjAxRo0A/0?wx_fmt=jpeg\"/><br/></p><p style=\"margin: 1.2em 0px !important;\">作为开发者，对于友商网站所使用的技术栈想必也充满了许多好奇心，有没有工具能够帮你完成这项工作呢？答案就是 Chrome 插件 BuiltWith Technology Profiler，它能够帮你分类呈现当前访问网站的技术栈组成，实乃探索友商之利器。</p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.5760869565217391\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibTmTTsxicg2KZkX2ib6FaePXQciaoIlHvyA3zZlnbVKuBR7tSGWSCZlBOw/0?wx_fmt=jpeg\"/><br/></p><p style=\"margin: 1.2em 0px !important;\">当然，同类产品中，你也可以使用 <a>Wappalyzer</a> 这一款 Chrome 插件。</p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">4. <a>Octotree</a>：你的 GitHub 文档库</h3><p style=\"margin: 1.2em 0px !important;\"><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://chrome.google.com/webstore/detail/octotree/bkhaagjahfmjljalopjnoealnfndnagc</span></p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.75\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibV0KkkppXrkWvMG1icoQ1psghK1tHIduxnowIxQUGXCF22HuD2HWEGbg/0?wx_fmt=jpeg\"/><br/></p><p style=\"margin: 1.2em 0px !important;\">GitHub 现有的目录层级形式，在查看来自不同层级文件夹的文件的时候，显得似乎不是很方便，Octotree 这款 Chrome 插件能够让你通过文档库的方式管理、查看你的 GitHub 仓库，简单直观的同时，也方便你进行文件之间的跳转操作。</p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">5. <a>GitHub Awesome Complete</a>：属于 GitHub 的 「Alfred」</h3><p style=\"margin: 1.2em 0px !important;\"><span style=\"font-size: 14px; color: rgb(0, 122, 170);\">https://github.com/algolia/github-awesome-autocomplete</span></p><p style=\"margin: 1.2em 0px !important;\"><img data-ratio=\"0.6847826086956522\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGib2a3D3BcvIeoJd5sH3UdYP9PkJhQs5bzy0q8k7ibPxdpLklGfmXHIpDw/0?wx_fmt=jpeg\"/><br/></p><p style=\"margin: 1.2em 0px !important;\">在 GitHub 搜索仓库或者项目的时候，你会怎么做？相信大部分人的步骤都是一样的：</p><ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\"><li><p>在搜索框输入关键字后按回车键</p></li><li><p>在搜索结果中找到相应结果，点击进入相应页面</p></li></ul><p><br/>有没有更简单快捷的操作方法？答案是 GitHub Awesome Complete 这款 Chrome 插件。这款插件能够让你在 GitHub 中输入关键字之后通过弹窗动态显示相应的搜索结果，你所需要做的，只是点击即可。</p><p><br/></p><p><img data-ratio=\"0.6304347826086957\" data-type=\"gif\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibiaicicgh1PLRD4y880wiauu40aKbJbXibLSxSEbD8OgcXcpibDAbP5qcQQWQ/0?wx_fmt=gif\"/><br/></p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\"></h3><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\"></h3><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">6. <a>Octo Mate</a>：增强你的 GitHub 体验</h3><p><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://github.com/camsong/chrome-github-mate/blob/master/README.cn.md</span></p><p><br/></p><p><img data-ratio=\"0.7891304347826087\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibaG4aTvnhXBKAONUjyUYM1gah3wDOmK2hz9ZQKgTMgQQCNpSmL7JJVQ/0?wx_fmt=jpeg\"/><br/></p><p><br/></p><p>除了以上两款 GitHub 相关的插件，这里我还要介绍一下 Octo Mate 这款能够提升你的 GitHub 体验的小工具。对于这款插件，主要功能有以下四点：</p><ul class=\" list-paddingleft-2\" style=\"margin: 1.2em 0px;padding-left: 2em;\"><li><p>一键下载文件：GitHub 可以让你很方便的以 .zip 格式下载所有文件，但如果只需要下载一个文件，非常麻烦。使用 Octo Mate 后只需要点击文件图标即可下载。</p></li><li><p>一键打开项目的 Github Pages</p></li><li><p>显示仓库大小</p></li><li><p>显示未读消息数</p></li></ul><p>相信这样一款插件一定能让你在使用 GitHub 的时候更加高效。</p><p><br/></p><p><img data-ratio=\"0.6239130434782608\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibZ2bWjHqiaicc4ZkzaQ7R7M23Q5hAaBTuHfLwiaNNEUvjwT9mQjrqqJTtw/0?wx_fmt=jpeg\"/><br/></p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\"></h3><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\"></h3><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\"></h3><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\"></h3><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">7. <a>Page Ruler</a>：你的网页标尺</h3><p><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://chrome.google.com/webstore/detail/page-ruler/jlpkojjdgbllmedoapgfodplfhcbnbpn?hl=zh-CN</span></p><p><br/></p><p><img data-ratio=\"0.75\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGib8HqcJmWHIV3JUfx2nX5GfT740iaxavJTkCuiaBfqVk0OYnm4ljwojib0g/0?wx_fmt=jpeg\"/><br/></p><p><br/></p><p>前端开发者在调试网页的时候，一定会遇到需要查看网页中某个具体控件或者整个网页具体尺寸的情况，这时候，Page Ruler 能够帮你完成这一项工作，测量网页元素，再也不用打开占据大片空间的「检查元素」窗口了。</p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">8. <a>User-Agent Switcher for Chrome</a>：网页自适应测试工具</h3><p><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://chrome.google.com/webstore/detail/user-agent-switcher-for-c/djflhoibgkdhkhhcedjiklpkjnoahfmg?hl=zh-CN</span></p><p><br/></p><p><img data-ratio=\"0.75\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGib0RAUGaIYXUCkKTRcWWPictCbBXjrawReQGjgY50J1KHldLoIK46ZCMg/0?wx_fmt=jpeg\"/><br/></p><p><br/></p><p>你的网页对于各类设备的自适应情况怎么样？正常情况下，我们需要同时在不同的设备上测试网页的自适应情况，有了 User-Agent Switcher for Chrome，只需要一个浏览器插件，你可以随时更换 UA，测试网页的自适应情况，帮你很好地提高了开发效率。</p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">9. <a>Vysor</a>：解放双手的 Android 测试工具</h3><p><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://chrome.google.com/webstore/detail/vysor/gidgenkbbabolejbgbpnhbimgjbffefm</span></p><p><br/></p><p><img data-ratio=\"0.8804347826086957\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGibvb3oJM1XiaicaAlFUT07DjPCfXrFYJDMa1OCYFic9gSKE2GzqUuLibtpTw/0?wx_fmt=jpeg\"/><br/></p><p><br/></p><p>实机调试 Android 应用，你是不是还在一边测试着 Android 设备一边在电脑上修改代码？有了 Vysor 这款 Chrome 插件，只需要通过 USB 连接，你就可以直接在 Chrome 中通过鼠标操作 Android 设备，设备间切换造成的时间成本降低了，开发效率自然就提高了。</p><h3 style=\"margin: 1.3em 0px 1em; padding: 0px; font-weight: bold;font-size: 1.3em;\">10. <a>SimilarWeb</a>：查看网站各种流量数据</h3><p><span style=\"color: rgb(0, 122, 170); font-size: 14px;\">https://chrome.google.com/webstore/detail/similarweb-website-rankin/hoklmmgfnpapgjgcpechhaamimifchmp</span></p><p><br/></p><p><img data-ratio=\"0.7521739130434782\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"\" src=\"http://read.html5.qq.com/image?src=forum&q=5&r=0&imgflag=7&imageUrl=http://mmbiz.qpic.cn/mmbiz/e4JibCgzXv6TlzIsSibRzduoibM6QK5qlGiblicCkEMK9nll6lCEMpHcya0vTYMke4l8CG2kcz8BWQQjjRMaicue5EOA/0?wx_fmt=jpeg\"/><br/></p><p><br/></p><p>对于网站开发者来说，除了网站本身的代码设计与开发，网站的各种用户访问数据与流量分析也是很重要的一块工作。SimilarWeb 这款 Chrome 插件能够帮你统计网站的流量来源与排名，查询网站参与等各种网站信息。</p><p><br/></p><p>除了本篇文章介绍的 Chrome 插件以外，Chrome 浏览器还有许多好用实用的扩展工具，也许你还没有找到你需要的那款浏览器插件，你也可以点击<span style=\"color: rgb(0, 122, 170);\">阅读原文</span>来掘金上看看，说不定就能找到你需要的那款插件。</p>\n" +
            "                    </div>\n" +
            "                    \n" +
            "                    \n" +
            "                    \n" +
            "                                        \n" +
            "                                        \n" +
            "                                        <div class=\"rich_media_tool\" id=\"js_toobar3\">\n" +
            "                                                                    <a class=\"media_tool_meta meta_primary\" href=\"http://gold.xitu.io/entry/5766ea5480dda4005f992d31/detail\" id=\"js_view_source\" rel=\"nofollow\" target=\"_blank\">阅读原文</a>\n" +
            "                                                <div class=\"media_tool_meta tips_global meta_primary\" id=\"js_read_area3\" style=\"display:none;\">阅读 <span id=\"readNum3\"></span></div>\n" +
            "\n" +
            "                        <span class=\"media_tool_meta meta_primary tips_global meta_praise\" id=\"like3\" style=\"display:none;\">\n" +
            "                            <i class=\"icon_praise_gray\"></i><span class=\"praise_num\" id=\"likeNum3\"></span>\n" +
            "                        </span>\n" +
            "\n" +
            "                        <a class=\"media_tool_meta tips_global meta_extra\" href=\"javascript:void(0);\" id=\"js_report_article3\" style=\"display:none;\">投诉</a>\n" +
            "\n" +
            "                    </div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "                                    </div>\n" +
            "\n" +
            "                <div class=\"rich_media_area_primary sougou\" id=\"sg_tj\" style=\"display:none\">\n" +
            "\n" +
            "                </div>\n" +
            "\n" +
            "                \n" +
            "               \n" +
            "            </div>";

}
