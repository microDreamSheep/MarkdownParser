package live.midreamsheep.markdown.parser.page;

import live.midreamsheep.markdown.parser.api.MarkdownHandlerCollectionAPI;
import live.midreamsheep.markdown.parser.api.line.MarkdownLineHandlerInter;
import live.midreamsheep.markdown.parser.page.colletion.ContextTypeHandlerCollection;
import live.midreamsheep.markdown.parser.page.colletion.ParseTypeHandlerCollection;
import lombok.Getter;


@Getter
public class MarkdownParserBuilder {

    private final ParseTypeHandlerCollection parseTypeHandler = new ParseTypeHandlerCollection();
    private final ContextTypeHandlerCollection contextTypeHandler = new ContextTypeHandlerCollection();


    public void addNewParseTypeHandler(int weight,Character start,MarkdownLineHandlerInter handler){
        parseTypeHandler.addNewParseTypeHandler(weight, start, handler);
    }

    public void addNewParseTypeHandler(Character start,MarkdownLineHandlerInter handler){
        addNewParseTypeHandler(0, start, handler);
    }


    public void addNewContextTypeHandler(MarkdownLineHandlerInter handler){
        contextTypeHandler.addNewContextTypeHandler(handler);
    }

    public void addNewContextTypeHandler(int index,MarkdownLineHandlerInter handler){
        contextTypeHandler.addNewContextTypeHandler(index, handler);
    }

    public void addCollections(MarkdownHandlerCollectionAPI collectionAPI){
        contextTypeHandler.addCollections(collectionAPI);
        parseTypeHandler.addCollections(collectionAPI);
    }

    public MarkdownParserBuilder(){}

    public MarkdownParserBuilder(MarkdownHandlerCollectionAPI collectionAPI){
        addCollections(collectionAPI);
    }
    public MarkdownParser build(){
        return new MarkdownParser(this.parseTypeHandler.getParseTypeHandler(), this.contextTypeHandler.getContextTypeHandler());
    }
}
