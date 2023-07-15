package live.midreamsheep.markdown.parser.api;

import live.midreamsheep.markdown.parser.api.line.MarkdownLineHandlerInter;

import java.util.List;
import java.util.Map;

public interface MarkdownHandlerCollectionAPI {

    Map<Character, List<MarkdownLineHandlerInter>> getParseTypeHandler();

    List<MarkdownLineHandlerInter> getContextTypeHandler();
}
