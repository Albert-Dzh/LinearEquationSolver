package LinearEquationSolver;

public class Parser {

    private String inFile;
    private String outFile;

    public String inputFile() {
        return inFile;
    }

    public String outputFile() {
        return outFile;
    }

    Parser(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if ("-in".equals(args[i])) {
                inFile = args[i + 1];
            }
            if ("-out".equals(args[i])) {
                outFile = args[i + 1];
            }
        }
    }
}
