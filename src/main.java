import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    private static ArrayList<PostCode> postCodes = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();

        while(true) {
            checkPostCode();
        }
    }

    private static void checkPostCode() {
        System.out.print("Indtast et muligt postnummer ->");
        int postCodeToCheck = input.nextInt();

        for (PostCode pc : postCodes) {
            if (pc.checkPostCode(postCodeToCheck)) {
                System.out.println("Fundet postnummer -> " + pc);
            }
        }
    }

    private static void loadData() {
        Scanner fs = null;
        try {
            fs = new Scanner(new File("data/danske-postnumre-byer-ny.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String tempString = fs.nextLine();

        for (int i = 0; i < tempString.length(); i++) {
            System.out.println("-" + tempString.charAt(i) + "-");
        }

        String[] tempStrings;
        while (fs.hasNextLine()) {
            tempStrings = fs.nextLine().split(";");
            postCodes.add(new PostCode(
                    Integer.parseInt(tempStrings[0]),
                    tempStrings[1]));
        }
    }

}
