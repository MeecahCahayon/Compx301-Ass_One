/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class TrieNode 
{ 
    //Creating private variables
    private boolean isEndOfWord;
    private int _phraseNum;
    private String _phraseChar;
    //temporary public (for testing the output)
    public ArrayList<TrieNode> children = new ArrayList<TrieNode>();

    //Constructors
    public TrieNode() {
        isEndOfWord = false;
    }

    public TrieNode(int phraseNum) {
        isEndOfWord = false;
        _phraseNum = phraseNum;
    }

    public TrieNode(int phraseNum, String phraseChar) {
        isEndOfWord = false;
        _phraseNum = phraseNum;
        _phraseChar = phraseChar;
    }

    /*Getters and Setters*/

    public String getPhraseChar() {
        return _phraseChar;
    }

    public int getPhraseNum() {
        return _phraseNum;
    }

    public void setChild(TrieNode child) {
        children.add(child);
    }
}