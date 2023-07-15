package live.midreamsheep.markdown.parser.page.colletion;

import live.midreamsheep.markdown.parser.api.MarkdownHandlerCollectionAPI;
import live.midreamsheep.markdown.parser.api.MarkdownLineHandlerInter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ContextTypeHandlerCollection {
    private final List<MarkdownLineHandlerInter> contextTypeHandler = new ArrayList<>();

    public void addNewContextTypeHandler(MarkdownLineHandlerInter handler){
        addNewContextTypeHandler(contextTypeHandler.size(), handler);
    }

    public void addNewContextTypeHandler(int index,MarkdownLineHandlerInter handler){
        contextTypeHandler.add(index, handler);
    }

    public void addCollections(MarkdownHandlerCollectionAPI collectionAPI){
        List<MarkdownLineHandlerInter> contextTypeHandlers = collectionAPI.getContextTypeHandler();
        contextTypeHandler.addAll(contextTypeHandlers);
    }
}
