package com.example.springboothelloworld.Service.GOF.Command;


import java.util.Stack;

public class CommandModeControl implements Control {

    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> stack = new Stack<>();


    public CommandModeControl() {
        onCommands = new Command[5];
        offCommands = new Command[5];
        NoCommand noCommand = new NoCommand();
        for (int i = 0; i < 5; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommands(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    @Override
    public void OnButton(int slot) {
        onCommands[slot].execute();
        stack.push(onCommands[slot]);
    }

    @Override
    public void OffButton(int slot) {
        offCommands[slot].execute();
        stack.push(offCommands[slot]);
    }

    @Override
    public void undoButton() {
        stack.pop().undo();
    }
}