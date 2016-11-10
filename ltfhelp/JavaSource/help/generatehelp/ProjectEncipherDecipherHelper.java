package help.generatehelp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

public class ProjectEncipherDecipherHelper {

	//encode/decode file helper util methods
	private static String encodeDecodePath(String path, String root, SimpleOffsetEncoderDecoder enc, boolean encode){
		String pathnoRoot = path.replace(root, "");   //remove root
		
		//split to folders 
		String [] folders = pathnoRoot.replace("\\", "/").split("/");
		for(int i = 0; i < folders.length; i++){   //encode folder names
			folders[i]= encode ?  enc.encode(folders[i]) : enc.decode(folders[i]);
		}
		
		//construct back folder path
		String res = root + File.separator;
		for(String s : folders) {
			res+=s+ File.separator;
		}
		return res;
	}
	
	
	/***
	 * 
	 * @param node
	 * @param encrypt
	 */
	private static void encryptDecryptFile(File node, boolean encrypt, SimpleOffsetEncoderDecoder simpleOffsetEncoderDecoder, EncipherDecipher encipherDecipher ){
		String newDirPath = encodeDecodePath(node.getPath(), decroot.getParent(), simpleOffsetEncoderDecoder, encrypt);
		System.out.println("Folder is " + node.getPath() + (encrypt ? " encoded folder is " :  " decoded folder is ") +newDirPath);
		if(node.isDirectory()) new File(newDirPath).mkdir();
		else
			try {
				File file = new File(newDirPath); file.createNewFile();
				//encrypt/decrypt and save to file 
				saveToFile(file, encrypt ?  encipherDecipher.encrypt(readFileContent(node)):  encipherDecipher.decrypt(readFileContent(node)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private static void saveToFile(File file, byte [] bytes) throws IOException{
		FileOutputStream fOutputStream = new FileOutputStream(file);
		try{
			fOutputStream.write(bytes);
			fOutputStream.flush();
			fOutputStream.close();
		}finally{
			fOutputStream.close();
		}
	}
	
	private static byte[] readFileContent(File file){
		// contain bytes read from file
	      Vector fileBytes = new Vector();
	      // read contents from file 
	      try {
	         FileInputStream in = new FileInputStream( file );
	         // read bytes from stream.
	         byte contents;
	         
	         while ( in.available() > 0 ) {
	            contents = ( byte )in.read();
	            fileBytes.add( new Byte( contents ) );
	         }
	           
	         in.close();
	      } 
	      // handle IOException
	      catch ( IOException exception ) {
	         exception.printStackTrace();
	      }
	      
	      // create byte array from contents in Vector fileBytes
	      byte[] fileContent = new byte[ fileBytes.size() ];
	      
	      for ( int i = 0; i < fileBytes.size(); i++ ) {
	    	  fileContent[ i ] = 
	            ( ( Byte ) fileBytes.elementAt( i ) ).byteValue();
	      }
	      return fileContent;
	}
	
	private static final String ALPHABET = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";    //alphabet for encrypting  the source files names
	private static final String PASSWORD = "pass";   //file encryption password
	final static EncipherDecipher encipherDecipher = new EncipherDecipher(PASSWORD);    //file name encryptor/ decryptor            
	final static SimpleOffsetEncoderDecoder simpleOffsetEncoderDecoder = new SimpleOffsetEncoderDecoder(ALPHABET, PASSWORD);    //file name encryptor / decryptor
	final static File encroot = new File("the path to the folder to be encrypted");     //the path to the folder to be encrypted
	final static File decroot = new File("the path to the folder to be encrypted");     //the path to the folder to be decrypted
	
	
	
	/***
	 * Decrypt the project folders & files...
	 * @author lubo
	 *
	 */
	private static class DecryptProjectFiles {
		void decrypt(){
			FileUtil.traverseDirs(decroot, new TraverseDirsCallBack() {
				@Override
				public void OnReturnFromRecursion(File node) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void OnForward(File node) {
					// TODO Auto-generated method stub
					encryptDecryptFile(node, false, simpleOffsetEncoderDecoder, encipherDecipher);
				}
			});
		}
	}
	
	/***
	 * Encrypt the project folders & files...
	 * @author lubo
	 *
	 */
	private static class EncryptProjectFiles {
		void encrypt(){
			FileUtil.traverseDirs(encroot, new TraverseDirsCallBack() {
				@Override
				public void OnReturnFromRecursion(File node) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void OnForward(File node) {
					encryptDecryptFile(node, true, simpleOffsetEncoderDecoder, encipherDecipher);
				}
			});
		}
	}
	
	public static void main(String []args) throws UnsupportedEncodingException{
		//new EncryptProjectFiles().encrypt();
	   // new DecryptProjectFiles().decrypt();
	}
}
