package live.midreamsheep.markdown.parser.page.colletion;

import live.midreamsheep.markdown.parser.api.MarkdownHandlerCollectionAPI;
import live.midreamsheep.markdown.parser.api.MarkdownLineHandlerInter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ParseTypeHandlerCollection {
    private final Map<Character, List<MarkdownLineHandlerInter>> parseTypeHandler = new HashMap<>();

    public void addNewParseTypeHandler(int weight,Character start,MarkdownLineHandlerInter handler){
        parseTypeHandler.computeIfAbsent(start, k -> new ArrayList<>());
        parseTypeHandler.get(start).add(weight, handler);
    }

    public void addNewParseTypeHandler(Character start,MarkdownLineHandlerInter handler){
        addNewParseTypeHandler(0, start, handler);
    }

    public void addCollections(MarkdownHandlerCollectionAPI collectionAPI){
        Map<Character, List<MarkdownLineHandlerInter>> parseTypeHandlers = collectionAPI.getParseTypeHandler();
        parseTypeHandlers.forEach((k,v)->{
            parseTypeHandler.computeIfAbsent(k, key -> new ArrayList<>());
            parseTypeHandler.get(k).addAll(v);
        });
    }
}
