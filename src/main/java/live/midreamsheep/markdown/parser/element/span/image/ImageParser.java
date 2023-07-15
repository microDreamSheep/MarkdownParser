package live.midreamsheep.markdown.parser.element.span.image;

import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.api.SpanParserInter;
import live.midreamsheep.markdown.parser.element.span.SpanParserMapper;
import live.midreamsheep.markdown.parser.element.span.link.LinkSpan;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

/**
 * 图片行内格式对象解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see ImageSpan
 * @see SpanParserMapper
 * */
public class ImageParser implements SpanParserInter {

    /**
     * 解析图片行内格式对象
     * 解析格式为 ![alt](url)
     * alt为图片的替代文本，url为图片的链接
     * 图片为叶子节点，不需要递归解析
     * */
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
