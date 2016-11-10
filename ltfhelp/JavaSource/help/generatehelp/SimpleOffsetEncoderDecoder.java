package help.generatehelp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;


public class SimpleOffsetEncoderDecoder {
	private static String defaultAlphabet = " ./\\~!@#$%^&*()_+{}[];:|',\"_1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private int [] offsets;
	private String alphabet;
	private int length ;
	private int scrableFactor = 10;    //factor for scrambling alphabet default 10

	/**
	 * @param alphabet
	 * @param passPhrase
	 */
	public SimpleOffsetEncoderDecoder(String alphabet, String passPhrase){
		this(alphabet, passPhrase, passPhrase.length());
	}
	

	/***
	 * 
	 * @param passPhrase
	 */
	public SimpleOffsetEncoderDecoder(String passPhrase){
		this(defaultAlphabet, passPhrase, passPhrase.length());
	}
	
	
	private SimpleOffsetEncoderDecoder(String alphabet, String passPhrase, int scrambleFactor){
		this.alphabet = alphabet;
		this.scrableFactor = scrambleFactor;
		this.length = alphabet.length();
		this.offsets = passPhraseToIntArray(this.alphabet, passPhrase);
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
		String currentAlphabet = alphabet;
		for(int p=0; p < scrableFactor; p++){
			bd = new StringBuilder();
			char alphabetChars [] = new char [currentAlphabet.length()];
			for(int i=0; i < currentAlphabet.length(); i++){
				alphabetChars[i] = currentAlphabet.charAt(i);
			}
			int offsetsLength = offsets.length;
			for(int i=0; i < currentAlphabet.length(); i++){
				swap(alphabetChars, i, offsets[i % offsetsLength]);
			}
			bd.append(alphabetChars);
			currentAlphabet = bd.toString();
		}
		return currentAlphabet;
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
	
	
}
