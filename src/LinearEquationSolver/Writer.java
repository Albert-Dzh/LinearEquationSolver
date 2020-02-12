package LinearEquationSolver;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    static void AnswerToFile(String fileN, LinEq linEq) {

        try (FileWriter fw = new FileWriter(new File(fileN))) {
            fw.append(linEq.getAnswer());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
