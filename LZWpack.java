/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWpack {
	
	public static void main(String[] args) {

        try {

            //DECLARE CONSTANTS
            final int MASK_OUTPUT = 0xff000000;
            final int RIGHT_SHIFT = 24;
            final int BYTE = 8;

            //READ AS STREAM OF BYTES
            InputStreamReader file = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(file);

            //DECLARE VARIABLES
            int maxPhraseNum = 256;
            int maxBit = 32;
            int packer = 0;
            int bitTracker = 0;
            int output = 0;
            int bitCount;
                        
            //READS A LINE
            String line = reader.readLine();

            //IF NOT THE END OF STREAM
            while (line != null) {
                
                //CONVERTS LINE INTO INT
                int inputNum = Integer.parseInt(line);

                //GET NEW BIT COUNT
                bitCount = (int)(Math.ceil(Math.log(maxPhraseNum) / Math.log(2)));

                //SHIFT PHRASE NUMBER TO THE LEFT
                int newPhraseNum = inputNum << (maxBit - bitTracker - bitCount);
                
                //ADD NEW PHRASE NUMBER TO PACKER
                packer = packer | newPhraseNum;

                //TRACK HOW MANY BITS THERE ARE IN THE PACKER
                bitTracker += bitCount;

                //MASKING
                packer = doMasking(packer, bitTracker);
                maxPhraseNum++;

                //OUTPUT FOR EVERY BYTE
                while (bitTracker > 7) {

                    //MASKING
                    output = packer & MASK_OUTPUT;
                    
                    //SHIFT TO THE RIGHT FOR OUTPUT
                    output = output >>> RIGHT_SHIFT;
                    byte outputByte = (byte)output;

                    //SHIFT PACKER TO CLEAR SPACE
                    packer = packer << BYTE;
                    bitTracker -= BYTE;

                    //OUTPUT
                    System.out.write(outputByte);
                }

                //READ NEXT LINE
                line = reader.readLine();
            }

            //IF THERE'S STILL BITS IN THE PACKER
            while (bitTracker >= 0) {
                
                //MASKING
                output = packer & MASK_OUTPUT;
                output = output >>> RIGHT_SHIFT;
                byte outputByte = (byte)output;

                //SHIFT PACKER TO THE LEFT BY 8 AND OUTPUT IT
                packer = packer << BYTE;
                bitTracker -= BYTE;

                //OUTPUT
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

    static int doMasking(int packer, int bitCount) {

        int mask = (int)(Math.pow(2, bitCount) - 1) << (32 - bitCount);
        packer &= mask;

        return packer;
    }
}