package com.example.springboothelloworld.Service.GOF.Command;

public class Stimulate {
    public static void main(String[] args) {
        Light light=new Light("bedroom");
        Stereo stereo=new Stereo();
        CommandModeControl commandModeControl=new CommandModeControl();
        commandModeControl.setCommands(0,new LightOnCommand(light),new LightOffCommand(light));
        commandModeControl.setCommands(1,new StereoOnCommand(stereo),new StereoOffCommand(stereo));
        commandModeControl.setCommands(2,new StereoAddVolCommand(stereo),new StereoSubVolCommand(stereo));
        commandModeControl.OnButton(0);
        commandModeControl.OffButton(0);
        commandModeControl.OnButton(1);
        commandModeControl.OnButton(2);

        commandModeControl.OnButton(2);
        commandModeControl.OffButton(2);
        commandModeControl.OffButton(1);
    }
}
