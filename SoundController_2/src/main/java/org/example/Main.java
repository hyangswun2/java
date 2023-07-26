package org.example;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input : ");
        int volume = scanner.nextInt();

        if (volume < 0 || volume > 100) {
            System.out.println("Invalid");
            return;
        }

        String desktopPath = System.getProperty("user.home") + "\\Desktop\\";
        String batFilePath = desktopPath + "volume.bat";

        try {

            FileWriter fileWriter = new FileWriter(batFilePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);


            InputStream nircmdStream = Main.class.getResourceAsStream("/nircmd.exe");

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = nircmdStream.read(buffer)) != -1) {
                fileWriter.write(new String(buffer, 0, bytesRead));
            }
            printWriter.println();
            printWriter.println("@echo off");
            printWriter.println("nircmd.exe setsysvolume " + volume);
            printWriter.close();


            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", batFilePath);
            builder.redirectErrorStream(true);
            Process process = builder.start();


            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();

            System.out.println("Done.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}