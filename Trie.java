/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

// Java implementation of search and insert operations 
// on Trie 
public class Trie {

    //creating private variables
    //temporary public (for testing the output)
    public TrieNode _root;

    //Constructor
    public Trie() {

        _root = new TrieNode();

        for (int rootPhraseNum = 1; rootPhraseNum < 257 ; rootPhraseNum++ ) {
            
            _root.setChild(new TrieNode(rootPhraseNum));
        }
    }

    /**** WE MIGHT NEED TO FIX SOME OF THE CODE BECAUSE OF THE CHANGE TO ARRAYLIST ***/
/*
    // If not present, inserts key into trie 
    // If the key is prefix of trie node,  
    // just marks leaf node 
    public void insert(String key) 
    { 
        TrieNode node = root; 
        int index = 0;
        
        //GO THROUGH STRING KEY
        for (int i=0; i<key.length(); i++) 
        { 
            //GET INDEX OF CHARACTER IN ASCII
            index = key.charAt(i) - 'a'; 

            //CHECK IF TRIE ALREADY HAS CHARACTER
            if (node.children[index] == null) {
                //MAKE NEW CHARACTER A NODE
                node.children[index] = new TrieNode();
                
            }
            //CHECK DOWN THE TRIE TO GET CHILDREN NODE
            node = node.children[index]; 
        }
        //END OF TRIE 
        node.isEndOfWord = true; 
    } 
       
    // Returns true if key presents in trie, else false 
    public boolean search(String key) 
    { 
        TrieNode node = root;
        int index; 
        
        for (int i=0; i<key.length(); i++) 
        { 
            //GET THE POSITION OF THE LETTER IN THE TRIE
            index = key.charAt(i) - 'a'; 
       
            //IF KEY IS NOT IN A NODE
            if (node.children[index] == null) 
            {
                return false;
            }
            //CHECK REST OF THE CHILDREN NODE
            node = node.children[index]; 
        } 
       
        return (node != null && node.isEndOfWord); 
    }
*/
}