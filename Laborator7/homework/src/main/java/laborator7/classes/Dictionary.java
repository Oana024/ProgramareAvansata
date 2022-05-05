package laborator7.classes;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<String> dictionary = new ArrayList<>();

    public boolean isWord(String word) {
        return dictionary.contains(word);
    }
    public String getWord(int index) {
        return dictionary.get(index);
    }
    public int getSize() {
        return dictionary.size();
    }
}
