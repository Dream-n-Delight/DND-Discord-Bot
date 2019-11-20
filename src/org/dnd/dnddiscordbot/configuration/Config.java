package org.dnd.dnddiscordbot.configuration;

import org.dnd.dnddiscordbot.tools.TextFileManager;

import java.io.File;

public class Config {

    private File configurationFile = new File("./config.json");
    private static TextFileManager tfm = new TextFileManager();

    public Config(){
        //Check if configurationFile is valid
    }

    public Config(File configurationFile){
        this.configurationFile = configurationFile;
        //Check if configurationFile is valid
    }

    private String getContent(String key){
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

    public String getBotToken(){
        return getContent("token");
    }

    public String getOwner(){
        return getContent("owner");
    }
}
