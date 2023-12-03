import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Day1 {
    public static void main(String[] args) {

        Map<String, String> numbersOnString = new HashMap<>();

        numbersOnString.put("one", "1");
        numbersOnString.put("two", "2");
        numbersOnString.put("three", "3");
        numbersOnString.put("four", "4");
        numbersOnString.put("five", "5");
        numbersOnString.put("six", "6");
        numbersOnString.put("seven", "7");
        numbersOnString.put("eight", "8");
        numbersOnString.put("nine", "9");

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input/day1.txt"));
            int totalValue = 0;
            for (String line : br.lines().toList()) {

                int index = 10000;
                while (index == 10000) {
                    String first = "";
                    for (Map.Entry<String, String> entry : numbersOnString.entrySet()) {
                        int pos = line.indexOf(entry.getKey());
                        if (pos != -1 && pos < index) {
                            index = line.indexOf(entry.getKey());
                            first = entry.getKey();
                        }
                    }
                    index = -1;
                    if (numbersOnString.containsKey(first)) {
                        line = line.replaceFirst(first, numbersOnString.get(first));
                        index = 10000;
                    }
                }
                int first = -1;
                int lastDigit = -1;
                for (String s : line.split("")) {
                    if (Character.isDigit(s.charAt(0))) {
                        if (first == -1) {
                            first = Integer.parseInt(s);
                        }
                        lastDigit = Integer.parseInt(s);
                    }
                }
                first *= 10;
                totalValue += first + lastDigit;
            }
            System.out.println(totalValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}