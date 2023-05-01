package live.midreamsheep.markdown.parser.element.elements.span.spans.bold;

import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserInter;

/**
 * 加粗行内对象解析器
 * @author midreamsheep
 * @since 2023/5/1
 * @version 1.0
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.bold.BoldSpan
 * @see live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserMapper
 * */
public class BoldParser implements SpanParserInter {

    /**
     * 解析加粗行内格式
     *      格式为**加粗**或者__加粗__
     * 可能会在加粗中包含其他行内格式，所以需要使用递归解析
     *      例如**~~加粗删除线~~**
     * */
    @Override
    public int parse(char[] chars, int i, Span span) {
        if(chars[i] == '*' && chars[i+1] == '*'){
            return findNextBold(chars,i+2,'*',span);
        }
        if(chars[i] == '_' && chars[i+1] == '_'){
            return findNextBold(chars,i+2,'_',span);
        }
        return -1;
    }
    private int findNextBold(char[] chars,int i,char type,Span span){
        int j = i;
        while (j < chars.length){
            if(chars[j] == type && chars[j+1] == type){
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
