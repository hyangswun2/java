package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Volume Level: ");
        int volumeLevel = scanner.nextInt();

        if (volumeLevel < 0 || volumeLevel > 100) {
            System.out.println("Enter Number within the Range(0 ~ 100).");
            return;
        }

        try {
            String desktopPath = System.getProperty("user.home") + "\\Desktop\\";

            String batFilePath = desktopPath + "set_volume.bat";
            String batFileContent = "@echo off\n" +
                    "setlocal enabledelayedexpansion\n" +
                    "set /a volumeLevel=" + volumeLevel + "\n" +
                    "powershell -Command \"(Get-WmiObject -Query \\\"Select * from Win32_SoundDevice\\\").SetMasterVolume(!volumeLevel!)\"";


            BufferedWriter writer = new BufferedWriter(new FileWriter(batFilePath));
            writer.write(batFileContent);
            writer.close();

            String powershellCommand = "powershell.exe -ExecutionPolicy Bypass -Command \"& '" + batFilePath + "'\"";
            Process process = Runtime.getRuntime().exec(powershellCommand);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
