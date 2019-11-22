package puzzle;

import heuristics.HeuristicEvaluator;

import java.util.ArrayList;

public class PuzzleStateNode implements Comparable<PuzzleStateNode>{
    public PuzzleState state;
    PuzzleStateNode parent;
    int depth;
    int heuristic;

    // These constructors are used for BFS and DFS
    public PuzzleStateNode(PuzzleState state) {
        this.state = state;
        this.parent = null;
        this.depth = 0;
        this.heuristic = 0;
    }

    public PuzzleStateNode(PuzzleState state, PuzzleStateNode parent, int depth) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        this.heuristic = 0;
    }

    // These constructors are used for A* search
    public PuzzleStateNode(PuzzleState state, HeuristicEvaluator heuristicEvaluator) {
        this.state = state;
        this.parent = null;
        this.depth = 0;
        this.heuristic = heuristicEvaluator.evaluate(state);
    }

    public PuzzleStateNode(PuzzleState state, PuzzleStateNode parent, int depth, HeuristicEvaluator heuristicEvaluator) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        this.heuristic = heuristicEvaluator.evaluate(state);
    }

    /*
     * Returns a list of neighbor nodes
     */
    public ArrayList<PuzzleStateNode> neighbors() {
        ArrayList<PuzzleState> stateNeighbors = state.neighbors();
        ArrayList<PuzzleStateNode> nodeNeighbors = new ArrayList<>();

        for (PuzzleState stateNeighbor : stateNeighbors) {
            nodeNeighbors.add(new PuzzleStateNode(stateNeighbor, this, depth+1));
        }
        return nodeNeighbors;
    }

    /*
     * Returns a list of neighbor nodes and assigns a heuristic value to each neighbor
     */
    public ArrayList<PuzzleStateNode> neighbors(HeuristicEvaluator heuristicEvaluator) {
        ArrayList<PuzzleState> stateNeighbors = state.neighbors();
        ArrayList<PuzzleStateNode> nodeNeighbors = new ArrayList<>();

        for (PuzzleState stateNeighbor : stateNeighbors) {
            nodeNeighbors.add(new PuzzleStateNode(stateNeighbor, this, depth+1,  heuristicEvaluator));
        }
        return nodeNeighbors;
    }

    public boolean matches(PuzzleState goal) {
        return state.equals(goal);
    }

    public Integer getCost() {
        return depth + heuristic;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PuzzleStateNode)) {
            return false;
        }

        PuzzleStateNode newPuzzleStateNode = (PuzzleStateNode) o;
        return state.equals(newPuzzleStateNode.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public int compareTo(PuzzleStateNode puzzleStateNode) {
        return getCost().compareTo(puzzleStateNode.getCost());
    }
}
