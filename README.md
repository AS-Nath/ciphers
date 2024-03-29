# **Encryption/Decryption - Project Summary**
<br>

**Introduction**
This piece of software (built exclusively in Java) allows the user to encrypt and decrypt messages
in 3 different ciphers:
<br>

**1.** *ASCII-Exchange*
<br>

**2.** *Generic Public Key Encryption*
<br>

**3.** *XOR*
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

# *Generic Public Key Encryption*
This cipher uses a public key (used by the encrypter) and a private key (used by the decrypter).
We take a number, generally 256, called the modulo.
Any individual ASCII character is encrypted as follows (pubk -> public key)
<br>

`encrypted = (c + pubk) % modulo [c -> character, modulo -> 256]`

and can be decrypted as follows (privk -> private key)
<br>

`decrypted = (c + privk) % modulo`

<br>
The private key is taken as any value from 1 to modulo-1, generally 255. As such, the public key is 
modulo - privk. If the private key is 133, the public key is 123. Test this out for yourself.
<br>
Note that ' ' (space) is left untouched. 
<br>
Also note that just like the substitution cipher, this is a HIGHLY insecure method of encryption
because of how basic it is - but it is the best way to demonstrate the concept of public-key
cryptography.
<br>
<br>

# *XOR*
XOR is a logic gate which works as follows:
<br>
0 XOR 0 == 0
<br>
0 XOR 1 == 1
<br>
1 XOR 0 == 1
<br>
1 XOR 1 == 0
<br>
<br>
Simply put, if A != B, A XOR B == 1. One interesting property is that if you repeat the XOR
operation, you get the original input. This cipher applies the XOR operation on the binary of the
ASCII code of every single character in the input string, XOR-ing it with a binary key input by the user.
Note that since the key is 8-bit, this only supports characters with 8-bit ASCII equivalents (up to 127). 
<br>
This produces an exceptionally cryptic-looking piece of text, but by repeating the exact same operation,
we can decrypt it. The one advantage is that this is pretty difficult to recognise as an encryption type,
but once someone realises that something has been encrypted using 8-bit XOR, they need a maximum of 127 tries
in a brute-force attack to decrypt the message.