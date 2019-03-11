package com.example.springboothelloworld.Service.GOF.Command;

public interface Control {
    void OnButton(int slot);
    void OffButton(int slot);
    void undoButton();
}
