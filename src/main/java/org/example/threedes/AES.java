package org.example.threedes;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

class AES {
    public static byte[] AESencrypt(byte[] buffer, SecretKey myDesKey1, Cipher myCipher, IvParameterSpec ivSpec)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        //byte[] myTransformedBytes = buffer;  // Operate on the incoming buffer
        // Encrypt with Key 1
        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey1, ivSpec);
        buffer = myCipher.doFinal(buffer);
        return buffer;
    }

    public static byte[] AESdecrypt(byte[] buffer, SecretKey myDesKey1, Cipher myCipher,IvParameterSpec ivSpec)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {

        //byte[] myTransformedBytes = buffer;  // Operate on the incoming
        // Decrypt with Key 1
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey1, ivSpec);
        buffer = myCipher.doFinal(buffer);
        return buffer;  // Return the correctly transformed bytes
    }
}

