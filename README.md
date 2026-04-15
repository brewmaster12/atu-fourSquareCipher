# atu-fourSquareCipher
Final project for the Object Oriented Software Development module for my Higher Diploma in Software Development at ATU Galway

My score for this project was 75%

# Project Brief
## Overview
You are required to develop a Java application that is capable of encrypting and decrypting a
text file or URL using a four-square cipher. The four-square cipher was invented by the French
cryptographer Felix Delastelle (1840-1902) and uses four 5x5 matrices arranged in a square to
encrypt pairs of characters in a message. Each of the 5x5 matrices contains 25 letters (the
relatively rare letter j is merged with the letter i). The upper-left and lower-right quadrants
(shown in green) are plaintext squares containing a standard alphabet. The upper-right and
lower-left quadrants (shown in blue) are the ciphertext squares contain a mixed random
alphabetic sequence. The four-square cipher is a polygraphic substitution cipher that uses the
same keyword to encrypt plain-text and decrypt cipher-text, i.e. the key is symmetric.

The encryption key is used to generate a unique sequence of letters that can be used to populate
the two ciphertext squares. The key can be randomly generated, specified with one keyword
or specified using two different keywords (dropping duplicate letters). Any remaining spaces,
i.e. a key length < 25 characters, should be filled with the remaining letters of the alphabet in
order.

## Minimum requirements
You are required to develop a Java application that can parse, encrypt and decrypt the
contents of a text file (small or very large…) or URL using the four-square cipher.

- The application should contain a command-line menu that prompts the user to enter a
keyword(s) and a file or URL. It should then parse the given resource line-by-line,
encrypt / decrypt the text and then append to an output file.

- You must use a 2D array structure to implement the four-square cipher. Do not use
any of the data structures in the Java Collections Framework. The knowledge you
will gain from mastering array structures will prove invaluable for the programming
modules in the next semester

The objective of the assignment is to reinforce the programming concepts that we have covered
since the start of the semester. In addition to the methods above, you are free to add any
additional functionality you want. The application of good programming practice and object-
oriented techniques will be rewarded.

# README

## Description
This is a console-based application that uses a four square cipher to encrypt or decrypt a .txt file
specified by the user and outputs the result to another .txt file specified by the user.

## To Run

cd src

javac ie/at/sw/Runner.java

java ie.at.sw.Runner


## Features
- Sequential prompts for user inputs 

- Specify the .txt file user wants to encrypt or decrypt

  - Validates that the inputted file must end in “.txt” (that it is a .txt file)
  
- Specify the name and location of the output file

  - Validates that the inputted file must end in “.txt” (that it is a .txt file)
  
- Specify if user wants to encrypt or decrypt the input file

  - Validates that user must choose either encrypt (‘E’) or decrypt (‘D’)
  
- Specify a key to use for the encrypted or decryption

  - If key input is left blank a default key will be used
  
  - Special characters will be automatically removed
  
  - Repeated letters will be automatically removed
  - Key may be of any length
  - Key is processed but not randomised so the same key will give consistent results
    across different instances of the project
- Uses a four square cipher to encrypt and decrypt
