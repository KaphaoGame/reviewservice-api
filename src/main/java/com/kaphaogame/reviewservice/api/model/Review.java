package com.kaphaogame.reviewservice.api.model;

public class Review {
    private String username;
    private String gameName;
    private String gameTag;
    private int story;
    private int gameplay;
    private int graphic;
    private int performance;
    private int sound;
    private String comments;

    public Review() {
    }

    public Review(String username, String gameName, String gameTag, int story, int gameplay, int graphic, int performance, int sound, String comments) {
        this.username = username;
        this.gameName = gameName;
        this.gameTag = gameTag;
        this.story = story;
        this.gameplay = gameplay;
        this.graphic = graphic;
        this.performance = performance;
        this.sound = sound;
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getGameplay() {
        return gameplay;
    }

    public void setGameplay(int gameplay) {
        this.gameplay = gameplay;
    }

    public int getGraphic() {
        return graphic;
    }

    public void setGraphic(int graphic) {
        this.graphic = graphic;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGameTag() {
        return gameTag;
    }

    public void setGameTag(String gameTag) {
        this.gameTag = gameTag;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
