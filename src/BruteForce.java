import java.io.*;
import java.util.Arrays;
import java.util.Set;

public class BruteForce {
    Scrambler scrambler = new Scrambler();

    Set <String> dictionary = Set.of("год", "человек", "время", "дело", "жизнь", "день", "привет", "друг", "пробный");


    public void hacking(String pathToEncrFile, String writeFile){
        try (BufferedReader br = new BufferedReader(new FileReader(pathToEncrFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile)))
        {
            String line;
            String compStr;
            String[] words;
            char[] tmp = scrambler.getAlphabet();
            br.mark(1);
            while (br.ready()) {
                line = br.readLine();
                if (flag){
                    br.reset();
                    while (br.ready()) {
                        line = br.readLine();
                        bw.write(scrambler.comparisonBack(line.toCharArray(), tmp) + "\n");
                    }
                }

                for (int i = 0; i < scrambler.getAlphabet().length; i++) {
                    tmp = shiftArray(scrambler.getAlphabet(), i);
                    compStr = scrambler.comparisonBack(line.toCharArray(), tmp);
                    words = compStr.split("\\s");
                    if (checkWords(words, dictionary)) {
                        flag = true;
                        break;
                    }
                }
            }



        }
        catch (FileNotFoundException e){
            throw new FileNotFoundEx("Файла по данному пути не найдено, введите другой путь или создайте файл");

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean checkWords(String[] words, Set <String> dictionary){
        for (String word:words) {
            if (dictionary.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public char[] shiftArray (char[] array, int positions){
        char [] encrArray = Arrays.copyOf(array, array.length);
            for (int i = 0; i < positions; i++) {
                char tmp = encrArray[encrArray.length-1];
                for (int j = encrArray.length - 1; j > 0; j--) {
                    encrArray[j] = encrArray[j - 1];
                }
                encrArray[0] = tmp;
            }
            return encrArray;
    }
    private boolean flag = false;

}
