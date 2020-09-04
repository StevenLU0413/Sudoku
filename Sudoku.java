public class Sudoku{
	private int[][] board;
	public final int SIZE = 9;// the board size is always 9X9
	
	public Sudoku(int[][] userBoard){//assuming that all the empty cell are represented with int 0 with the grid that user provided
		this.board = new int[SIZE][SIZE];
		for(int i = 0; i< SIZE; i++){
			for(int j = 0; j< SIZE; j++){
				board[i][j] = userBoard[i][j];
			}
		}
	}
	
	private boolean isEmpty(int row, int col){// a method to check if a cell is empty
		if(board[row][col] == 0){
			return true;
		}
		
		return false;
	}
	
	private boolean isNotInRow(int row, int num){// a method to check if the input number matches the number in that row
		for(int i = 0; i< SIZE; i++){
			if(board[row][i] == num){
				return false;
			}
		}
		return true;
	}
	
	private boolean isNotInCol(int col, int num){// a method to check if the input number matches the number in that column
		for(int i = 0; i<SIZE; i++){
			if(board[i][col] == num){
				return false;
			}
		}
		return true;
	}
	
	private  boolean isNotInBox(int row, int col, int num){// a method to check if the input number matches the number in the 3X3 grid
		int r = row - row%3;// an algorithm inspired from geekforgeek website
		int c = col - col%3;
		
		for(int i = r; i < (r+3); i++){
			for(int j = c; j < (c+3); j++){
				if(board[r][c] == num){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValid(int row, int col, int num){// a conclusive method of all the sudoku contrains
		return isNotInRow(row, num) && isNotInCol(col, num) && isNotInBox(row, col, num);
	}
	
	public boolean fillBoard(){
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				if(isEmpty(i, j)){//check if a cell is empty
					int row = i;
					int col = j;
					for(int num = 1; num<=9; num++){//trying numebers from 1 to 9
						if(isValid(row, col, num)){
							board[row][col] = num;
							
							if(fillBoard()){//started recursive backtracking 
								return true;
							}
							else{
								board[row][col] = 0;//if answer is not correct, we empty the cell and continue
							}

						}
					}
					return false;// return false if cell is not empty
				}
			}
			
		}
		return true;// return true if the sudoku is solved
	}
	
	public void printBoard(){
		for(int i = 0; i <SIZE; i++){
			for(int j = 0; j<SIZE; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] myBoard= {
					{9,0,0,7,8,0,5,4,0},
					{0,4,5,9,0,0,7,0,2},
					{6,7,0,0,4,5,3,9,1},
					{8,0,7,1,6,4,0,0,0},
					{0,9,6,0,2,7,8,1,0},
					{5,2,1,3,0,8,4,0,7},
					{7,0,4,0,0,1,0,5,9},
					{1,0,9,0,7,0,6,0,8},
					{0,0,3,6,0,9,1,7,0},
				}; 
				Sudoku mySudoku = new Sudoku(myBoard);
				if(mySudoku.fillBoard()){
					mySudoku.printBoard();
				}
				else{
					System.out.print("No solution");
				}
		}

}

