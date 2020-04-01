/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWunpack {
	
	public static void main(String[] args) {
		
		//PASS IN A TEXT FILE FOR INPUT
        if (args.length != 1) {
            
            //PRINT ERROR MESSAGE
            System.err.println("Enter valid argument: java LZWunpack <LZWunpack output file>");
            return;
        }

        try {
            //VARIABLES 
            int maxPhraseNum = 256;
            int bitTracker;
            int output;
            int unpacker;
            int bitCount;

        	//READ AS STREAM OF BYTES FROM FILE
            InputStream file = new FileInputStream(args[0]);
            //READ BYTE
            int inputByte = file.read();
            bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

            

        }

        catch (Exception eUnpacker) 
        {
        	//PRINT ERROR
            System.err.println("Error: " + eUnpacker);
            return;
        }
	}

	static int doMasking(int bitCount, int unpacker) 
    {
		String strMask = "0";
		int intMask;
		int count = 0;

		for (int i = 0; i < bitCount; i++ ) {
			
			strMask += "1";
			count++;
		}
	
		while (count < 31) {
			
			strMask += "0";
			count++;
		}

    	intMask = Integer.parseInt(strMask,2);
    	intMask = intMask << 1;
    	packer = unpacker & intMask;

		return unpacker;
	}
}