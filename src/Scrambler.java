import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


public class Alphabet {


    public char[] getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    private char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                       'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й',
                        'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я', '.', ',', '"',
                        ':', '-', '!', '?', ' '};

    private int key;
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if (key > 0 && key < 71)
        this.key = key;
        else {
            System.out.println("Ключ должен быть в диапазоне от 0 до 71");
        }
    }
    public void encryption(String str, int Key) {
        setKey(Key);
        try (FileReader in = new FileReader(str);
             BufferedReader bufferedReader = new BufferedReader(in)){
            while (bufferedReader.ready()){
                String line = bufferedReader.readLine();
                char[] chars = line.toCharArray();


//                System.out.println(shiftArray(alphabet, getKey()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //Этот метод сдвигает массив чаров на число key
    //В Key передаем наш ключ
    public char[] shiftArray(char[] array, int key){
        char [] encrArray = Arrays.copyOf(array, array.length);
        if (key > 0){
            for (int i = 0; i < key; i++) {
                char tmp = encrArray[encrArray.length-1];
                for (int j = encrArray.length - 1; j > 0; j--) {
                    encrArray[j] = encrArray[j-1];
                }
                encrArray[0] = tmp;
            }
        }
        return encrArray;
    }
    public String comparison(char[] a, char[] b){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {



            }
        }

        return "Null";
    }


}
