package org.dnd.dnddiscordbot.modules.sftp;

import java.io.File;

public class SFTPConnection {

    String host;
    int port;
    String user;
    String password;

    SFTPConnection(String host, int port, String user, String password){

        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;

    }

    public UploadFile uploadFile(File file, String path){
        return new UploadFile(file, path);
    }



}
