package help.generatehelp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;


public class SimpleOffsetEncoderDecoder {

	private int offset;
	private String alphabet=" ./\\~!@#$%^&*()_+{}[];:|',\"_1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private int length = alphabet.length();
	
	
	public SimpleOffsetEncoderDecoder(int offset){
		this.offset =  offset % length;
		if(this.offset == 0) this.offset = 3;
	}
	
	public SimpleOffsetEncoderDecoder(String alphabet, int offset){
		this.alphabet = alphabet;
		this.length = alphabet.length();
		this.offset =  offset % length;
		if(this.offset == 0) this.offset = 3;
	}
	
	public  String encode(String s){
		if(s == null) return null;
		if(s.isEmpty()) return s;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < s.length(); i++){
			char currentChar = s.charAt(i);
			if(charPosisition(currentChar) < 0) sb.append(currentChar);
			else sb.append(encode(s.charAt(i)));
		}
		return sb.toString();
	}
	
	public  String decode(String s){
		if(s == null) return null;
		if(s.isEmpty()) return s;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < s.length(); i++){
			char currentChar = s.charAt(i);
			if(charPosisition(currentChar) < 0) sb.append(currentChar);
			else sb.append(decode(s.charAt(i)));
		}
		return sb.toString();
	}
	
	public char encode(char c){
		return alphabet.charAt(newCharPostion(charPosisition(c), 1));
	}
	
	public char decode(char c){
		return alphabet.charAt(newCharPostion(charPosisition(c), -1));
	}
	
	private int charPosisition(char c){
		return alphabet.indexOf(c);
	}
	
	private int newCharPostion(int position, int  mult){
	   int offset = (this.offset * mult);
	   return 	(position + offset) >= length ? ((position + offset) - length) : ((position + offset) < 0 ? (position + offset)  + length : (position + offset) );
	}
	
	
	private static String encodePath(String path, String root, SimpleOffsetEncoderDecoder enc){
		String pathnoRoot = path.replace(root, "");   //remove root
		
		//split to folders 
		String [] folders = pathnoRoot.replace("\\", "/").split("/");
		for(int i = 0; i < folders.length; i++){   //encode folder names
			folders[i]= enc.encode(folders[i]);
		}
		
		//construct back folder path
		String res = root + File.separator;
		for(String s : folders) {
			res+=s+ File.separator;
		}
		return res;
	}
	
	private static String decodePath(String path, String root, SimpleOffsetEncoderDecoder enc){
		String pathnoRoot = path.replace(root, "");   //remove root
		
		//split to folders 
		String [] folders = pathnoRoot.replace("\\", "/").split("/");
		for(int i = 0; i < folders.length; i++){   //decode folder names
			folders[i]= enc.decode(folders[i]);
		}
		
		//construct back folder path
		String res = root + File.separator;
		for(String s : folders) {
			res+=s+ File.separator;
		}
		return res;
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
	
	private static final String ALPHABET = "myalphbetus";    //alphabet encrypting for the source files names
	private static final int OFFSET = 2;     //offset for letters of files names
	private static final String PASSWORD = "pass";   //file encryption password
	final static EncipherDecipher encc = new EncipherDecipher(PASSWORD);    //file name encryptor/ decryptor            
	final static SimpleOffsetEncoderDecoder enc = new SimpleOffsetEncoderDecoder(ALPHABET, OFFSET);    //file name encryptor / decryptor
	final static String decfolderParent = "D:";   //the parent folder of the folder to be decrypted
	final static String enfolderParent = "D:";    //the parent folder of the folder to be encrypted
	final static File encroot = new File("D:\\sources");     //the path to the folder to be encrypted
	final static File decroot = new File("D:\\folder_to_be_decrypted");     //the path to the folder to be decrypted
	
	
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
					String newDirPath = SimpleOffsetEncoderDecoder.decodePath(node.getPath(), decfolderParent, enc);
					System.out.println("folder is " + node.getPath() + " decoded folder = " +newDirPath);
					if(node.isDirectory()) new File(newDirPath).mkdir();
					else
						try {
							File file = new File(newDirPath); file.createNewFile();
							//encrypt and save to file 
							SimpleOffsetEncoderDecoder.saveToFile(file, encc.decrypt(SimpleOffsetEncoderDecoder.readFileContent(node)));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
					// TODO Auto-generated method stub
					String newDirPath = SimpleOffsetEncoderDecoder.encodePath(node.getPath(), enfolderParent, enc);
					
					System.out.println("folder is " + node.getPath() + " encoded folder = " + newDirPath);
					if(node.isDirectory()) new File(newDirPath).mkdir();
					else
						try {
							File file = new File(newDirPath); file.createNewFile();
							//encrypt and save to file 
							SimpleOffsetEncoderDecoder.saveToFile(file, encc.encrypt(SimpleOffsetEncoderDecoder.readFileContent(node)));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			});
		}
	}
	
	public static void main(String []args) throws UnsupportedEncodingException{
		//new EncryptProjectFiles().encrypt();
		//new DecryptProjectFiles().decrypt();
	}
}
