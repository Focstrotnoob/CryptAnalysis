import java.io.*;
import java.io.FileNotFoundException;

public class ReaderWriter {
    public void readingEncryptWrite(String readFile, String writeFile, Scrambler scrambler){
        try (BufferedReader br = new BufferedReader(new FileReader(readFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile)))
        {
            scrambler.setEcnrAlphabet((scrambler.shiftArray(scrambler.getAlphabet())));
            String line;
            char[] array;
            while (br.ready()){
                line = br.readLine() + "\n";
                array = line.toCharArray();
                bw.write(scrambler.comparison(array, scrambler.getAlphabet()));
            }

        }
        catch (FileNotFoundException e){
            throw new FileNotFoundEx("Файла по данному пути не найдено, введите другой путь или создайте файл");

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void readingDecryptWrite(String readFile, String writeFile, Scrambler scrambler){
        try (BufferedReader br = new BufferedReader(new FileReader(readFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile)))
        {
            scrambler.setEcnrAlphabet((scrambler.shiftArray(scrambler.getAlphabet())));
            String line;
            char[] array;
            while (br.ready()){
                line = br.readLine() + "\n";
                array = line.toCharArray();
                bw.write(scrambler.comparisonBack(array, scrambler.getEcnrAlphabet()));
            }

        }
        catch (FileNotFoundException e){
            throw new FileNotFoundEx("Файла по данному пути не найдено, введите другой путь или создайте файл");

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
