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

            //READ AS STREAM OF BYTES FROM FILE
            InputStream file = new FileInputStream(args[0]);

            //DECLARE CONSTANTS
            final int MAX_BIT = 32;
            final int INPUT_BIT = 8;

            //DECLARE VARIABLES 
            int maxPhraseNum = 256;
            int bitTracker = 0;
            int unpacker = 0;
            int output = 0;
            int bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

            //READ FIRST BYTE
            int inputByte = file.read();

            //IF NOT THE END OF STREAM
            while (inputByte != -1) {

                //SHIFT PHRASE TO THE LEFT
                int newByte = inputByte << (MAX_BIT - bitTracker - INPUT_BIT);

                //ADD NEW PHRASE NUMBER TO UNPACKER
                unpacker = unpacker | newByte;

                //TRACK NUMBER OF BITS IN THE UNPACKER
                bitTracker += INPUT_BIT;

                //MASKING
                unpacker = doMasking(unpacker, bitTracker);
                // maxPhraseNum++;

                //GET NEW BIT COUNT
                bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

                if (bitTracker >= bitCount) {

                    //MASKING
                    output = doMasking(unpacker, bitCount);
                    
                    //SHIFT TO THE RIGHT FOR OUTPUT
                    output = output >>> (MAX_BIT - bitCount);

                    //SHIFT UNPACKER TO CLEAR SPACE
                    unpacker = unpacker << bitCount;
                    bitTracker -= bitCount;

                    //OUTPUT
                    System.out.println(output);

                    maxPhraseNum++;
                }

                //READ NEXT BYTE
                inputByte = file.read();
            }
        }

        catch (Exception eUnpacker) {

            //PRINT ERROR
            System.err.println("Error: " + eUnpacker);
            return;
        }
    }

    static int doMasking(int unPacker, int bitCount) {
        
        int mask = (int)(Math.pow(2, bitCount) - 1) << (32 - bitCount);
        unPacker &= mask;

        return unPacker;
    }
}