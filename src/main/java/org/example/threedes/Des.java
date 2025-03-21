package org.example.threedes;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

class Des {
    public static byte[] DESencrypt(byte[] buffer, SecretKey myDesKey1, SecretKey myDesKey2, SecretKey myDesKey3, Cipher myCipher,IvParameterSpec ivSpec)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {


            byte[] myTransformedBytes = buffer;  // Operate on the incoming buffer


            // Encrypt with Key 1
            myCipher.init(Cipher.ENCRYPT_MODE, myDesKey1, ivSpec);
            myTransformedBytes = myCipher.doFinal(myTransformedBytes);

            // Decrypt with Key 2
            myCipher.init(Cipher.DECRYPT_MODE, myDesKey2, ivSpec);
            myTransformedBytes = myCipher.doFinal(myTransformedBytes);

            // Encrypt with Key 3
            myCipher.init(Cipher.ENCRYPT_MODE, myDesKey3, ivSpec);
            myTransformedBytes = myCipher.doFinal(myTransformedBytes);



            return myTransformedBytes;  // Return the correctly transformed bytes
    }

        public static byte[] DESdecrypt(byte[] buffer, SecretKey myDesKey1, SecretKey myDesKey2, SecretKey myDesKey3, Cipher myCipher,IvParameterSpec ivSpec)
                throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException,
                IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {


                byte[] myTransformedBytes = buffer;  // Operate on the incoming buffer

                // Decrypt with Key 3
                myCipher.init(Cipher.DECRYPT_MODE, myDesKey3, ivSpec);
                myTransformedBytes = myCipher.doFinal(myTransformedBytes);

                // Encrypt with Key 2
                myCipher.init(Cipher.ENCRYPT_MODE, myDesKey2, ivSpec);
                myTransformedBytes = myCipher.doFinal(myTransformedBytes);

                // Decrypt with Key 1
                myCipher.init(Cipher.DECRYPT_MODE, myDesKey1, ivSpec);
                myTransformedBytes = myCipher.doFinal(myTransformedBytes);


                return myTransformedBytes;  // Return the correctly transformed bytes
        }
}
