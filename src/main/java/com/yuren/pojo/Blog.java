package com.yuren.pojo;

public class Blog {
    private int essayNum;
    private int commentNum;
    private int runningDays;
    private int views;

    public Blog() {
    }

    public Blog(int essayNum, int commentNum, int runningDays, int views) {
        this.essayNum = essayNum;
        this.commentNum = commentNum;
        this.runningDays = runningDays;
        this.views = views;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "essayNum=" + essayNum +
                ", commentNum=" + commentNum +
                ", runningDays=" + runningDays +
                ", views=" + views +
                '}';
    }

    public int getEssayNum() {
        return essayNum;
    }

    public void setEssayNum(int essayNum) {
        this.essayNum = essayNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getRunningDays() {
        return runningDays;
    }

    public void setRunningDays(int runningDays) {
        this.runningDays = runningDays;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
