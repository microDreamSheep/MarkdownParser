package live.midreamsheep.markdown.parser.element.elements.line;

import live.midreamsheep.markdown.parser.element.MarkdownLineElement;
import live.midreamsheep.markdown.parser.element.elements.line.code.CodeParser;
import live.midreamsheep.markdown.parser.element.elements.line.head.HeadParser;
import live.midreamsheep.markdown.parser.element.elements.line.horizontal.HorizontalLine;
import live.midreamsheep.markdown.parser.tool.str.MarkdownParserStringUntil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkdownLineParserMapper {
    private static final Map<String, MarkdownLineParserInter> mapper = new HashMap<>();

    public static void register(String key, MarkdownLineParserInter parser){
        mapper.put(key, parser);
    }

    public static Map<String, MarkdownLineParserInter> getMapper() {
        return mapper;
    }
    public static MarkdownLineParserInter get(String key){
        return mapper.get(key);
    }

    static{
        register("#", new HeadParser());
        register("`", new CodeParser());
        register("-", (lines,index,elements) -> {
            long start = System.currentTimeMillis();
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '-')&&lines[index].trim().length()>=3){
                elements.add(new HorizontalLine());
                return index;
            }
            long end = System.currentTimeMillis();
            System.out.println(end-start);
            return -1;
        });
        register("*", (lines,index,elements) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '*')&&lines[index].trim().length()>=3){
                elements.add(new HorizontalLine());
                return index;
            }
            return -1;
        });
        register("_", (lines,index,elements) -> {
            if(MarkdownParserStringUntil.isAlways(lines[index].trim().toCharArray(), '_')&&lines[index].trim().length()>=3){
                elements.add(new HorizontalLine());
                return index;
            }
            return -1;
        });
    }
}
