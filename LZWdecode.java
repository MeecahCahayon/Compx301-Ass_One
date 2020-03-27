/* Name: Meecah Cahayon + Eunice Llobet
 * Student ID: 1259825 + 1330233
 */

import java.util.*;
import java.io.*;

class LZWdecode {

    public static void main(String[] args) {
    	//PASS IN A TEXT FILE FOR INPUT
        if (args.length != 1) {
            
            //PRINT ERROR MESSAGE
            System.err.println("Enter valid argument: java LZWdecode <Input text File>");
            return;
        }

        try {
            
            //READ AS STREAM OF BYTES FROM FILE
            InputStream fis = new FileInputStream(args[0]);

           	//DECLARE VARIABLES
           	
            
            }
        }
        catch(Exception eEncode) {

            //PRINT ERROR
            System.err.println("Error: " + eEncode);
            return;
        }
    }
 }