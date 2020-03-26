/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class Trie {

    //creating private variables
    //temporary public (for testing the output)
    public TrieNode _root;

    //Constructor
    public Trie() {

        _root = new TrieNode();

        //CREATE EXPECTED SYMBOLS FOR TRIE
        for (int rootPhraseNum = 0; rootPhraseNum < 256 ; rootPhraseNum++ ) {
            
            //CHANGE INT INTO ASCII CHARACTER THEN ADD CHILDREN
            char rootPhraseChar = (char)rootPhraseNum;
            _root.setChild(new TrieNode(rootPhraseNum + 1, rootPhraseChar));
        }
    }

    //Method to find char in trie
    public TrieNode FindChar(TrieNode node, int intInput) {

        TrieNode curr = node;

        for (int i = 0; i < curr.getChildren().size(); i++ ) {
            
            if (curr.getChildren().get(i).getPhraseChar() == intInput) {
                return curr.getChildren().get(i);
            }
        }

        //if not found
        return null;
    }

    public TrieNode getTrieRoot() {
        return _root;
    }
}