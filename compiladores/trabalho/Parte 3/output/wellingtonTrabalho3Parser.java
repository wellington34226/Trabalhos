// $ANTLR 3.4 F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g 2012-06-27 21:02:23

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class wellingtonTrabalho3Parser extends Parser {
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


    public wellingtonTrabalho3Parser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public wellingtonTrabalho3Parser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return wellingtonTrabalho3Parser.tokenNames; }
    public String getGrammarFileName() { return "F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g"; }


    public static class prog_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prog"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:9:1: prog : BEGIN NEWLINE start NEWLINE END NEWLINE ;
    public final wellingtonTrabalho3Parser.prog_return prog() throws RecognitionException {
        wellingtonTrabalho3Parser.prog_return retval = new wellingtonTrabalho3Parser.prog_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token BEGIN1=null;
        Token NEWLINE2=null;
        Token NEWLINE4=null;
        Token END5=null;
        Token NEWLINE6=null;
        wellingtonTrabalho3Parser.start_return start3 =null;


        CommonTree BEGIN1_tree=null;
        CommonTree NEWLINE2_tree=null;
        CommonTree NEWLINE4_tree=null;
        CommonTree END5_tree=null;
        CommonTree NEWLINE6_tree=null;

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:10:2: ( BEGIN NEWLINE start NEWLINE END NEWLINE )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:10:4: BEGIN NEWLINE start NEWLINE END NEWLINE
            {
            root_0 = (CommonTree)adaptor.nil();


            BEGIN1=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_prog28); 
            BEGIN1_tree = 
            (CommonTree)adaptor.create(BEGIN1)
            ;
            adaptor.addChild(root_0, BEGIN1_tree);


            NEWLINE2=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_prog30); 
            NEWLINE2_tree = 
            (CommonTree)adaptor.create(NEWLINE2)
            ;
            adaptor.addChild(root_0, NEWLINE2_tree);


            pushFollow(FOLLOW_start_in_prog32);
            start3=start();

            state._fsp--;

            adaptor.addChild(root_0, start3.getTree());

            System.out.println((start3!=null?((CommonTree)start3.tree):null)==null?"null":(start3!=null?((CommonTree)start3.tree):null).toStringTree());

            NEWLINE4=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_prog36); 
            NEWLINE4_tree = 
            (CommonTree)adaptor.create(NEWLINE4)
            ;
            adaptor.addChild(root_0, NEWLINE4_tree);


            END5=(Token)match(input,END,FOLLOW_END_in_prog38); 
            END5_tree = 
            (CommonTree)adaptor.create(END5)
            ;
            adaptor.addChild(root_0, END5_tree);


            NEWLINE6=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_prog40); 
            NEWLINE6_tree = 
            (CommonTree)adaptor.create(NEWLINE6)
            ;
            adaptor.addChild(root_0, NEWLINE6_tree);


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


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "start"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:12:1: start : decls NEWLINE coms ;
    public final wellingtonTrabalho3Parser.start_return start() throws RecognitionException {
        wellingtonTrabalho3Parser.start_return retval = new wellingtonTrabalho3Parser.start_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NEWLINE8=null;
        wellingtonTrabalho3Parser.decls_return decls7 =null;

        wellingtonTrabalho3Parser.coms_return coms9 =null;


        CommonTree NEWLINE8_tree=null;

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:13:2: ( decls NEWLINE coms )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:13:4: decls NEWLINE coms
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_decls_in_start50);
            decls7=decls();

            state._fsp--;

            adaptor.addChild(root_0, decls7.getTree());

            NEWLINE8=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_start52); 
            NEWLINE8_tree = 
            (CommonTree)adaptor.create(NEWLINE8)
            ;
            adaptor.addChild(root_0, NEWLINE8_tree);


            pushFollow(FOLLOW_coms_in_start54);
            coms9=coms();

            state._fsp--;

            adaptor.addChild(root_0, coms9.getTree());

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
    // $ANTLR end "start"


    public static class decls_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "decls"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:15:1: decls : ( decl ';' ! ( NEWLINE )* )+ ;
    public final wellingtonTrabalho3Parser.decls_return decls() throws RecognitionException {
        wellingtonTrabalho3Parser.decls_return retval = new wellingtonTrabalho3Parser.decls_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal11=null;
        Token NEWLINE12=null;
        wellingtonTrabalho3Parser.decl_return decl10 =null;


        CommonTree char_literal11_tree=null;
        CommonTree NEWLINE12_tree=null;

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:16:2: ( ( decl ';' ! ( NEWLINE )* )+ )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:16:4: ( decl ';' ! ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:16:4: ( decl ';' ! ( NEWLINE )* )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==INTEGER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:16:5: decl ';' ! ( NEWLINE )*
            	    {
            	    pushFollow(FOLLOW_decl_in_decls64);
            	    decl10=decl();

            	    state._fsp--;

            	    adaptor.addChild(root_0, decl10.getTree());

            	    char_literal11=(Token)match(input,19,FOLLOW_19_in_decls65); 

            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:16:14: ( NEWLINE )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==NEWLINE) ) {
            	            int LA1_1 = input.LA(2);

            	            if ( ((LA1_1 >= INTEGER && LA1_1 <= NEWLINE)) ) {
            	                alt1=1;
            	            }


            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:16:15: NEWLINE
            	    	    {
            	    	    NEWLINE12=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_decls69); 
            	    	    NEWLINE12_tree = 
            	    	    (CommonTree)adaptor.create(NEWLINE12)
            	    	    ;
            	    	    adaptor.addChild(root_0, NEWLINE12_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);


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
    // $ANTLR end "decls"


    public static class decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "decl"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:18:1: decl : INTEGER ' ' ID ( ',' ID )* -> ^( INTEGER ( ID )+ ) ;
    public final wellingtonTrabalho3Parser.decl_return decl() throws RecognitionException {
        wellingtonTrabalho3Parser.decl_return retval = new wellingtonTrabalho3Parser.decl_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token INTEGER13=null;
        Token char_literal14=null;
        Token ID15=null;
        Token char_literal16=null;
        Token ID17=null;

        CommonTree INTEGER13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree ID15_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree ID17_tree=null;
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleTokenStream stream_11=new RewriteRuleTokenStream(adaptor,"token 11");

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:19:2: ( INTEGER ' ' ID ( ',' ID )* -> ^( INTEGER ( ID )+ ) )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:19:4: INTEGER ' ' ID ( ',' ID )*
            {
            INTEGER13=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_decl84);  
            stream_INTEGER.add(INTEGER13);


            char_literal14=(Token)match(input,11,FOLLOW_11_in_decl86);  
            stream_11.add(char_literal14);


            ID15=(Token)match(input,ID,FOLLOW_ID_in_decl88);  
            stream_ID.add(ID15);


            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:19:19: ( ',' ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:19:20: ',' ID
            	    {
            	    char_literal16=(Token)match(input,16,FOLLOW_16_in_decl91);  
            	    stream_16.add(char_literal16);


            	    ID17=(Token)match(input,ID,FOLLOW_ID_in_decl93);  
            	    stream_ID.add(ID17);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // AST REWRITE
            // elements: INTEGER, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 19:29: -> ^( INTEGER ( ID )+ )
            {
                // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:19:32: ^( INTEGER ( ID )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                stream_INTEGER.nextNode()
                , root_1);

                if ( !(stream_ID.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ID.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_ID.nextNode()
                    );

                }
                stream_ID.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

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
    // $ANTLR end "decl"


    public static class coms_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "coms"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:21:1: coms : ( com ';' ! ( NEWLINE )* )+ ;
    public final wellingtonTrabalho3Parser.coms_return coms() throws RecognitionException {
        wellingtonTrabalho3Parser.coms_return retval = new wellingtonTrabalho3Parser.coms_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal19=null;
        Token NEWLINE20=null;
        wellingtonTrabalho3Parser.com_return com18 =null;


        CommonTree char_literal19_tree=null;
        CommonTree NEWLINE20_tree=null;

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:22:2: ( ( com ';' ! ( NEWLINE )* )+ )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:22:4: ( com ';' ! ( NEWLINE )* )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:22:4: ( com ';' ! ( NEWLINE )* )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID||LA5_0==21) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:22:5: com ';' ! ( NEWLINE )*
            	    {
            	    pushFollow(FOLLOW_com_in_coms116);
            	    com18=com();

            	    state._fsp--;

            	    adaptor.addChild(root_0, com18.getTree());

            	    char_literal19=(Token)match(input,19,FOLLOW_19_in_coms118); 

            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:22:14: ( NEWLINE )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==NEWLINE) ) {
            	            int LA4_1 = input.LA(2);

            	            if ( (LA4_1==ID||LA4_1==NEWLINE||LA4_1==21) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:22:15: NEWLINE
            	    	    {
            	    	    NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_coms122); 
            	    	    NEWLINE20_tree = 
            	    	    (CommonTree)adaptor.create(NEWLINE20)
            	    	    ;
            	    	    adaptor.addChild(root_0, NEWLINE20_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
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
    // $ANTLR end "coms"


    public static class com_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "com"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:24:1: com : ( ID '=' expr -> ^( '=' ID expr ) | 'print(' ePrints ')' -> ^( 'print(' ePrints ')' ) );
    public final wellingtonTrabalho3Parser.com_return com() throws RecognitionException {
        wellingtonTrabalho3Parser.com_return retval = new wellingtonTrabalho3Parser.com_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ID21=null;
        Token char_literal22=null;
        Token string_literal24=null;
        Token char_literal26=null;
        wellingtonTrabalho3Parser.expr_return expr23 =null;

        wellingtonTrabalho3Parser.ePrints_return ePrints25 =null;


        CommonTree ID21_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree string_literal24_tree=null;
        CommonTree char_literal26_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_20=new RewriteRuleTokenStream(adaptor,"token 20");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleSubtreeStream stream_ePrints=new RewriteRuleSubtreeStream(adaptor,"rule ePrints");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:25:2: ( ID '=' expr -> ^( '=' ID expr ) | 'print(' ePrints ')' -> ^( 'print(' ePrints ')' ) )
            int alt6=2;
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

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:25:4: ID '=' expr
                    {
                    ID21=(Token)match(input,ID,FOLLOW_ID_in_com137);  
                    stream_ID.add(ID21);


                    char_literal22=(Token)match(input,20,FOLLOW_20_in_com139);  
                    stream_20.add(char_literal22);


                    pushFollow(FOLLOW_expr_in_com141);
                    expr23=expr();

                    state._fsp--;

                    stream_expr.add(expr23.getTree());

                    // AST REWRITE
                    // elements: expr, 20, ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 25:16: -> ^( '=' ID expr )
                    {
                        // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:25:19: ^( '=' ID expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_20.nextNode()
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
                case 2 :
                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:26:4: 'print(' ePrints ')'
                    {
                    string_literal24=(Token)match(input,21,FOLLOW_21_in_com156);  
                    stream_21.add(string_literal24);


                    pushFollow(FOLLOW_ePrints_in_com158);
                    ePrints25=ePrints();

                    state._fsp--;

                    stream_ePrints.add(ePrints25.getTree());

                    char_literal26=(Token)match(input,13,FOLLOW_13_in_com160);  
                    stream_13.add(char_literal26);


                    // AST REWRITE
                    // elements: 21, 13, ePrints
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 26:25: -> ^( 'print(' ePrints ')' )
                    {
                        // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:26:28: ^( 'print(' ePrints ')' )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_21.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_ePrints.nextTree());

                        adaptor.addChild(root_1, 
                        stream_13.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

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
    // $ANTLR end "com"


    public static class ePrints_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ePrints"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:29:1: ePrints : expr ( ',' ! expr )* ;
    public final wellingtonTrabalho3Parser.ePrints_return ePrints() throws RecognitionException {
        wellingtonTrabalho3Parser.ePrints_return retval = new wellingtonTrabalho3Parser.ePrints_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal28=null;
        wellingtonTrabalho3Parser.expr_return expr27 =null;

        wellingtonTrabalho3Parser.expr_return expr29 =null;


        CommonTree char_literal28_tree=null;

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:30:2: ( expr ( ',' ! expr )* )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:30:4: expr ( ',' ! expr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expr_in_ePrints183);
            expr27=expr();

            state._fsp--;

            adaptor.addChild(root_0, expr27.getTree());

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:30:9: ( ',' ! expr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:30:10: ',' ! expr
            	    {
            	    char_literal28=(Token)match(input,16,FOLLOW_16_in_ePrints186); 

            	    pushFollow(FOLLOW_expr_in_ePrints189);
            	    expr29=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr29.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "ePrints"


    public static class expr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expr"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:32:1: expr : multexpr ( ( '+' ^| '-' ^) multexpr )* ;
    public final wellingtonTrabalho3Parser.expr_return expr() throws RecognitionException {
        wellingtonTrabalho3Parser.expr_return retval = new wellingtonTrabalho3Parser.expr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal31=null;
        Token char_literal32=null;
        wellingtonTrabalho3Parser.multexpr_return multexpr30 =null;

        wellingtonTrabalho3Parser.multexpr_return multexpr33 =null;


        CommonTree char_literal31_tree=null;
        CommonTree char_literal32_tree=null;

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:33:2: ( multexpr ( ( '+' ^| '-' ^) multexpr )* )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:33:4: multexpr ( ( '+' ^| '-' ^) multexpr )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_multexpr_in_expr202);
            multexpr30=multexpr();

            state._fsp--;

            adaptor.addChild(root_0, multexpr30.getTree());

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:34:3: ( ( '+' ^| '-' ^) multexpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15||LA9_0==17) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:34:4: ( '+' ^| '-' ^) multexpr
            	    {
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:34:4: ( '+' ^| '-' ^)
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==15) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==17) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:34:5: '+' ^
            	            {
            	            char_literal31=(Token)match(input,15,FOLLOW_15_in_expr208); 
            	            char_literal31_tree = 
            	            (CommonTree)adaptor.create(char_literal31)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal31_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:34:12: '-' ^
            	            {
            	            char_literal32=(Token)match(input,17,FOLLOW_17_in_expr213); 
            	            char_literal32_tree = 
            	            (CommonTree)adaptor.create(char_literal32)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal32_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_multexpr_in_expr217);
            	    multexpr33=multexpr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, multexpr33.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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


    public static class multexpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "multexpr"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:36:1: multexpr : atom ( ( '*' ^| '/' ^) atom )* ;
    public final wellingtonTrabalho3Parser.multexpr_return multexpr() throws RecognitionException {
        wellingtonTrabalho3Parser.multexpr_return retval = new wellingtonTrabalho3Parser.multexpr_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal35=null;
        Token char_literal36=null;
        wellingtonTrabalho3Parser.atom_return atom34 =null;

        wellingtonTrabalho3Parser.atom_return atom37 =null;


        CommonTree char_literal35_tree=null;
        CommonTree char_literal36_tree=null;

        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:37:2: ( atom ( ( '*' ^| '/' ^) atom )* )
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:37:4: atom ( ( '*' ^| '/' ^) atom )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_atom_in_multexpr230);
            atom34=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom34.getTree());

            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:38:3: ( ( '*' ^| '/' ^) atom )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14||LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:38:4: ( '*' ^| '/' ^) atom
            	    {
            	    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:38:4: ( '*' ^| '/' ^)
            	    int alt10=2;
            	    int LA10_0 = input.LA(1);

            	    if ( (LA10_0==14) ) {
            	        alt10=1;
            	    }
            	    else if ( (LA10_0==18) ) {
            	        alt10=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt10) {
            	        case 1 :
            	            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:38:5: '*' ^
            	            {
            	            char_literal35=(Token)match(input,14,FOLLOW_14_in_multexpr237); 
            	            char_literal35_tree = 
            	            (CommonTree)adaptor.create(char_literal35)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal35_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:38:12: '/' ^
            	            {
            	            char_literal36=(Token)match(input,18,FOLLOW_18_in_multexpr242); 
            	            char_literal36_tree = 
            	            (CommonTree)adaptor.create(char_literal36)
            	            ;
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal36_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_atom_in_multexpr246);
            	    atom37=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom37.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end "multexpr"


    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:40:1: atom : ( INT | ID | '(' ! expr ')' !| '(' com ',' expr ')' -> ^( ',' com expr ) );
    public final wellingtonTrabalho3Parser.atom_return atom() throws RecognitionException {
        wellingtonTrabalho3Parser.atom_return retval = new wellingtonTrabalho3Parser.atom_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token INT38=null;
        Token ID39=null;
        Token char_literal40=null;
        Token char_literal42=null;
        Token char_literal43=null;
        Token char_literal45=null;
        Token char_literal47=null;
        wellingtonTrabalho3Parser.expr_return expr41 =null;

        wellingtonTrabalho3Parser.com_return com44 =null;

        wellingtonTrabalho3Parser.expr_return expr46 =null;


        CommonTree INT38_tree=null;
        CommonTree ID39_tree=null;
        CommonTree char_literal40_tree=null;
        CommonTree char_literal42_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree char_literal47_tree=null;
        RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
        RewriteRuleTokenStream stream_13=new RewriteRuleTokenStream(adaptor,"token 13");
        RewriteRuleTokenStream stream_12=new RewriteRuleTokenStream(adaptor,"token 12");
        RewriteRuleSubtreeStream stream_com=new RewriteRuleSubtreeStream(adaptor,"rule com");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:41:2: ( INT | ID | '(' ! expr ')' !| '(' com ',' expr ')' -> ^( ',' com expr ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case INT:
                {
                alt12=1;
                }
                break;
            case ID:
                {
                alt12=2;
                }
                break;
            case 12:
                {
                switch ( input.LA(2) ) {
                case INT:
                case 12:
                    {
                    alt12=3;
                    }
                    break;
                case ID:
                    {
                    int LA12_5 = input.LA(3);

                    if ( (LA12_5==20) ) {
                        alt12=4;
                    }
                    else if ( ((LA12_5 >= 13 && LA12_5 <= 15)||(LA12_5 >= 17 && LA12_5 <= 18)) ) {
                        alt12=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 5, input);

                        throw nvae;

                    }
                    }
                    break;
                case 21:
                    {
                    alt12=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    throw nvae;

                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }

            switch (alt12) {
                case 1 :
                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:41:4: INT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    INT38=(Token)match(input,INT,FOLLOW_INT_in_atom258); 
                    INT38_tree = 
                    (CommonTree)adaptor.create(INT38)
                    ;
                    adaptor.addChild(root_0, INT38_tree);


                    }
                    break;
                case 2 :
                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:42:4: ID
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    ID39=(Token)match(input,ID,FOLLOW_ID_in_atom263); 
                    ID39_tree = 
                    (CommonTree)adaptor.create(ID39)
                    ;
                    adaptor.addChild(root_0, ID39_tree);


                    }
                    break;
                case 3 :
                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:43:4: '(' ! expr ')' !
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal40=(Token)match(input,12,FOLLOW_12_in_atom268); 

                    pushFollow(FOLLOW_expr_in_atom270);
                    expr41=expr();

                    state._fsp--;

                    adaptor.addChild(root_0, expr41.getTree());

                    char_literal42=(Token)match(input,13,FOLLOW_13_in_atom271); 

                    }
                    break;
                case 4 :
                    // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:44:4: '(' com ',' expr ')'
                    {
                    char_literal43=(Token)match(input,12,FOLLOW_12_in_atom277);  
                    stream_12.add(char_literal43);


                    pushFollow(FOLLOW_com_in_atom278);
                    com44=com();

                    state._fsp--;

                    stream_com.add(com44.getTree());

                    char_literal45=(Token)match(input,16,FOLLOW_16_in_atom280);  
                    stream_16.add(char_literal45);


                    pushFollow(FOLLOW_expr_in_atom282);
                    expr46=expr();

                    state._fsp--;

                    stream_expr.add(expr46.getTree());

                    char_literal47=(Token)match(input,13,FOLLOW_13_in_atom283);  
                    stream_13.add(char_literal47);


                    // AST REWRITE
                    // elements: com, expr, 16
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 44:23: -> ^( ',' com expr )
                    {
                        // F:\\Compiladores\\Trabalho\\Parte 3\\wellingtonTrabalho3.g:44:26: ^( ',' com expr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_16.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, stream_com.nextTree());

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

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
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_BEGIN_in_prog28 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog30 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_start_in_prog32 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog36 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_END_in_prog38 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_prog40 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decls_in_start50 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NEWLINE_in_start52 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_coms_in_start54 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_in_decls64 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_decls65 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_NEWLINE_in_decls69 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_INTEGER_in_decl84 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_decl86 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_decl88 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_decl91 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ID_in_decl93 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_com_in_coms116 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_coms118 = new BitSet(new long[]{0x0000000000200242L});
    public static final BitSet FOLLOW_NEWLINE_in_coms122 = new BitSet(new long[]{0x0000000000200242L});
    public static final BitSet FOLLOW_ID_in_com137 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_com139 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_com141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_com156 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_ePrints_in_com158 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_com160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_ePrints183 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ePrints186 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_ePrints189 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_multexpr_in_expr202 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_15_in_expr208 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_17_in_expr213 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_multexpr_in_expr217 = new BitSet(new long[]{0x0000000000028002L});
    public static final BitSet FOLLOW_atom_in_multexpr230 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_14_in_multexpr237 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_18_in_multexpr242 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_atom_in_multexpr246 = new BitSet(new long[]{0x0000000000044002L});
    public static final BitSet FOLLOW_INT_in_atom258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_atom268 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_atom270 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_atom271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_atom277 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_com_in_atom278 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_atom280 = new BitSet(new long[]{0x00000000000010C0L});
    public static final BitSet FOLLOW_expr_in_atom282 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_atom283 = new BitSet(new long[]{0x0000000000000002L});

}