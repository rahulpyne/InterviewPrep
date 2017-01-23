package arraysAndStrings;

public class RotateMatrix {
	
	public static int[][] rotateImage(int[][] matrix){
		int rotatedmatrix[][] = new int[matrix[0].length][matrix.length];
		int offset = matrix.length - 1;
		for(int row = 0; row< matrix.length; row++){			
			for(int col=0;col<matrix[0].length;col++){
				rotatedmatrix[col][offset] = matrix[row][col];
			}
			offset--;
		}
		return rotatedmatrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{2,3,4,5},{4,0,8,9},{3,7,2,0}};
		int rotatedmatrix[][];
		rotatedmatrix = rotateImage(matrix);
		for(int row = 0;row< rotatedmatrix.length;row++){
			for(int col=0;col<rotatedmatrix[0].length;col++){
				System.out.print(rotatedmatrix[row][col]);
			}
			System.out.println();
		}
	}

}
