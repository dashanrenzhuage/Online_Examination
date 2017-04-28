package edu.mum.onlinetest.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Based64Util {

	public static void main(String args[]) {

//		System.out.println("decoded string = "+decode("YnNlamF3YWw6MTIz"));
		
		if(md5("koala").equals("a564de63c2d0da68cf47586ee05984d7")){
			System.out.println("true");
		}else{
			System.out.println("false");
		}

	}

	public static String encode(String rawStirng) {
		byte[] message = null;
		try {
			message = rawStirng.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printBase64Binary(message);
	}
	
	

	public static String decode(String encodedString) {
		byte[] decoded = DatatypeConverter.parseBase64Binary(encodedString);
		String decodedString = "";
		try {
			decodedString = new String(decoded, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return decodedString;
	}
	
	
	public static String md5(String str){
		MessageDigest messageDigest;
		String hashed ="";
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(str.getBytes(),0, str.length());  
			hashed = new BigInteger(1,messageDigest.digest()).toString(16);  
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}  
		
		if (hashed.length() < 32) {
		   hashed = "0" + hashed; 
		}
		return hashed;
	}
	
	public static boolean isValidMD5(String s) {
	    return s.matches("[a-fA-F0-9]{32}");
	}
}
