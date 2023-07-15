package live.midreamsheep.markdown.parser.api;

import java.util.List;
import java.util.Map;

public interface MarkdownHandlerCollectionAPI {

    Map<Character, List<MarkdownLineHandlerInter>> getParseTypeHandler();

    List<MarkdownLineHandlerInter> getContextTypeHandler();
}
