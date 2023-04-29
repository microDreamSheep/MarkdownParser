package live.midreamsheep.markdown.parser.element.elements.span.spans.italic;

import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.spans.bold.BoldSpan;

public class ItalicParser implements SpanParserInter {
    @Override
    public int parse(char[] chars, int i, Span span) {
        if(chars[i] == '*'){
            return findNextBold(chars,i+1,'*',span);
        }
        if(chars[i] == '_'){
            return findNextBold(chars,i+1,'_',span);
        }
        return -1;
    }
    private int findNextBold(char[] chars,int i,char type,Span span){
        int j = i;
        while (j < chars.length){
            if(chars[j] == type){
                //找到了
                ItalicSpan italicSpan = new ItalicSpan();
                SpanParser.parse(new String(chars, i, j - i), italicSpan);
                span.addChildSpan(italicSpan);
                return j;
            }
            j++;
        }
        return -1;
    }
}
