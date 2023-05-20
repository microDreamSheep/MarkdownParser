package live.midreamsheep.markdown.parser.element.span.strikethrough;

import live.midreamsheep.markdown.parser.element.span.SpanParser;
import live.midreamsheep.markdown.parser.element.span.Span;
import live.midreamsheep.markdown.parser.element.span.SpanParserInter;
import live.midreamsheep.markdown.parser.element.span.SpanParserMapper;
import live.midreamsheep.markdown.parser.element.span.bold.BoldSpan;

/**
 * 删除线行内格式解析器，用于解析~~删除线~~格式的行内格式
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see StrikethroughSpan
 * @see SpanParserInter
 * @see SpanParserMapper
 * */
public class StrikethroughParser implements SpanParserInter {
    /**
     * 处理删除线
     * 由于删除线格式中可以包含其他行内格式，所以需要使用递归解析
     * 例如~~**删除线加粗**~~
     * */
    @Override
    public int parse(char[] chars, int i, Span span) {
        if(chars[i] == '~' && chars[i+1] == '~'){
            return findNextBold(chars,i+2,span);
        }
        return -1;
    }
    private int findNextBold(char[] chars,int i ,Span span){
        int j = i;
        while (j < chars.length){
            if(chars[j] == '~' && chars[j+1] == '~'){
                //找到了
                BoldSpan boldSpan = new BoldSpan();
                SpanParser.parse(new String(chars, i, j - i), boldSpan);
                span.addChildSpan(boldSpan);
                return j+1;
            }
            j++;
        }
        return -1;
    }
}
