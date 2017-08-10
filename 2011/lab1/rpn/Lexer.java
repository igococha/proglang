
public class Lexer {
    public Lexer(String e) {
	tokens = e.split("\\s+");  // one or more spaces
	currentIndex = -1;
	currentToken = null;
	lastIndex = tokens.length-1;
    }
    public boolean hasNextToken() { 
	return (currentIndex < lastIndex);
    }
    public Token getCurrentToken() { return currentToken; }

    public Token getNextToken() throws LexerException {
	TokenKind k;
	String s;
	char c;
	if (hasNextToken()) { /* New Token is created */
	    currentIndex++;
	    s = tokens[currentIndex];
	    /* Lexical Analysis - determine type of Token */
	    if (isNumeric(s)) {
		k = TokenKind.INTEGER;
	    } else  if (s.length()==1) {
		c = s.charAt(0);
		switch(c) {
		case '+': k = TokenKind.PLUS; break;
		case '-': k = TokenKind.MINUS; break;
		case '*': k = TokenKind.MULT; break;
		case '/': k = TokenKind.DIV; break;
		default: k = TokenKind.ERROR;
		}
	    } else {
		k = TokenKind.ERROR;
	    }
	    currentToken = new Token(tokens[currentIndex],k);
	    if (k==TokenKind.ERROR)
		throw new LexerException("String not recognised");
	} else { /* No more tokens left - end of stream */
	    currentIndex = lastIndex + 1;
	    currentToken = null;
	}
	return currentToken;
    }

    private boolean isNumeric(String s) {
	for(int i=0; i < s.length(); i++)
	    if (!Character.isDigit(s.charAt(i)))
		return false;
	return true;
    }
	

    private String[] tokens;
    private int currentIndex;
    private Token currentToken;
    private int lastIndex;

}