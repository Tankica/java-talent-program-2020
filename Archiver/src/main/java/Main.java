import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner sn = new Scanner(System.in);
        System.out.println("Which compress algorithm should be used, zip or 7z");
        String algorithm = sn.next();

        if (algorithm.equals("7z")) {
            new SevenZipArchiver().archive(new File(".\\files"), new File(".\\archive.7z"));
        } else if (algorithm.equals("zip")) {
            new ZipArchiver().archive(new File(".\\files"), new File(".\\archive.zip"));
        } else {
            throw new InvalidInputException("Invalid input, your available options for input are 7z or zip");
        }
    }
}
