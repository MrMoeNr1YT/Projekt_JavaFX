module WebViewTest {
	requires javafx.controls;
	requires javafx.web;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
