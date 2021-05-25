package com.portfotracker.utils;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.List;

public class FileManager {

    public static void createFile(String fileName) throws IOException {

        //Create ROOT/data directory if not exist
        FileManager.createDataDir();

        //try to create file in ROOT/data/filename
        try {
            File jsonFile = new File(System.getProperty("user.dir") + "/data/" + fileName);
            jsonFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void createFile(String fileName, List<String> path) throws IOException {

        FileManager.createNestedDir(path);

        String rootPath = System.getProperty("user.dir") + "/data";

        for (int i = 0; i < path.size(); i++) {
            rootPath = rootPath + "/" + path.get(i);
        }

        try {
            File jsonFile = new File(rootPath + "/" + fileName);
            jsonFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createDataDir(){
        File dir = new File(System.getProperty("user.dir") + "/data");

        if(!dir.exists()){
            dir.mkdir();
        }
    }

    private static void createNestedDir(List<String> path){
        FileManager.createDataDir();

        String rootPath = System.getProperty("user.dir") + "/data";

        for (String dir:path) {
            File directory = new File(rootPath);
            if(!directory.exists()){
                directory.mkdir();
            }

            rootPath = rootPath + "/" + dir;
        }
        File directory = new File(rootPath);
        if(!directory.exists()){
            directory.mkdir();
        }

    }
}
