package src.main.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PariService extends Pari {
    private ArrayList<Pari> paries;

    public PariService() {
        paries = new ArrayList<>();
    }

    public void writeTweet(String filename) {
        Pari pari = new Pari();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        pari.setContent(str);
        paries.add(pari);
        writeToFile(paries, paries.indexOf(pari), true,filename);
    }

    public void removeTweet(String filename, int index) {
        Iterator<Pari> iterator = paries.iterator();
        while (iterator.hasNext()) {
            if (correctIndex(index)) {
                paries.remove(index);
                writeToFile(paries, index, false,filename);
            } else {
                System.out.println("Wrong index");
                removeTweet(filename, index);
            }
        }
    }

    public void writeToFile(ArrayList<Pari> messages, int index, boolean bool, String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename, bool);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if (correctIndex(index)) {
                bufferedWriter.write(messages.get(index).getContent());
                bufferedWriter.close();
                fileWriter.close();
            } else {
                System.out.println("Wrong index");
                writeToFile(messages, index, bool, filename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean correctIndex(int index) {
        if (index < paries.size()) {
            System.out.println("Out of Bound");
            return false;
        }
        return true;
    }

}
