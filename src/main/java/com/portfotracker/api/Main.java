package com.portfotracker.api;

import com.portfotracker.utils.FileManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> dir = new ArrayList<String>();

        dir.add("x");
        dir.add("y");
        dir.add("z");

        FileManager.createFile("x.json", dir);


    }
}
