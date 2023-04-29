package live.midreamsheep.markdown.parser.element.elements.span.spans.bold;

import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserInter;

public class BoldParser implements SpanParserInter {
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
