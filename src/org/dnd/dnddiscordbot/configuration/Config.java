package org.dnd.dnddiscordbot.configuration;

import org.dnd.dnddiscordbot.tools.TextFileManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Config {

    private File configurationFile = new File("config.txt");
    private static TextFileManager tfm = new TextFileManager();

    public Config() throws IOException {
        validateConfigurationFile();
    }

    public Config(File configurationFile) throws IOException {
        this.configurationFile = configurationFile;
        validateConfigurationFile();
    }

    private void validateConfigurationFile() throws IOException {
        if (!tfm.fileExists(configurationFile)){
            List<String> lines = Arrays.asList("token = YOUR_DISCORD_BOT_TOKEN", "prefix = !");

            Files.write(configurationFile.toPath(),
                    lines,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            System.out.println("Configuration file created.");
        }
    }

    private String getContent(String key) throws IOException {
        String[] fileContents = tfm.read(this.configurationFile);
        String content = null;

        for (String s : fileContents){
            if (s.startsWith(key)){
                content = s.split("=")[1].replaceFirst(" ", "");
            }
        }
        return content;
    }

    public String getBotToken() throws IOException {
        return getContent("token").replaceAll(" ", "");
    }

    public String getPrefix() throws IOException {
        return getContent("prefix");
    }
}
