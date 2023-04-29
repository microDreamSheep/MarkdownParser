package live.midreamsheep.markdown.parser.element.elements.span.spans.image;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.spans.link.LinkSpan;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

public class ImageParser implements SpanParserInter {
    @Override
    public int parse(char[] chars, int i, Span span) {
        StringBuilder displayName = new StringBuilder();
        int result = MarkdownParserStringUntil.findStringInStartAndEnd(chars, i, '[', ']', displayName);
        if(result == -1){
            return -1;
        }
        StringBuilder metaStr = new StringBuilder();
        int end = MarkdownParserStringUntil.findStringInStartAndEnd(chars, result+1, '(', ')', metaStr);
        if(end == -1){
            return -1;
        }
        String url = metaStr.toString();
        String title = url;
        if(url.contains(" ")){
            String temp = url.substring(url.indexOf(" ")+1);
            if(temp.contains("\"")){
                title = temp.substring(temp.indexOf("\""), temp.lastIndexOf("\""));
                url = url.substring(0, url.indexOf(" "));
            }
        }
        LinkSpan linkSpan = new LinkSpan();
        linkSpan.setDisplay(displayName.toString());
        linkSpan.setUrl(url);
        linkSpan.setTitle(title);
        span.addChildSpan(linkSpan);
        return end+1;
    }
}
