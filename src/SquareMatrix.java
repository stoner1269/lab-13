import java.util.ArrayList;
import java.util.Random;

public class SquareMatrix {

    private ArrayList<ArrayList<Integer>> matrix;

    public SquareMatrix(int n, int min, int max) {
        Random random = new Random();
        matrix = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            matrix.add(new ArrayList<Integer>(n));
            for (int j = 0; j < n; j++) {
                matrix.get(i).add(random.nextInt(max - min + 1) + min);
            }
        }
    }

    public void render() {
        for(ArrayList<Integer> row: matrix) {
            for (Integer element: row) {
                System.out.print(String.format("%3d ", element));
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getMaxItem(Diagonal type) {
        int max = Integer.MIN_VALUE;
        switch(type) {
            case MAIN_DIAGONAL:
                for (int i = 0; i < matrix.size(); i++ ) {
                    for (int j = 0; j < matrix.size(); j++) {
                        if (i == j) {
                            if (max < matrix.get(i).get(j)) max = matrix.get(i).get(j);
                        }
                    }
                }
                break;
            case SIDE_DIAGONAL:
                for (int i = 0; i < matrix.size(); i++) {
                    for (int j = matrix.size() - 1; j >= 0; j--) {
                        if (i == matrix.size() - 1 - j) {
                            if (max < matrix.get(i).get(j)) max = matrix.get(i).get(j);
                        }
                    }
                }
                break;
        }
        return  max;
    }

    public void setItem(int item) {
        for (int i = 0; i < matrix.size(); i++ ) {
            for (int j = 0; j < matrix.size(); j++) {
                if ((i == matrix.size() - 1 - i) && (i == j)) {
                    matrix.get(i).set(j, item);
                }
            }
        }
    }
}
