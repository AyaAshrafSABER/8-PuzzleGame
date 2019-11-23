package algorithms;

//import javafx.util.Pair;
import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractTreeSearch {
     Collection<PuzzleStateNode> frontier;
     HashSet<PuzzleStateNode> explored;

    public AbstractTreeSearch() {
        this.explored = new HashSet<>();
    }

    public abstract boolean search(PuzzleState initialState, PuzzleState goalState);

    public Collection<PuzzleStateNode> getFrontier (){
        return this.frontier;
    }

}
