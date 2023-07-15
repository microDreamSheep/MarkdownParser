package live.midreamsheep.markdown.parser.api.standard;

import live.midreamsheep.markdown.parser.api.MarkdownHandlerCollectionAPI;
import live.midreamsheep.markdown.parser.api.MarkdownLineHandlerInter;

import java.util.List;
import java.util.Map;

public class MarkdownStandardParserCollection implements MarkdownHandlerCollectionAPI {
    @Override
    public Map<Character, List<MarkdownLineHandlerInter>> getParseTypeHandler() {


        return null;
    }

    @Override
    public List<MarkdownLineHandlerInter> getContextTypeHandler() {
        return null;
    }
}
