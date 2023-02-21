import java.io.*;
import java.util.Arrays;


public class Scrambler {

    protected Scrambler(){}


    public Scrambler (int key){
        if (key >= 0 && key < 71) {
            this.key = key;
        } else {
            throw new InvalidKey("Ключ должен быть в диапазоне от 0 до 70");
        }
    }

    public int getKey() {
        return key;
    }

    private int key;

    public char[] getAlphabet() {
        return alphabet;
    }

    private final char[] alphabet = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й',
            'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я', '.', ',', '"',
            ':', '-', '!', '?', ' '};

    public char[] getEcnrAlphabet() {
        return ecnrAlphabet;
    }

    public void setEcnrAlphabet(char[] ecnrAlphabet) {
        this.ecnrAlphabet = ecnrAlphabet;
    }

    private char[] ecnrAlphabet = Arrays.copyOf(getAlphabet(), getAlphabet().length);




    public char[] shiftArray(char[] array){
        char [] encrArray = Arrays.copyOf(array, array.length);
        if (key > 0){
            for (int i = 0; i < key; i++) {
                char tmp = encrArray[encrArray.length-1];
                for (int j = encrArray.length - 1; j > 0; j--) {
                    encrArray[j] = encrArray[j - 1];
                }
                encrArray[0] = tmp;
            }
        }else {
            for (int i = 0; i > key; i--) {
                char tmp = encrArray[0];
                for (int j = 1; j < encrArray.length; j++) {
                    encrArray[j - 1] = encrArray[j];
                }
                encrArray[encrArray.length - 1] = tmp;
            }
        }
        return encrArray;
    }

    public String comparison(char[] text, char[] b){
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (text[i] == b[j]) {
                    text[i] = ecnrAlphabet[j];
                    break;
                }
            }
        }
        return String.valueOf(text);
    }

    public String comparisonBack(char[] enctText, char[] b){
        for (int i = 0; i < enctText.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (enctText[i] == b[j]){
                    enctText[i] = alphabet[j];
                    break;
                }
            }
        }
        return String.valueOf(enctText);
    }
}
