package live.midreamsheep.markdown.parser.api.line;

import live.midreamsheep.markdown.parser.api.line.delete.MarkdownLineDeleteInter;
import live.midreamsheep.markdown.parser.api.line.parse.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.api.line.update.MarkdownLineUpdateInter;

public interface MarkdownLineHandlerInter
        extends MarkdownLineParserInter, MarkdownLineDeleteInter, MarkdownLineUpdateInter {}