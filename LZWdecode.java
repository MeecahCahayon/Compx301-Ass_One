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
            InputStream file = new FileInputStream(args[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));

            //DECLARE VARIABLES
            Library myLibrary = new Library();
            LibNode parentNode, currNode, inputNode;
            Stack<Character> charStack = new Stack<Character>();
            int phraseNum = 256;
            int currIN;
            char mmc = '\0';

            //READS LINE
            String line = reader.readLine();
            parentNode = myLibrary.getLibraryRoot();

            //WHILE NOT END OF FILE
            while(line != null) {

                //CONVERT LINE TO INT
                int inputNum = Integer.parseInt(line);

                //FIND PHRASE NUMBER IN THE LIBRARY
                inputNode = myLibrary.findPhraseNumber(inputNum);

                currIN = inputNode.getInputNum();

                //IF PHRASE NUMBER HAS INPUTNUM
                while (currIN != 0) {

                    //GO TO THAT PHRASE NUMBER IN LIBRARY
                    currNode = myLibrary.findPhraseNumber(currIN);

                    //GET MISMATCH CHAR AND PUSH TO STACK
                    mmc = currNode.getMmc();
                    charStack.push(mmc);

                    currIN = currNode.getInputNum();
                }

                //ADD NEW PHRASE TO THE LIBRARY
                myLibrary.addNode(phraseNum);

                //ADD INPUTNUM TO THAT PHRASE NUMBER
                currNode = myLibrary.findPhraseNumber(phraseNum);
                currNode.setInputNum(inputNum);

                //FOR EVERY PHRASE NUMBER BIGGER THAN PHRASE NUMBER + 1 SET MISMATCH CHAR
                if (phraseNum > 256) {
                    
                    //IF MISMATCH CHAR IS EMPTY
                    if (!charStack.empty()) {
                        
                        //SET TOP OF THE STACK CHAR
                        parentNode.setMmc(charStack.peek());

                    }
                    else {

                        //SET SAME MISMATCH CHAR AS ITS INPUTNUM
                        parentNode.setMmc(inputNode.getMmc());
                    }
                }

                //WHILE THERE IS SOMETHING IN THE STACK
                while(!charStack.empty()) {

                    //POP THE PRINT OUTPUT
                    System.out.print(charStack.pop());
                }

                //THEN OUTPUT THE INPUT NODE'S MISMATCH CHAR LAST
                System.out.print(inputNode.getMmc());

                //SAVE PHRASENUM FOR PUTTING MISMATCH CHAR LATER
                parentNode = currNode;
                phraseNum++;

                //NEXT LINE
                line = reader.readLine();
            }
        }
        catch (Exception eDecode) {

            //PRINT ERROR
            System.err.println("Error: " + eDecode);
            return;
        }
    }
}