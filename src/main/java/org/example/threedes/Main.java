package org.example.threedes;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.lang.runtime.SwitchBootstraps;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;


import static org.example.threedes.DES.TDESdecrypt;
import static org.example.threedes.DES.TDESencrypt;

class Main {
    public static void main(String arg[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Choose the mode: \n1. 3DES/CTR \n 2. AES/CFB");
        int op = scan.nextInt();

        switch (op){
            case 1: {
                ThreeDES();
            }
            case 2: {
                AES();
            }
        }




    }

    private static void AES() throws Exception {
            final int PACKET_SIZE = 8 * 1024; // 8KB
            byte[] buffer = new byte[PACKET_SIZE];
            int packetNum = 0;

            byte[] ivBytes = new byte[16]; // AES uses 16-byte IV
            for (int i = 0; i < 16; i++) {
                ivBytes[i] = (byte) 0b01010101;
            }
            IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

            Cipher myCipher = Cipher.getInstance("AES/CFB/NoPadding");

            Scanner s1 = new Scanner(System.in);
            System.out.println("Select operation:\n1. Encrypt\n2. Decrypt");
            int op = s1.nextInt();

            System.out.println("Provide a key: ");
            SecretKey key1 = generateAESKey(s1.next());




            System.out.println("Provide an input file name:");
            Path inputPath = Paths.get("src/main/resources/" + s1.next());

            System.out.println("Provide an output file name:");
            Path outputPath = Paths.get("src/main/resources/" + s1.next());

            System.out.println("Processing...");

            try (InputStream inputStream = new FileInputStream(inputPath.toFile());
                 OutputStream outputStream = new FileOutputStream(outputPath.toFile())) {

                long start = System.currentTimeMillis();
                int bytesRead;
                if(op == 1) {
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        byte[] packet = new byte[bytesRead];
                        System.arraycopy(buffer, 0, packet, 0, bytesRead);

                        byte[] transformed;

                        transformed = AES.AESencrypt(packet, key1, myCipher, ivSpec);


                        outputStream.write(transformed);
                        packetNum++;
                    }
                }else{
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        byte[] packet = new byte[bytesRead];
                        System.arraycopy(buffer, 0, packet, 0, bytesRead);

                        byte[] transformed;

                        transformed = AES.AESdecrypt(packet, key1, myCipher, ivSpec);


                        outputStream.write(transformed);
                        packetNum++;
                    }
                }


                System.out.println("Processing done in " + (System.currentTimeMillis() - start) + " milliseconds");
                System.out.println("Total number of packets: " + packetNum);
            } catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println("done. Pockets: " + packetNum );
        }




    public static SecretKey generateAESKey(String password) throws Exception {
        byte[] keyBytes = password.getBytes();
        byte[] key = new byte[16]; // 128-bit key
        System.arraycopy(keyBytes, 0, key, 0, Math.min(keyBytes.length, 16));
        return new SecretKeySpec(key, "AES");
    }

    public static void ThreeDES() throws InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException {
        final int PACKET_SIZE = 1024 * 1024;  // 8KB
        byte[] buffer = new byte[PACKET_SIZE];  // Buffer to hold 8KB packets
        int packetNum = 0;


        //Generating Key
        KeyGenerator Mygenerator = KeyGenerator.getInstance("DES");
        SecretKeyFactory MyKeyFactory = SecretKeyFactory.getInstance("DES");


        byte[] ivBytes = {(byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101,
                (byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101, (byte) 0b01010101};

        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);


        Cipher myCipher = Cipher.getInstance("DES/CTR/NoPadding");

        Scanner s1 = new Scanner(System.in);
        int op;
        System.out.println("Secect operation:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        op = s1.nextInt();
        switch (op) {
            case 1: {
                String key1;
                String key2;
                String key3;
                System.out.println("Provide a key 1:");
                key1 = s1.next();
                System.out.println("Provide a key 2:");
                key2 = s1.next();
                System.out.println("Provide a key 3:");
                key3 = s1.next();
                String Password1 = key1;
                String Password2 = key2;
                String Password3 = key3;
                byte[] mybyte1 = Password1.getBytes();
                byte[] mybyte2 = Password2.getBytes();
                byte[] mybyte3 = Password3.getBytes();
                DESKeySpec myMaterial1 = new DESKeySpec(mybyte1);
                DESKeySpec myMaterial2 = new DESKeySpec(mybyte2);
                DESKeySpec myMaterial3 = new DESKeySpec(mybyte3);
                SecretKey myDesKey1 = MyKeyFactory.generateSecret(myMaterial1);
                SecretKey myDesKey2 = MyKeyFactory.generateSecret(myMaterial2);
                SecretKey myDesKey3 = MyKeyFactory.generateSecret(myMaterial3);

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
                        byte[] encryptedPacket = TDESencrypt(buffer, myDesKey1, myDesKey2, myDesKey3, myCipher, ivSpec);
                        outputStream.write(encryptedPacket);
                        packetNum++;
                    }
                    System.out.println("Processing done in " + (System.currentTimeMillis() - start) + " millsiseconds");
                    System.out.println("Total number of packets: " + packetNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                String key1;
                String key2;
                String key3;
                System.out.println("Provide a key 1:");
                key1 = s1.next();
                System.out.println("Provide a key 2:");
                key2 = s1.next();
                System.out.println("Provide a key 3:");
                key3 = s1.next();
                String Password1 = key1;
                String Password2 = key2;
                String Password3 = key3;
                byte[] mybyte1 = Password1.getBytes();
                byte[] mybyte2 = Password2.getBytes();
                byte[] mybyte3 = Password3.getBytes();
                DESKeySpec myMaterial1 = new DESKeySpec(mybyte1);
                DESKeySpec myMaterial2 = new DESKeySpec(mybyte2);
                DESKeySpec myMaterial3 = new DESKeySpec(mybyte3);
                SecretKey myDesKey1 = MyKeyFactory.generateSecret(myMaterial1);
                SecretKey myDesKey2 = MyKeyFactory.generateSecret(myMaterial2);
                SecretKey myDesKey3 = MyKeyFactory.generateSecret(myMaterial3);

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
                        byte[] encryptedPacket = TDESdecrypt(buffer, myDesKey1, myDesKey2, myDesKey3, myCipher, ivSpec);
                        outputStream.write(encryptedPacket);
                    }
                    System.out.println("Processing done in " + (System.currentTimeMillis() - start) + " millsiseconds");
                } catch (Exception e) {
                    e.printStackTrace();
                }


                break;
            }
        }

        System.out.println("done. Pockets: " + packetNum );

    }
}




