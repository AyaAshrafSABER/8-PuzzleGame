package sample;
import algorithms.AStarSearch;
import algorithms.AbstractTreeSearch;
import algorithms.BreadthFirstSearch;
import algorithms.DepthFirstSearch;
import heuristics.EuclideanHeuristic;
import heuristics.HeuristicEvaluator;
import heuristics.ManhattanHeuristic;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.*;

public class Controller implements Initializable{
    final private PuzzleState sloved = new PuzzleState(new int []{0,1,2,3,4,5,6,7,8});
    final ToggleGroup algorithm = new ToggleGroup();
    private AbstractTreeSearch treeSearch;
    private PuzzleState init;
    private ListIterator<PuzzleState> path;

    @FXML
    private TextField cost;
    @FXML
    private TextField depth;
    @FXML
    private TextField time;
    @FXML
    private RadioButton dfs;
    @FXML
    private RadioButton bfs;
    @FXML
    private RadioButton aStarE;
    @FXML
    private RadioButton aStarM;
    @FXML
    private Button selectAlgorithm;
    @FXML
    private Button next;
    @FXML
    private Button back;
    @FXML
    private TextField index0;
    @FXML
    private TextField index1;
    @FXML
    private TextField index2;
    @FXML
    private TextField index3;
    @FXML
    private TextField index4;
    @FXML
    private TextField index5;
    @FXML
    private TextField index6;
    @FXML
    private TextField index7;
    @FXML
    private TextField index8;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        setRadioButton();
    }


       private void setRadioButton() {
        dfs.setToggleGroup(algorithm);
        dfs.setSelected(true);
        bfs.setToggleGroup(algorithm);
        aStarE.setToggleGroup(algorithm);
        aStarM.setToggleGroup(algorithm);

    }
    private int[] getCongfigration(){
        int[] config = new int[9];
        config[0] = Integer.parseInt(index0.getText());
        config[1] = Integer.parseInt(index1.getText());
        config[2] = Integer.parseInt(index2.getText());
        config[3] = Integer.parseInt(index3.getText());
        config[4] = Integer.parseInt(index4.getText());
        config[5] = Integer.parseInt(index5.getText());
        config[6] = Integer.parseInt(index6.getText());
        config[7] = Integer.parseInt(index7.getText());
        config[8] = Integer.parseInt(index8.getText());
        return config;
    }
    private void displayConfigration(int[]config){
        index0.setText(config[0] + "");
        index1.setText(config[1] + "");
        index2.setText(config[2] + "");
        index3.setText(config[3] + "");
        index4.setText(config[4] + "");
        index5.setText(config[5] + "");
        index6.setText(config[6] + "");
        index7.setText(config[7] + "");
        index8.setText(config[8] + "");

    }
    @FXML
    private void runAlgorithm(ActionEvent event) {
        init= new PuzzleState(getCongfigration());
        disablePuzzle();
        if(dfs.isSelected()){
            treeSearch = new DepthFirstSearch();
        }else if (bfs.isSelected()){
            treeSearch = new BreadthFirstSearch();
        }else if (aStarE.isSelected()){
            HeuristicEvaluator h = new EuclideanHeuristic();
             treeSearch = new AStarSearch(h);
        }else { //M
            HeuristicEvaluator h = new ManhattanHeuristic();
            treeSearch = new AStarSearch(h);
        }
        treeSearch.search(init,sloved);
        path = (ListIterator<PuzzleState>) treeSearch.getPathToGoal().listIterator();
        time.setText(treeSearch.runtimeMillis()+" " + "msec");
        cost.setText(treeSearch.getGoal().getCost()+ "");
        depth.setText(treeSearch.getSearchDepth()+"");

    }

    private void disablePuzzle() {
        index0.setDisable(true);
        index1.setDisable(true);
        index2.setDisable(true);
        index3.setDisable(true);
        index4.setDisable(true);
        index5.setDisable(true);
        index6.setDisable(true);
        index7.setDisable(true);
        index8.setDisable(true);
    }

    @FXML
    private void nextState(ActionEvent event) {
        if(path.hasNext()){
            displayConfigration(path.next().getConfiguration());
        }
    }
    @FXML
    private void prevState(ActionEvent event) {
        if(path.hasPrevious()){
            displayConfigration(path.previous().getConfiguration());
        }
    }
    @FXML
    private void resetPuzzel(ActionEvent event){
        EnablePuzzle();

    }

    private void EnablePuzzle() {
        index0.setDisable(false);
        index1.setDisable(false);
        index2.setDisable(false);
        index3.setDisable(false);
        index4.setDisable(false);
        index5.setDisable(false);
        index6.setDisable(false);
        index7.setDisable(false);
        index8.setDisable(false);
    }
}
