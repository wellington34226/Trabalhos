// $ANTLR 3.4 F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g 2012-06-27 21:05:57

import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class wellingtonTrabalho3Arv extends DebugTreeParser {
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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "ePrints", "expr", "coms", "com", "start", "decl", "decls", 
    "prog"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public wellingtonTrabalho3Arv(TreeNodeStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public wellingtonTrabalho3Arv(TreeNodeStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this, port, input.getTreeAdaptor());

        setDebugListener(proxy);
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
    }

public wellingtonTrabalho3Arv(TreeNodeStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return wellingtonTrabalho3Arv.tokenNames; }
    public String getGrammarFileName() { return "F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g"; }


    HashMap memory=new HashMap();



    // $ANTLR start "prog"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:16:1: prog : BEGIN NEWLINE start NEWLINE END NEWLINE ;
    public final void prog() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "prog");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(16, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:17:2: ( BEGIN NEWLINE start NEWLINE END NEWLINE )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:17:4: BEGIN NEWLINE start NEWLINE END NEWLINE
            {
            dbg.location(17,4);
            match(input,BEGIN,FOLLOW_BEGIN_in_prog39); 
            dbg.location(17,10);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_prog41); 
            dbg.location(17,18);
            pushFollow(FOLLOW_start_in_prog43);
            start();

            state._fsp--;

            dbg.location(17,24);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_prog45); 
            dbg.location(17,32);
            match(input,END,FOLLOW_END_in_prog47); 
            dbg.location(17,36);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_prog49); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(17, 42);

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
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:19:1: start : decls NEWLINE coms ;
    public final void start() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "start");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:20:2: ( decls NEWLINE coms )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:20:4: decls NEWLINE coms
            {
            dbg.location(20,4);
            pushFollow(FOLLOW_decls_in_start59);
            decls();

            state._fsp--;

            dbg.location(20,10);
            match(input,NEWLINE,FOLLOW_NEWLINE_in_start61); 
            dbg.location(20,18);
            pushFollow(FOLLOW_coms_in_start63);
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
        dbg.location(20, 21);

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
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:22:1: decls : ( decl ';' ( NEWLINE )* )+ ;
    public final void decls() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "decls");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(22, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:23:2: ( ( decl ';' ( NEWLINE )* )+ )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:23:4: ( decl ';' ( NEWLINE )* )+
            {
            dbg.location(23,4);
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:23:4: ( decl ';' ( NEWLINE )* )+
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

            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:23:5: decl ';' ( NEWLINE )*
            	    {
            	    dbg.location(23,5);
            	    pushFollow(FOLLOW_decl_in_decls73);
            	    decl();

            	    state._fsp--;

            	    dbg.location(23,9);
            	    match(input,19,FOLLOW_19_in_decls74); 
            	    dbg.location(23,13);
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:23:13: ( NEWLINE )*
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

            	    	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:23:14: NEWLINE
            	    	    {
            	    	    dbg.location(23,14);
            	    	    match(input,NEWLINE,FOLLOW_NEWLINE_in_decls77); 

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
        dbg.location(23, 24);

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
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:25:1: decl : ^( INTEGER (e= ID )+ ) ;
    public final void decl() throws RecognitionException {
        CommonTree e=null;

        try { dbg.enterRule(getGrammarFileName(), "decl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(25, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:26:2: ( ^( INTEGER (e= ID )+ ) )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:26:4: ^( INTEGER (e= ID )+ )
            {
            dbg.location(26,4);
            dbg.location(26,6);
            match(input,INTEGER,FOLLOW_INTEGER_in_decl93); 

            match(input, Token.DOWN, null); 
            dbg.location(26,14);
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:26:14: (e= ID )+
            int cnt3=0;
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:26:16: e= ID
            	    {
            	    dbg.location(26,17);
            	    e=(CommonTree)match(input,ID,FOLLOW_ID_in_decl99); 
            	    dbg.location(26,21);
            	    memory.put((e!=null?e.getText():null),new Integer(0));

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt3++;
            } while (true);
            } finally {dbg.exitSubRule(3);}


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(26, 60);

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
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:28:1: coms : ( com ( NEWLINE )* )+ ;
    public final void coms() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "coms");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(28, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:29:2: ( ( com ( NEWLINE )* )+ )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:29:4: ( com ( NEWLINE )* )+
            {
            dbg.location(29,4);
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:29:4: ( com ( NEWLINE )* )+
            int cnt5=0;
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 20 && LA5_0 <= 21)) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:29:5: com ( NEWLINE )*
            	    {
            	    dbg.location(29,5);
            	    pushFollow(FOLLOW_com_in_coms116);
            	    com();

            	    state._fsp--;

            	    dbg.location(29,9);
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:29:9: ( NEWLINE )*
            	    try { dbg.enterSubRule(4);

            	    loop4:
            	    do {
            	        int alt4=2;
            	        try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==NEWLINE) ) {
            	            int LA4_1 = input.LA(2);

            	            if ( (LA4_1==NEWLINE||(LA4_1 >= 20 && LA4_1 <= 21)) ) {
            	                alt4=1;
            	            }


            	        }


            	        } finally {dbg.exitDecision(4);}

            	        switch (alt4) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:29:10: NEWLINE
            	    	    {
            	    	    dbg.location(29,10);
            	    	    match(input,NEWLINE,FOLLOW_NEWLINE_in_coms119); 

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
        dbg.location(29, 21);

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
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:31:1: com : ( ^( '=' ID expr ) | ^( 'print(' ePrints ')' ) );
    public final void com() throws RecognitionException {
        CommonTree ID1=null;
        int expr2 =0;

        String ePrints3 =null;


        try { dbg.enterRule(getGrammarFileName(), "com");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(31, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:32:2: ( ^( '=' ID expr ) | ^( 'print(' ePrints ')' ) )
            int alt6=2;
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
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

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:32:4: ^( '=' ID expr )
                    {
                    dbg.location(32,4);
                    dbg.location(32,6);
                    match(input,20,FOLLOW_20_in_com136); 

                    match(input, Token.DOWN, null); 
                    dbg.location(32,10);
                    ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_com138); 
                    dbg.location(32,13);
                    pushFollow(FOLLOW_expr_in_com140);
                    expr2=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    dbg.location(32,19);
                    memory.put((ID1!=null?ID1.getText():null),new Integer(expr2));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:33:4: ^( 'print(' ePrints ')' )
                    {
                    dbg.location(33,4);
                    dbg.location(33,6);
                    match(input,21,FOLLOW_21_in_com149); 

                    match(input, Token.DOWN, null); 
                    dbg.location(33,14);
                    pushFollow(FOLLOW_ePrints_in_com150);
                    ePrints3=ePrints();

                    state._fsp--;

                    dbg.location(33,21);
                    match(input,13,FOLLOW_13_in_com151); 

                    match(input, Token.UP, null); 

                    dbg.location(33,26);
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
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:36:1: ePrints returns [String value] : e= expr (e= expr )* ;
    public final String ePrints() throws RecognitionException {
        String value = null;


        int e =0;


        try { dbg.enterRule(getGrammarFileName(), "ePrints");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(36, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:37:2: (e= expr (e= expr )* )
            dbg.enterAlt(1);

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:37:4: e= expr (e= expr )*
            {
            dbg.location(37,5);
            pushFollow(FOLLOW_expr_in_ePrints172);
            e=expr();

            state._fsp--;

            dbg.location(37,11);
            value =new String((new Integer(e)).toString());
            dbg.location(38,3);
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:38:3: (e= expr )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= ID && LA7_0 <= INT)||(LA7_0 >= 14 && LA7_0 <= 18)) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:38:4: e= expr
            	    {
            	    dbg.location(38,5);
            	    pushFollow(FOLLOW_expr_in_ePrints181);
            	    e=expr();

            	    state._fsp--;

            	    dbg.location(38,11);
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
        dbg.location(38, 95);

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
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:40:1: expr returns [int value] : ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | ^( ',' com a= expr ) | ID | INT );
    public final int expr() throws RecognitionException {
        int value = 0;


        CommonTree ID4=null;
        CommonTree INT5=null;
        int a =0;

        int b =0;


        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(40, 0);

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:41:2: ( ^( '+' a= expr b= expr ) | ^( '-' a= expr b= expr ) | ^( '*' a= expr b= expr ) | ^( '/' a= expr b= expr ) | ^( ',' com a= expr ) | ID | INT )
            int alt8=7;
            try { dbg.enterDecision(8, decisionCanBacktrack[8]);

            switch ( input.LA(1) ) {
            case 15:
                {
                alt8=1;
                }
                break;
            case 17:
                {
                alt8=2;
                }
                break;
            case 14:
                {
                alt8=3;
                }
                break;
            case 18:
                {
                alt8=4;
                }
                break;
            case 16:
                {
                alt8=5;
                }
                break;
            case ID:
                {
                alt8=6;
                }
                break;
            case INT:
                {
                alt8=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(8);}

            switch (alt8) {
                case 1 :
                    dbg.enterAlt(1);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:41:4: ^( '+' a= expr b= expr )
                    {
                    dbg.location(41,4);
                    dbg.location(41,6);
                    match(input,15,FOLLOW_15_in_expr200); 

                    match(input, Token.DOWN, null); 
                    dbg.location(41,11);
                    pushFollow(FOLLOW_expr_in_expr204);
                    a=expr();

                    state._fsp--;

                    dbg.location(41,18);
                    pushFollow(FOLLOW_expr_in_expr208);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    dbg.location(41,25);
                    value = a+b;

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:42:4: ^( '-' a= expr b= expr )
                    {
                    dbg.location(42,4);
                    dbg.location(42,6);
                    match(input,17,FOLLOW_17_in_expr217); 

                    match(input, Token.DOWN, null); 
                    dbg.location(42,11);
                    pushFollow(FOLLOW_expr_in_expr221);
                    a=expr();

                    state._fsp--;

                    dbg.location(42,18);
                    pushFollow(FOLLOW_expr_in_expr225);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    dbg.location(42,25);
                    value = a-b;

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:43:4: ^( '*' a= expr b= expr )
                    {
                    dbg.location(43,4);
                    dbg.location(43,6);
                    match(input,14,FOLLOW_14_in_expr234); 

                    match(input, Token.DOWN, null); 
                    dbg.location(43,11);
                    pushFollow(FOLLOW_expr_in_expr238);
                    a=expr();

                    state._fsp--;

                    dbg.location(43,18);
                    pushFollow(FOLLOW_expr_in_expr242);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    dbg.location(43,25);
                    value = a*b;

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:44:4: ^( '/' a= expr b= expr )
                    {
                    dbg.location(44,4);
                    dbg.location(44,6);
                    match(input,18,FOLLOW_18_in_expr251); 

                    match(input, Token.DOWN, null); 
                    dbg.location(44,11);
                    pushFollow(FOLLOW_expr_in_expr255);
                    a=expr();

                    state._fsp--;

                    dbg.location(44,18);
                    pushFollow(FOLLOW_expr_in_expr259);
                    b=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    dbg.location(44,25);
                    if(b!=0)value = a/b;
                    			else System.out.println("Operacao ilegal. Divisao por zero! " + a + "/" + b);

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:46:4: ^( ',' com a= expr )
                    {
                    dbg.location(46,4);
                    dbg.location(46,6);
                    match(input,16,FOLLOW_16_in_expr268); 

                    match(input, Token.DOWN, null); 
                    dbg.location(46,10);
                    pushFollow(FOLLOW_com_in_expr270);
                    com();

                    state._fsp--;

                    dbg.location(46,15);
                    pushFollow(FOLLOW_expr_in_expr274);
                    a=expr();

                    state._fsp--;


                    match(input, Token.UP, null); 

                    dbg.location(46,22);
                    value = a;

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:47:4: ID
                    {
                    dbg.location(47,4);
                    ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_expr282); 
                    dbg.location(47,7);

                    			Integer v=(Integer)memory.get((ID4!=null?ID4.getText():null));
                    			if(v!=null) value =v.intValue();
                    			else System.out.println("Variavel nao definida: " + (ID4!=null?ID4.getText():null));
                    		

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3Arv.g:52:4: INT
                    {
                    dbg.location(52,4);
                    INT5=(CommonTree)match(input,INT,FOLLOW_INT_in_expr289); 
                    dbg.location(52,8);
                    value = Integer.parseInt((INT5!=null?INT5.getText():null));

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
        dbg.location(53, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return value;
    }
    // $ANTLR end "expr"

    // Delegated rules


 

    public static final BitSet FOLLOW_BEGIN_in_prog39 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog41 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_start_in_prog43 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_END_in_prog47 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decls_in_start59 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_start61 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_coms_in_start63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_in_decls73 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_decls74 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_NEWLINE_in_decls77 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_INTEGER_in_decl93 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_decl99 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_com_in_coms116 = new BitSet(new long[]{0x0000000000300202L});
    public static final BitSet FOLLOW_NEWLINE_in_coms119 = new BitSet(new long[]{0x0000000000300202L});
    public static final BitSet FOLLOW_20_in_com136 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_com138 = new BitSet(new long[]{0x000000000007C0C0L});
    public static final BitSet FOLLOW_expr_in_com140 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_21_in_com149 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ePrints_in_com150 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_com151 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expr_in_ePrints172 = new BitSet(new long[]{0x000000000007C0C2L});
    public static final BitSet FOLLOW_expr_in_ePrints181 = new BitSet(new long[]{0x000000000007C0C2L});
    public static final BitSet FOLLOW_15_in_expr200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr204 = new BitSet(new long[]{0x000000000007C0C0L});
    public static final BitSet FOLLOW_expr_in_expr208 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_17_in_expr217 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr221 = new BitSet(new long[]{0x000000000007C0C0L});
    public static final BitSet FOLLOW_expr_in_expr225 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_14_in_expr234 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr238 = new BitSet(new long[]{0x000000000007C0C0L});
    public static final BitSet FOLLOW_expr_in_expr242 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_18_in_expr251 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expr_in_expr255 = new BitSet(new long[]{0x000000000007C0C0L});
    public static final BitSet FOLLOW_expr_in_expr259 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_16_in_expr268 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_com_in_expr270 = new BitSet(new long[]{0x000000000007C0C0L});
    public static final BitSet FOLLOW_expr_in_expr274 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_expr282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_expr289 = new BitSet(new long[]{0x0000000000000002L});

}