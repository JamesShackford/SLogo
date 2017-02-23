package main;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tool.SelectionBar;
import tool.Tool;
import view.InputBox;
import view.PageView;
import view.SimulationView;

/**
 * 
 * @author jimmy
 *
 */
public class LogoController
{
	public final int DISPLAY_WIDTH = 600;
	public final int DISPLAY_HEIGHT = 600;

	private List<PageView> pages;
	private SimulationView simulation;
	private SelectionBar selectionBar;
	private InputBox inputBox;
	private Stage stage;
	private BorderPane pane;

	public LogoController(Stage stage)
	{
		pages = new ArrayList<PageView>();
		simulation = new SimulationView();
		selectionBar = new SelectionBar();
		inputBox = new InputBox();
		stage.setTitle("SLogo");
		stage.show();
		this.stage = stage;
		stage.setScene(makeScene());
	}

	private Scene makeScene()
	{
		this.pane = new BorderPane();
		pane.setBottom(inputBox.display());
		pane.setTop(selectionBar.display());
		return new Scene(pane, DISPLAY_WIDTH, DISPLAY_HEIGHT);
	}

	public void addPage(PageView page)
	{
		this.pages.add(page);
	}

	public void setSimulation(SimulationView simulation)
	{
		this.simulation = simulation;
	}

	public void addTool(Tool tool)
	{
		selectionBar.addTool(tool);
	}

}
