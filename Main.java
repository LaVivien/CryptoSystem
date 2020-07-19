package linkedListCrypto;

import java.math.BigInteger;

public class Main {
	
    public static void main(String[] args) {  	
		MHKCrypto mhkCrypto = new MHKCrypto();		
		String input = "Welcome to Data Structures and Algorithms"; 
		System.out.println("String to encrypt:\n" + input);
		mhkCrypto.genPrivateKey(input.length());
		mhkCrypto.genPublicKey();
		BigInteger encrypted = mhkCrypto.encrypt(input);
		System.out.println("\nEncrypted as this single large integer:");
		System.out.println(encrypted);
		System.out.println("\nDecryption: \n" + mhkCrypto.decrypt(encrypted));
    }
}
