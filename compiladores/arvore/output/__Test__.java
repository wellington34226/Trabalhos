import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        ExpressaoLexer lex = new ExpressaoLexer(new ANTLRFileStream("E:\\Compiladores\\arvore\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);


        ExpressaoParser parser = new ExpressaoParser(tokens);
        ExpressaoParser.prog_return r = parser.prog();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(r.getTree());


        ExpArv walker = new ExpArv(nodes);
        try {
            walker.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }

}