/*
 * AC_Lexer
 *
 * Somewhat "fragile" lexer implementation of AC language.
 *
 * @author SomeoneWhoDoesntWantToOwnThisCode
 */

import java.util.Scanner;
import java.io.FileInputStream;

public class AC_Lexer implements Lexer, AC_Token {
    int lines;
    Scanner tokenScanner;
    Scanner lineScanner;

    public AC_Lexer(String filename) {
	try {
	    lineScanner = new Scanner(new FileInputStream(filename));
	}
	catch (java.io.FileNotFoundException e) {
	    System.out.println("ERROR: File not found: " + filename);
	    System.exit(0);
	}
	catch (Exception e) {
	    System.out.println("ERROR: Unknown cause.");
	    e.printStackTrace();
	    System.exit(0);
	}
	tokenScanner = new Scanner("");
	lines = 0;
    }
    private void error(String msg) {
	System.out.println("LexError(line " + getLineNum() + "): " + msg);
	System.exit(1);
    }

    public int getLineNum() { return lines; }
    public int nextToken() {
	
	while (! tokenScanner.hasNext()) {
	    if (! lineScanner.hasNextLine()) return EOP_TOK;
	    tokenScanner = new Scanner(lineScanner.nextLine());
	    lines++;
	}

	String token = tokenScanner.next();
	if ("p".equals(token)) return PRINT_KEYWORD_TOK;
	else if ("i".equals(token)) return INT_KEYWORD_TOK;
	else if ("f".equals(token)) return FLOAT_KEYWORD_TOK;
	else if ("(".equals(token)) return LPAREN_TOK;
	else if (")".equals(token)) return RPAREN_TOK;
	else if ("+".equals(token)) return PLUS_TOK;
	else if ("*".equals(token)) return MUL_TOK;
	else if ("/".equals(token)) return DIV_TOK;
	else if ("-".equals(token)) return MINUS_TOK;
	else if ("^".equals(token)) return HAT_TOK;
	else if ("=".equals(token)) return ASSIGN_TOK;
	else {
	    int dotIndex = token.indexOf(".");
	    if (dotIndex >= 0) {
		String beforeDot = token.substring(0,dotIndex);
		String afterDot = token.substring(dotIndex+1);
		if (allDigitChars(beforeDot) && allDigitChars(afterDot))
		    return FLOAT_CONST_TOK;
		else
		    error("non digit char in FLOAT_CONST_TOK");
	    }
	    else {
		char c = token.charAt(0);
		if ('0' <= c && c <= '9') {
		    if (allDigitChars(token)) return INT_CONST_TOK;
		    else error("non digit char in INT_CONST_TOK");
		}
		else if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
		    if (allLetterChars(token)) return IDENT_TOK;
		    else error("non letter char in IDENT_TOK");
		}
		else {
		    error("unknown token: " + token);
		}
	    }
	}
	return ERROR_TOK;
    }
    private boolean allDigitChars(String s) {
	char[] chars = s.toCharArray();
	for (int i=0; i < chars.length; i++)
	    if (! ('0' <= chars[i] && chars[i] <= '9')) return false;
	return true;
    }
    private boolean allLetterChars(String s) {
	s = s.toLowerCase();
	char[] chars = s.toCharArray();
	for (int i=0; i < chars.length; i++)
	    if (! ('a' <= chars[i] && chars[i] <= 'z')) return false;
	return true;
    }

    // Poor man's unit testing...
    // The real program entry point is in AC_RDP class.
    public static void main(String[] args) {
	AC_Lexer lexer = new AC_Lexer(args[0]);
	int tok;
	while ( (tok = lexer.nextToken()) != EOP_TOK )
	    System.out.println("Token " + tok +
			       " on line # " + lexer.getLineNum());
    }
}
