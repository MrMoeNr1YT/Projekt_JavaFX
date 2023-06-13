
package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		DatePicker birthDate = new DatePicker();		
		birthDate.setEditable(false);
		
		// Print the new date on standard output
		birthDate.setOnAction(e -> 
			System.out.println("New Date:" + birthDate.getValue()));
		
		String pattern = "MM/dd/yyyy";
		birthDate.setConverter(new LocalDateStringConverter());
		birthDate.setPromptText(pattern.toLowerCase());
		
		// Create a day cell factory
		Callback<DatePicker, DateCell> dayCellFactory = 
		new Callback<DatePicker, DateCell>() {
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override 
					public void updateItem(LocalDate item, boolean empty) {
						// Must call super
						super.updateItem(item, empty);

	

						// Show Weekends in blue color
						DayOfWeek day = DayOfWeek.from(item);
						if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
							this.setTextFill(Color.BLUE);
						}
					}
				};
			}};
		
		// Set the day cell factory
		birthDate.setDayCellFactory(dayCellFactory);
	
		
		
		Label r = new Label("Text eingeben"); 
		
		HBox root = new HBox(100); 
		root.getChildren().add(r);
		root.getChildren().add(birthDate);
		
		
		
		Label l = new Label("Text eingeben"); 
		TextField t = new TextField(); 
		
		HBox h = new HBox(100); 
		h.getChildren().add(l); 
		h.getChildren().add(t); 
		
		
		
		Button btn = new Button("OK"); 
		
		btn.setOnAction(e-> {
			if(birthDate.getValue() != null && t.getText() != null) {
				String a = birthDate.toString();
				new Bemerkung(a, t.getText()); 
			}
		});
		
		
		HBox b = new HBox(100); 
		b.getChildren().add(btn);
		
		
		GridPane grid = new GridPane(); 
		grid.setPadding(new Insets(5,5,5,5));
		grid.setHgap(5);
		grid.setVgap(5);
		grid.add(root, 0, 0);
		grid.add(h, 0, 1);
		grid.add(b, 1, 2);
		
		Scene scene = new Scene(grid, 450, 450);
		Stage s = new Stage();
		s.setScene(scene);
		s.setTitle("KalenderToDoList");
		s.show();

	}
}
