package puzzle;

import heuristics.HeuristicEvaluator;

import java.util.ArrayList;

public class PuzzleStateNode implements Comparable<PuzzleStateNode>{
    PuzzleState state;
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
    public PuzzleStateNode(PuzzleState state, int heuristic) {
        this.state = state;
        this.parent = null;
        this.depth = 0;
        this.heuristic = heuristic;
    }

    public PuzzleStateNode(PuzzleState state, PuzzleStateNode parent, int depth, int heuristic) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        this.heuristic = heuristic;
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
            nodeNeighbors.add(new PuzzleStateNode(stateNeighbor, this, depth+1,  heuristicEvaluator.evaluate(stateNeighbor)));
        }
        return nodeNeighbors;
    }

    public boolean matches(PuzzleState goal) {
        return state.matches(goal);
    }

    public Integer getCost() {
        return depth + heuristic;
    }

    @Override
    public int compareTo(PuzzleStateNode puzzleStateNode) {
        return getCost().compareTo(puzzleStateNode.getCost());
    }
}
