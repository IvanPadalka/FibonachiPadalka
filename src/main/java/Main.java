import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Model{
    public List<Integer> getRange() {
        return range;
    }

    public void setRange(List<Integer> range) {
        this.range = range;
    }

    private List<Integer> range = new ArrayList<>();

    public Model(List<Integer> range) {
        this.range = range;
    }
}
class View {

}
class Controller{
    public int readNumberFromKeyboard() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = null;
        try {
            num = reader.readLine();
        } catch (IOException e) {
            System.out.println("Number is not writed");
        }
        int numInt = Integer.parseInt(num);
        return numInt;
    }
    public List<Integer> creatingList(int nfirstNum, int nlastNum){
        List<Integer> rangeList = IntStream.rangeClosed(nfirstNum, nlastNum).boxed().collect(Collectors.toList());
        return rangeList;
    }
    public List<Integer> listOfTheSums(List<Integer> list){
        int sumE = 0, sumO = 0;

        for(int varriable : list)
        {
            if(varriable % 2 == 0)
            {
                sumE = sumE + varriable;
            }
            else
            {
                sumO = sumO + varriable;
            }
        }
        List<Integer> sum = new ArrayList<>();
        sum.add(sumE);
        sum.add(sumO);
        return sum;
    }
    public List<Double> buidingFibonachiNumbersAndCalculatingPercentage(int n) {
        int iteratorOdd=0;
        int iteratorEven=0;

        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }

        for (int i = 0; i < n; ++i) {
            System.out.println(f[i]);

            if(f[i] % 2 == 0)
            {
                iteratorOdd = iteratorOdd + 1;
            }
            else
            {
                iteratorEven = iteratorEven + 1;
            }
        }
        double iteratorOddDouble=(double)iteratorOdd;
        double iteratorEvenDouble=(double)iteratorEven;
        double nDouble = (double) n;
        List<Double> percents = new ArrayList<>();
        percents.add((iteratorOddDouble/nDouble)*100);
        percents.add((iteratorEvenDouble/nDouble)*100);
        return percents;

    }

}
public class Main {
    public static void main (String args[]) throws IOException {
        int nfirstNum = new Controller().readNumberFromKeyboard();
        int nlastNum = new Controller().readNumberFromKeyboard();
        List<Integer> list = new Controller().creatingList(nfirstNum, nlastNum);
        List<Integer> listOfSum =new Controller().listOfTheSums(list);
        int setSize = new Controller().readNumberFromKeyboard();
        List<Double> percents = new Controller().buidingFibonachiNumbersAndCalculatingPercentage(setSize);
        System.out.println(percents);




    }
}


