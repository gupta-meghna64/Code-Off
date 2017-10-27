package com.example.codeoff;

/**
 * Created by HP on 27-10-2017.
 */

public class User {

    public String Name;
    public String emailID;
    public String typeOfUser;
    public String imageID;
    public int yearOfPassing;
    public String githubLink;
    public String linkedinLink;
    public String websiteLink;


    public String getNm() {
        return Name;
    }

    public void setNam(String name) {
        Name = name;
    }

    public String getMail() {
        return emailID;
    }

    public void setEmail(String emailID) {
        emailID = emailID;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }




}
