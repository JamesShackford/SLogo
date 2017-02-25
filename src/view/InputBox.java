package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * The view that displays the console, allows the user to input commands
 * @author Jesse
 *
 */
public class InputBox extends Observable {
	private BorderPane inputBox;
	private ScrollPane scroll;
	private TextField console;
	private String input;
	private VBox inputs;
	private Label current;
	private List<String> previous;
	
	/**
	 * Generates all the nodes and defines their actions
	 */
	public InputBox(){
		initiateItems();
		console.setOnAction(e -> consoleAction());
	}
	
	/**
	 * Returns the the input of the console
	 * @return
	 */
	public String getInput(){
		return input;
	}
	
	public List<String> getPastInputs(){
		return previous;
	}
	
	/**
	 * Returns the group of nodes to be displayed
	 * @return
	 */
	public BorderPane display(){
		return inputBox;
	}
	
	private void initiateItems(){
		inputBox = new BorderPane();
		scroll = new ScrollPane();
		scroll.setPrefHeight(200);
		scroll.setMaxHeight(200);
		
		inputs = new VBox();
		scroll.setContent(inputs);
		scroll.vvalueProperty().bind(inputs.heightProperty());
		
		console = new TextField();
		console.setPromptText("Enter your code here...");
		inputBox.setCenter(scroll);
		inputBox.setBottom(console);
		
		previous = new ArrayList<>();
	}
	
	private void consoleAction(){	
		input = console.getText();
		previous.add(input);
		console.clear();
		
		current = new Label(input);	
		current.setOnMouseClicked(e -> textAction());
		inputs.getChildren().add(current);
		
		setChanged();
		notifyObservers(/*input*/);
	}
	
	private void textAction(){
		System.out.println("poop");
	}


}
