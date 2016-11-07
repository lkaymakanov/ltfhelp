package help.generatehelp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;


public class SimpleOffsetEncoderDecoder {

	private int [] offsets;
	private String alphabet=" ./\\~!@#$%^&*()_+{}[];:|',\"_1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private int length = alphabet.length();

	
	public SimpleOffsetEncoderDecoder(String alphabet, String passPhrase){
		this.alphabet = alphabet;
		this.offsets = passPhraseToIntArray(this.alphabet, passPhrase);
		this.length = alphabet.length();
	}
	

	public SimpleOffsetEncoderDecoder(String passPhrase){
		this.offsets =  passPhraseToIntArray(alphabet, passPhrase);
		this.length = alphabet.length();
	}
	
	public SimpleOffsetEncoderDecoder(int [] offsets){
		this.offsets =  offsets;
	}
	
	public SimpleOffsetEncoderDecoder(String alphabet, int [] offsets){
		this.alphabet = alphabet;
		this.length = alphabet.length();
		this.offsets = offsets;
	}
	
	private int [] passPhraseToIntArray(String alphabet, String passPhrase){
		int arr [] = new int [passPhrase.length()];
		int aplhlength = alphabet.length();
		for(int i = 0; i < passPhrase.length(); i++){
			arr[i] = (passPhrase.codePointAt(i) % aplhlength);
		}
		return arr;
	}
	
	public SimpleOffsetEncoderDecoder(int offset){
		this.offsets =  new int [] {offset};
	}
	
	public SimpleOffsetEncoderDecoder(String alphabet, int  offset){
		this.alphabet = alphabet;
		this.length = alphabet.length();
		this.offsets =  new int [] {offset};
	}
	
	
	public  String encode(String s){
		if(s == null) return null;
		if(s.isEmpty()) return s;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < s.length(); i++){
			char currentChar = s.charAt(i);
			if(charPosisitionInAlphabet(currentChar) < 0) sb.append(currentChar);
			else sb.append(encode(s.charAt(i), i));
		}
		return sb.toString();
	}
	
	public  String decode(String s){
		if(s == null) return null;
		if(s.isEmpty()) return s;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < s.length(); i++){
			char currentChar = s.charAt(i);
			if(charPosisitionInAlphabet(currentChar) < 0) sb.append(currentChar);
			else sb.append(decode(s.charAt(i), i));
		}
		return sb.toString();
	}
	
	private char encode(char c, int charPosInString){
		return alphabet.charAt(newCharPostion(charPosisitionInAlphabet(c), charPosInString, 1));
	}
	
	private char decode(char c, int charPosInString){
		return alphabet.charAt(newCharPostion(charPosisitionInAlphabet(c), charPosInString, -1));
	}
	
	private int charPosisitionInAlphabet(char c){
		return alphabet.indexOf(c);
	}
	
	private int newCharPostion(int positionInAlphabet, int positionInString, int  mult){
	   int offset = (offsets[(positionInString % this.offsets.length)]* mult);
	   return 	(positionInAlphabet + offset) >= length ? ((positionInAlphabet + offset) - length) : ((positionInAlphabet + offset) < 0 ? (positionInAlphabet + offset)  + length : (positionInAlphabet + offset) );
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
	
	private static final String ALPHABET = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";    //alphabet encrypting for the source files names
	private static final String PASSWORD = "pass";   //file encryption password
	final static EncipherDecipher encc = new EncipherDecipher(PASSWORD);    //file name encryptor/ decryptor            
	final static SimpleOffsetEncoderDecoder enc = new SimpleOffsetEncoderDecoder(ALPHABET, PASSWORD);    //file name encryptor / decryptor
	final static String decfolderParent = "D:";   //the parent folder of the folder to be decrypted
	final static String enfolderParent = "D:";    //the parent folder of the folder to be encrypted
	final static File encroot = new File("D:\\path_to_file_to_be_encrypted");     //the path to the folder to be encrypted
	final static File decroot = new File("D:\\path_to_file_to_be_decrypted");     //the path to the folder to be decrypted
	
	
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
