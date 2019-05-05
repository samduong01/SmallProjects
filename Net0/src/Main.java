import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.*;

/**
 * Created by sam on 4/30/19.
 */
public class Main {
    public static void main(String[] args){

        for(String filename: args){
            Main dr = new Main(filename);

            dr.start();
            StringBuilder result = new StringBuilder(filename);
        }


        OutputStream out = null;

        try{
            out = new FileOutputStream("/Users/sam/Projects/Net0/src/out.txt");
            generateChars(out);

        }catch (IOException e){
            System.err.println(e.getMessage());
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e){

                }
            }
        }
    }

    public static void generateChars(OutputStream out) throws IOException{
        int firstPrintableChar = 33;
        int numberOfPintableChar = 94;
        int numberOfCharPerLine = 72;

        int start = firstPrintableChar;

        while(true){
            for(int i = start;i<start+numberOfCharPerLine;i++){
                out.write(((i-firstPrintableChar)% numberOfPintableChar)+firstPrintableChar);
            }
            out.write('\r');
            out.write('\n');
            start = ((start+1)-firstPrintableChar)% numberOfCharPerLine + firstPrintableChar;

        }
    }
}
