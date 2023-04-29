package live.midreamsheep.markdown.parser.element.elements.span.spans.link;

import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserInter;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

public class LinkParser implements SpanParserInter {
    @Override
    public int parse(char[] chars, int i, Span span) {
        StringBuilder name = new StringBuilder();
        int result = MarkdownParserStringUntil.findStringInStartAndEnd(chars, i, '[', ']', name);
        if(result == -1){
            return -1;
        }
        StringBuilder data = new StringBuilder();
        int end = MarkdownParserStringUntil.findStringInStartAndEnd(chars, result+1, '(', ')', data);
        if(end == -1){
         return -1;
        }
        String url = data.toString();
        String title = url;
        if(url.contains(" ")){
            String temp = url.substring(url.indexOf(" ")+1);
            if(temp.contains("\"")){
                title = temp.substring(temp.indexOf("\""), temp.lastIndexOf("\""));
                url = url.substring(0, url.indexOf(" "));
            }
        }
        LinkSpan linkSpan = new LinkSpan();
        linkSpan.setDisplay(name.toString());
        linkSpan.setUrl(url);
        linkSpan.setTitle(title);
        span.addChildSpan(linkSpan);
        return end+1;
    }
}
