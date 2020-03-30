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
            System.err.println("Enter valid argument: java LZWdecode <LZWencode output file>");
            return;
        }

        try {

        	//READ AS STREAM OF BYTES FROM FILE
            InputStream file = new FileInputStream(args[0]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(file));

            //DECLARE VARIABLES
            int maxPhraseNum = 256;
            int maxBit = 32;
            int bitCount = (int)(Math.log(maxPhraseNum) / Math.log(2));
            String strMask;
            int intMask;
            int prevBitCount;

            //READS A LINE
            String line = reader.readLine();
            if (line != null) {

            	//CONVERTS LINE INTO INT
                int inputNum = Integer.parseInt(line);

                //shit phrase number by (maxBit-bitCount) to the left
            	int packer = inputNum << (maxBit-bitCount);
            	prevBitCount = bitCount;

            	//mask the packer according to bitCount
            	strMask = getMask(bitCount);
            	intMask = Integer.parseInt(strMask,2);
            	intMask = intMask << 1;
            	packer = packer & intMask;

            	System.out.println("String Mask: " + strMask);
            	System.out.println("Int Mask: " + intMask);
            	maxPhraseNum++;
            }

            //WHILE NOT END OF THE FILE
            while (line != null) {
            	
            	//CONVERTS LINE INTO INT
            	int inputNum = Integer.parseInt(line);

            	//testing
            	System.out.println(inputNum);

            	//NEXT LINE
                line = reader.readLine();
            }

        }
        catch (Exception ePacker) {

        	//PRINT ERROR
            System.err.println("Error: " + ePacker);
            return;
        }
	}

	static String getMask(int bitCount) {

		String mask = "";
		int count = 0;

		for (int i = 0; i < bitCount ; i++ ) {
			
			mask += "1";
			count++;
		}
	
		while (count < 31) {
			
			mask += "0";
			count++;
		}

		return mask;
	}
}