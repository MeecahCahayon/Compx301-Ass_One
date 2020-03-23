import java.util.*;
import java.io.*;

public class LZWencode {

    public static void main(String[] args) {
        
        //if there's 0 || >1 argument
        if (args.length != 1) {
            
            //print error
            System.err.println("Enter valid argument: java LZWencode <textcode>");
            return;
        }

        try {
            String filename = args[0];
            //READ BYTES FROM FILE
            InputStream fis = new FileInputStream(filename);
            //DECODE BYTES INTO CHARACTERS
            InputStreamReader isr = new InputStreamReader(fis);
            //READ TEST FROM DECODED CHARACTER STREAM
            BufferedReader br = new BufferedReader(isr); 

            //FOR EVERY LINE, DO SOMETHING
            String line = "";
            while((line = br.readLine()) != null) {
                //System.out.println(line);     //TEST IF SYSTEM WILL OUTPUT LINE FROM TEXT

            }

            LZWencode e = new LZWencode();
            //e.encode(input);

        }
        catch(Exception eEncode) {

            //print error
            System.err.println("Error: " + eEncode);
            return;
        }
    }

    //VARIABLES: TRIE, LIST OF INTEGERS
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

    //GET ALL POSSIBLE SYMBOLS FROM INPUT
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


}