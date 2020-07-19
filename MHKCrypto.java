package linkedListCrypto;

import java.math.BigInteger;
import java.util.*;

public class MHKCrypto {
	
	private DoublyLinkedList <BigInteger> w;
    public DoublyLinkedList <BigInteger> B;
    private BigInteger q = new BigInteger("0");
    private BigInteger r = new BigInteger("0");
    private int listSize = 0;

    public MHKCrypto(){   	
        w = new DoublyLinkedList<>();
        B = new DoublyLinkedList<>();
    }

    // Generate private key
    public void genPrivateKey(int length) {
		BigInteger sum = new BigInteger("0"); 
        Random random = new Random();       
        for(int i=0;i<(length*8);i++){
        	DoubleNode<BigInteger> temp = w.getHead();
        	if(temp == null){
        		sum = BigInteger.ZERO;
        	} else {
        		while(temp!=null) {
        			sum = sum.add(temp.getC());
        			temp = temp.getNext();
        		}
        	}
        	sum = sum.add(new BigInteger(random.nextInt(5)+1+""));
        	w.addAtEnd(sum);
        }	
	}

    //Generate public key 
	public void  genPublicKey(){
		q = genQ();
		r = genR();		
		DoubleNode<BigInteger> temp = w.getHead();
		while(temp!=null) {
			BigInteger x;
			x = temp.getC().multiply(r).mod(q);
			B.addAtEnd(x);
			temp = temp.getNext();
		}
	}
	
	private BigInteger genQ(){
		DoubleNode<BigInteger> temp = w.getHead();
		BigInteger sum = new BigInteger("0");
		Random r = new Random();
		while(temp!=null) {
			sum = sum.add(temp.getC());
			temp = temp.getNext();
		}		
		return sum.add(new BigInteger(""+r.nextInt(5)+1));
	}
	
	private BigInteger genR(){
		Random rand = new Random();
		BigInteger r;
		do {
            r = q.subtract(new BigInteger(rand.nextInt(1000) + ""));
        } while ((r.compareTo(new BigInteger("0")) > 0) && (q.gcd(r).intValue() != 1));
		
		return r;
	}

    //Encrypt(private key, message)
	public BigInteger encrypt(String inputStr) {
		listSize = inputStr.length()*8;
		BigInteger encrpytedmsg = new BigInteger("0");
		int count =7;
		int[] input = new int[8];
		Arrays.fill(input,0);				
		for(int i=0;i<inputStr.length();i++){
			int x = inputStr.charAt(i);
			while(x!=0){
				input[count] = x%2;
				x = x/2;
				count = count -1;
			}				
			for(int j=0;j<8;j++){
				BigInteger value = B.get(i * 8 + j);
				if(input[j]!=0){
					encrpytedmsg = encrpytedmsg.add(value);
				}
			}
			Arrays.fill(input,0);
			count =7;
		}
		
		return encrpytedmsg;		
	}

    //decrypt 
	public String decrypt(BigInteger encrypt) {		
		BigInteger b1 = encrypt.mod(q);
        BigInteger b2 = r.modInverse(q);
        BigInteger b3 = b1.multiply(b2);
        BigInteger value = b3.mod(q);    
        int[] bitmask = new int[listSize];
        int i = listSize -1;
        while(value.compareTo(BigInteger.ZERO) != 0) {
        	BigInteger encrpt_key = w.get(i);
        	if(value.compareTo(encrpt_key) >=0) {
        		value = value.subtract(encrpt_key);
        		bitmask[i] = 1;
        	}
        	i=i-1;
        }     
        int len = bitmask.length;
        String concat="";
        double x=0;
        while(len > 0) {
        	len = len - 1;   
        	if(len%8==0) {
        		concat = concat + (char)x;
        		x=0;
        	} else {
        		if (bitmask[len]==1) {
        			x = x+Math.pow(2,8-(len%8)-1);
        		}
        	}     	
        }       
        StringBuffer buffer = new StringBuffer(concat);
        StringBuffer x1 = buffer.reverse();  
        return x1.toString();
	}
}
