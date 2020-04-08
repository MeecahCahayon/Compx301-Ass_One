/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class Library {

	//DECLARE VARIABLES
	private LibNode _root;

	//CONSTRUCTOR
	public Library() {

		//CREATE THE ROOT
		_root = new LibNode(-1);
		LibNode parent = _root;
		LibNode curr = _root;

		//CREATING ALL POSSIBLE CHARACTERS (ASCII)
		for(int phraseNum = 0; phraseNum < 256; phraseNum++) {

			//CREATE A PHRASENUMBER
			curr = new LibNode(phraseNum);

			//SET ITS CHAR
			char mmc = (char)phraseNum;
			curr.setMmc(mmc);

			//SET NEXT NODE
			parent.setNext(curr);
			parent = curr;
		}
	}

	//ADD NODE AT THE END OF THE LIBRARY LIST
	public void addNode(int phraseNum) {

		LibNode curr = _root;

		//WHILE NOT AT THE END OF LIST
		while(curr.getNext() != null) {

			curr = curr.getNext();
		}

		curr.setNext(new LibNode(phraseNum));
	}

	//FIND PHRASE NUMBER IN LIBRARY
	public LibNode findPhraseNumber(int phrasenumber) {

		LibNode curr = _root;

		//IF NOT SAME PHRASE NUMBER
    	while(phrasenumber != curr.getPhraseNum()) {

    		//go next
    		curr = curr.getNext();
    	}

    	return curr;
	}

	public LibNode getLibraryRoot() {
		
		return _root;
	}
}