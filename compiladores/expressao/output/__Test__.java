import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import expressao.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        ExpressaoLexer lex = new ExpressaoLexer(new ANTLRFileStream("E:\\Compiladores\\expressao\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        ExpressaoParser g = new ExpressaoParser(tokens, 49100, null);
        try {
            g.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}