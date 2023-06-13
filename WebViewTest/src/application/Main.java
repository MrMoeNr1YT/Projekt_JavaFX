package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
	private WebView webview;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// Must create a WebView object from the JavaFX Application Thread
		webview = new WebView(); 

		MenuItem yahoo = new MenuItem("Yahoo");
		yahoo.setOnAction(e -> loadPage("http://www.yahoo.com"));

		MenuItem google = new MenuItem("Google");
		google.setOnAction(e -> loadPage("http://www.google.com"));
		
		MenuItem webuntis = new MenuItem("WebUntis");
		webuntis.setOnAction(e -> loadPage("https://klio.webuntis.com/WebUntis/?school=hak-reutte#/basic/timetable"));
	
		// Add menu items to the MenuButton
		MenuButton links = new MenuButton("Visit");
		links.getItems().addAll(yahoo, google,webuntis); 

		BorderPane root = new BorderPane();
		root.setTop(links);
		BorderPane.setAlignment(links, Pos.TOP_RIGHT);
		root.setCenter(webview);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Using MenuButton Controls");
		stage.show();
	}
	
	public void loadPage(String url) {
		webview.getEngine().load(url);
	}
}
