package net.sourceforge.pmd.cpd.token;

import net.sourceforge.pmd.lang.ast.GenericToken;
import org.antlr.v4.runtime.Token;

/**
 * Generic Antlr representation of a token.
 */
public class GenericAntlrToken implements GenericToken {

    private final Token token;
    private final GenericAntlrToken previousComment;

    /**
     * Constructor
     *
     * @param token The antlr token implementation
     * @param previousComment The previous comment
     */
    public GenericAntlrToken(final Token token, final GenericAntlrToken previousComment) {
        this.token = token;
        this.previousComment = previousComment;
    }


    @Override
    public GenericToken getNext() {
        // Antlr implementation does not require this
        return null;
    }

    @Override
    public GenericToken getPreviousComment() {
        return previousComment;
    }

    @Override
    public String getImage() {
        return token.getText();
    }

    @Override
    public int getBeginLine() {
        return token.getLine();
    }

    @Override
    public int getEndLine() {
        return token.getLine(); // TODO: review this
    }

    @Override
    public int getBeginColumn() {
        return token.getCharPositionInLine();
    }

    @Override
    public int getEndColumn() {
        return token.getCharPositionInLine() + token.getStopIndex() - token.getStartIndex();
    }
}
