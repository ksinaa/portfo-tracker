package com.portfotracker.portfo;

import com.portfotracker.utils.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Portfo {

    public void addCoin(Coin coin) throws IOException {

        FileManager.createFile("coins.json");

        //TODO adding Write Json file to FileManager and manage adding coin here

        
    }

}
