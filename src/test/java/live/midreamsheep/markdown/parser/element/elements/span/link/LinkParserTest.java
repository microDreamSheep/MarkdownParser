package live.midreamsheep.markdown.parser.element.elements.span.link;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanElementType;
import live.midreamsheep.markdown.parser.element.span.link.LinkParser;
import live.midreamsheep.markdown.parser.element.span.link.LinkSpan;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;
import org.junit.Test;

public class LinkParserTest {
    @Test
    public void parseTest() {
        String markdown = "[百度](www.baidu.com)";
        LinkParser linkParser = new LinkParser();
        Span span = new Span();
        linkParser.parse(markdown.toCharArray(), 0, span);
        LinkSpan linkSpan = (LinkSpan) span.getChildSpans().get(0).getChildSpans().get(0);
        assert span.getChildSpans().size() == 1: "LinkParserTest failed([]()): size of childSpans is not 1";
        assert linkSpan.getTitle().equals("百度"): "LinkParserTest failed([]()): text of title is not 百度";
        assert linkSpan.getUrl().equals("www.baidu.com"): "LinkParserTest failed([]()): url of url is not www.baidu.com";
        assert span.getChildSpans().get(0).getType()== SpanElementType.STRIKETHROUGH: "LinkParserTest failed([]()): type of childSpan is not linkSpan";
        span = new Span();
        markdown = "[百度](www.baidu.com \"百度\")";
        linkParser.parse(markdown.toCharArray(), 0, span);
        linkSpan = (LinkSpan) span.getChildSpans().get(0).getChildSpans().get(0);
        assert span.getChildSpans().size() == 1: "LinkParserTest failed([]( \"\")): size of childSpans is not 1";
        assert linkSpan.getTitle().equals("百度"): "LinkParserTest failed([]( \"\")): title is not 百度";
        assert linkSpan.getUrl().equals("www.baidu.com"): "LinkParserTest failed([]( \"\")): url is not www.baidu.com";
        assert linkSpan.getDisplay().equals("百度"): "LinkParserTest failed([]( \"\")): display is not 百度";
        assert span.getChildSpans().get(0).getType()== SpanElementType.STRIKETHROUGH: "LinkParserTest failed([]( \"\")): type of childSpan is not linkSpan";

    }
}
