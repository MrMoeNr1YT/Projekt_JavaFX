
package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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

						// Disable all future date cells
						if (item.isAfter(LocalDate.now())) {
							this.setDisable(true);
						}

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
	
		Label l = new Label("Text eingeben"); 
		TextField t = new TextField(); 
		
		
		
		HBox root = new HBox(new Label("Birth Date:"), birthDate); 
		root.setStyle("-fx-padding: 10;" + 
		              "-fx-border-style: solid inside;" + 
		              "-fx-border-width: 5;" +
		              "-fx-border-insets: 5;" + 
		             "-fx-border-radius: 5;" + 
		             "-fx-border-color: blue;");
		
		HBox h = new HBox(100);
		h.getChildren().add(l); 
		h.getChildren().add(t); 
		
		root.getChildren().add(h); 
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("Using DatePicker Control");
		stage.show();
		stage.sizeToScene();
	}
}
