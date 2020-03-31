/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWpacker {
	
	public static void main(String[] args) {
		
		//PASS IN A TEXT FILE FOR INPUT
        if (args.length != 1) {
            
            //PRINT ERROR MESSAGE
            System.err.println("Enter valid argument: java LZWpacker <LZWencode output file>");
            return;
        }

        try {

        	//READ AS STREAM OF BYTES FROM FILE
            InputStream file = new FileInputStream(args[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));

            //DECLARE VARIABLES
            int maxPhraseNum = 256;
            int maxBit = 32;
            int maskOutput = 0xff000000;
            int packer = 0;
            int trackerCount = 0;
            int output = 0;
            int bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));
			            
            //READS A LINE
            String line = reader.readLine();

            //WHILE NOT END OF THE FILE
            while (line != null) {
            	
            	//CONVERTS LINE INTO INT
            	int inputNum = Integer.parseInt(line);

            	//Get new bitCount
            	bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

            	//shift phrase number by (maxBit - trackerCount - bitCount) to the left
            	int newPhraseNum = inputNum << (maxBit - trackerCount - bitCount);

            	//add new phrase number to packer
            	packer = packer | newPhraseNum;

            	//
            	trackerCount += bitCount;

            	//mask the packer according to trackerCount and bitCount
            	packer = doMasking((trackerCount + bitCount), packer);
            	maxPhraseNum++;
        
            	//while there's 8 or more bits
            	while (trackerCount > 7) {

            		//shift the packer by 8 to the left and outpit it
            		output = packer & maskOutput;
            		output = output >>> 24;
            		byte outputByte = (byte)output;
            		packer = packer << 8;
            		trackerCount -= 8;

            		System.out.write(outputByte);
            	}

            	//NEXT LINE
                line = reader.readLine();
            }

            if (trackerCount != 0) {
            	
            	//shift the packer by 8 to the left and outpit it
        		output = packer & maskOutput;

        		// System.out.println("byte 1 " + output);
        		output = output >>> 24;
        		byte outputByte = (byte)output;
        		packer = packer << 8;

        		System.out.write(outputByte);
            }

            System.out.flush();
            reader.close();
        }
        catch (Exception ePacker) {

        	//PRINT ERROR
            System.err.println("Error: " + ePacker);
            return;
        }
	}

	static int doMasking(int bitCount, int packer) {

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
    	packer = packer & intMask;

		return packer;
	}
}