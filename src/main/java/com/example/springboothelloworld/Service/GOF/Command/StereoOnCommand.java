package com.example.springboothelloworld.Service.GOF.Command;

public class StereoOnCommand implements  Command {
    private  Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.On();
        stereo.setCd();
    }

    @Override
    public void undo() {
    stereo.Off();
    }
}
