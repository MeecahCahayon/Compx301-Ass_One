/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWencode {

    public static void main(String[] args) {

        try {
            
            //READ AS STREAM OF BYTES FROM FILE
            BufferedInputStream input = new BufferedInputStream(System.in);

            //DECLARE VARIABLES
            Trie myTrie = new Trie();
            TrieNode parentNode, currNode;
            //NUMBER OF EXPECTED SYMBOLS
            int phraseNum = 256;
            
            //READ FIRST BYTE
            int intInput = input.read();
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
                    intInput = input.read();
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