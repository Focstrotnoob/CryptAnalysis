import java.io.*;

public class IO {
    public void readingAndEncrypt(String readFile, String writeFile, Scrambler scrambler){
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void readingAndDecrypt(String readFile, String writeFile, Scrambler scrambler){
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
