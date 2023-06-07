package live.midreamsheep.markdown.parser.element.span.link;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 链接行内格式对象
 * 链接行内格式对象是一个Markdown行树的叶子节点
 * 链接对象包含三个属性，分别是链接地址(url)，链接标题(title,悬浮显示)，链接显示内容(display)
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see LinkParser
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkSpan extends Span {

    private String url;
    private String title;
    private String display;
    @Override
    protected SpanElementType setType() {
        return SpanElementType.LINK;
    }

    @Override
    public Span addChildSpan(Span child) {
        return null;
    }

    @Override
    public List<Span> getChildSpans() {
        return null;
    }

}
