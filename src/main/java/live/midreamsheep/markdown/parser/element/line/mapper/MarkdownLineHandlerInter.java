package live.midreamsheep.markdown.parser.element.line.mapper;

import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserInter;
import live.midreamsheep.markdown.parser.element.line.mapper.parser.MarkdownLineParserSelection;
import live.midreamsheep.markdown.parser.element.line.mapper.update.delete.MarkdownLineDeleteInter;

public interface MarkdownLineHandlerInter
        extends MarkdownLineParserInter, MarkdownLineDeleteInter, MarkdownLineParserSelection {}