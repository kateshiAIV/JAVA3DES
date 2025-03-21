package org.example.threedes;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

class Des{
    public static void DES(Path path) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {


        String test = "MY TEST MESSAGE";
//        byte[] myFile = Files.readAllBytes(path);
        byte[] myFile = test.getBytes();

        //If you want to use your own key
        // SecretKeyFactory MyKeyFactory = SecretKeyFactory.getInstance("DES");
        // String Password = "My Password";
        // byte[] mybyte =Password.getBytes();
        // DESKeySpec myMaterial = new DESKeySpec(mybyte);
        // SecretKey myDESKey = MyKeyFactory.generateSecret(myMaterial);

        //Generating Key
        KeyGenerator Mygenerator = KeyGenerator.getInstance("DES");
        SecretKey myDesKey1 = Mygenerator.generateKey();
        SecretKey myDesKey2 = Mygenerator.generateKey();
        SecretKey myDesKey3 = Mygenerator.generateKey();

        // Generating IV (Initialization Vector) for CTR mode
        byte[] ivBytes = new byte[8]; // DES block size is 8 bytes
        SecureRandom random = new SecureRandom();
        random.nextBytes(ivBytes);
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        //initializing crypto algorithm
        Cipher myCipher = Cipher.getInstance("DES/CTR/NoPadding");
        System.out.println("Input: " + test);
        //encrypt with key 1
        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey1, ivSpec);
        byte[] myEncryptedBytes=myCipher.doFinal(myFile);
        String encrypteddata=new String(myEncryptedBytes);
        System.out.println("1st step: " + encrypteddata);


        //decrypt with key 2
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey2, ivSpec);
        myEncryptedBytes = myCipher.doFinal(myEncryptedBytes);
        encrypteddata=new String(myEncryptedBytes);
        System.out.println("2st step: " + encrypteddata);



        //encrypt with key 3
        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey3, ivSpec);
        myEncryptedBytes=myCipher.doFinal(myEncryptedBytes);
        encrypteddata=new String(myEncryptedBytes);
        System.out.println("3st step: " + encrypteddata);



        //dencrypt with key 3
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey3, ivSpec);
        myEncryptedBytes = myCipher.doFinal(myEncryptedBytes);
        encrypteddata=new String(myEncryptedBytes);
        System.out.println("4st step: " + encrypteddata);


        //encrypt with key 2
        myCipher.init(Cipher.ENCRYPT_MODE, myDesKey2, ivSpec);
        myEncryptedBytes=myCipher.doFinal(myEncryptedBytes);
        encrypteddata=new String(myEncryptedBytes);
        System.out.println("5st step: " + encrypteddata);


        //decrypt with key 1
        myCipher.init(Cipher.DECRYPT_MODE, myDesKey1, ivSpec);
        myEncryptedBytes=myCipher.doFinal(myEncryptedBytes);
        encrypteddata=new String(myEncryptedBytes);
        System.out.println("6st step: " + encrypteddata);

    }
}


//print message in byte format
//System.out.println(Arrays.toString(myEncryptedBytes));
//System.out.println(Arrays.toString(myDecryptedBytes));

//        String encrypteddata=new String(myEncryptedBytes);
//        String decrypteddata=new String(myDecryptedBytes);
//
//        System.out.println("Message : "+ message);
//        System.out.println("Encrypted - "+ encrypteddata);
//        System.out.println("Decrypted Message - "+ decrypteddata);