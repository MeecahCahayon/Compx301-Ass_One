import java.util.*;
import java.io.*;

class Library {
	LibNode root;

	public Library() {

		root = new LibNode(1);
		LibNode parent = root;
		LibNode curr = root;

		for(int i = 1; i < 256; i++) {

			curr = new LibNode(i+1);
			parent.setNext(curr);
			parent = curr;
		}
	}

	public void addNode(int phraseNum) {

	}
}