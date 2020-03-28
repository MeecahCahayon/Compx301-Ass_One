/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class Library {

	//creating private variables
	private LibNode _root;

	//constructor
	public Library() {

		_root = new LibNode(1);
		LibNode parent = _root;
		LibNode curr = _root;

		for(int phraseNum = 0; phraseNum < 256; phraseNum++) {

			//create phrase number
			curr = new LibNode(phraseNum+1);

			//set character to specific phrasenumber
			char mmc = (char)phraseNum;
			curr.setMmc(mmc);

			//link parent to curr then next
			parent.setNext(curr);
			parent = curr;
		}
	}

	//add node at the end of the library list
	public void addNode(int phraseNum) {

		LibNode curr = _root;

		//WHILE NOT AT THE END OF LIST
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}

		curr.setNext(new LibNode(phraseNum));
	}

	public LibNode findPhraseNumber(int phrasenumber) {

		LibNode curr = _root;

		//find phrase number in library
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