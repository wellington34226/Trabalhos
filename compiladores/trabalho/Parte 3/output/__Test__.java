import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        wellingtonTrabalho3Lexer lex = new wellingtonTrabalho3Lexer(new ANTLRFileStream("F:\\Compiladores\\Trabalho\\entrada_padrao.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);


        wellingtonTrabalho3Parser parser = new wellingtonTrabalho3Parser(tokens);
        wellingtonTrabalho3Parser.prog_return r = parser.prog();
        CommonTreeNodeStream nodes = new CommonTreeNodeStream(r.getTree());


        wellingtonTrabalho3Arv walker = new wellingtonTrabalho3Arv(nodes);
        try {
            walker.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }

    }

}