package com.example.magnumaakankshaboral;

public class GitList {

    public GitList(String login_name) {
        this.login_name = login_name;
    }

    String login_name;

    public GitList(String login_name, String image_url, String image_name) {
        this.login_name = login_name;
        this.image_url = image_url;
        this.image_name = image_name;
    }

    String image_url;
    String image_name;

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }


}
