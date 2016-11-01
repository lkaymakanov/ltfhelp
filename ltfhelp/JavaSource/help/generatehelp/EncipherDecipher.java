package help.generatehelp;


// Java core package
import java.io.*;
import java.util.*;
import java.util.List;
import java.security.*;
import java.security.spec.*;

// third-party packages
import com.sun.crypto.provider.SunJCE;



// Java extension package
import javax.crypto.*;
import javax.crypto.spec.*;

public class EncipherDecipher  {

   // salt for password-based encryption-decryption algorithm
   private static final byte[] salt = {
      ( byte )0xf5, ( byte )0x33, ( byte )0x01, ( byte )0x2a,
      ( byte )0xb2, ( byte )0xcc, ( byte )0xe4, ( byte )0x7f
   };
    
   // iteration count
   private int iterationCount = 100;
   private String password;

    
   // frame constructor
   public EncipherDecipher(String password) {
      // set security provider
      Security.addProvider(new SunJCE() );
     this.password = password;

      
   } // end constructor
   
   // obtain contents from editor pane and encrypt
   public byte[] encrypt(byte [] bytes) 
   {
      // create secret key and get cipher instance
      Cipher cipher = null;
      try {
          
         // create password based encryption key object
         PBEKeySpec keySpec = 
            new PBEKeySpec( password.toCharArray() );
                  
         // obtain instance for secret key factory
         SecretKeyFactory keyFactory = 
            SecretKeyFactory.getInstance( "PBEWithMD5AndDES" );
         
         // generate secret key for encryption
         SecretKey secretKey = keyFactory.generateSecret( keySpec );

         // specifies parameters used with password based encryption
         PBEParameterSpec parameterSpec = 
            new PBEParameterSpec( salt, iterationCount );
         
         // obtain cipher instance reference
         cipher = Cipher.getInstance( "PBEWithMD5AndDES" );
   
         // initialize cipher in encrypt mode
         cipher.init( Cipher.ENCRYPT_MODE, secretKey, 
            parameterSpec );
      } 
      
      // handle NoSuchAlgorithmException 
      catch ( NoSuchAlgorithmException exception ) {
         exception.printStackTrace();
         System.exit( 1 );
      }
      
      // handle InvalidKeySpecException 
      catch ( InvalidKeySpecException exception ) {
         exception.printStackTrace();
         System.exit( 1 );
      }
      
      // handle InvalidKeyException 
      catch ( InvalidKeyException exception ) {
         exception.printStackTrace();
         System.exit( 1 );
      }
      
      // handle NoSuchPaddingException 
      catch ( NoSuchPaddingException exception ) {
         exception.printStackTrace();
         System.exit( 1 );          
      }
      
      // handle InvalidAlgorithmParameterException 
      catch ( InvalidAlgorithmParameterException exception ) {
         exception.printStackTrace();
         System.exit( 1 );          
      }
     
      // create array of bytes
      byte[] outputArray = bytes;

      
      // create FileOutputStream
      ByteArrayOutputStream  byteOutputStream = new ByteArrayOutputStream();
      
      // create CipherOutputStream
      CipherOutputStream out = new CipherOutputStream( byteOutputStream, cipher );
      
      // write contents to ByteArrayOutputStream and close
      try {
         out.write( outputArray );
         out.flush();
         out.close();
      } 
      // handle IOException 
      catch ( IOException exception ) {
         exception.printStackTrace();
      }
      
      return byteOutputStream.toByteArray();
     
   }

   // obtain contents from file and decrypt
   public byte [] decrypt(byte [] bytes) 
   {

      // used to rebuild byte list
     // Vector fileBytes = new Vector();
          
      // obtain user input
      //String password = passwordTextField.getText();
      //String fileName = fileNameTextField.getText();

      // create secret key
      Cipher cipher = null;
      
      try {
         // create password based encryption key object
         PBEKeySpec keySpec = 
            new PBEKeySpec( password.toCharArray() );
                  
         // obtain instance for secret key factory
         SecretKeyFactory keyFactory = 
            SecretKeyFactory.getInstance( "PBEWithMD5AndDES" );
         
         // generate secret key for encryption
         SecretKey secretKey = keyFactory.generateSecret( keySpec );

         // specifies parameters used with password based encryption
         PBEParameterSpec parameterSpec = 
            new PBEParameterSpec( salt, iterationCount );         
         
         // obtain cipher instance reference.
         cipher = Cipher.getInstance( "PBEWithMD5AndDES" );
   
         // initialize cipher in decrypt mode
         cipher.init( Cipher.DECRYPT_MODE, secretKey, 
            parameterSpec );
      }
      
      // handle NoSuchAlgorithmException 
      catch ( NoSuchAlgorithmException exception ) {
         exception.printStackTrace();
         System.exit( 1 );
      }
      
      // handle InvalidKeySpecException 
      catch ( InvalidKeySpecException exception ) {
         exception.printStackTrace();
         System.exit( 1 );
      }
      
      // handle InvalidKeyException 
      catch ( InvalidKeyException exception ) {
         exception.printStackTrace();
         System.exit( 1 );
      }

      // handle NoSuchPaddingException 
      catch ( NoSuchPaddingException exception ) {
         exception.printStackTrace();
         System.exit( 1 );          
      }
      
      // handle InvalidAlgorithmParameterException 
      catch ( InvalidAlgorithmParameterException exception ) {
         exception.printStackTrace();
         System.exit( 1 );          
      }
      
      ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
      List<Byte> encrBytes = new ArrayList<Byte>();   
      // read and decrypt contents from byteInputStream
      try {
         
         CipherInputStream in = 
            new CipherInputStream( byteInputStream, cipher );
         
         // read bytes from stream.
         byte contents = ( byte ) in.read();
         
         while ( contents != -1 ) {   
        	 encrBytes.add( new Byte( contents ) );
            contents = ( byte ) in.read();
         }           
         in.close();
      
      } 
      
      // handle IOException
      catch ( IOException exception ) {
         exception.printStackTrace();
         System.exit( 1 );
      }
      
      // create byte array from contents in Vector fileBytes
      byte[] decryptedText = new byte[ encrBytes.size() ];
      for ( int i = 0; i < encrBytes.size(); i++ ) {
         decryptedText[i] = 
            ( ( Byte )encrBytes.get( i ) ).byteValue();
      }
                
     return decryptedText;
   }
   
}

/***************************************************************
 * (C) Copyright 2002 by Deitel & Associates, Inc. and         *
 * Prentice Hall. All Rights Reserved.                         *
 *                                                             *
 * DISCLAIMER: The authors and publisher of this book have     *
 * used their best efforts in preparing the book. These        *
 * efforts include the development, research, and testing of   *
 * the theories and programs to determine their effectiveness. *
 * The authors and publisher make no warranty of any kind,     *
 * expressed or implied, with regard to these programs or to   *
 * the documentation contained in these books. The authors     *
 * and publisher shall not be liable in any event for          *
 * incidental or consequential damages in connection with, or  *
 * arising out of, the furnishing, performance, or use of      *
 * these programs.                                             *
 ***************************************************************/
