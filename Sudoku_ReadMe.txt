Logic and Sudoku



For those of you who donÕt know how to solve a Sudoku problem, here is a brief explanation of the rules:
* The game board consists of a 9x9 grid, further broken down into a 3x3 set of smaller 3x3 grids (see the example below) with each individual cell of the grid to eventually contain a digit between 1 and 9.
* The final goal is to fill the board with digits so that all of the following are true:
o Each row of 9 cells contains the digits 1 through 9 in some order with no repeats or omissions.
o Each column of 9 cells contains the digits 1 through 9 in some order with no repeats or omissions.
o Each of the smaller 3x3 grids contains the digits 1 through 9 in some order with no repeats or omissions.



The Program
This Program automatically solves Sudoku puzzles. It does the following:
* Prompts the user to enter a file name.
* Opens that file and read in the Sudoku puzzle contained within (the file consist of 9 rows of 9 numbers each, with zeroes representing the initially empty cells). Display the initial problem read in.
* The program then solves the puzzle by filling in the empty cells of the grid. Displays the final solution.


