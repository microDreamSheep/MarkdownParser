package live.midreamsheep.markdown.parser.element.elements.span.spans;

import live.midreamsheep.markdown.parser.element.elements.span.spans.bold.BoldParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.image.ImageParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.italic.ItalicParser;
import live.midreamsheep.markdown.parser.element.elements.span.spans.link.LinkParser;

import java.util.HashMap;
import java.util.Map;

public class SpanParserMapper {
    private static final Map<String, SpanParserInter> mapper = new HashMap<>();

    public static void register(String key, SpanParserInter parser){
        mapper.put(key, parser);
    }

    public static SpanParserInter get(String key){
        return mapper.get(key);
    }

    static{
        register("bold",new BoldParser());
        register("italic",new ItalicParser());
        register("link",new LinkParser());
        register("image",new ImageParser());

        register("!",(content,index,span)->mapper.get("image").parse(content,index,span));
        register("[",(content,index,span)->mapper.get("link").parse(content,index,span));
        register("*",(content,index,span)->{
            if(content[index+1] == '*'){
                return mapper.get("bold").parse(content,index,span);
            }
            return mapper.get("italic").parse(content,index,span);
        });
        register("_",(content,index,span)->{
            if(content[index+1] == '_'){
                return mapper.get("bold").parse(content,index,span);
            }
            return mapper.get("italic").parse(content,index,span);
        });

    }
}
