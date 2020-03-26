/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 
 */

import java.util.*;
import java.io.*;

class MLZWencode {

    public static void main(String[] args) {
        
        //if there's 0 || >1 argument
        if (args.length != 1) {
            
            //print error
            System.err.println("Enter valid argument: java LZWencode <Input text File>");
            return;
        }

        try {
            
            //Initialise to read and write bytes from file
            InputStream fis = new FileInputStream(args[0]);
            //OutputStream fos = new FileOutputStream(args[1]);

            //variables
            Trie myTrie = new Trie();
            TrieNode parentNode, currNode;
            int phraseNum = 257;
            
            //read first byte
            int intInput = fis.read();
            int tempInput = intInput;
            parentNode = myTrie.getTrieRoot();

            //if not the end of the stream
            while (intInput != -1) {

                currNode = myTrie.FindChar(myTrie.getTrieRoot(), intInput);

                //Check if its on Trie
                while (currNode != null) {

                    parentNode = currNode;

                    //Testing if output works
                    //System.out.println("Byte " + intInput + " found. Char is " + currNode.getPhraseChar());

                    //next byte and node
                    intInput = fis.read();
                    tempInput = intInput;
                    currNode = myTrie.FindChar(currNode, intInput);
                }
                    
                //add char to trie
                parentNode.setChild(new TrieNode(phraseNum, (char)intInput));
                phraseNum++;
                
                //write on the file second argument
                //fos.writeInt(parentNode.getPhraseNum());
                //Testing if output works
                //System.out.println("Byte " + intInput + " is not found. phraseNum is " + parentNode.getPhraseNum());
                System.out.println(parentNode.getPhraseNum());

                intInput = tempInput;

            }
        }
        catch(Exception eEncode) {

            //print error
            System.err.println("Error: " + eEncode);
            return;
        }
    }
}

/* NOTE */

// 1.) What is the difference between BufferedInputStream to InputStream? Which is better in this program?

/* END NOTE */