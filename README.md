# Merkle-Hellman Knapsack Cryptosystem

## Background

You will be implementing the well-known Merkle-Hellman Knapsack Cryptosystem algorithm using a Doubly Linked List. This exercise will challenge you to use linked lists in a more complex way, and will also serve as an introduction to NP-Complete problems. 

## Problem Statement

In this assignment you will implement key generation, encryption and decryption using the Merkle-Hellman Knapsack Cryptosystem. A very clear and well-written description of this algorithm can be found at the following link. This is a required reading for the course and should be understood prior to writing code:
http://en.wikipedia.org/wiki/Merkle–Hellman_knapsack_cryptosystem

Note that the example provided on the wiki is an example using small integers with w = {2,
7, 11, 21, 42, 89, 180, 354}. In this project, w will consist of 640 huge integers.

You will write two doubly linked lists of objects to hold two lists of BigIntegers. One list, w, will be used to hold the superincreasing sequence of integers that make up part of the private key and used for decryption. The second list, b, will be used to hold the public key material used for encryption. Your list class should encapsulate all of the work associated with lists and should not know anything about Merkle-Hellman. You will include pre- and post-conditions with each of your methods and will describe each method’s run-time complexity using Big Theta (both best and worst case).

Using a doubly linked list for this problem is appropriate but not ideal. However, it is very appropriate for a first course in data structures. Use a doubly linked list for this project, but you should be aware that there are better alternatives.

Use the built-in methods of the BigInteger class provided by Java. These methods make it fairly easy to implement some of the tedious but essential parts of Merkle-Hellman. 

## Hint

Since your program must handle 80 characters of input and since each character can be represented in 8 bits, your lists will have (80 * 8) 640 nodes. Note that key generation is typically done once. Then, the key is used. It is not typical that the key size would depend on the size of the input (which may vary).

## Example

```
String to encrypt:
Welcome to Data Structures and Algorithms

Encrypted as this single large integer:
896565913913625345190532377161504578853838807660067315324875625882047524293378988136679066309863542775671737312781408

Decryption: 
Welcome to Data Structures and Algorithms
```






