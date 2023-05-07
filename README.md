# Encryption/Decryption
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
in the Unicode set - and thus encrypted. This is the simplest form of cipher, and was even used by 
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
Shift 4: I'm fine thanks ---> M'q jmri xlerow [<i>Note that the apostrophe (') is maintained!<i>]

***The following components are IN DEVELOPMENT and are subject to change.***

# *RSA*
<br>

# *AES*