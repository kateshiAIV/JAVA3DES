package org.example.threedes;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Scanner;


import static org.example.threedes.Des.DESdecrypt;
import static org.example.threedes.Des.DESencrypt;

class Main {
    public static void main(String arg[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {




        final int PACKET_SIZE = 8192;  // 8KB
        byte[] buffer = new byte[PACKET_SIZE];  // Buffer to hold 8KB packets

        //If you want to use your own key





        //Generating Key
        KeyGenerator Mygenerator = KeyGenerator.getInstance("DES");
        SecretKeyFactory MyKeyFactory = SecretKeyFactory.getInstance("DES");

        byte[] ivBytes = { (byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101,
                (byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101 };

        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        Cipher myCipher = Cipher.getInstance("DES/CTR/NoPadding");

        Scanner s1 = new Scanner(System.in);
        int op;
        System.out.println("Secect operation:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        op = s1.nextInt();
        switch (op){
            case 1:{
                String key;
                System.out.println("Provide a key:");
                key = s1.next();
                String Password = key;
                byte[] mybyte =Password.getBytes();
                DESKeySpec myMaterial = new DESKeySpec(mybyte);
                SecretKey myDesKey1 = MyKeyFactory.generateSecret(myMaterial);
                SecretKey myDesKey2 = MyKeyFactory.generateSecret(myMaterial);
                SecretKey myDesKey3 = MyKeyFactory.generateSecret(myMaterial);

                String in;
                System.out.println("Provide an input file name:");
                in = s1.next();
                Path path = Paths.get(String.format("src/main/resources/%s", in));

                String out;
                System.out.println("Provide an output file name:");
                out = s1.next();
                Path outputPath = Paths.get(String.format("src/main/resources/%s", out));

                System.out.println("Processing...");

                try (InputStream inputStream = new FileInputStream(path.toFile());
                     OutputStream outputStream = new FileOutputStream(outputPath.toFile())) {

                    long start = System.currentTimeMillis();
                    // Read the file in 8KB packets
                    while (inputStream.read(buffer) != -1) {
                        byte[] encryptedPacket = DESencrypt(buffer,myDesKey1,myDesKey2,myDesKey3,myCipher,ivSpec);
                        outputStream.write(encryptedPacket);
                    }
                    System.out.println("Processing done in " + (System.currentTimeMillis()-start) + " millsiseconds");
                } catch (Exception e) {
                    e.printStackTrace();
                }



                break;
            }
            case 2:{
                String key;
                System.out.println("Provide a key:");
                key = s1.next();
                String Password = key;
                byte[] mybyte =Password.getBytes();
                DESKeySpec myMaterial = new DESKeySpec(mybyte);
                SecretKey myDesKey1 = MyKeyFactory.generateSecret(myMaterial);
                SecretKey myDesKey2 = MyKeyFactory.generateSecret(myMaterial);
                SecretKey myDesKey3 = MyKeyFactory.generateSecret(myMaterial);

                String in;
                System.out.println("Provide an input file name:");
                in = s1.next();
                Path path = Paths.get(String.format("src/main/resources/%s", in));

                String out;
                System.out.println("Provide an output file name:");
                out = s1.next();
                Path outputPath = Paths.get(String.format("src/main/resources/%s", out));

                System.out.println("Processing...");

                try (InputStream inputStream = new FileInputStream(path.toFile());
                     OutputStream outputStream = new FileOutputStream(outputPath.toFile())) {

                    long start = System.currentTimeMillis();
                    // Read the file in 8KB packets
                    while (inputStream.read(buffer) != -1) {
                        byte[] encryptedPacket = DESdecrypt(buffer,myDesKey1,myDesKey2,myDesKey3,myCipher,ivSpec);
                        outputStream.write(encryptedPacket);
                    }
                    System.out.println("Processing done in " + (System.currentTimeMillis()-start) + " millsiseconds");
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;
            }
        }

        System.out.println("Packet.");

    }
}
