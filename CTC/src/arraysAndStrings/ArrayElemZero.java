package arraysAndStrings;

public class ArrayElemZero {
	
	public static int[][] getZeroedArray(int[][] givenMatrix){
		boolean row[] = new boolean[givenMatrix.length];
		boolean col[] = new boolean[givenMatrix[0].length];
		for(int giverow=0;giverow< givenMatrix.length; giverow++ ){
			for(int givecol =0; givecol < givenMatrix[0].length; givecol++ ){
				if(givenMatrix[giverow][givecol] == 0){
					row[giverow] = true;
					col[givecol] = true;
				}
			}
		}
		for(int rowindex=0; rowindex < row.length; rowindex++){
			for(int colindex=0;colindex < col.length; colindex++){
						if(row[rowindex] || col[colindex]){
							givenMatrix[rowindex][colindex]=0;
					}
				}			
		}		
			
		return givenMatrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] giveMatrix = {{2, 3, 5, 0},{1, 7, 4, 9},{3, 0,7,2}};
		giveMatrix = getZeroedArray(giveMatrix);
		for(int giverow=0;giverow< giveMatrix.length; giverow++ ){
			for(int givecol =0; givecol < giveMatrix[0].length; givecol++ ){
			System.out.print(giveMatrix[giverow][givecol]);
			}
			System.out.println();
		}
	}

}
