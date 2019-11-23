package sample;
import algorithms.AStarSearch;
import algorithms.AbstractTreeSearch;
import algorithms.BreadthFirstSearch;
import algorithms.DepthFirstSearch;
import heuristics.EuclideanHeuristic;
import heuristics.HeuristicEvaluator;
import heuristics.ManhattanHeuristic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import puzzle.PuzzleState;

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

    private TextField[] getTextFields() {
        return new TextField[]{index0, index1, index2, index3, index4, index5, index6, index7, index8};
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
        TextField[] textFields = getTextFields();

        for (int i = 0; i < 9; i++) {
            config[i] = Integer.parseInt(textFields[i].getText());
        }
        return config;
    }
    private void displayConfigration(int[]config){
        TextField[] textFields = getTextFields();
        for (int i = 0; i < 9; i++) {
            textFields[i].setVisible(true);
            textFields[i].setText(config[i] + "");
            if (config[i] == 0) {
                textFields[i].setVisible(false);
                continue;
            }
        }
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

        displayConfigration(path.next().getConfiguration());
    }

    private void disablePuzzle() {
        TextField[] textFields = getTextFields();
        for (int i = 0; i < 9; i++) {
            textFields[i].setDisable(true);
        }
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
        TextField[] textFields = getTextFields();
        for (int i = 0; i < 9; i++) {
            textFields[i].setVisible(true);
            textFields[i].setDisable(false);
        }
    }
}
