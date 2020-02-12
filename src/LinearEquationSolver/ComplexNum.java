package LinearEquationSolver;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ComplexNum {

    public static final double EPSILON = 0.001;


    private double SimplPrt; //Без 'i'
    private double ComplPrt; //C   'i'


    ComplexNum(double SimplPrt, double ComplPrt) {

        this.SimplPrt = SimplPrt;
        this.ComplPrt = ComplPrt;
    }


    ComplexNum(String num) {

        String[] toParse = getTwoParts(num);


        if ("+".equals(toParse[1])) {
            toParse[1] = "1";
        }
        if ("-".equals(toParse[1])) {
            toParse[1] = "-1";
        }

        SimplPrt = Double.parseDouble(toParse[0]);
        ComplPrt = Double.parseDouble(toParse[1]);
    }


    private String[] getTwoParts(String num) {

        StringBuilder Simpl = new StringBuilder();
        String Compl = "0";
        int length = num.length();

        if (length == 1) {
            if ("i".equals(num)) {
                return new String[]{"0", "1"};
            }
            return new String[]{num, "0"};
        }

        for (int i = 1; i < length; i++) {
            if (num.charAt(i) == '+' || num.charAt(i) == '-') {
                Simpl.append(num, 0, i);
                Compl = num.substring(i, length - 1).replace("i", "");
                break;
            }
            else if (i == length - 1) {
                if (num.contains("i")) {
                    Simpl.append("0");
                    Compl = num.substring(0, length - 1).replace("i", "");
                }
                else {
                    Simpl.append(num);
                    Compl = "0";
                }
            }
        }
        return new String[]{Simpl.toString(), Compl};
    }

    //симпл логика для сложить умножить вычесть разделить и доп. для сопряжения
    static ComplexNum sum(ComplexNum a, ComplexNum bi) {
        return new ComplexNum(a.SimplPrt + bi.SimplPrt, a.ComplPrt + bi.ComplPrt);
    }

    static ComplexNum multiply(ComplexNum a, ComplexNum bi) {
        return new ComplexNum(a.SimplPrt * bi.SimplPrt - a.ComplPrt * bi.ComplPrt, a.SimplPrt * bi.ComplPrt + a.ComplPrt * bi.SimplPrt);
    }

    static ComplexNum subtract(ComplexNum first, ComplexNum second) {
        return new ComplexNum(first.SimplPrt - second.SimplPrt, first.ComplPrt - second.ComplPrt);
    }

    static ComplexNum divide(ComplexNum top, ComplexNum bot) {

        ComplexNum temp = multiply(top, conjugate(bot));
        double divider = bot.SimplPrt * bot.SimplPrt + bot.ComplPrt * bot.ComplPrt;
        return new ComplexNum(temp.SimplPrt / divider, temp.ComplPrt / divider);
    }

    private static ComplexNum conjugate(ComplexNum a) {
        return new ComplexNum(a.SimplPrt, -a.ComplPrt);
    }

    //ловить пустышку
    boolean isZero() {
        return SimplPrt == 0 && ComplPrt == 0;
    }


    @Override
    public String toString() {

        final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        final DecimalFormat realFormat = new DecimalFormat("0.####", symbols);
        final DecimalFormat imagFormat = new DecimalFormat("0.####i", symbols);

        if (Math.abs(ComplPrt) < EPSILON) {
            return realFormat.format(SimplPrt);
        }
        if (Math.abs(SimplPrt) < EPSILON) {
            return imagFormat.format(ComplPrt);
        }
        imagFormat.setPositivePrefix("+");
        return String.format("%s%s", realFormat.format(SimplPrt), imagFormat.format(ComplPrt));
    }
}
