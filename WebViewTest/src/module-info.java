module WebViewTest {
	requires javafx.controls;
	requires javafx.web;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
