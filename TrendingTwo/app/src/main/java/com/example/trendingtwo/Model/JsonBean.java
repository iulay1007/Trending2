package com.example.trendingtwo.Model;

import java.util.List;

public class JsonBean {
    /**
     * author : corona-warn-app
     * name : cwa-server
     * avatar : https://github.com/corona-warn-app.png
     * url : https://github.com/corona-warn-app/cwa-server
     * description : Backend implementation for the Apple/Google exposure notification API.
     * language : Java
     * languageColor : #b07219
     * stars : 370
     * forks : 33
     * currentPeriodStars : 226
     * builtBy : [{"username":"michael-burwig","href":"https://github.com/michael-burwig","avatar":"https://avatars1.githubusercontent.com/u/64439292"},{"username":"pithumke","href":"https://github.com/pithumke","avatar":"https://avatars0.githubusercontent.com/u/8984460"},{"username":"johanneseschrig","href":"https://github.com/johanneseschrig","avatar":"https://avatars0.githubusercontent.com/u/6208191"},{"username":"ole-lilienthal","href":"https://github.com/ole-lilienthal","avatar":"https://avatars0.githubusercontent.com/u/1227839"},{"username":"christian-kirschnick","href":"https://github.com/christian-kirschnick","avatar":"https://avatars1.githubusercontent.com/u/64424068"}]
     */

    private String author;
    private String name;
    private String avatar;
    private String url;
    private String description;
    private String language;
    private String languageColor;
    private int stars;
    private int forks;
    private int currentPeriodStars;
    private List<BuiltByBean> builtBy;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getCurrentPeriodStars() {
        return currentPeriodStars;
    }

    public void setCurrentPeriodStars(int currentPeriodStars) {
        this.currentPeriodStars = currentPeriodStars;
    }


    public List<BuiltByBean> getBuiltBy() {
        return builtBy;
    }

    public void setBuiltBy(List<BuiltByBean> builtBy) {
        this.builtBy = builtBy;
    }

    public static class BuiltByBean {
        /**
         * username : michael-burwig
         * href : https://github.com/michael-burwig
         * avatar : https://avatars1.githubusercontent.com/u/64439292
         */

        private String username;
        private String href;
        private String avatar;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
