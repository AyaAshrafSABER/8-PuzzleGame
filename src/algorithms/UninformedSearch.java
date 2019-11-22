package algorithms;

import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.ArrayDeque;
import java.util.Stack;

public class UninformedSearch extends AbstractTreeSearch {
    public UninformedSearch (String algorithm){
        super();
        if (algorithm == "DFS"){
            this.frontier = new Stack<>();
        } else if (algorithm == "BFS"){
            this.frontier = new ArrayDeque<>();
        }
    }
    @Override
    public boolean search(PuzzleState initialState, PuzzleState goalState) {
        PuzzleStateNode root = new PuzzleStateNode(initialState);
        this.frontier.add(root);
        while(!this.frontier.isEmpty()){
            PuzzleStateNode curr = this.frontier.iterator().next();
            this.frontier.remove(curr);
            explored.add(curr);
            if(curr.matches(goalState)){
                return true;
            }
            for (PuzzleStateNode node: curr.neighbors()) {
                if (!frontier.contains(node) && !explored.contains(node))
                    frontier.add(node);
            }
        }
        return false;
    }
}
