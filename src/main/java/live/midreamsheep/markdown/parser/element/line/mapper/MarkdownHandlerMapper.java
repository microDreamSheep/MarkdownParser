package live.midreamsheep.markdown.parser.element.line.mapper;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.code.CodeHandler;
import live.midreamsheep.markdown.parser.element.line.head.HeadHandler;
import live.midreamsheep.markdown.parser.element.line.horizontal.HorizontalHandler;
import live.midreamsheep.markdown.parser.element.line.quote.QuoteHandler;
import live.midreamsheep.markdown.parser.element.line.standard.StandardHandler;
import live.midreamsheep.markdown.parser.element.line.table.TableHandler;

import java.util.HashMap;
import java.util.Map;

public class MarkdownHandlerMapper {
    private static final Map<LineElementType,MarkdownLineHandlerInter> mapper = new HashMap<>();

    public static void register(LineElementType type, MarkdownLineHandlerInter handler){
        mapper.put(type, handler);
    }

    static{
        register(LineElementType.HEAD, new HeadHandler());
        register(LineElementType.CODE, new CodeHandler());
        register(LineElementType.QUOTE, new QuoteHandler());
        register(LineElementType.TABLE, new TableHandler());
        register(LineElementType.HORIZONTAL, new HorizontalHandler());
        register(LineElementType.STANDARD, new StandardHandler());
    }

    public static MarkdownLineHandlerInter get(LineElementType type){
        return mapper.get(type);
    }

}
