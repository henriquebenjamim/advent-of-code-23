import java.io.BufferedReader;
import java.io.FileReader;

public class Day1 {
    public static void main(String[] args) {

        String exampleText = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet 
                """;

        try {
            String currentDir = System.getProperty("user.dir");
            BufferedReader br = new BufferedReader(new FileReader(currentDir + "/src/files/day1-input.txt"));
            int totalValue = 0;
            for (String lineFromText : br.lines().toList()) {
                int firstDigit = -1;
                int lastDigit = -1;
                for (String s : lineFromText.split("")) {
                    if (Character.isDigit(s.charAt(0))) {
                        if (firstDigit == -1) {
                            firstDigit = Integer.parseInt(s);
                        }
                        lastDigit = Integer.parseInt(s);
                    }
                }
                firstDigit *= 10;
                totalValue += firstDigit + lastDigit;
            }
            System.out.println(totalValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}