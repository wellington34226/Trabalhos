// $ANTLR 3.4 E:\\Compiladores\\arvore\\Expressao.g 2012-05-06 13:15:20

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ExpressaoParser extends Parser {
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


    public ExpressaoParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ExpressaoParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return ExpressaoParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\Compiladores\\arvore\\Expressao.g"; }


    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prog"
    // E:\\Compiladores\\arvore\\Expressao.g:8:1: prog : ( stat )+ ;
    public final ExpressaoParser.prog_return prog() throws RecognitionException {
        ExpressaoParser.prog_return retval = new ExpressaoParser.prog_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ExpressaoParser.stat_return stat1 =null;



        try {
            // E:\\Compiladores\\arvore\\Expressao.g:9:2: ( ( stat )+ )
            // E:\\Compiladores\\arvore\\Expressao.g:9:4: ( stat )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // E:\\Compiladores\\arvore\\Expressao.g:9:4: ( stat )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ID && LA1_0 <= NEWLINE)||LA1_0==8) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\Compiladores\\arvore\\Expressao.g:9:5: stat
            	    {
            	    pushFollow(FOLLOW_stat_in_prog27);
            	    stat1=stat();

            	    state._fsp--;

            	    adaptor.addChild(root_0, stat1.getTree());

            	    System.out.println((stat1!=null?((CommonTree)stat1.tree):null)==null?"null":(stat1!=null?((CommonTree)stat1.tree):null).toStringTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prog"


    public static class stat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stat"
    // E:\\Compiladores\\arvore\\Expressao.g:10:1: stat : ( expr NEWLINE -> expr | ID '=' expr NEWLINE -> ^( '=' ID expr ) | NEWLINE ->);
    public final ExpressaoParser.stat_return stat() throws RecognitionException {
        ExpressaoParser.stat_return retval = new ExpressaoParser.stat_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NEWLINE3=null;
        Token ID4=null;
        Token char_literal5=null;
        Token NEWLINE7=null;
        Token NEWLINE8=null;
        ExpressaoParser.expr_return expr2 =null;

        ExpressaoParser.expr_return expr6 =null;


        CommonTree NEWLINE3_tree=null;
        CommonTree ID4_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree NEWLINE7_tree=null;
        CommonTree NEWLINE8_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_14=new RewriteRuleTokenStream(adaptor,"token 14");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // E:\\Compiladores\\arvore\\Expressao.g:11:2: ( expr NEWLINE -> expr | ID '=' expr NEWLINE -> ^( '=' ID expr ) | NEWLINE ->)
            int alt2=3;
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

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // E:\\Compiladores\\arvore\\Expressao.g:11:4: expr NEWLINE
                    {
                    pushFollow(FOLLOW_expr_in_stat38);
                    expr2=expr();

                    state._fsp--;

                    stream_expr.add(expr2.getTree());

                    NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat40);  
                    stream_NEWLINE.add(NEWLINE3);


                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 11:17: -> expr
                    {
                        adaptor.addChild(root_0, stream_expr.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // E:\\Compiladores\\arvore\\Expressao.g:12:10: ID '=' expr NEWLINE
                    {
                    ID4=(Token)match(input,ID,FOLLOW_ID_in_stat55);  
                    stream_ID.add(ID4);


                    char_literal5=(Token)match(input,14,FOLLOW_14_in_stat57);  
                    stream_14.add(char_literal5);


                    pushFollow(FOLLOW_expr_in_stat59);
                    expr6=expr();

                    state._fsp--;

                    stream_expr.add(expr6.getTree());

                    NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat61);  
                    stream_NEWLINE.add(NEWLINE7);


                    // AST REWRITE
                    // elements: 14, expr, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 12:30: -> ^( '=' ID expr )
                    {
                        // E:\\Compiladores\\arvore\\Expressao.g:12:33: ^( '=' ID expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_14.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // E:\\Compiladores\\arvore\\Expressao.g:13:10: NEWLINE
                    {
                    NEWLINE8=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat82);  
                    stream_NEWLINE.add(NEWLINE8);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 13:18: ->
                    {
                        root_0 = null;
                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stat"


    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // E:\\Compiladores\\arvore\\Expressao.g:14:1: expr : mult ( ( '+' ^| '-' ^) mult )* ;
    public final ExpressaoParser.expr_return expr() throws RecognitionException {
        ExpressaoParser.expr_return retval = new ExpressaoParser.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal10=null;
        Token char_literal11=null;
        ExpressaoParser.mult_return mult9 =null;

        ExpressaoParser.mult_return mult12 =null;


        CommonTree char_literal10_tree=null;
        CommonTree char_literal11_tree=null;

        try {
            // E:\\Compiladores\\arvore\\Expressao.g:15:2: ( mult ( ( '+' ^| '-' ^) mult )* )
            // E:\\Compiladores\\arvore\\Expressao.g:15:4: mult ( ( '+' ^| '-' ^) mult )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_in_expr93);
            mult9=mult();

            state._fsp--;

            adaptor.addChild(root_0, mult9.getTree());

            // E:\\Compiladores\\arvore\\Expressao.g:16:3: ( ( '+' ^| '-' ^) mult )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 11 && LA4_0 <= 12)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // E:\\Compiladores\\arvore\\Expressao.g:16:4: ( '+' ^| '-' ^) mult
            	    {
            	    // E:\\Compiladores\\arvore\\Expressao.g:16:4: ( '+' ^| '-' ^)
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==11) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==12) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // E:\\Compiladores\\arvore\\Expressao.g:16:5: '+' ^
            	            {
            	            char_literal10=(Token)match(input,11,FOLLOW_11_in_expr99); 
            	            char_literal10_tree = 
            	            (CommonTree)adaptor.create(char_literal10)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal10_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // E:\\Compiladores\\arvore\\Expressao.g:16:12: '-' ^
            	            {
            	            char_literal11=(Token)match(input,12,FOLLOW_12_in_expr104); 
            	            char_literal11_tree = 
            	            (CommonTree)adaptor.create(char_literal11)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal11_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_mult_in_expr108);
            	    mult12=mult();

            	    state._fsp--;

            	    adaptor.addChild(root_0, mult12.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expr"


    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult"
    // E:\\Compiladores\\arvore\\Expressao.g:17:1: mult : atom ( ( '*' ^| '/' ^) atom )* ;
    public final ExpressaoParser.mult_return mult() throws RecognitionException {
        ExpressaoParser.mult_return retval = new ExpressaoParser.mult_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal14=null;
        Token char_literal15=null;
        ExpressaoParser.atom_return atom13 =null;

        ExpressaoParser.atom_return atom16 =null;


        CommonTree char_literal14_tree=null;
        CommonTree char_literal15_tree=null;

        try {
            // E:\\Compiladores\\arvore\\Expressao.g:18:2: ( atom ( ( '*' ^| '/' ^) atom )* )
            // E:\\Compiladores\\arvore\\Expressao.g:18:4: atom ( ( '*' ^| '/' ^) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_atom_in_mult118);
            atom13=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom13.getTree());

            // E:\\Compiladores\\arvore\\Expressao.g:19:3: ( ( '*' ^| '/' ^) atom )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==10||LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // E:\\Compiladores\\arvore\\Expressao.g:19:5: ( '*' ^| '/' ^) atom
            	    {
            	    // E:\\Compiladores\\arvore\\Expressao.g:19:5: ( '*' ^| '/' ^)
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==10) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==13) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // E:\\Compiladores\\arvore\\Expressao.g:19:6: '*' ^
            	            {
            	            char_literal14=(Token)match(input,10,FOLLOW_10_in_mult125); 
            	            char_literal14_tree = 
            	            (CommonTree)adaptor.create(char_literal14)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal14_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // E:\\Compiladores\\arvore\\Expressao.g:19:13: '/' ^
            	            {
            	            char_literal15=(Token)match(input,13,FOLLOW_13_in_mult130); 
            	            char_literal15_tree = 
            	            (CommonTree)adaptor.create(char_literal15)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal15_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_atom_in_mult134);
            	    atom16=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom16.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mult"


    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // E:\\Compiladores\\arvore\\Expressao.g:20:1: atom : ( INT | ID | '(' ! expr ')' !);
    public final ExpressaoParser.atom_return atom() throws RecognitionException {
        ExpressaoParser.atom_return retval = new ExpressaoParser.atom_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token INT17=null;
        Token ID18=null;
        Token char_literal19=null;
        Token char_literal21=null;
        ExpressaoParser.expr_return expr20 =null;


        CommonTree INT17_tree=null;
        CommonTree ID18_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree char_literal21_tree=null;

        try {
            // E:\\Compiladores\\arvore\\Expressao.g:21:2: ( INT | ID | '(' ! expr ')' !)
            int alt7=3;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt7=1;
                }
                break;
            case ID:
                {
                alt7=2;
                }
                break;
            case 8:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // E:\\Compiladores\\arvore\\Expressao.g:21:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    INT17=(Token)match(input,INT,FOLLOW_INT_in_atom144); 
                    INT17_tree = 
                    (CommonTree)adaptor.create(INT17)
                    ;
                    adaptor.addChild(root_0, INT17_tree);


                    }
                    break;
                case 2 :
                    // E:\\Compiladores\\arvore\\Expressao.g:22:7: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    ID18=(Token)match(input,ID,FOLLOW_ID_in_atom152); 
                    ID18_tree = 
                    (CommonTree)adaptor.create(ID18)
                    ;
                    adaptor.addChild(root_0, ID18_tree);


                    }
                    break;
                case 3 :
                    // E:\\Compiladores\\arvore\\Expressao.g:23:7: '(' ! expr ')' !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal19=(Token)match(input,8,FOLLOW_8_in_atom160); 

                    pushFollow(FOLLOW_expr_in_atom162);
                    expr20=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr20.getTree());

                    char_literal21=(Token)match(input,9,FOLLOW_9_in_atom163); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_stat_in_prog27 = new BitSet(new long[]{0x0000000000000172L});
    public static final BitSet FOLLOW_expr_in_stat38 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat40 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_stat55 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_stat57 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_expr_in_stat59 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NEWLINE_in_stat61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_stat82 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_in_expr93 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_11_in_expr99 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_12_in_expr104 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_mult_in_expr108 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_atom_in_mult118 = new BitSet(new long[]{0x0000000000002402L});
    public static final BitSet FOLLOW_10_in_mult125 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_13_in_mult130 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_atom_in_mult134 = new BitSet(new long[]{0x0000000000002402L});
    public static final BitSet FOLLOW_INT_in_atom144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_atom160 = new BitSet(new long[]{0x0000000000000130L});
    public static final BitSet FOLLOW_expr_in_atom162 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_atom163 = new BitSet(new long[]{0x0000000000000002L});

}