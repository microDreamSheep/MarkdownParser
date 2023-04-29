package live.midreamsheep.markdown.parser.element.elements.span.spans.image;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

import java.util.List;

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
