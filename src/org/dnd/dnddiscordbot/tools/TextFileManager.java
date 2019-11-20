package org.dnd.dnddiscordbot.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileManager {
    public TextFileManager(){
    }

    public String[] read(File file) throws IOException {
        List<String> fileContents = new ArrayList<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            fileContents.add(line);
        }
        return fileContents.toArray(new String[0]);
    }

    public void write(File file, String[] args) throws IOException{
        FileWriter writer = new FileWriter(file);
        for (String line : args){
            writer.write(line+"\n");
        }
    }
}
