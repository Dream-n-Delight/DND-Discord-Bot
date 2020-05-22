package org.dnd.dnddiscordbot.modules.profile;

import com.jcraft.jsch.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProfileBuilder {

    private static String rndName;

    public static String CreateProfilePicture(String profilePicture_url, String rankIcon_url) throws IOException {

        Image profilePicture = ImageIO.read(new File(profilePicture_url));
        profilePicture = profilePicture.getScaledInstance(70, 70, Image.SCALE_SMOOTH);

        Image rankIcon = ImageIO.read(new File(rankIcon_url));
        rankIcon = rankIcon.getScaledInstance(25, 25, Image.SCALE_SMOOTH);

        BufferedImage newimg = new BufferedImage(80,80, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = newimg.createGraphics();

        graphics.drawImage(profilePicture,0,0,null);

        graphics.setColor(new Color(36,49,68));
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        graphics.setComposite(alphaComposite);
        graphics.fillOval(48,48,30,30);

        AlphaComposite alphaComposite2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
        graphics.setComposite(alphaComposite2);
        graphics.setColor(new Color(36,49,68));
        graphics.fillOval(48,48,29,29);

        graphics.drawImage(rankIcon, 51, 51, null);

        File tmpFile = new File("output.png");
        ImageIO.write(newimg,"png", tmpFile);

        UploadFile(new FileInputStream(tmpFile));

        tmpFile.deleteOnExit();

        return "http://dehys.com/media/profile_pictures/"+rndName+".png";


    }

    private static void UploadFile(InputStream inputStream){
        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("", "");
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("");
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;

            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            java.util.Random random = new java.util.Random();

            rndName = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            sftpChannel.put(inputStream, "../var/www/html/media/profile_pictures/"+rndName+".png");
            sftpChannel.exit();
            session.disconnect();

            System.out.println("http://dehys.com/media/profile_pictures/"+rndName+".png");

        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
    }


}
