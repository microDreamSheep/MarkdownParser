package live.midreamsheep.markdown.parser.element.elements.span.spans.strikethrough;

import live.midreamsheep.markdown.parser.element.elements.span.SpanParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.Span;
import live.midreamsheep.markdown.parser.element.elements.span.spans.SpanParserInter;
import live.midreamsheep.markdown.parser.element.elements.span.spans.bold.BoldSpan;

public class StrikethroughParser implements SpanParserInter {
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
