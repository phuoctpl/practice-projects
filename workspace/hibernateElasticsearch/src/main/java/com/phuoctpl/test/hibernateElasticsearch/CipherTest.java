package com.phuoctpl.test.hibernateElasticsearch;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class CipherTest {
	
	
	public static void main(String[] args) {
		try {
			Cipher cipher = Cipher.getInstance("AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
