# Sudoku with back tracking
Ramneet Kaur 
Steven Lu
Fot this project we assumed that the user input will be integers, so we don't have to worries about type casting. We start off thinking of the three ways ofchecking if a number is valid. first, check to see if the number matches anything in that row. then do the same thing to the column. Lastly, check within the little 3X3 grid. row and column was easy to check since it's just linear search. for the 3x3 grid, we used modules(inspired by the code by MohanDas from geeksforgeeks.com) . For the actual solving method, we search for the empty space then try numbers from 1-9 and start backtracking. return true if solved, or continue sovling the sudoku, or return false if the sudoku have no solution. Last, print the board.
In this project we hardcoded the board, but usually it will involve Scaning for using input.
