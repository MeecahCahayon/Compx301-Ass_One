/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

public class LZWencode {

    public static void main(String[] args) {
        
        //if there's 0 || >1 argument
        if (args.length != 2) {
            
            //print error
            System.err.println("Enter valid argument: java LZWencode <textcode> <textcode>");
            return;
        }

        try {
            
            //Initialise to read and write bytes from file
            InputStream fis = new FileInputStream(args[0]);
            OutputStream fos = new FileOutputStream(args[1]);

            //read first byte
            int intInput = fis.read();

            //Creating a Trie
            Trie trie = new Trie();

            //testing if children works
            for (int rootPhraseNum = 0; rootPhraseNum < trie._root.children.size() ; rootPhraseNum++ ) {
            
                System.out.println("Child " + trie._root.children.get(rootPhraseNum).getPhraseNum());
            }

            //if not the end of the stream
            while (intInput != -1) {

                //Check if its on Trie

                //write on the file second argument
                //Testing if output works
                System.out.println("First output is :" + intInput);
                fos.write(intInput);

                //next byte
                intInput = fis.read();
            }

            fos.flush();
            fos.close();

            //LZWencode e = new LZWencode();
            //e.encode(input);

        }
        catch(Exception eEncode) {

            //print error
            System.err.println("Error: " + eEncode);
            return;
        }
    }

    /* NOTE */

    // 1.) What is the difference between BufferedInputStream to InputStream? Which is better in this program?

    /* END NOTE */

    /**** WE MIGHT NEED TO MOVE THIS TO MAIN ***/

    /*//VARIABLES: TRIE, LIST OF INTEGERS
    //private Trie lzwTrie;
    private Trie dictionary;
    private Trie key;
    private int count;
    private ArrayList<Integer> output;


    public LZWencode() {
        //lzwTrie = new Trie();
        dictionary = new Trie();
        key = new Trie();
        
        output = new ArrayList<Integer>();
    }

    public ArrayList<Integer> encode(String input) {

        //GET UNIQUE CHARACTERS FROM INPUT
        String unique_char = uniqueChar(input);
        count = 0;
        
        //INSERT INTO TRIE EACH CHARACTERS 
        //INSERT A NUMBER TO THE LIST FOR EACH INSERT
        for(char c: unique_char.toCharArray()) {
            //lzwTrie.insert("" + c);
            dictionary.insert(c + Integer.toString(count));
            output.add(output.size() + 1);
        }

        String wc = "";
        String w = "";

        //CHECK INPUT IF CURRENT CHARACTER IS IN TRIE
        for(char c: input.toCharArray()) {
            wc = w+c;

            //CHECK IF FIRST CHARACTER IS IN TRIE
            if(key.search(wc)) {
                w = wc;
            }
            else {
                //ADD TO TRIE
                count++;
                dictionary.insert(c + Integer.toString(count));
                
                //output.add(output.size()+1);
            }
        }

        return output;
    }
*/

/**** I DONT THINK WE NEED THIS ANYMORE WILL EXPLAIN WHEN WE VID CHAT ***/


/*    //GET ALL POSSIBLE SYMBOLS FROM INPUT
    public String uniqueChar(String input) {
    	String unique = "";

        //GO THROUGH INPUT STRING AND CHECK IF CHARACTERS REPEAT
    	for(int i=0; i<input.length(); i++) {
    		int count = 1;

    		for(int j=i+1; j<input.length();j++) {
                //IF THERE'S DUPLICATE
    			if(input.charAt(i) == input.charAt(j)) {
    				count++;
    			}
    		}
            //IF THE COUNT DIDN'T INCREMENT
            //CHAR HAS NOT YET BEEN ENCOUNTERED
            //THEREFORE OUTPUT
    		if(count == 1) {
    			unique += input.charAt(i);
    		}
    	}
    	return unique;
    }
*/


}