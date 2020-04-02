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

            //READ FIRST BYTE
            int inputByte = file.read();

            // System.out.println("orig bitCount " + bitCount);
            // System.out.println("");

            //IF NOT THE END OF STREAM
            while (inputByte != -1) {
                
                //Get new bitCount
                // bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));
                // System.out.println("bitCount" + bitCount);

                //shift phrase number by (MAX_BIT - trackerCount - inputBit(8)) to the left
                int newByte = inputByte << (MAX_BIT - bitTracker - INPPUT_BIT);

                //add new phrase number to packer
                unpacker = unpacker | newByte;

                bitTracker += INPPUT_BIT;

                //mask the packer according to trackerCount and bitCount
                unpacker = doMasking(unpacker, bitTracker);
                // maxPhraseNum++;

                //Get new bitCount
                bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

                // System.out.println("bitCount " + bitCount);
                // System.out.println("");

                /*if (bitTracker >= prevBitCount) {

                    output = doMasking(unpacker, prevBitCount);
                    output = output >>> (MAX_BIT - prevBitCount);

                    unpacker = unpacker << prevBitCount;
                    bitTracker -= prevBitCount;

                    System.out.println(output);
                    System.out.println("");

                    maxPhraseNum++;
                }*/

                if (bitTracker >= bitCount) {

                    output = doMasking(unpacker, bitCount);
                    output = output >>> (MAX_BIT - bitCount);

                    unpacker = unpacker << bitCount;
                    bitTracker -= bitCount;

                    System.out.println(output);
                    // System.out.println("");

                    maxPhraseNum++;
                }

                // System.out.println("after bitCount " + bitCount);
                // System.out.println("");
                // System.out.println("-------");
            
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

    static int doMasking(int unPacker, int bitCount) {
        
        int mask = (int)(Math.pow(2, bitCount) - 1) << (32 - bitCount);
        unPacker &= mask;

        return unPacker;
    }
}