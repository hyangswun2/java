package org.example;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class Main {
    public interface VolumeControl extends Library {
        VolumeControl INSTANCE = Native.load(Platform.isWindows() ? "winmm" : "c", VolumeControl.class);
        void waveOutSetVolume(int uDeviceID, int dwVolume);
    }

    public static void main(String[] args) {
        int volumeLevel = 50;

        int normalizedVolume = (int) (volumeLevel * 655.35);

        try {
            VolumeControl.INSTANCE.waveOutSetVolume(0, normalizedVolume);

            System.out.println("Done.");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Error.");
        }
    }
}
