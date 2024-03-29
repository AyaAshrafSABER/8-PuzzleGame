package puzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleState {
    private int[] configuration;


    public PuzzleState(int[] configuration) {
        this.configuration = configuration;
    }

    public ArrayList<PuzzleState> neighbors() {
        ArrayList<PuzzleState> neighbors = new ArrayList();
        ArrayList<Integer> freeTileAdjacentIndexes = freeTileAdjacentIndexes();

        for (int adjacentIndex : freeTileAdjacentIndexes) {
            int[] neighbor_configuration = configuration.clone();
            int temp = neighbor_configuration[adjacentIndex];
            neighbor_configuration[adjacentIndex] = 0;
            neighbor_configuration[freeTileIndex()] = temp;

            neighbors.add(new PuzzleState(neighbor_configuration));
        }
        return neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PuzzleState)) {
            return false;
        }

        PuzzleState newPuzzleState = (PuzzleState) o;

        return Arrays.equals(configuration, newPuzzleState.configuration);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(configuration);
    }

    public void printConfiguration() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(configuration, 3*i, 3*i+3)));
        }
        System.out.println();
    }

    /*
     * Get indexes of tiles adjacent to the free tile i.e tiles that can be moved in the current state
     */
    private ArrayList<Integer> freeTileAdjacentIndexes() {
        ArrayList<Integer> neighborIndexes = new ArrayList();
        int freeTileIndex = freeTileIndex();

        // List of potential neighbors starting from right neighbor, bottom, left and top
        int potentialIndexes[] = {freeTileIndex + 1, freeTileIndex + 3, freeTileIndex - 1, freeTileIndex - 3};

        if (potentialIndexes[0] / 3 == freeTileIndex / 3) {
            neighborIndexes.add(potentialIndexes[0]);
        }
        if (potentialIndexes[1] <= 8) {
            neighborIndexes.add(potentialIndexes[1]);
        }
        if (potentialIndexes[2] / 3 == freeTileIndex / 3 && potentialIndexes[2] >= 0) {
            neighborIndexes.add(potentialIndexes[2]);
        }
        if (potentialIndexes[3] / 3 >= 0 && potentialIndexes[3] >= 0) {
            neighborIndexes.add(potentialIndexes[3]);
        }
        return neighborIndexes;
    }

    /*
     * Get index of the free tile
     */
    private int freeTileIndex() {
        for (int i = 0; i < configuration.length; i++) {
            if (configuration[i] == 0)
                return i;
        }
        return -1;
    }

    public int[] getConfiguration() {
        return this.configuration;
    }
}
