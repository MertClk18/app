package lake;

import java.util.Random;

public class FrozenLake {
    private static final int ROWS = 8;
    private static final int COLS = 11;
    private static final String CE = "CE"; // Cliff Edge
    private static final String R1 = "R1"; // Researcher 1
    private static final String IB = "IB"; // Ice Block
    private String[][] lakeMap;

    public FrozenLake() {
        lakeMap = new String[ROWS][COLS];
        generateMap();
    }

    public FrozenLake(int rows, int cols) {
        lakeMap = new String[rows][cols];
        generateMap();
    }

    public void generateMap() {
        Random rand = new Random();

        // Initialize map with empty spaces
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                lakeMap[row][col] = " ";
            }
        }

        // Place Cliff Edge along one side (randomly chosen)
        int cliffSide = rand.nextInt(4); // 0: top, 1: bottom, 2: left, 3: right
        placeCliffEdge(cliffSide);

        // Place Researcher 1 at the initial position (first row, 6th column)
        lakeMap[0][5] = R1;

        // Place Ice Blocks (one per row, 2nd row excluding 6th column)
        placeIceBlocks();

        // Place other objects
        placeIceSurfaces(); // Place IS (Ice Surfaces)
        placeRandomObject("HI", 3);  // Hazard Ice
    }

    private void placeCliffEdge(int side) {
        switch (side) {
            case 0: // Top
                for (int col = 0; col < COLS; col++) {
                    lakeMap[0][col] = CE;
                }
                lakeMap[0][5] = R1; // Ensure Researcher 1 is not overwritten
                break;
            case 1: // Bottom
                for (int col = 0; col < COLS; col++) {
                    lakeMap[ROWS - 1][col] = CE;
                }
                break;
            case 2: // Left
                for (int row = 0; row < ROWS; row++) {
                    lakeMap[row][0] = CE;
                }
                break;
            case 3: // Right
                for (int row = 0; row < ROWS; row++) {
                    lakeMap[row][COLS - 1] = CE;
                }
                break;
        }
    }

    private void placeIceBlocks() {
        Random rand = new Random();
        for (int row = 0; row < ROWS; row++) {
            while (true) {
                int col = rand.nextInt(COLS);

                // Ensure no object is placed directly adjacent to Cliff Edge
                if (isAdjacentToCliff(row, col)) {
                    continue;
                }

                // Skip the block directly in front of Researcher 1 (2nd row, 6th column)
                if (row == 1 && col == 5) {
                    continue;
                }

                if (lakeMap[row][col].equals(" ")) {
                    lakeMap[row][col] = IB;
                    break;
                }
            }
        }
    }

    private boolean isAdjacentToCliff(int row, int col) {
        // Check for adjacency to Cliff Edge (CE)
        int[] rowOffsets = {-1, 0, 1};
        int[] colOffsets = {-1, 0, 1};

        for (int rowOffset : rowOffsets) {
            for (int colOffset : colOffsets) {
                int newRow = row + rowOffset;
                int newCol = col + colOffset;

                if (isInsideLake(newRow, newCol) && lakeMap[newRow][newCol].equals(CE)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void placeIceSurfaces() {
        Random rand = new Random();
        int placed = 0;
        while (placed < 3) { // Place 3 Ice Surfaces
            int row = rand.nextInt(ROWS);
            int col = rand.nextInt(COLS);

            // Ensure IS is placed only next to walls (first or last column)
            if ((col == 0 || col == COLS - 1) && lakeMap[row][col].equals(" ")) {
                lakeMap[row][col] = "IS";
                placed++;
            }
        }
    }

    private void placeRandomObject(String obj, int count) {
        Random rand = new Random();
        int placed = 0;
        while (placed < count) {
            int row = rand.nextInt(ROWS);
            int col = rand.nextInt(COLS);

            // Ensure no object is placed in the Researcher 1's position or directly in front
            if ((row == 0 && col == 5) || (row == 1 && col == 5)) {
                continue;
            }

            // Ensure no object is placed adjacent to Cliff Edge
            if (isAdjacentToCliff(row, col)) {
                continue;
            }

            if (lakeMap[row][col].equals(" ")) {
                lakeMap[row][col] = obj;
                placed++;
            }
        }
    }

    public void printLakeMap() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.printf("| %2s ", lakeMap[row][col]);
            }
            System.out.println("|");

            for (int col = 0; col < COLS; col++) {
                System.out.print("-----");
            }
            System.out.println("-");
        }
    }

    public boolean isHazard(int row, int col) {
        return lakeMap[row][col].equals("HI");
    }

    public boolean isWall(int row, int col) {
        return lakeMap[row][col].equals(CE); // Cliff Edge
    }

    public boolean isInsideLake(int row, int col) {
        return row >= 0 && row < ROWS && col >= 0 && col < COLS;
    }

    public void removeHazard(int row, int col) {
        if (isInsideLake(row, col) && lakeMap[row][col].equals("HI")) {
            lakeMap[row][col] = " "; // Remove hazard by setting the position to empty
        }
    }

    public int getRows() {
        return ROWS;
    }

    public int getColumns() {
        return COLS;
    }

}
