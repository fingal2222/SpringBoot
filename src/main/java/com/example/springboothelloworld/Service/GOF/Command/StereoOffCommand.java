package com.example.springboothelloworld.Service.GOF.Command;

public class StereoOffCommand implements  Command {
    private  Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.Off();
    }

    @Override
    public void undo() {
        stereo.On();
    }
}
