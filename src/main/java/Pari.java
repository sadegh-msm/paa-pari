package src.main.java;

import java.time.LocalDate;

public class Pari {
    private Account user;
    private int likes;
    private String content;
    private LocalDate localDate;

    public Pari(){
        user = new Account();
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(content.length() <= 256){
            this.content = content;
        }else {
            System.out.println("Your content is more than 256 characters Enter again");
            setContent(content);
        }

    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate() {
        this.localDate = LocalDate.now();
    }
}
