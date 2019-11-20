package org.dnd.dnddiscordbot.configuration;

import org.dnd.dnddiscordbot.tools.TextFileManager;

import java.io.File;
import java.io.IOException;

public class Config {

    private File configurationFile = new File("./config.txt");
    private static TextFileManager tfm = new TextFileManager();

    public Config(){
        try {
            configurationFile.createNewFile();
            System.out.println("Configuration file created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Config(File configurationFile){
        this.configurationFile = configurationFile;
        //Check if configurationFile is valid
    }

    private String getContent(String key) throws IOException {
        String[] fileContents = tfm.read(this.configurationFile);
        String content = null;

        for (String s : fileContents){
            if (s.startsWith(key)){
                content = s.split("=")[1];
                if (content.startsWith(" ")) content.replaceFirst(" ", "");
            }
        }
        return content;
    }

    public String getBotToken() throws IOException {
        return getContent("token");
    }

    public String getOwner() throws IOException {
        return getContent("owner");
    }
}
