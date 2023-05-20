package live.midreamsheep.markdown.parser.element.span.link;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanParserInter;
import live.midreamsheep.markdown.parser.element.span.SpanParserMapper;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

/**
 * Link行内格式对象解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see LinkSpan
 * @see SpanParserMapper
 * */
public class LinkParser implements SpanParserInter {
    /**
     * 解析方法
     * 用于解析的格式为[display](url "title") "title"为可选内容
     * link为叶子节点，不需要递归解析
     * */
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
