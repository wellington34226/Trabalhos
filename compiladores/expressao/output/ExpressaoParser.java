// $ANTLR 3.4 E:\\Compiladores\\expressao\\Expressao.g 2012-04-27 22:25:37

package expressao;
import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings({"all", "warnings", "unchecked"})
public class ExpressaoParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", "'('", "')'", "'*'", "'+'", "'-'", "'/'", "'='"
    };

    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int ID=4;
    public static final int INT=5;
    public static final int NEWLINE=6;
    public static final int WS=7;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "atom", "prog", "expr", "mult", "stat"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public ExpressaoParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public ExpressaoParser(TokenStream input, int port, RecognizerSharedState state) {
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

public ExpressaoParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg, new RecognizerSharedState());
}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

    public String[] getTokenNames() { return ExpressaoParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Compiladores\\expressao\\Expressao.g"; }


    HashMap memory = new HashMap();



    // $ANTLR start "prog"
    // E:\\Compiladores\\expressao\\Expressao.g:14:1: prog : ( stat )+ ;
    public final void prog() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "prog");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(14, 0);

        try {
            // E:\\Compiladores\\expressao\\Expressao.g:15:2: ( ( stat )+ )
            dbg.enterAlt(1);

            // E:\\Compiladores\\expressao\\Expressao.g:15:4: ( stat )+
            {
            dbg.location(15,4);
            // E:\\Compiladores\\expressao\\Expressao.g:15:4: ( stat )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= NEWLINE)||LA1_0==8) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // E:\\Compiladores\\expressao\\Expressao.g:15:4: stat
            	    {
            	    dbg.location(15,4);
            	    pushFollow(FOLLOW_stat_in_prog31);
            	    stat();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(15, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "prog");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "prog"



    // $ANTLR start "stat"
    // E:\\Compiladores\\expressao\\Expressao.g:16:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
    public final void stat() throws RecognitionException {
        Token ID2=null;
        int expr1 =0;

        int expr3 =0;


        try { dbg.enterRule(getGrammarFileName(), "stat");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(16, 0);

        try {
            // E:\\Compiladores\\expressao\\Expressao.g:17:2: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
            int alt2=3;
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

            switch ( input.LA(1) ) {
            case INT:
            case 8:
                {
                alt2=1;
                }
                break;
            case ID:
                {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==14) ) {
                    alt2=2;
                }
                else if ( (LA2_2==NEWLINE||(LA2_2 >= 10 && LA2_2 <= 13)) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case NEWLINE:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // E:\\Compiladores\\expressao\\Expressao.g:17:4: expr NEWLINE
                    {
                    dbg.location(17,4);
                    pushFollow(FOLLOW_expr_in_stat40);
                    expr1=expr();

                    state._fsp--;

                    dbg.location(17,9);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat42); 
                    dbg.location(17,17);
                    System.out.println(expr1);

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // E:\\Compiladores\\expressao\\Expressao.g:18:10: ID '=' expr NEWLINE
                    {
                    dbg.location(18,10);
                    ID2=(Token)match(input,ID,FOLLOW_ID_in_stat55); 
                    dbg.location(18,13);
                    match(input,14,FOLLOW_14_in_stat57); 
                    dbg.location(18,17);
                    pushFollow(FOLLOW_expr_in_stat59);
                    expr3=expr();

                    state._fsp--;

                    dbg.location(18,22);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat61); 
                    dbg.location(18,30);
                    memory.put((ID2!=null?ID2.getText():null),new Integer(expr3));

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // E:\\Compiladores\\expressao\\Expressao.g:19:10: NEWLINE
                    {
                    dbg.location(19,10);
                    match(input,NEWLINE,FOLLOW_NEWLINE_in_stat74); 

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
        dbg.location(19, 16);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "stat");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "stat"



    // $ANTLR start "expr"
    // E:\\Compiladores\\expressao\\Expressao.g:20:1: expr returns [int value] : e= mult ( '+' e= mult | '-' e= mult )* ;
    public final int expr() throws RecognitionException {
        int value = 0;


        int e =0;


        try { dbg.enterRule(getGrammarFileName(), "expr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(20, 0);

        try {
            // E:\\Compiladores\\expressao\\Expressao.g:21:2: (e= mult ( '+' e= mult | '-' e= mult )* )
            dbg.enterAlt(1);

            // E:\\Compiladores\\expressao\\Expressao.g:21:4: e= mult ( '+' e= mult | '-' e= mult )*
            {
            dbg.location(21,5);
            pushFollow(FOLLOW_mult_in_expr88);
            e=mult();

            state._fsp--;

            dbg.location(21,11);
            value = e;
            dbg.location(22,3);
            // E:\\Compiladores\\expressao\\Expressao.g:22:3: ( '+' e= mult | '-' e= mult )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=3;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }
                else if ( (LA3_0==12) ) {
                    alt3=2;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // E:\\Compiladores\\expressao\\Expressao.g:22:5: '+' e= mult
            	    {
            	    dbg.location(22,5);
            	    match(input,11,FOLLOW_11_in_expr96); 
            	    dbg.location(22,10);
            	    pushFollow(FOLLOW_mult_in_expr100);
            	    e=mult();

            	    state._fsp--;

            	    dbg.location(22,16);
            	    value += e;

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // E:\\Compiladores\\expressao\\Expressao.g:23:5: '-' e= mult
            	    {
            	    dbg.location(23,5);
            	    match(input,12,FOLLOW_12_in_expr108); 
            	    dbg.location(23,10);
            	    pushFollow(FOLLOW_mult_in_expr112);
            	    e=mult();

            	    state._fsp--;

            	    dbg.location(23,16);
            	    value -=e;

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
        dbg.location(23, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return value;
    }
    // $ANTLR end "expr"



    // $ANTLR start "mult"
    // E:\\Compiladores\\expressao\\Expressao.g:24:1: mult returns [int value] : e= atom ( '*' e= atom | '/' e= atom )* ;
    public final int mult() throws RecognitionException {
        int value = 0;


        int e =0;


        try { dbg.enterRule(getGrammarFileName(), "mult");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(24, 0);

        try {
            // E:\\Compiladores\\expressao\\Expressao.g:25:2: (e= atom ( '*' e= atom | '/' e= atom )* )
            dbg.enterAlt(1);

            // E:\\Compiladores\\expressao\\Expressao.g:25:4: e= atom ( '*' e= atom | '/' e= atom )*
            {
            dbg.location(25,5);
            pushFollow(FOLLOW_atom_in_mult130);
            e=atom();

            state._fsp--;

            dbg.location(25,11);
            value = e;
            dbg.location(26,3);
            // E:\\Compiladores\\expressao\\Expressao.g:26:3: ( '*' e= atom | '/' e= atom )*
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=3;
                try { dbg.enterDecision(4, decisionCanBacktrack[4]);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==10) ) {
                    alt4=1;
                }
                else if ( (LA4_0==13) ) {
                    alt4=2;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // E:\\Compiladores\\expressao\\Expressao.g:26:5: '*' e= atom
            	    {
            	    dbg.location(26,5);
            	    match(input,10,FOLLOW_10_in_mult139); 
            	    dbg.location(26,10);
            	    pushFollow(FOLLOW_atom_in_mult143);
            	    e=atom();

            	    state._fsp--;

            	    dbg.location(26,16);
            	    value *= e;

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // E:\\Compiladores\\expressao\\Expressao.g:27:4: '/' e= atom
            	    {
            	    dbg.location(27,4);
            	    match(input,13,FOLLOW_13_in_mult150); 
            	    dbg.location(27,9);
            	    pushFollow(FOLLOW_atom_in_mult154);
            	    e=atom();

            	    state._fsp--;

            	    dbg.location(27,15);
            	    if (e!=0)value = value/e;
            	    		else System.err.println("Operacao ilegao.\nDivisao por zero! "+e);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);
            } finally {dbg.exitSubRule(4);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(28, 78);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mult");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return value;
    }
    // $ANTLR end "mult"



    // $ANTLR start "atom"
    // E:\\Compiladores\\expressao\\Expressao.g:29:1: atom returns [int value] : ( INT | ID | '(' expr ')' );
    public final int atom() throws RecognitionException {
        int value = 0;


        Token INT4=null;
        Token ID5=null;
        int expr6 =0;


        try { dbg.enterRule(getGrammarFileName(), "atom");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(29, 0);

        try {
            // E:\\Compiladores\\expressao\\Expressao.g:30:2: ( INT | ID | '(' expr ')' )
            int alt5=3;
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            switch ( input.LA(1) ) {
            case INT:
                {
                alt5=1;
                }
                break;
            case ID:
                {
                alt5=2;
                }
                break;
            case 8:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // E:\\Compiladores\\expressao\\Expressao.g:30:4: INT
                    {
                    dbg.location(30,4);
                    INT4=(Token)match(input,INT,FOLLOW_INT_in_atom170); 
                    dbg.location(30,8);
                    value = Integer.parseInt((INT4!=null?INT4.getText():null));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // E:\\Compiladores\\expressao\\Expressao.g:31:10: ID
                    {
                    dbg.location(31,10);
                    ID5=(Token)match(input,ID,FOLLOW_ID_in_atom183); 
                    dbg.location(31,13);
                    Integer v = (Integer)memory.get((ID5!=null?ID5.getText():null));
                          			if(v!=null) value =v.intValue();
                          			else System.err.println("undefined varible "+(ID5!=null?ID5.getText():null));

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // E:\\Compiladores\\expressao\\Expressao.g:34:10: '(' expr ')'
                    {
                    dbg.location(34,10);
                    match(input,8,FOLLOW_8_in_atom196); 
                    dbg.location(34,13);
                    pushFollow(FOLLOW_expr_in_atom197);
                    expr6=expr();

                    state._fsp--;

                    dbg.location(34,17);
                    match(input,9,FOLLOW_9_in_atom198); 
                    dbg.location(34,21);
                    value = expr6;

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
        dbg.location(34, 43);

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


 

    public static final BitSet FOLLOW_stat_in_prog31 = new BitSet(new long[]{0x0000000000000172L});
    public static final BitSet FOLLOW_expr_in_stat40 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat42 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stat55 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_stat57 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_expr_in_stat59 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_in_expr88 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_expr96 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_mult_in_expr100 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_12_in_expr108 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_mult_in_expr112 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_atom_in_mult130 = new BitSet(new long[]{0x0000000000002402L});
    public static final BitSet FOLLOW_10_in_mult139 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_atom_in_mult143 = new BitSet(new long[]{0x0000000000002402L});
    public static final BitSet FOLLOW_13_in_mult150 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_atom_in_mult154 = new BitSet(new long[]{0x0000000000002402L});
    public static final BitSet FOLLOW_INT_in_atom170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_atom196 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_expr_in_atom197 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_atom198 = new BitSet(new long[]{0x0000000000000002L});

}