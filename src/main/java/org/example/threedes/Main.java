package org.example.threedes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.example.threedes.Des.DES;

class Main {
    public static void main(String arg[]){

        Path filePath = Paths.get("src/main/resources/puni/Environment/Island.png");  // Adjust path as needed
        try {
            DES(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
