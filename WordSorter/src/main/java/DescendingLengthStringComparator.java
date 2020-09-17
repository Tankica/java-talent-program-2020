import java.util.Comparator;

public class DescendingLengthStringComparator implements Comparator<String> {

    public int compare(String word1, String word2) {
        return word2.length() - word1.length();
    }
}
