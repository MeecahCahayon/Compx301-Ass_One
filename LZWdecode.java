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
            int phraseNum = 257;
            int currIN;
            char mmc = '\0';

            //reads a line
            String line = reader.readLine();
            parentNode = myLibrary.getLibraryRoot();

            //WHILE NOT END OF FILE
            while(line != null) {

                //convert line to int
                int inputNum = Integer.parseInt(line);

                //find phrase number in library
                inputNode = myLibrary.findPhraseNumber(inputNum);

                currIN = inputNode.getInputNum();

                //check if phrasenumber has inputNum
                while (currIN != 0) {

                    //go to that phrase number in library
                    currNode = myLibrary.findPhraseNumber(currIN);

                    mmc = currNode.getMmc();
                    charStack.push(mmc);

                    currIN = currNode.getInputNum();
                }

                //ADD NEW PHRASE TO THE LIBRARY
                myLibrary.addNode(phraseNum);

                //add inputNum to that phraseNumber
                currNode = myLibrary.findPhraseNumber(phraseNum);
                currNode.setInputNum(inputNum);

                if (phraseNum > 257) {
                    
                    if (!charStack.empty()) {
                        
                        parentNode.setMmc(charStack.peek());

                    }
                    else {

                        //get the input number where input number matches phrase number
                        parentNode.setMmc(inputNode.getMmc());
                    }
                }

                //while there's something in the stack
                while(!charStack.empty()) {

                    //pop then print output
                    //System.out.println("Hi");
                    System.out.print(charStack.pop());
                }

                //output inputNode mmc
                System.out.print(inputNode.getMmc());

                //save this phraseNum for putting mmc later
                parentNode = currNode;

                //add one to lib phraseNumber
                phraseNum++;

                //next line
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