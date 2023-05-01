package live.midreamsheep.markdown.parser.element.elements.span.spans.link;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

import java.util.List;

/**
 * 链接行内格式对象
 * 链接行内格式对象是一个Markdown行树的叶子节点
 * 链接对象包含三个属性，分别是链接地址(url)，链接标题(title,悬浮显示)，链接显示内容(display)
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.link.LinkParser
 * */
public class LinkSpan extends Span {

    private String url;
    private String title;
    private String display;
    @Override
    protected SpanElementType setType() {
        return SpanElementType.IMAGE;
    }

    @Override
    public Span addChildSpan(Span child) {
        return null;
    }

    @Override
    public List<Span> getChildSpans() {
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
