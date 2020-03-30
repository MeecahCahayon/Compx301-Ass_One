/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class Trie {

    //DECLARE VARIABLES
    private TrieNode _root;

    //CONSTRUCTOR
    public Trie() {

        _root = new TrieNode();

        //CREATE EXPECTED SYMBOLS FOR TRIE
        for (int rootPhraseNum = 0; rootPhraseNum < 256 ; rootPhraseNum++ ) {
            
            //CHANGE INT INTO ASCII CHARACTER THEN ADD CHILDREN
            char rootPhraseChar = (char)rootPhraseNum;
            _root.setChild(new TrieNode(rootPhraseNum, rootPhraseChar));
        }
    }

    //FIND CHAR IN TRIE AND RETURN THE NODE IF FOUND
    //IF NOT FOUND, RETURN NULL
    public TrieNode FindChar(TrieNode node, int intInput) {

        TrieNode curr = node;

        for (int i = 0; i < curr.getChildren().size(); i++ ) {
            
            if (curr.getChildren().get(i).getPhraseChar() == intInput) {
                return curr.getChildren().get(i);
            }
        }
        return null;
    }

    public TrieNode getTrieRoot() {
        return _root;
    }
}