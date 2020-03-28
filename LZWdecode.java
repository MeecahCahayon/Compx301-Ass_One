/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWdecode {

    public static void main(String[] args) {
        
        //PASS IN A TEXT FILE FOR INPUT
        if (args.length != 1) {
            
            //PRINT ERROR MESSAGE
            System.err.println("Enter valid argument: java LZWdecode <LZWencode output file>");
            return;
        }

        try {

            //READ AS STREAM OF BYTES FROM FILE
            InputStream fis = new FileInputStream(args[0]);

            //READ FIRST BYTE
            int intEncoderOutput = fis.read();

            //DECLARE VARIABLES
            Library myLibrary = new Library();
            int phraseNum = 257;




            LibNode head = myLibrary.root;

            //test if library has 256 items and its char
            while (head.getNext() != null) {

                System.out.println("Phrase Number: " + head.getPhraseNum() + ". Char " + head.getMmc());
                head = head.getNext();
            }
            //output last node of the list
            if (head.getNext() == null) {
                
                System.out.println("Phrase Number: " + head.getPhraseNum() + ". Char " + head.getMmc());
            }





            //IF NOT THE END OF STREAM
            while (intEncoderOutput != -1) {
                
                System.out.println((char)intEncoderOutput);
                intEncoderOutput = fis.read();
            }





            //testing addNode
            myLibrary.addNode(phraseNum);
            phraseNum++;

            head = myLibrary.root;

            //test if library has 256 items and its char
            while (head.getNext() != null) {

                System.out.println("Phrase Number: " + head.getPhraseNum() + ". Char " + head.getMmc());
                head = head.getNext();
            }
            //test if the new added lib node is added
            if (head.getNext() == null) {
                
                System.out.println("Phrase Number: " + head.getPhraseNum() + ".");
            }

        }
        catch (Exception eDecode) {

            //PRINT ERROR
            System.err.println("Error: " + eDecode);
            return;
        }
    }
}