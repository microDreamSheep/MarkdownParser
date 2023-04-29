package live.midreamsheep.markdown.parser.element.elements.span.spans.link;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanElementType;

import java.util.List;

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
