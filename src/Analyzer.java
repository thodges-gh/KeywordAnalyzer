import java.util.*;

/**
 * Created by Thomas Hodges on 7/24/15.
 */
public class Analyzer {


    private String[] singleLine;

    public Analyzer(String[] input) {
        this.singleLine = input;
    }

    public void wordCount() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < singleLine.length; i++) {
            list.add(this.singleLine[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        Map<String, Integer> sortedMap = new TreeMap<>(map);
        getWordInDescendingFreqOrder(sortedMap);

    }

    static void getWordInDescendingFreqOrder(Map<String, Integer> wordCount) {

        // Convert map to list of <String,Integer> entries
        List<Map.Entry<String, Integer>> list =
                new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());

        // Sort list by integer values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // compare o2 to o1, instead of o1 to o2, to get descending freq. order
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // Populate the result into a list
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
            System.out.println(entry.getKey() + " : "
                    + entry.getValue());
        }

    }

}
