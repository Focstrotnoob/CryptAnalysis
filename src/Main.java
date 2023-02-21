public class Main {
    public static void main(String[] args) {
        Scrambler sc = new Scrambler(48);
        ReaderWriter rw = new ReaderWriter();
        BruteForce bf = new BruteForce();
        rw.readingEncryptWrite("P:\\file1.txt", "P:\\file2.txt", sc);
        rw.readingDecryptWrite("P:\\file2.txt", "P:\\file3.txt", sc);
        bf.hacking("P:\\file2.txt", "P:\\file4.txt");










    }
}