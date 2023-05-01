package live.midreamsheep.markdown.parser.element.elements.span.spans.image;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

import java.util.List;

/**
 * 图片行内格式对象
 * 用于存储图片的url和title
 * 图片行内格式对象是一个Markdown行树的叶子节点
 * 图片对象包含两个属性，分别是图片地址(url)，图片标题(title,悬浮显示)
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.image.ImageParser
 * */
public class ImageSpan extends Span{

    private String url;
    private String title;
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

}
