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
            System.err.println("Enter valid argument: java LZWunpack <LZWpacker output file>");
            return;
        }

        try {

            //READ AS STREAM OF BYTES FROM FILE
            InputStream file = new FileInputStream(args[0]);

            //declaring final variables
            final int MAX_BIT = 32;
            final int INPPUT_BIT = 8;

            //DECLARE VARIABLES 
            int maxPhraseNum = 256;
            int bitTracker = 0;
            int unpacker = 0;
            int output = 0;
            int bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));
            int prevBitCount = bitCount;

            //READ FIRST BYTE
            int inputByte = file.read();

            //IF NOT THE END OF STREAM
            while (inputByte != -1) {
                
                //Get new bitCount
                bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

                //shift phrase number by (MAX_BIT - trackerCount - inputBit(8)) to the left
                int newByte = inputByte << (MAX_BIT - bitTracker - INPPUT_BIT);

                // System.out.println("maxBit: " + MAX_BIT);
                // System.out.println("bitTracker: " + bitTracker);
                // System.out.println("bitCount: " + bitCount);

                //add new phrase number to packer
                unpacker = unpacker | newByte;

                bitTracker += INPPUT_BIT;
                // System.out.println("newByte: " + newByte);
                // System.out.println("unpacker: " + unpacker);
                // System.out.println("new bitTracker: " + bitTracker);

                //mask the packer according to trackerCount and bitCount
                unpacker = doMasking(bitTracker, unpacker);
                maxPhraseNum++;

                if (bitTracker >= prevBitCount) {
                    
                    // System.out.println("YES");
                    output = doMasking(prevBitCount, unpacker);
                    // System.out.println("output w/o shift: " + output);
                    output = output >>> (MAX_BIT - prevBitCount);

                    unpacker = unpacker << prevBitCount;
                    bitTracker -= prevBitCount;

                    // System.out.println("inputByte: " + inputByte);
                    // System.out.println("OUTPUT: " + output);
                    // System.out.println("new bitTracker: " + bitTracker);
                    // System.out.println("");

                    System.out.println(output);
                }
                else {

                    // System.out.println("NO");
                    // System.out.println("");
                }
                

                inputByte = file.read();
            }

            while (bitTracker >= 0) {
                
                //Get new bitCount
                bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

                // System.out.println("LAST");
                output = doMasking(bitCount, unpacker);
                // System.out.println("output w/o shift: " + output);
                output = output >>> (MAX_BIT - bitCount);

                unpacker = unpacker << bitCount;
                bitTracker -= bitCount;

                // System.out.println("inputByte: " + inputByte);
                // System.out.println("OUTPUT: " + output);
                // System.out.println("new bitTracker: " + bitTracker);
                // System.out.println("");

                System.out.println(output);
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
        String strMask = "";
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