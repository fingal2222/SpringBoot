package com.example.springboothelloworld.Service.GOF.Command;

public class StereoAddVolCommand implements  Command {

    private  Stereo stereo;

    public StereoAddVolCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        int volume=stereo.getVol();
        if (volume < 12) {
            stereo.setVol(++volume);
        }
    }

    @Override
    public void undo() {
        int volume=stereo.getVol();
        if (volume>0) {
            stereo.setVol(--volume);
        }
    }
}
