package LinearEquationSolver;

/**
 *
 * Программа решает СЛУ
 * Можно с коплексными числами (вида a+bi)
 *
 * Формат входных данных: текст из файла формата .txt
 * (между каждым эл-том в линейном уравнении стоит пробел).
 * Инфо о названии input/output файлов получаем через @args при запуске.
 *
 * Формат выходных данных: текст в файле формата .txt
 * Программа сама запишет результат работы в output файл.
 *
 * Возможные варианты ответа:
 * no solutions
 * one solution
 * infinitely many solutions
 *
 */

public class SysLinEqMain {
    public static void main(String[] args) {

        Parser parser = new Parser(args);
        LinEq linEq = new LinEq();
        Reader.getLinEq(parser.inputFile(), linEq);
        linEq.solve();
        Writer.AnswerToFile(parser.outputFile(), linEq);

    }
}
