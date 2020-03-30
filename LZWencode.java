/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWencode {

    public static void main(String[] args) {
        
        //PASS IN A TEXT FILE FOR INPUT
        if (args.length != 1) {
            
            //PRINT ERROR MESSAGE
            System.err.println("Enter valid argument: java LZWencode <Input text File>");
            return;
        }

        try {
            
            //READ AS STREAM OF BYTES FROM FILE
            InputStream fis = new FileInputStream(args[0]);

            //DECLARE VARIABLES
            Trie myTrie = new Trie();
            TrieNode parentNode, currNode;
            //NUMBER OF EXPECTED SYMBOLS
            int phraseNum = 256;
            
            //READ FIRST BYTE
            int intInput = fis.read();
            int tempInput = intInput;
            parentNode = myTrie.getTrieRoot();

            //IF NOT THE END OF STREAM
            while (intInput != -1) {

            	//GET NODE WHERE INPUT MATCHES A NODE
                currNode = myTrie.FindChar(myTrie.getTrieRoot(), intInput);

                //CHECK IF CURRENT NODE IS IN TRIE
                while (currNode != null) {

                    parentNode = currNode;

                    //READ NEXT BYTE AND SET NEXT NODE
                    intInput = fis.read();
                    tempInput = intInput;
                    currNode = myTrie.FindChar(currNode, intInput);
                }
                    
                //ADD CHARACTER TO TRIE
                parentNode.setChild(new TrieNode(phraseNum, (char)intInput));
                phraseNum++;
                
                //OUTPUT PHRASE NUMBERS
                System.out.println(parentNode.getPhraseNum());

                intInput = tempInput;

            }
        }
        catch(Exception eEncode) {

            //PRINT ERROR
            System.err.println("Error: " + eEncode);
            return;
        }
    }
}