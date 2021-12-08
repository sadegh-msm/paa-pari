package src.main.java;

public class ReplyingSystem extends Pari{
    private Account user;
    private Pari repliedOn;
    private String content;

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }


}
