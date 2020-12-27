# Battleship https://hyperskill.org/projects/125
## Stage 1
In this stage, you should arrange your ships on the game field. Before you start, let's discuss the conventions of the game:

1. On a 10x10 field, the first row should contain numbers from 1 to 10 indicating the column, and the first column should contain letters from A to J indicating the row.
2. The symbol `~` denotes the fog of war: the unknown area on the opponent's field and the yet untouched area on your field.
3. The symbol `O` denotes a cell with your ship, `X` denotes that the ship was hit, and `M` signifies a miss.
4. You have 5 ships: Aircraft Carrier is 5 cells, Battleship is 4 cells, Submarine is 3 cells, Cruiser is also 3 cells, and Destroyer is 2 cells. Start placing your ships with the largest one.
5. To place a ship, enter two coordinates: the beginning and the end of the ship.
6. If an error occurs in the input coordinates, your program should report it. The message should contain the word `Error`.