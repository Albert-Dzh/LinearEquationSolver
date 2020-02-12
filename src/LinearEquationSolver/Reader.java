package LinearEquationSolver;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {


    static void getLinEq(String fileN, LinEq destination)  {

        try (Scanner in = new Scanner(new File(fileN))) {

            String ignoreThis = in.nextLine();

            while (in.hasNextLine()) {
                String[] temp = in.nextLine().split("\\s+");
                int length = temp.length;
                ComplexNum[] line = new ComplexNum[length];

                for (int i = 0; i < length; i++) {
                    line[i] = new ComplexNum(temp[i]);
                }
                destination.fillRow(line);
            }
        } catch (FileNotFoundException notFound) {
            notFound.printStackTrace();
        }
    }
}
