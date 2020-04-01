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
            int bitTracker = 8;
            //KEEPS TRACK OF HOW MANY BITS A PHRASE NUMBER NEEDs
            int bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));
            int prevBitCount = bitCount;

            int output;
            int unpacker;
            
        	//READ AS STREAM OF BYTES FROM FILE
            InputStream file = new FileInputStream(args[0]);
            //READ BYTE
            int inputByte = file.read();
            
            while(inputByte != -1) 
            {
                //BRING INPUT TO THE FRONT OF THE 32 BITS
                unpacker = inputByte << 24;
                
                //TRACK AMOUNT OF BITS IN
                bitTracker += 8;

                //MASKING
                unpacker = doMasking(bitCount, unpacker);

                //IF THE BIT TRACKER IS GREATER THAN OR EQUALS TO BITCOUNT THEN OUTPUT
                if(bitTracker >= prevBitCount) 
                {
                    //do masking (masking depends on how many prevBitcount)
                    output = doMasking(prevBitCount, unpacker);

                    //SHIFT TO THE RIGHT BY 32 - PREVBITCOUNT
                    output = output >>> (32 - prevBitCount);
                    //OUTPUT THE OUTPUT       
                    System.out.println(output);

                    unpacker <<= prevBitCount;
                    bitTracker -= prevBitCount; //THIS IS RIGHT
                }
                prevBitCount = bitCount;
                maxPhraseNum++;

                //READ NEXT BYTE
                inputByte = file.read();
            }

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
    	unpacker = unpacker & intMask;

		return unpacker;
	}
}