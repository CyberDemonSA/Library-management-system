import java.io.File;// какая та параша
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class MainSystem {

    static String fileName = null;
    static Library lib = new Library();
    static Scanner in = new Scanner(System.in);
    static Boolean running = true;


    public static void main(String[] args) {
        while (running) {
            System.out.println("\nEnter 0 for load a library"
                    + "\nEnter 1 for save and quit"
                    + "\nEnter 2 for list alll books in library"
                    + "\nEnter 3 for add book to library");
            int answer = in.nextInt();
            switch (answer) {
                case 0:
                    System.out.println("Enter the file name to load");
                    fileName name = in.next();

                    FileInputStream fis = null;
                    ObjectInputStream in = null;


                    File file = new File(fileName);
                    if (file.exists())
                    try {
                        fis = FileInputStream(file);
                        in = new ObjectInputStream(fis);
                        lib = (Library) in.readObject();
                        fis.close();
                        in.close();

                    } catch (IOException e) {
                        // to auto generate catch block
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        // to auto generate catch block
                        e.printStackTrace();
                    } else {

                    }
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
            }
        }
    }
}