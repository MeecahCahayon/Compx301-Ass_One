/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class Library {

	//creating private variables
	//temporary public will need to change to private
	public LibNode root;

	//constructor
	public Library() {

		root = new LibNode(1);
		LibNode parent = root;
		LibNode curr = root;

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

		LibNode curr = root;

		//WHILE NOT AT THE END OF LIST
		while(curr.getNext() != null) {
			curr = curr.getNext();
		}

		curr.setNext(new LibNode(phraseNum));
	}
}