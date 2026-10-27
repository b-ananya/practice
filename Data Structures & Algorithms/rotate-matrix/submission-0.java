class Solution {
    public void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
    }

    // (i, j) -> (j, n-1-i)
    // or
    // reverse the matrix vertically
    // (first row becomes last, last row becomes first)
    // transpose the matrix (swap rows with cols)
    // aka for i < j, swap matrix [i][j] with matrix[j][i]

}
