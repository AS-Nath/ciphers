# Encryption/Decryption - Project Summary
<br>

**Introduction**
This piece of software (built exclusively in Java) allows the user to encrypt and decrypt messages
in 3 different ciphers:
<br>

**1.** *ASCII-Exchange*
<br>

**2.** *RSA*
<br>

**3.** *AES*
<br>

# *ASCII-Exchange*
This is a substitution cipher - each character is shifted a fixed number of times (input by the user)
in the ASCII set - and thus encrypted. This is the simplest form of cipher, and was even used by 
the Roman emperor/general Julius Caesar. The most basic version of this cipher is thus called the
Caesar cipher.
<br>
Our implementation of this cipher allows the user to input how far they would like to shift each character,
and for both sets of characters (upper-/lower-case), text wraps around to a/A if it crosses z/Z and 
vice-versa.
<br>

*Examples:* 
<br>
Shift 4: hello how are you ---> lipps lsa evi csy
<br>
Shift 4: I'm fine thanks ---> M'q jmri xlerow <i>[Note that the apostrophe (') is maintained!]</i>
<br>
The user may want to test the decryption for themselves, by copying the encrypted version from here.
<br>
<br>
One possible output the user might want to consider is this:
<br>
Enter an integer! Or maybe a smaller one.
<br>

This might be a confusing output, because it occurs *after* you input what you want to encrypt/decrypt,
but it has to do with the shift value you input. 

Quite simply, you either did not enter an integer, or (more likely) the number you input was too large
for the program to handle. Inputs even over 26 can be handled (I used 32 in testing) but if you try 
something like 231323, the program throws an Exception which is caught, handled and so this message is
output. 

To proceed, just re-enter a smaller shift value.

***The following components are IN DEVELOPMENT and are subject to change.***

# *RSA*
<br>

# *AES*