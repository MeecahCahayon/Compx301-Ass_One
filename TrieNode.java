/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

class TrieNode 
{ 
    // Alphabet size (# of symbols) 
    private final int ALPHABET_SIZE = 26;
    public TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
    public boolean isEndOfWord;


    //Creating private variables
    private int _phraseNum;
    private String _phraseChar;
    
    public TrieNode() { 
        isEndOfWord = false; 
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null; 
        }
    }

    //Constructor
    public TrieNode(int phraseNum, String phraseChar) {
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
}