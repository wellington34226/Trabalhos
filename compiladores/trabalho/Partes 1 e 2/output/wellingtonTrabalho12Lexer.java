// $ANTLR 3.4 F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g 2012-06-27 20:41:30
package wellingtonTrabalho12;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class wellingtonTrabalho12Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int BEGIN=4;
    public static final int END=5;
    public static final int ID=6;
    public static final int INT=7;
    public static final int INTEGER=8;
    public static final int NEWLINE=9;
    public static final int WS=10;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public wellingtonTrabalho12Lexer() {} 
    public wellingtonTrabalho12Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public wellingtonTrabalho12Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:4:7: ( ' ' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:4:9: ' '
            {
            match(' '); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:5:7: ( '(' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:5:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:6:7: ( ')' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:6:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:7:7: ( '*' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:7:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:8:7: ( '+' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:8:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:9:7: ( ',' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:9:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:10:7: ( '-' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:10:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:11:7: ( '/' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:11:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:12:7: ( ';' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:12:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:13:7: ( '=' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:13:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:14:7: ( 'print(' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:14:9: 'print('
            {
            match("print("); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:62:7: ( ( 'BEGIN' ) )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:62:9: ( 'BEGIN' )
            {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:62:9: ( 'BEGIN' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:62:10: 'BEGIN'
            {
            match("BEGIN"); 



            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:63:5: ( ( 'END' ) )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:63:7: ( 'END' )
            {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:63:7: ( 'END' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:63:8: 'END'
            {
            match("END"); 



            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:64:9: ( ( 'integer' ) )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:64:11: ( 'integer' )
            {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:64:11: ( 'integer' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:64:12: 'integer'
            {
            match("integer"); 



            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:65:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )* )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:65:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:65:30: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:66:5: ( ( '0' .. '9' )+ )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:66:10: ( '0' .. '9' )+
            {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:66:10: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:67:9: ( ( '\\r' )? '\\n' )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:67:11: ( '\\r' )? '\\n'
            {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:67:11: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:67:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:68:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:68:7: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:68:7: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | BEGIN | END | INTEGER | ID | INT | NEWLINE | WS )
        int alt5=18;
        switch ( input.LA(1) ) {
        case ' ':
            {
            int LA5_1 = input.LA(2);

            if ( ((LA5_1 >= '\t' && LA5_1 <= '\n')||LA5_1=='\r'||LA5_1==' ') ) {
                alt5=18;
            }
            else {
                alt5=1;
            }
            }
            break;
        case '(':
            {
            alt5=2;
            }
            break;
        case ')':
            {
            alt5=3;
            }
            break;
        case '*':
            {
            alt5=4;
            }
            break;
        case '+':
            {
            alt5=5;
            }
            break;
        case ',':
            {
            alt5=6;
            }
            break;
        case '-':
            {
            alt5=7;
            }
            break;
        case '/':
            {
            alt5=8;
            }
            break;
        case ';':
            {
            alt5=9;
            }
            break;
        case '=':
            {
            alt5=10;
            }
            break;
        case 'p':
            {
            int LA5_11 = input.LA(2);

            if ( (LA5_11=='r') ) {
                int LA5_21 = input.LA(3);

                if ( (LA5_21=='i') ) {
                    int LA5_26 = input.LA(4);

                    if ( (LA5_26=='n') ) {
                        int LA5_30 = input.LA(5);

                        if ( (LA5_30=='t') ) {
                            int LA5_34 = input.LA(6);

                            if ( (LA5_34=='(') ) {
                                alt5=11;
                            }
                            else {
                                alt5=15;
                            }
                        }
                        else {
                            alt5=15;
                        }
                    }
                    else {
                        alt5=15;
                    }
                }
                else {
                    alt5=15;
                }
            }
            else {
                alt5=15;
            }
            }
            break;
        case 'B':
            {
            int LA5_12 = input.LA(2);

            if ( (LA5_12=='E') ) {
                int LA5_22 = input.LA(3);

                if ( (LA5_22=='G') ) {
                    int LA5_27 = input.LA(4);

                    if ( (LA5_27=='I') ) {
                        int LA5_31 = input.LA(5);

                        if ( (LA5_31=='N') ) {
                            int LA5_35 = input.LA(6);

                            if ( ((LA5_35 >= '0' && LA5_35 <= '9')||(LA5_35 >= 'A' && LA5_35 <= 'Z')||LA5_35=='_'||(LA5_35 >= 'a' && LA5_35 <= 'z')) ) {
                                alt5=15;
                            }
                            else {
                                alt5=12;
                            }
                        }
                        else {
                            alt5=15;
                        }
                    }
                    else {
                        alt5=15;
                    }
                }
                else {
                    alt5=15;
                }
            }
            else {
                alt5=15;
            }
            }
            break;
        case 'E':
            {
            int LA5_13 = input.LA(2);

            if ( (LA5_13=='N') ) {
                int LA5_23 = input.LA(3);

                if ( (LA5_23=='D') ) {
                    int LA5_28 = input.LA(4);

                    if ( ((LA5_28 >= '0' && LA5_28 <= '9')||(LA5_28 >= 'A' && LA5_28 <= 'Z')||LA5_28=='_'||(LA5_28 >= 'a' && LA5_28 <= 'z')) ) {
                        alt5=15;
                    }
                    else {
                        alt5=13;
                    }
                }
                else {
                    alt5=15;
                }
            }
            else {
                alt5=15;
            }
            }
            break;
        case 'i':
            {
            int LA5_14 = input.LA(2);

            if ( (LA5_14=='n') ) {
                int LA5_24 = input.LA(3);

                if ( (LA5_24=='t') ) {
                    int LA5_29 = input.LA(4);

                    if ( (LA5_29=='e') ) {
                        int LA5_33 = input.LA(5);

                        if ( (LA5_33=='g') ) {
                            int LA5_36 = input.LA(6);

                            if ( (LA5_36=='e') ) {
                                int LA5_39 = input.LA(7);

                                if ( (LA5_39=='r') ) {
                                    int LA5_40 = input.LA(8);

                                    if ( ((LA5_40 >= '0' && LA5_40 <= '9')||(LA5_40 >= 'A' && LA5_40 <= 'Z')||LA5_40=='_'||(LA5_40 >= 'a' && LA5_40 <= 'z')) ) {
                                        alt5=15;
                                    }
                                    else {
                                        alt5=14;
                                    }
                                }
                                else {
                                    alt5=15;
                                }
                            }
                            else {
                                alt5=15;
                            }
                        }
                        else {
                            alt5=15;
                        }
                    }
                    else {
                        alt5=15;
                    }
                }
                else {
                    alt5=15;
                }
            }
            else {
                alt5=15;
            }
            }
            break;
        case 'A':
        case 'C':
        case 'D':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=15;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt5=16;
            }
            break;
        case '\r':
            {
            int LA5_17 = input.LA(2);

            if ( (LA5_17=='\n') ) {
                int LA5_18 = input.LA(3);

                if ( ((LA5_18 >= '\t' && LA5_18 <= '\n')||LA5_18=='\r'||LA5_18==' ') ) {
                    alt5=18;
                }
                else {
                    alt5=17;
                }
            }
            else {
                alt5=18;
            }
            }
            break;
        case '\n':
            {
            int LA5_18 = input.LA(2);

            if ( ((LA5_18 >= '\t' && LA5_18 <= '\n')||LA5_18=='\r'||LA5_18==' ') ) {
                alt5=18;
            }
            else {
                alt5=17;
            }
            }
            break;
        case '\t':
            {
            alt5=18;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:76: BEGIN
                {
                mBEGIN(); 


                }
                break;
            case 13 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:82: END
                {
                mEND(); 


                }
                break;
            case 14 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:86: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 15 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:94: ID
                {
                mID(); 


                }
                break;
            case 16 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:97: INT
                {
                mINT(); 


                }
                break;
            case 17 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:101: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 18 :
                // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:1:109: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}