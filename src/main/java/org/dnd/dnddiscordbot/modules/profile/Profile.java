package org.dnd.dnddiscordbot.modules.profile;

import net.dv8tion.jda.api.entities.User;

public class Profile {

    ProfileBuilder profileBuilder;
    User user;
    String profilePicture;
    String[] links;

    Profile(ProfileBuilder profileBuilder, User user, String profilePicture, String[] links){

        this.profileBuilder = profileBuilder;
        this.user = user;
        this.profilePicture = profilePicture;
        this.links = links;

    }

}
