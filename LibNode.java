import java.util.*;
import java.io.*;

class LibNode {
	//DECLARE VARIABLES
	private int _phraseNum;
	private int _inputNum = 0;
	private char _mmc;
	private LibNode _next;

	//CONSTRUCTOR
	public LibNode(int phraseNum) {
		_phraseNum = phraseNum;
	}

	//GETTERS AND SETTERS
	public int getPhraseNum() {
		return _phraseNum;
	}

	public int getInputNum() {
		return _inputNum;
	}

	public void setInputNum(int inputNum) {
		_inputNum = inputNum;
	}

	public char getMmc() {
		return _mmc;
	}

	public void setMmc(char mmc) {
		_mmc = mmc;
	}

	public LibNode getNext() {
		return _next;
	}

	public void setNext(LibNode next) {
		_next = next;
	}
}