/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

class TrieNode 
{ 
    // Alphabet size (# of symbols) 
    //private final int ALPHABET_SIZE = 26;
    private boolean isEndOfWord;

    //Creating private variables
    private int _phraseNum;
    private String _phraseChar;
    private TrieNode[] children = new TrieNode[]; 

    //Constructor
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

    public void setChildren(TrieNode child) {
        children.add(child);
    }
}