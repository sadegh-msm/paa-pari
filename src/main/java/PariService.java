package src.main.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * The type Pari service.
 */
public class PariService extends Pari {
    private ArrayList<Pari> paries;

    /**
     * Instantiates a new Pari service.
     */
    public PariService() {
        paries = new ArrayList<>();
    }

    /**
     * Write a new pari.
     *
     * @param filename the filename
     */
    public void writePari(String filename) {
        Pari pari = new Pari();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        pari.setContent(str);
        paries.add(pari);
        writeToFile(paries, paries.indexOf(pari), true,filename);
    }

    /**
     * Remove a Pari.
     *
     * @param filename the filename
     * @param index    the index
     */
    public void removePari(String filename, int index) {
        Iterator<Pari> iterator = paries.iterator();
        while (iterator.hasNext()) {
            if (correctIndex(index)) {
                paries.remove(index);
                writeToFile(paries, index, false,filename);
            } else {
                System.out.println("Wrong index");
                removePari(filename, index);
            }
        }
    }

    /**
     * Writes the pari to file.
     *
     * @param messages the messages
     * @param index    the index
     * @param bool     the bool
     * @param filename the filename
     */
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


    /**
     * checks if the index is true or not.
     *
     * @param index the index
     * @return the boolean
     */
    public boolean correctIndex(int index) {
        if (index < paries.size()) {
            System.out.println("Out of Bound");
            return false;
        }
        return true;
    }

}
