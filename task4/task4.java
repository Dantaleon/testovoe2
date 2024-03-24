package task4;

public class task4 {

	public static void main(String[] args) {
		
		int size = 7; // change this
		
		int[][] matrix = new int[size][size];
		
		// найдем кол-во разных чисел для матрицы и их максимальное значение (border)
		// зависимость кол-ва чисел от размерности матрицы: 1,2 - 1; 3,4 - 2; 5,6 - 3;
		// для нечетных размерностей формула: /2 и to ceil
		// для четных размерностей формула: /2
		
		int numCount;
		if (size % 2 == 0) {
			numCount = size / 2;
		} else {
			numCount = (int)(Math.ceil(size / 2)) + 1;
		}
		
		int borderNum = numCount - 1;
		
		// будем заполнять матрицу "передвигаясь" по краям матрицы от начала (0,0)
		// не делая повторных присвоений номера ячейки, и сдвигая начало по диагонали
		// выход из алгоритма при старт выше по диагонали чем конец
		
		int startX = 0; // x - row, y - col
		int startY = 0;
		int endX = size - 1; 
		int endY = size - 1;
		
		runSquarePerimeter(matrix, startX, endX, startY, endY, borderNum);
		outputMatrix(matrix);
	}
	
	
	public static int[][] runSquarePerimeter(
			int[][] matrix, int startX, int endX, int startY, int endY, int numFill) 
	{
		// run from 0,0 to the right until wall and filling (col changes)
		for (int x = startX, y = startY; y <= endY; ++y) {
			
			matrix[x][y] = numFill;
		}
		
		// run from (startX + 1,endY) to the bottom until wall and filling (row changes)
		for (int x = startX + 1, y = endY; x <= endX; ++x) {
			
			matrix[x][y] = numFill;
			
		}
		
		// run from (endX, endY-1) to the left until wall and filling (reverse col changes)
		for (int x = endX, y = endY-1; y >= startY; --y) {
			
			matrix[x][y] = numFill;
			
		}
		
		// run from (endX-1, startY) to the top until wall - 1 and filling (reverse row changes)
		for (int x = endX-1, y = startY; x > startX; --x) {
			
			matrix[x][y] = numFill;
			
		}
		
		// if new position incorrect - return matrix (start below end in diag)
		if (startX+1 > endX-1 && startY+1 > endY-1) {
			
			return matrix;
		}
		
		// if new pos correct - change values for the next square perimeter
		startX += 1; startY += 1;
		endX -= 1; endY -= 1;
		
		numFill -= 1;
		
		return runSquarePerimeter(matrix, startX, endX, startY, endY, numFill);
	
	}

	public static void outputMatrix(int[][] matrix) {
		System.out.println("------------------------------");
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				System.out.printf("%4d", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------------");
	}

}
