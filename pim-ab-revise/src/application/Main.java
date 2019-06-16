package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.RootViewController;
import view.MemberViewController;

public class Main extends Application {
	
    private Stage rootStage;
    private BorderPane rootBorderPane;
    private AnchorPane memberAnchorPane;

    @Override
	public void start(Stage primaryStage) {
		try {
			this.rootStage = primaryStage;
	        this.rootStage.setTitle("Have a PASSION! 201312067 송성운"); //메시지 수정
	        
			loadMainBoderPane();
			loadMemberAnchorPane();			
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadMainBoderPane() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/RootView.fxml")); // view controls				
			rootBorderPane = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootBorderPane, 900, 600);
			scene.getStylesheets().add(Main.class.getResource("/view/member.css").toExternalForm()); //배경처리
			rootStage.setScene(scene);	
			rootStage.show();
			//controller : service 이름으로 작성
			RootViewController controller = loader.getController();
            controller.setMainApp(this);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void loadMemberAnchorPane() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/MemberView.fxml")); // view controls
			memberAnchorPane = (AnchorPane) loader.load();

			rootBorderPane.setCenter(memberAnchorPane);
			
			MemberViewController controller = loader.getController();
            controller.setMainApp(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Stage getRootStage() {
        return rootStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
