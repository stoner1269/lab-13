public class Main {

    public static void main(String args[]) {
        SquareMatrix squareMatrix = new SquareMatrix(5, -20, 20);
        squareMatrix.render();
        int max1 = squareMatrix.getMaxItem(Diagonal.MAIN_DIAGONAL);
        int max2 = squareMatrix.getMaxItem(Diagonal.SIDE_DIAGONAL);
        int max = (max1 > max2) ? max1 : max2;
        squareMatrix.setItem(max);
        squareMatrix.render();
    }
}
