package controller;

import common.Library;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import view.Menu;

public class CountProgramming extends Menu<String> {

    static String[] mc = {"Letter Count", "Character Count", "Exit"};
    String str;
    Library l;

    public CountProgramming() {
        super("PROGRAMMING", mc);
        l = new Library();
        str = l.getString("Input string: ");
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                countLetter(str);
                break;
            case 2:
                str = str.replaceAll("\\s|\\p{Punct}+", "");
                countCharacter(str);
                break;
            case 3:

                System.exit(0);
        }
    }

    public void countLetter(String str) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        StringTokenizer tokenizer = new StringTokenizer(str, " \t\n\r\f!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            int count = lhm.getOrDefault(token, 0);
            lhm.put(token, count + 1);
        }

        lhm.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }

    public void countCharacter(String str) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }
            lhm.put(ch + "", count);
        }

        lhm.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
}
