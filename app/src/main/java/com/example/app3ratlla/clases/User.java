package com.example.app3ratlla.clases;

public class User implements Comparable<User>{
    private int profileImage;
    private String username;
    private int score;

    public User(int profileImage, String username, int score) {
        this.profileImage = profileImage;
        this.username = username;
        this.score = score;
    }


    public int getProfileImage() {
        return profileImage;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(User otherUser) {
        return otherUser.getScore() - this.score;
    }
}
