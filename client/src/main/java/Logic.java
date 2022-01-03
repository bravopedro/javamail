/*
This Program will take data from all companies in the S and P 500 and every day at the closing bell output a top 10 most
"valuable" companies based on benjamin Grahams investing formula ((EPS * (8.5 + 2g) * 4.4) / Y). The data used for this
top 10 list will be updated every day at the closing bell of the DOW which is 4 p.m ET This top 10 list
will then be formatted into an email to be sent out The input for this program will
be Scraped from FINWIZ.com. I hope that you enjoy this program.
 */
public class Logic {
    public static void main(String[] args) {
        int i = 0;
        String[] SandP = new String[505]; // the input of tihs array will be downloaded from FinWiz.com
        double [] valueOfShares = new double[505];

        double EPS = 1;     // placeholder value's should come from FINWIZ
        double magicNum = 22.5;
        double bookValuePerShare = 46.67;
        double growthRate = 1;
        int k = 0;

        valueOfShares =  BennysNumber(EPS, magicNum, growthRate, SandP);
        top10List(valueOfShares, SandP);


    }

    public static double top10List(double[] value , String[] names) {

        int[] top10List = new int[10];          // my logic to create the top 10 list of stocks
        int j = 0;                              // I know that this could have been done a lot simpler
        // using a sorting algorithm, but I'm not too great with that stuff yet
        double one = 1;
        double two = 2;
        double three = 3;
        double four = 4;
        double five = 5;
        double six = 6;
        double seven = 7;
        double eight = 8;
        double nine = 9;
        double ten = 10;

        String one1 = "#1";
        String two2 = "#2";
        String three3 = "#3";
        String four4 = "#4";
        String five5 = "#5";
        String six6 = "#6";
        String seven7 = "#7";
        String eight8 = "#8";
        String nine9 = "#9";
        String ten10 = "#10";


        while (value.length >= j)

            if (value[j] > one) {
                names[j] = one1;
                one = value[j];

            }
        if (value[j] > two) {
            names[j] = two2;
            two = value[j];
        }
        if (value[j] > three) {
            names[j] = three3;
            three = value[j];
        }
        if (value[j] > three) {
            names[j] = four4;
            four = value[j];
        }
        if (value[j] > four) {
            names[j] = five5;
            five = value[j];
        }
        if (value[j] > five) {
            names[j] = six6;
            six = value[j];
        }
        if (value[j] > six) {
            names[j] = seven7;
            seven = value[j];
        }
        if (value[j] > seven) {
            names[j] = eight8;
            eight = value[j];
        }
        if (value[j] > eight) {
            names[j] = nine9;
            nine = value[j];
        }
        if (value[j] > nine) {
            names[j] = ten10;
            ten = value[j];
        }
        return 6;
    }

    public static double [] BennysNumber(double EPS, double magicNum, double growthRate,  String [] SandPRevised){
        double [] value = new double [505];         // plugs in our values for Benjamin Grahams investing Formula
        for(int i = 0; SandPRevised.length > i; i++){
            value[i] =  (EPS * (8.5 + 2 * growthRate) * 4.4) / 2.7;
            SandPRevised[i] = String.valueOf(value[i]);
        }
        return value;

    }
}


