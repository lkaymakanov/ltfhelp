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

	/**
	 * @param alphabet
	 * @param passPhrase
	 */
	public SimpleOffsetEncoderDecoder(String alphabet, String passPhrase){
		this.alphabet = alphabet;
		this.length = alphabet.length();
		this.offsets = passPhraseToIntArray(this.alphabet, passPhrase);
		this.alphabet = scrambleAlphabet();
	}
	

	/***
	 * 
	 * @param passPhrase
	 */
	public SimpleOffsetEncoderDecoder(String passPhrase){
		this.offsets =  passPhraseToIntArray(alphabet, passPhrase);
		this.length = alphabet.length();
		this.alphabet = scrambleAlphabet();
	}
	
	/*	
	public SimpleOffsetEncoderDecoder(int offset){
		this.offsets =  new int [] {offset};
	}
	
	public SimpleOffsetEncoderDecoder(String alphabet, int  offset){
		this.alphabet = alphabet;
		this.length = alphabet.length();
		this.offsets =  new int [] {offset};
	}*/
	
	
	/***
	 * Scrambles alphabet by offsets!
	 */
	private String scrambleAlphabet(){
		StringBuilder bd = new StringBuilder();
		char alphabetChars [] = new char [alphabet.length()];
		for(int i=0; i < alphabet.length(); i++){
			alphabetChars[i] = alphabet.charAt(i);
		}
		int offsetsLength = offsets.length;
		for(int i=0; i < alphabet.length(); i++){
			swap(alphabetChars, i, offsets[i % offsetsLength]);
		}
		bd.append(alphabetChars);
		return bd.toString();
	}
	
	private void swap(char [] chars, int index1, int index2){
	   char c1=	chars[index1];  chars[index1] = chars[index2]; chars[index2] = c1;
	}
	
	private int [] passPhraseToIntArray(String alphabet, String passPhrase){
		int arr [] = new int [passPhrase.length()];
		int aplhlength = alphabet.length();
		for(int i = 0; i < passPhrase.length(); i++){
			arr[i] = (passPhrase.codePointAt(i) % aplhlength);
		}
		return arr;
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
	   return newCharPostion(positionInAlphabet, positionInString,  (offsets[(positionInString % this.offsets.length)]* mult), mult);
	}
	
	
	private int newCharPostion(int positionInAlphabet, int positionInString, int offset, int  mult){
	   return 	(positionInAlphabet + offset) >= length ? ((positionInAlphabet + offset) - length) : ((positionInAlphabet + offset) < 0 ? (positionInAlphabet + offset)  + length : (positionInAlphabet + offset) );
	}
	
	
	
	
	
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
		String newDirPath = SimpleOffsetEncoderDecoder.encodeDecodePath(node.getPath(), decroot.getParent(), simpleOffsetEncoderDecoder, encrypt);
		System.out.println("Folder is " + node.getPath() + (encrypt ? " encoded folder is " :  " decoded folder is ") +newDirPath);
		if(node.isDirectory()) new File(newDirPath).mkdir();
		else
			try {
				File file = new File(newDirPath); file.createNewFile();
				//encrypt/decrypt and save to file 
				SimpleOffsetEncoderDecoder.saveToFile(file, encrypt ?  encipherDecipher.encrypt(SimpleOffsetEncoderDecoder.readFileContent(node)):  encipherDecipher.decrypt(SimpleOffsetEncoderDecoder.readFileContent(node)));
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
	final static File encroot = new File("path_to_the_folder_to_be_encrypted");     //the path to the folder to be encrypted
	final static File decroot = new File("path_to_the_folder_to_be_decrypted");     //the path to the folder to be decrypted
	
	
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
					SimpleOffsetEncoderDecoder.encryptDecryptFile(node, false, simpleOffsetEncoderDecoder, encipherDecipher);
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
					SimpleOffsetEncoderDecoder.encryptDecryptFile(node, true, simpleOffsetEncoderDecoder, encipherDecipher);
				}
			});
		}
	}
	
	public static void main(String []args) throws UnsupportedEncodingException{
		//new EncryptProjectFiles().encrypt();
		new DecryptProjectFiles().decrypt();
	}
}
