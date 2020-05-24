package org.dnd.dnddiscordbot.modules.sftp;

public class SFTPBuilder {

    String host;
    int port;
    String user;
    String password;

    public SFTPBuilder(){
        this.host = null;
        this.port = 22;
        this.user = null;
        this.password = null;
    }

    public SFTPBuilder setHost(String host){
        this.host = host;
        return this;
    }

    public SFTPBuilder setPort(int port){
        this.port = port;
        return this;
    }

    public SFTPBuilder setUser(String user){
        this.user = user;
        return this;
    }

    public SFTPBuilder setPassword(String password){
        this.password = password;
        return this;
    }

    public SFTPConnection build(){
        return new SFTPConnection(
                this.host,
                this.port,
                this.user,
                this.password
        );
    }
}
