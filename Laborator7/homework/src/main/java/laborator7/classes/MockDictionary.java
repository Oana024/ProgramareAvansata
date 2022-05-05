package laborator7.classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MockDictionary extends Dictionary {
    List<String> dictionary = new ArrayList<>();

    @Override
    public boolean isWord(String word) {
        return dictionary.contains(word);
    }

    public MockDictionary() {
        try {
            File myObj = new File("src/main/resources/dictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                dictionary.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public String getWord(int index) {
        return dictionary.get(index);
    }

    @Override
    public int getSize() {
        return dictionary.size();
    }
}
