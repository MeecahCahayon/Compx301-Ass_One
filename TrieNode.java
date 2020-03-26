/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class TrieNode {

    //Creating private variables
    private boolean isEndOfWord;
    private int _phraseNum;
    private char _phraseChar;
    private ArrayList<TrieNode> children = new ArrayList<TrieNode>(); 

    //Constructors
    public TrieNode() {
        isEndOfWord = false;
    }

    public TrieNode(int phraseNum, char phraseChar) {
        isEndOfWord = false;
        _phraseNum = phraseNum;
        _phraseChar = phraseChar;
    }

    /*Getters and Setters*/

    public char getPhraseChar() {
        return _phraseChar;
    }

    public int getPhraseNum() {
        return _phraseNum;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public ArrayList<TrieNode> getChildren() {
        return children;
    }

    public void setChild(TrieNode child) {
        children.add(child);
    }
}