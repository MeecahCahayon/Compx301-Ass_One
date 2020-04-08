/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWunpack {
    
    public static void main(String[] args) {

        try {

            //READ AS STREAM OF BYTES FROM FILE
            BufferedInputStream input = new BufferedInputStream(System.in);

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
            int inputByte = input.read();

            //IF NOT THE END OF STREAM
            while (inputByte != -1) {

                inputByte = doMasking(inputByte, 0xFF000000);

                //SHIFT PHRASE TO THE LEFT
                int newByte = inputByte << (MAX_BIT - bitTracker - INPUT_BIT);

                //ADD NEW PHRASE NUMBER TO UNPACKER
                unpacker = unpacker | newByte;

                //TRACK NUMBER OF BITS IN THE UNPACKER
                bitTracker += INPUT_BIT;

                //MASKING
                unpacker = doMasking(unpacker, bitTracker);

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
                inputByte = input.read();
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