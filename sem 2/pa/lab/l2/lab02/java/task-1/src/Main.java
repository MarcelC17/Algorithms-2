import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    static class Obj {
        public int weight;
        public int price;

        public Obj() {
            weight = 0;
            price = 0;
        }
    };

    static class Rucsac{
        double scale;
        int number;

        public Rucsac(double scale, int number){
            this.scale = scale;
            this.number = number;
        }
    }

    static class Task {
        public final static String INPUT_FILE = "in";
        public final static String OUTPUT_FILE = "out";

        int n, w;
        Obj[] objs;

        public void solve() {
            readInput();
            writeOutput(getResult());
        }

        private void readInput() {
            try {
                Scanner sc = new Scanner(new File(INPUT_FILE));
                n = sc.nextInt();
                w = sc.nextInt();
                objs = new Obj[n];
                for (int i = 0; i < n; i++) {
                    objs[i] = new Obj();
                    objs[i].weight = sc.nextInt();
                    objs[i].price = sc.nextInt();
                }
                sc.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void writeOutput(double result) {
            try {
                PrintWriter pw = new PrintWriter(new File(OUTPUT_FILE));
                pw.printf("%.4f\n", result);
                pw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private double getResult() {
            // TODO: Aflati profitul maxim care se poate obtine cu
            // obiectele date.
            ArrayList<Rucsac> scale= new ArrayList<Rucsac>();
            int i = 0;
            for (Obj obiect : objs){
               scale.add(new Rucsac((double) (obiect.price)/(double) (obiect.weight), i));
            }

            Collections.sort(scale,Collections.reverseOrder());
            double sum = 0;
            for (Rucsac ruc: scale){
               if (sum + objs[ruc.number].price > 100){
                   sum += objs[ruc.number].price;
               } else break;
            }

            sum +
            return 0;
        }
    }

    public static void main(String[] args) {
        new Task().solve();
    }
}
