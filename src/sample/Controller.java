package sample;
import algorithms.AStarSearch;
import algorithms.AbstractTreeSearch;
import algorithms.BreadthFirstSearch;
import algorithms.DepthFirstSearch;
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

import java.util.Collection;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    final ToggleGroup algorithm = new ToggleGroup();
    private AbstractTreeSearch treeSearch;
    private PuzzleState init;
    final private PuzzleState sloved = new PuzzleState(new int []{0,1,2,3,4,5,6,7,8});
    private Collection<PuzzleStateNode>  path;

    @FXML
    private TextField cost;
    @FXML
    private TextField depth;
    @FXML
    private RadioButton dfs;
    @FXML
    private RadioButton bfs;
    @FXML
    private RadioButton aStar;
    @FXML
    private Button selectAlgorithm;
    @FXML
    private Button next;
    @FXML
    private Button back;
    @FXML
    private Button index0;
    @FXML
    private Button index1;
    @FXML
    private Button index2;
    @FXML
    private Button index3;
    @FXML
    private Button index4;
    @FXML
    private Button index5;
    @FXML
    private Button index6;
    @FXML
    private Button index7;
    @FXML
    private Button index8;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        setRadioButton();
        init = randomState();
        displayState(init);
    }

    private void displayState(PuzzleState state) {
        int[] config = state.getConfiguration();
        index0.setText(config[0]+"");
        index1.setText(config[1]+"");
        index2.setText(config[2]+"");
        index3.setText(config[3]+"");
        index4.setText(config[4]+"");
        index5.setText(config[5]+"");
        index6.setText(config[6]+"");
        index7.setText(config[7]+"");
        index8.setText(config[8]+"");

    }

    private PuzzleState randomState() {
        int[] configuration = new int[]{1,4,2,3,0,5,6,7,8};
//        Random r = new Random();
//        for(int i = 0; i < 9; i++) {
//
//        }
        return new PuzzleState(configuration);
    }

    private void setRadioButton() {
        dfs.setToggleGroup(algorithm);
        dfs.setSelected(true);
        bfs.setToggleGroup(algorithm);
        aStar.setToggleGroup(algorithm);
    }

    @FXML
    private void runAlgorithm(ActionEvent event) {
        if(dfs.isSelected()){
            treeSearch = new DepthFirstSearch();
            treeSearch.search(init,sloved);
            path = treeSearch.getFrontier();

        }else if (bfs.isSelected()){
            treeSearch = new BreadthFirstSearch();
            treeSearch.search(init,sloved);
            path = treeSearch.getFrontier();

        }else if (aStar.isSelected()){
           // treeSearch = new AStarSearch();
             treeSearch.search(init,sloved);
             path = treeSearch.getFrontier();

        }
    }
    @FXML
    private void nextState(ActionEvent event) {

    }
    @FXML
    private void prevState(ActionEvent event) {

    }
}
