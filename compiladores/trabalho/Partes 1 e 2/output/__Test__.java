import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import wellingtonTrabalho12.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        wellingtonTrabalho12Lexer lex = new wellingtonTrabalho12Lexer(new ANTLRFileStream("F:\\Compiladores\\Trabalho\\entrada_padrao.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        wellingtonTrabalho12Parser g = new wellingtonTrabalho12Parser(tokens, 49100, null);
        try {
            g.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}