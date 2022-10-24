import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //long start = System.currentTimeMillis();
        //long start = System.nanoTime();

        File file = new File("inputs//input_AoC_5b.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> listOfStrings = new ArrayList<>();

        String s;
        //put Strings in array
        while ((s = br.readLine()) != null) {
            if (s.isBlank()) continue;

            listOfStrings.add(s);
        }

        //long end1 = System.currentTimeMillis();
        //long end1 = System.nanoTime();
        int countOfNiceStrings = 0;

        for(String g : listOfStrings) {
            //condition 2

            boolean isExactlyOneLetterBetween = false;

            for(int i = 0; i < g.length()-2; i++){
                char c1 = g.charAt(i);
                char c2 = g.charAt(i+2);
                if(g.charAt(i) == g.charAt(i+2))
                    isExactlyOneLetterBetween = true;
            }

            if(!isExactlyOneLetterBetween)
                continue;

            //condition 1

            boolean isContainsAPair = false;

            for(int i = 0; i < g.length()-1; i++){
                String str = g.substring(i, i+2);

                for (int j = i+2; j < g.length()-1; j++) {
                    String c3 = g.substring(j, j + 2);
                    if (str.equals(g.substring(j, j + 2)) && i != j){

                        isContainsAPair = true;
                    }

                }
            }


            if (isContainsAPair && isExactlyOneLetterBetween)
                countOfNiceStrings++;
        }

        System.out.println(countOfNiceStrings);

        //long end2 = System.currentTimeMillis();
        //long end2 = System.nanoTime();

//        System.out.println("Time for whole project: " + (end2 - start));
//        System.out.println("Time for reading txt file: " + (end1 - start));
//        System.out.println("Time for executing tests: " + (end2 - end1));
    }
}