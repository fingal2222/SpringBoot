package com.example.springboothelloworld.Service.GOF.Command;

public class Stereo {
    private static int volume = 0;

    public Stereo() {
    }

    public void On() {
        System.out.println("open the stereo");
    }

    public void Off() {
        System.out.println("close the stereo");
    }

    public void setCd() {
        System.out.println("cd is setting");
    }

    public int getVol() {
        return volume;
    }

    public void setVol(int vol) {
        this.volume = vol;
        System.out.println("stereo volume is " +volume);
    }


}
