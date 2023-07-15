package live.midreamsheep.markdown.parser.element.line.mapper.parser;

import live.midreamsheep.markdown.parser.element.line.LineElementType;
import live.midreamsheep.markdown.parser.element.line.mapper.MarkdownHandlerMapper;
import live.midreamsheep.markdown.parser.api.MarkdownLineHandlerInter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 解析行对象映射表
 * @see MarkdownLineParserInter
 * */
public class MarkdownLineParserMapper {
    private static final Map<String, List<MarkdownLineHandlerInter>> PARSER_INTER_HASH_MAP = new HashMap<>();
    public static void register(String key, MarkdownLineHandlerInter parser){
        PARSER_INTER_HASH_MAP.computeIfAbsent(key, k -> new LinkedList<>());
        PARSER_INTER_HASH_MAP.get(key).add(parser);
    }

    public static Map<String, List<MarkdownLineHandlerInter>> getParserInterHashMap() {
        return PARSER_INTER_HASH_MAP;
    }

    /**
     * 通过key获取解析器
     * @param key 解析器key
     *            例如：#、-、*、`等
     *            key都为一种语法的第一个字符
     *            例如：#、##、###、####等都是标题语法，但是#是标题语法的第一个字符，所以key为#
     *            例如：-、--、---、----等都是分割线语法，但是-是分割线语法的第一个字符，所以key为-
     * @return 解析器
     * */
    public static List<MarkdownLineHandlerInter> get(String key){
        return PARSER_INTER_HASH_MAP.get(key);
    }

    static{
        //注册解析器
        register("|", MarkdownHandlerMapper.get(LineElementType.TABLE));
        register(">", MarkdownHandlerMapper.get(LineElementType.QUOTE));
        register("`", MarkdownHandlerMapper.get(LineElementType.CODE));
        register("#", MarkdownHandlerMapper.get(LineElementType.HEAD));
        register("-", MarkdownHandlerMapper.get(LineElementType.HORIZONTAL));
        register("*", MarkdownHandlerMapper.get(LineElementType.HORIZONTAL));
        register("_", MarkdownHandlerMapper.get(LineElementType.HORIZONTAL));
    }
}
