package algorithms;

//import javafx.util.Pair;
import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class AbstractTreeSearch {
    Collection<PuzzleStateNode> frontier;
    HashSet<PuzzleStateNode> explored;

    int searchDepth;
    PuzzleStateNode goal;
    long startTime;
    long endTime;

    public AbstractTreeSearch() {
        this.explored = new HashSet<>();
        this.searchDepth = 0;
        this.goal = null;
        this.startTime = 0;
        this.endTime = 0;
    }

    public abstract boolean search(PuzzleState initialState, PuzzleState goalState);

    public Collection<PuzzleStateNode> getFrontier (){
        return this.frontier;
    }


    public long runtimeMillis() {
        return (endTime - startTime)/1000000;
    }

    public int getSearchDepth() {
        return searchDepth;
    }

    public ArrayList<PuzzleState> getPathToGoal() {
        PuzzleStateNode node = goal;
        ArrayList<PuzzleState> path = new ArrayList<>();

        while (node != null) {
            path.add(node.state);
            node = node.parent;
        }
        return path;
    }
    public PuzzleStateNode getGoal(){
        return goal;
    }

}
