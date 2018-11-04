// $ANTLR 3.4 F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g 2012-06-27 20:41:27

package wellingtonTrabalho12;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class wellingtonTrabalho12Parser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BEGIN", "END", "ID", "INT", "INTEGER", "NEWLINE", "WS", "' '", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'='", "'print('"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "prog", "decls", "ePrints", "com", "atom", "start", "multexpr", 
    "coms", "expr", "decl"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public wellingtonTrabalho12Parser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public wellingtonTrabalho12Parser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, null);

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public wellingtonTrabalho12Parser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return wellingtonTrabalho12Parser.tokenNames; }
    public String getGrammarFileName() { return "F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g"; }


    HashMap memory = new HashMap();



    // $ANTLR start "prog"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:14:1: prog : BEGIN NEWLINE start NEWLINE END NEWLINE ;
    public final void prog() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "prog");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(14, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:15:2: ( BEGIN NEWLINE start NEWLINE END NEWLINE )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:15:4: BEGIN NEWLINE start NEWLINE END NEWLINE
            {
            dbg.location(15,4);
            match(input,BEGIN,FOLLOW_BEGIN_in_prog31); 
            dbg.location(15,10);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_prog33); 
            dbg.location(15,18);
            pushFollow(FOLLOW_start_in_prog35);
            start();

            state._fsp--;

            dbg.location(15,24);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_prog37); 
            dbg.location(15,32);
            match(input,END,FOLLOW_END_in_prog39); 
            dbg.location(15,36);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_prog41); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(15, 42);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "prog");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "start"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:17:1: start : decls NEWLINE coms ;
    public final void start() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "start");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(17, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:18:2: ( decls NEWLINE coms )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:18:4: decls NEWLINE coms
            {
            dbg.location(18,4);
            pushFollow(FOLLOW_decls_in_start51);
            decls();

            state._fsp--;

            dbg.location(18,10);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_start53); 
            dbg.location(18,18);
            pushFollow(FOLLOW_coms_in_start55);
            coms();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(18, 21);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "start");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "start"



    // $ANTLR start "decls"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:20:1: decls : ( decl ';' ( NEWLINE )* )+ ;
    public final void decls() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "decls");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(20, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:21:2: ( ( decl ';' ( NEWLINE )* )+ )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:21:4: ( decl ';' ( NEWLINE )* )+
            {
            dbg.location(21,4);
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:21:4: ( decl ';' ( NEWLINE )* )+
            int cnt2=0;
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==INTEGER) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:21:5: decl ';' ( NEWLINE )*
            	    {
            	    dbg.location(21,5);
            	    pushFollow(FOLLOW_decl_in_decls66);
            	    decl();

            	    state._fsp--;

            	    dbg.location(21,9);
            	    match(input,19,FOLLOW_19_in_decls67); 
            	    dbg.location(21,13);
            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:21:13: ( NEWLINE )*
            	    try { dbg.enterSubRule(1);

            	    loop1:
            	    do {
            	        int alt1=2;
            	        try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==NEWLINE) ) {
            	            int LA1_1 = input.LA(2);

            	            if ( ((LA1_1 >= INTEGER && LA1_1 <= NEWLINE)) ) {
            	                alt1=1;
            	            }


            	        }


            	        } finally {dbg.exitDecision(1);}

            	        switch (alt1) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:21:14: NEWLINE
            	    	    {
            	    	    dbg.location(21,14);
            	    	    match(input,NEWLINE,FOLLOW_NEWLINE_in_decls70); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(1);}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt2++;
            } while (true);
            } finally {dbg.exitSubRule(2);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(21, 25);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "decls");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "decls"



    // $ANTLR start "decl"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:23:1: decl : INTEGER ' ' e= ID ( ',' e= ID )* ;
    public final void decl() throws RecognitionException {
        Token e=null;

        try { dbg.enterRule(getGrammarFileName(), "decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(23, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:24:2: ( INTEGER ' ' e= ID ( ',' e= ID )* )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:24:4: INTEGER ' ' e= ID ( ',' e= ID )*
            {
            dbg.location(24,4);
            match(input,INTEGER,FOLLOW_INTEGER_in_decl86); 
            dbg.location(24,12);
            match(input,11,FOLLOW_11_in_decl88); 
            dbg.location(24,17);
            e=(Token)match(input,ID,FOLLOW_ID_in_decl92); 
            dbg.location(24,21);
            memory.put((e!=null?e.getText():null),new Integer(0));
            dbg.location(24,58);
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:24:58: ( ',' e= ID )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:24:59: ',' e= ID
            	    {
            	    dbg.location(24,59);
            	    match(input,16,FOLLOW_16_in_decl96); 
            	    dbg.location(24,63);
            	    e=(Token)match(input,ID,FOLLOW_ID_in_decl99); 
            	    dbg.location(24,67);
            	    memory.put((e!=null?e.getText():null),new Integer(0));

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(24, 105);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "decl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "decl"



    // $ANTLR start "coms"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:26:1: coms : ( com ';' ( NEWLINE )* )+ ;
    public final void coms() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "coms");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(26, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:27:2: ( ( com ';' ( NEWLINE )* )+ )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:27:4: ( com ';' ( NEWLINE )* )+
            {
            dbg.location(27,4);
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:27:4: ( com ';' ( NEWLINE )* )+
            int cnt5=0;
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID||LA5_0==21) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:27:5: com ';' ( NEWLINE )*
            	    {
            	    dbg.location(27,5);
            	    pushFollow(FOLLOW_com_in_coms115);
            	    com();

            	    state._fsp--;

            	    dbg.location(27,9);
            	    match(input,19,FOLLOW_19_in_coms117); 
            	    dbg.location(27,13);
            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:27:13: ( NEWLINE )*
            	    try { dbg.enterSubRule(4);

            	    loop4:
            	    do {
            	        int alt4=2;
            	        try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==NEWLINE) ) {
            	            int LA4_1 = input.LA(2);

            	            if ( (LA4_1==ID||LA4_1==NEWLINE||LA4_1==21) ) {
            	                alt4=1;
            	            }


            	        }


            	        } finally {dbg.exitDecision(4);}

            	        switch (alt4) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:27:14: NEWLINE
            	    	    {
            	    	    dbg.location(27,14);
            	    	    match(input,NEWLINE,FOLLOW_NEWLINE_in_coms120); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(4);}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt5++;
            } while (true);
            } finally {dbg.exitSubRule(5);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(27, 25);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "coms");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "coms"



    // $ANTLR start "com"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:29:1: com : ( ID '=' expr | 'print(' ePrints ')' );
    public final void com() throws RecognitionException {
        Token ID1=null;
        int expr2 =0;

        String ePrints3 =null;


        try { dbg.enterRule(getGrammarFileName(), "com");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(29, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:30:2: ( ID '=' expr | 'print(' ePrints ')' )
            int alt6=2;
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==21) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:30:4: ID '=' expr
                    {
                    dbg.location(30,4);
                    ID1=(Token)match(input,ID,FOLLOW_ID_in_com136); 
                    dbg.location(30,7);
                    match(input,20,FOLLOW_20_in_com138); 
                    dbg.location(30,11);
                    pushFollow(FOLLOW_expr_in_com140);
                    expr2=expr();

                    state._fsp--;

                    dbg.location(30,16);
                    Integer v = (Integer)memory.get((ID1!=null?ID1.getText():null));
                          			if(v!=null) memory.put((ID1!=null?ID1.getText():null),new Integer(expr2));
                          			else System.err.println("Variavel nao definida: " + (ID1!=null?ID1.getText():null));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:33:4: 'print(' ePrints ')'
                    {
                    dbg.location(33,4);
                    match(input,21,FOLLOW_21_in_com147); 
                    dbg.location(33,12);
                    pushFollow(FOLLOW_ePrints_in_com148);
                    ePrints3=ePrints();

                    state._fsp--;

                    dbg.location(33,19);
                    match(input,13,FOLLOW_13_in_com149); 
                    dbg.location(33,22);
                    System.out.println(ePrints3);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(34, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "com");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "com"



    // $ANTLR start "ePrints"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:36:1: ePrints returns [String value] : e= expr ( ',' e= expr )* ;
    public final String ePrints() throws RecognitionException {
        String value = null;


        int e =0;


        try { dbg.enterRule(getGrammarFileName(), "ePrints");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(36, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:37:2: (e= expr ( ',' e= expr )* )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:37:4: e= expr ( ',' e= expr )*
            {
            dbg.location(37,5);
            pushFollow(FOLLOW_expr_in_ePrints167);
            e=expr();

            state._fsp--;

            dbg.location(37,11);
            value =new String((new Integer(e)).toString());
            dbg.location(38,3);
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:38:3: ( ',' e= expr )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:38:4: ',' e= expr
            	    {
            	    dbg.location(38,4);
            	    match(input,16,FOLLOW_16_in_ePrints174); 
            	    dbg.location(38,9);
            	    pushFollow(FOLLOW_expr_in_ePrints178);
            	    e=expr();

            	    state._fsp--;

            	    dbg.location(38,15);
            	    value =value.concat("\n").concat(new String((new Integer(e)).toString()));

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(38, 99);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ePrints");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return value;
    }
    // $ANTLR end "ePrints"



    // $ANTLR start "expr"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:40:1: expr returns [int value] : e= multexpr ( '+' e= multexpr | '-' e= multexpr )* ;
    public final int expr() throws RecognitionException {
        int value = 0;


        int e =0;


        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:41:2: (e= multexpr ( '+' e= multexpr | '-' e= multexpr )* )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:41:4: e= multexpr ( '+' e= multexpr | '-' e= multexpr )*
            {
            dbg.location(41,5);
            pushFollow(FOLLOW_multexpr_in_expr197);
            e=multexpr();

            state._fsp--;

            dbg.location(41,15);
            value = e;
            dbg.location(42,3);
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:42:3: ( '+' e= multexpr | '-' e= multexpr )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=3;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }
                else if ( (LA8_0==17) ) {
                    alt8=2;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:42:4: '+' e= multexpr
            	    {
            	    dbg.location(42,4);
            	    match(input,15,FOLLOW_15_in_expr204); 
            	    dbg.location(42,9);
            	    pushFollow(FOLLOW_multexpr_in_expr208);
            	    e=multexpr();

            	    state._fsp--;

            	    dbg.location(42,19);
            	    value += e;

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:43:4: '-' e= multexpr
            	    {
            	    dbg.location(43,4);
            	    match(input,17,FOLLOW_17_in_expr215); 
            	    dbg.location(43,9);
            	    pushFollow(FOLLOW_multexpr_in_expr219);
            	    e=multexpr();

            	    state._fsp--;

            	    dbg.location(43,19);
            	    value -=e;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(44, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return value;
    }
    // $ANTLR end "expr"



    // $ANTLR start "multexpr"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:46:1: multexpr returns [int value] : e= atom ( '*' e= atom | '/' e= atom )* ;
    public final int multexpr() throws RecognitionException {
        int value = 0;


        int e =0;


        try { dbg.enterRule(getGrammarFileName(), "multexpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(46, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:47:2: (e= atom ( '*' e= atom | '/' e= atom )* )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:47:4: e= atom ( '*' e= atom | '/' e= atom )*
            {
            dbg.location(47,5);
            pushFollow(FOLLOW_atom_in_multexpr241);
            e=atom();

            state._fsp--;

            dbg.location(47,11);
            value = e;
            dbg.location(48,3);
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:48:3: ( '*' e= atom | '/' e= atom )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=3;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==14) ) {
                    alt9=1;
                }
                else if ( (LA9_0==18) ) {
                    alt9=2;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:48:4: '*' e= atom
            	    {
            	    dbg.location(48,4);
            	    match(input,14,FOLLOW_14_in_multexpr248); 
            	    dbg.location(48,9);
            	    pushFollow(FOLLOW_atom_in_multexpr252);
            	    e=atom();

            	    state._fsp--;

            	    dbg.location(48,15);
            	    value *= e;

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:49:4: '/' e= atom
            	    {
            	    dbg.location(49,4);
            	    match(input,18,FOLLOW_18_in_multexpr259); 
            	    dbg.location(49,9);
            	    pushFollow(FOLLOW_atom_in_multexpr263);
            	    e=atom();

            	    state._fsp--;

            	    dbg.location(49,15);
            	    if (e!=0)value = value/e;
            	    		else System.err.println("Operacao ilegal. Divisao por zero! " + value + "/" +e);

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(51, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "multexpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return value;
    }
    // $ANTLR end "multexpr"



    // $ANTLR start "atom"
    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:53:1: atom returns [int value] : ( INT | ID | '(' expr ')' | '(' com ',' expr ')' );
    public final int atom() throws RecognitionException {
        int value = 0;


        Token INT4=null;
        Token ID5=null;
        int expr6 =0;

        int expr7 =0;


        try { dbg.enterRule(getGrammarFileName(), "atom");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(53, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:54:2: ( INT | ID | '(' expr ')' | '(' com ',' expr ')' )
            int alt10=4;
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            switch ( input.LA(1) ) {
            case INT:
                {
                alt10=1;
                }
                break;
            case ID:
                {
                alt10=2;
                }
                break;
            case 12:
                {
                switch ( input.LA(2) ) {
                case INT:
                case 12:
                    {
                    alt10=3;
                    }
                    break;
                case ID:
                    {
                    int LA10_5 = input.LA(3);

                    if ( (LA10_5==20) ) {
                        alt10=4;
                    }
                    else if ( ((LA10_5 >= 13 && LA10_5 <= 15)||(LA10_5 >= 17 && LA10_5 <= 18)) ) {
                        alt10=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 5, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                    }
                    break;
                case 21:
                    {
                    alt10=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 3, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:54:4: INT
                    {
                    dbg.location(54,4);
                    INT4=(Token)match(input,INT,FOLLOW_INT_in_atom283); 
                    dbg.location(54,8);
                    value = Integer.parseInt((INT4!=null?INT4.getText():null));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:55:4: ID
                    {
                    dbg.location(55,4);
                    ID5=(Token)match(input,ID,FOLLOW_ID_in_atom290); 
                    dbg.location(55,7);
                    Integer v = (Integer)memory.get((ID5!=null?ID5.getText():null));
                          			if(v!=null) value =v.intValue();
                          			else System.err.println("Variavel nao definida: " + (ID5!=null?ID5.getText():null));

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:58:4: '(' expr ')'
                    {
                    dbg.location(58,4);
                    match(input,12,FOLLOW_12_in_atom297); 
                    dbg.location(58,7);
                    pushFollow(FOLLOW_expr_in_atom298);
                    expr6=expr();

                    state._fsp--;

                    dbg.location(58,11);
                    match(input,13,FOLLOW_13_in_atom299); 
                    dbg.location(58,15);
                    value = expr6;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // F:\\Compiladores\\Trabalho\\Partes 1 e 2\\wellingtonTrabalho12.g:59:4: '(' com ',' expr ')'
                    {
                    dbg.location(59,4);
                    match(input,12,FOLLOW_12_in_atom306); 
                    dbg.location(59,7);
                    pushFollow(FOLLOW_com_in_atom307);
                    com();

                    state._fsp--;

                    dbg.location(59,10);
                    match(input,16,FOLLOW_16_in_atom308); 
                    dbg.location(59,13);
                    pushFollow(FOLLOW_expr_in_atom309);
                    expr7=expr();

                    state._fsp--;

                    dbg.location(59,18);
                    value = expr7;
                    dbg.location(59,41);
                    match(input,13,FOLLOW_13_in_atom312); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(60, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "atom");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return value;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_BEGIN_in_prog31 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog33 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_start_in_prog35 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog37 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_END_in_prog39 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog41 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decls_in_start51 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_start53 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_coms_in_start55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_in_decls66 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_decls67 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_NEWLINE_in_decls70 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_INTEGER_in_decl86 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_decl88 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_decl92 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_decl96 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_decl99 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_com_in_coms115 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_coms117 = new BitSet(new long[]{0x0000000000200242L});
    public static final BitSet FOLLOW_NEWLINE_in_coms120 = new BitSet(new long[]{0x0000000000200242L});
    public static final BitSet FOLLOW_ID_in_com136 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_com138 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_com140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_com147 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_ePrints_in_com148 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_com149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_ePrints167 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ePrints174 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_ePrints178 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_multexpr_in_expr197 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_15_in_expr204 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_multexpr_in_expr208 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_17_in_expr215 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_multexpr_in_expr219 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_atom_in_multexpr241 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_14_in_multexpr248 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_atom_in_multexpr252 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_18_in_multexpr259 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_atom_in_multexpr263 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_INT_in_atom283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_atom297 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_atom298 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_atom299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_atom306 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_com_in_atom307 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_atom308 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_atom309 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_atom312 = new BitSet(new long[]{0x0000000000000002L});

}