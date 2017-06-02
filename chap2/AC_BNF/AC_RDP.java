
/* Implements the AC grammar:

terminal INT_KEYWORD_TOK, 
FLOAT_KEYWORD_TOK, 
PRINT_KEYWORD_TOK;

terminal PLUS_TOK, 
MINUS_TOK, 
MUL_TOK, 
DIV_TOK, 
HAT_TOK, 
ASSIGN_TOK;

terminal IDENT_TOK, 
INT_CONST_TOK, 
FLOAT_CONST_TOK; 

non terminal Program, DeclList, Decl, StmtList, Stmt;

non terminal AssignStmt, PrintStmt, Expr, Oper;

Program ::= DeclList StmtList        ;
DeclList ::= Decl DeclList           |     lambda  ;
Decl  ::= INT_KEYWORD_TOK IDENT_TOK  | FLOAT_KEYWORD_TOK IDENT_TOK ;
StmtList ::= Stmt StmtList           |     lambda  ;
Stmt ::= AssignStmt                  |   PrintStmt  ;
PrintStmt ::= PRINT_KEYWORD_TOK IDENT_TOK           ;
AssignStmt ::= IDENT_TOK ASSIGN_TOK Expr            ;
Expr ::= IDENT_TOK                   |   INT_CONST_TOK
     |   FLOAT_CONST_TOK             |   Expr Oper Expr  
     |   LPAREN_TOK Expr RPAREN_TOK  ;
Oper ::= PLUS_TOK | MINUS_TOK | MUL_TOK | DIV_TOK | HAT_TOK ;
*/


public class AC_RDP extends RDP implements AC_Token {

    public static void main(String[] args) {
	if (args.length != 1) {
	    System.out.println("usage: java AC_RDP ac-file-name");
	    System.exit(0);
	}
	AC_RDP parser = new AC_RDP(new AC_Lexer(args[0]));
	parser.parse();
    }
    public AC_RDP(Lexer ac_lexer) {
	super(ac_lexer);
    }



    
    /****************************************************************/
    /* You need to write the methods specific to the AC_RDP parser. */
    /****************************************************************/

    protected void start() {
	/* call your specific start symbol nonterm here! */
	program();
    }

    /****************************************************************/
    // ********* My Methods to Implement *********
    /****************************************************************/
    
    //Program ::= DeclList StmtList;
    public void program() {
	if (currToken == INT_KEYWORD_TOK
	    || currToken == FLOAT_KEYWORD_TOK) {
	    declList();
	    stmtList();
	}
    }

    //DeclList ::= Decl DeclList | lambda;
    public void declList() {
	if (currToken == INT_KEYWORD_TOK
	    || currToken == FLOAT_KEYWORD_TOK) {
	    decl();
	    declList();
	} else lambda();
    }

    //Decl ::= INT_KEYWORD_TOK IDENT_TOK | FLOAT_KEYWORD_TOK IDENT_TOK;
    public void decl() {
	if (currToken == INT_KEYWORD_TOK) {
	    match(INT_KEYWORD_TOK);
	    match(IDENT_TOK);
	}
	else if (currToken == FLOAT_KEYWORD_TOK) {
	    match(FLOAT_KEYWORD_TOK);
	    match(IDENT_TOK);
	}
    }

    //StmtList ::= Stmt StmtList | lambda;
    public void stmtList() {
	if (currToken == IDENT_TOK
	    || currToken == PRINT_KEYWORD_TOK) {
	    stmt();
	    stmtList();
	} else lambda();
    }

    //Stmt ::= AssignStmt | PrintStmt;
    public void stmt() {
	if (currToken == IDENT_TOK) {
	    assignStmt();
	} else if (currToken == PRINT_KEYWORD_TOK) {
	    printStmt();
	} else error("Problem in stmt() method.");
	
    }

    //AssignStmt ::= IDENT_TOK ASSIGN_TOK Expr; 
    public void assignStmt() {
	if (currToken == IDENT_TOK) {
	    match(IDENT_TOK);
	    match(ASSIGN_TOK);
	    expr();
	} else error("Problem in assignStmt() method.");
    }

    //PrintStmt ::= PRINT_KEYWORD_TOK IDENT_TOK;
    public void printStmt() {
	if (currToken == PRINT_KEYWORD_TOK) {
	    match(PRINT_KEYWORD_TOK);
	    match(IDENT_TOK);
	} else error("Problem in the printStmt() method");
    }

    //Expr ::= IDENT_TOK
    //       | INT_CONST_TOK
    //       | FLOAT_CONST_TOK
    //       | LPAREN_TOK Expr RPAREN_TOK Expr2;
    public void expr() {
	if (currToken == IDENT_TOK) {
	    match(IDENT_TOK);
	    expr2();
	} else if (currToken == INT_CONST_TOK) {
	    match(INT_CONST_TOK);
	    expr2();
	} else if (currToken == FLOAT_CONST_TOK) {
	    match(FLOAT_CONST_TOK);
	    expr2();
	} else if (currToken == LPAREN_TOK) {
	    match(LPAREN_TOK);
	    expr();
	    match(RPAREN_TOK);
	    expr2();
	} else error("Problem in expr() method."); 
    }

    //Expr2 ::= Oper Expr Expr2 | lambda
    public void expr2() {
	if (currToken == PLUS_TOK || currToken == MINUS_TOK
	    || currToken == MUL_TOK || currToken == DIV_TOK
	    || currToken == HAT_TOK) {
	    oper();
	    expr();
	    expr2();
	} else lambda();
    }

    //Oper ::= PLUS_TOK | MINUS_TOK | MUL_TOK | DIV_TOK | HAT_TOK;
    public void oper() {
	if (currToken == PLUS_TOK)       match(PLUS_TOK);
	else if (currToken == MINUS_TOK) match(MINUS_TOK);
	else if (currToken == MUL_TOK)   match(MUL_TOK);
	else if (currToken == DIV_TOK)   match(DIV_TOK);
	else if (currToken == HAT_TOK)   match(HAT_TOK);
	else error("Problem in the oper() method");
    }
}
