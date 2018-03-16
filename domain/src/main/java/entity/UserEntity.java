package entity;

/**
 * Created by Erizo on 14.03.2018.
 */

public class UserEntity {

    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    private String profileUrl;

    public UserEntity() {
    }

    public UserEntity(String userName, int age, String progileUrl) {
        this.userName = userName;
        this.age = age;
        this.profileUrl = progileUrl;
    }


}