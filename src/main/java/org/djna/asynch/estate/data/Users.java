package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.List;

public class Users {

    public List<User> getListOfUsers() {

        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add( new User("houseUser1", "pinkbun123_1"));
        listOfUsers.add( new User("houseUser2", "pinkbun123_2"));
        listOfUsers.add( new User("houseUser3", "pinkbun123_3"));
        listOfUsers.add( new User("houseUser4", "pinkbun123_4"));
        listOfUsers.add( new User("houseUser5", "pinkbun123_5"));
        listOfUsers.add( new User("houseUser6", "pinkbun123_6"));
        listOfUsers.add( new User("houseUser7", "pinkbun123_7"));
        listOfUsers.add( new User("houseUser8", "pinkbun123_8"));
        listOfUsers.add( new User("estateOwner", "redflag62"));
        listOfUsers.add( new User("handyMan", "greencup34"));

        return listOfUsers;
    }


}
