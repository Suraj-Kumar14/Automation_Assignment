import java.util.Scanner;
public class MatrixOperations 
{

    static int[][] readMatrix(Scanner sc, int r, int c) {
        int[][] mat = new int[r][c];
        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        return mat;
    }

    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static int[][] addMatrices(int[][] A, int[][] B) {
        int r = A.length, c = A[0].length;
        int[][] sum = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                sum[i][j] = A[i][j] + B[i][j];
        return sum;
    }

    static int[][] subtractMatrices(int[][] A, int[][] B) {
        int r = A.length, c = A[0].length;
        int[][] diff = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                diff[i][j] = A[i][j] - B[i][j];
        return diff;
    }

    static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int r = A.length, c = B[0].length, n = B.length;
        int[][] result = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    static int[][] transposeMatrix(int[][] A) {
        int r = A.length, c = A[0].length;
        int[][] t = new int[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                t[j][i] = A[i][j];
        return t;
    }

    static boolean isSquareMatrix(int[][] A) {
        return A.length == A[0].length;
    }

    static boolean isDiagonalMatrix(int[][] A) {
        if (!isSquareMatrix(A)) return false;
        int n = A.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (i != j && A[i][j] != 0)
                    return false;
        return true;
    }

    static boolean isIdentityMatrix(int[][] A) {
        if (!isSquareMatrix(A)) return false;
        int n = A.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j && A[i][j] != 1) return false;
                if (i != j && A[i][j] != 0) return false;
            }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns of Matrix A: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int[][] A = readMatrix(sc, r1, c1);

        System.out.print("Enter rows and columns of Matrix B: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        int[][] B = readMatrix(sc, r2, c2);

        if (r1 == r2 && c1 == c2) {
            System.out.println("\nAddition:");
            printMatrix(addMatrices(A, B));

            System.out.println("\nSubtraction:");
            printMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition/Subtraction not possible");
        }

        if (c1 == r2) {
            System.out.println("\nMultiplication:");
            printMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMultiplication not possible");
        }

        System.out.println("\nTranspose of Matrix A:");
        printMatrix(transposeMatrix(A));

        System.out.println("\nIs Matrix A Square? " + isSquareMatrix(A));
        System.out.println("Is Matrix A Diagonal? " + isDiagonalMatrix(A));
        System.out.println("Is Matrix A Identity? " + isIdentityMatrix(A));

        sc.close();
    }
}
