package CountLittersText;
import java.io.*;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnalysText {
    private static Map<Character, Integer> map = new HashMap<>();

    private static Map<Character, Integer> calculate(String text) {
        for (char sym: text.toCharArray()) {
            if (Character.isLetter(sym)) {
                if (map.containsKey(sym)) {
                    map.put(sym, map.get(sym) + 1);
                } else map.put(sym, 1);
            }
        }
        System.out.println(map.toString());
        return map;
    }

    public static Map<Character, Integer> countLitters(String file_path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader inStream = new FileReader(file_path);

        String text = "";
        while (true){
            char sym = (char)inStream.read();
            if (sym == '/') break;
            text += sym;
        }
        return calculate(text);
    }

    public static void mostFrequentLitters(String file_path) throws IOException {
        Map<Character,Integer> litters = map;
        Character mostFrequent = 'а'; Integer count = 0;

        for (Map.Entry<Character, Integer> entry : litters.entrySet()) {
            if (entry.getValue() > count) {
                mostFrequent = entry.getKey();
                count = entry.getValue();
            }
        }
        System.out.println("Самый частый: " + mostFrequent + ", встретился: " + count + "раз");
    }
}
