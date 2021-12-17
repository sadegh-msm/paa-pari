package src.main.java;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The type Replying system.
 */
public class ReplyingSystemImpl extends Pari implements ReplyingSystem{
    private Account user;
    private ArrayList<Pari> replyParies;
    private String content;

    /**
     * Instantiates a new Replying system.
     */
    public ReplyingSystemImpl() {
        this.user = new Account();
        this.replyParies = new ArrayList<>();
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        if (content.length() <= 256){
            this.content = content;
        } else {
            System.out.println("Out of Bound please enter again!");
            setContent(content);
        }
    }

    /**
     * Reply on pari.
     *
     * @param repliedOn the replied on
     */
    public void replyOnPari(Pari repliedOn) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the reply of the pari");
        String content = scanner.nextLine();
        Pari reply = new Pari();
        reply.setAll(content);
        replyParies.add(reply);
    }

    /**
     * Print replied paries.
     */
    public void printReplied() {
        int flag = replyParies.size();

        if (flag == 1){
            System.out.println("---| " + replyParies.get(1).getWriter());
            System.out.println("---| " + replyParies.get(1).getContent());
            System.out.println("---| " + replyParies.get(1).getLikes() + "\t\t" + replyParies.get(1).getLocalDateOfPari());
        } else if (flag == 2){
            System.out.println("------| " + replyParies.get(2).getWriter());
            System.out.println("------| " + replyParies.get(2).getContent());
            System.out.println("------| " + replyParies.get(2).getLikes() + "\t\t" + replyParies.get(2).getLocalDateOfPari());
        } else if (flag == 3){
            System.out.println("---------| " + replyParies.get(3).getWriter());
            System.out.println("---------| " + replyParies.get(3).getContent());
            System.out.println("---------| " + replyParies.get(3).getLikes() + "\t\t" + replyParies.get(3).getLocalDateOfPari());
        }
    }
}
