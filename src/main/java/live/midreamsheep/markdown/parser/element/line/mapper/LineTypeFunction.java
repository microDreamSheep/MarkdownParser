package live.midreamsheep.markdown.parser.element.line.mapper;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.line.code.CodeDataLine;
import live.midreamsheep.markdown.parser.element.line.standard.Standard;
import live.midreamsheep.markdown.parser.element.span.str.StandardSpan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LineTypeFunction {

    private static final Map<LineElementType,RemoveFunctionInterface> removeFunctionMap = new HashMap<>();

    static {
        removeFunctionMap.put(LineElementType.CODE, (page, index) -> {
            MarkdownLineElement byIndex = page.getByIndex(index);
            List<String> contents = new LinkedList<>();
            for (; index < page.getElements().size(); index++) {
                MarkdownLineElement data = page.getByIndex(index);
                if (data.getType() == LineElementType.CODE_DATA) {
                    contents.add (((StandardSpan) ((CodeDataLine) data).getCodeData()).getContent());
                    page.removeLine(index);
                    index--;
                    continue;
                }
                if (data.getType() == LineElementType.CODE) {

                    data = new Standard(data.getContent());
                    break;
                }
            }
        });
    }

    public RemoveFunctionInterface getRemoveFunction(LineElementType type){
        return removeFunctionMap.get(type);
    }

    public static boolean isSingleLine(LineElementType type) {
        return type==LineElementType.STANDARD ||
                type==LineElementType.HORIZONTAL ||
                type==LineElementType.HEAD ||
                type==LineElementType.CODE_DATA;
    }
}
