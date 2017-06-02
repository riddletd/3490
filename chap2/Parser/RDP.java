
public abstract class RDP implements Token {

    private Lexer lexer;
    protected int currToken;
    
    public RDP(Lexer lexer) {
	this.lexer = lexer;
    }
    public void parse() {
	currToken = lexer.nextToken();
	start();
	
	if (currToken == EOP_TOK)
	    System.out.println("Congratulations! File parses successfully.");
	else 
	    error("Extraneous input in file.");
    }
    protected void error(String message) {
	System.out.println("ERROR on line " + lexer.getLineNum() +
			   ": " + message);
	System.exit(0);
    }
    protected void match(int expectedToken) {
	if (currToken == expectedToken) {
	    currToken = lexer.nextToken();
	}
	else {
	    error("Expected token " + expectedToken +
		  " but found token " + currToken + ".");
	}
    }
    protected void lambda() {
    }

    /*********** USER MUST IMPLEMENT THIS! (and subsequent grammar) *******/
    protected abstract void start();
}
