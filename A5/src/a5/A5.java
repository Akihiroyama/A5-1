/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package a5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;



/**
*
* @author akihiro
*/
public class A5 extends Application {
   
	private VBox vbox;
	private Scene scene;
	private TextArea textArea;
	private Label label;
	private Button commandButton;
	private Button commandButton1;
	private HBox commandArea;
	private String string1;
	private String new_string1;
	private String new_string2;
  
   
	@Override
	public void start(final Stage stage){
	vbox = new VBox();
	scene = new Scene(vbox);
	textArea = new TextArea();
	label = new Label("3文字以上入力してください！");
	commandButton = new Button("OK");
	commandButton1 = new Button("Clear");
	commandArea = new HBox();
	commandArea.setSpacing(5);
	string1 = textArea.getText();
     
        
	commandArea.getChildren().addAll(commandButton, commandButton1);
	vbox.getChildren().addAll(label,textArea, commandArea);
 
   
	commandButton.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent actionEvent) {
			string1 = textArea.getText();
			int i=2;
			if(string1.length() <= i){
				final Stage stage1 = new Stage();
				VBox vBox = new VBox(15);
				vBox.setAlignment(Pos.CENTER);
				Scene scene = new Scene(vBox, 300, 200, Color.WHITESMOKE);
				stage1.setScene(scene);
				stage1.centerOnScreen();
				stage1.show();
				Image img = new Image("a5/unnamed.png");
				ImageView iv = new ImageView(img);
				iv.setFitWidth(80);
				iv.setFitHeight(80);
				Text text = new Text(50, 100, "正しく入力して！");
				text.setFill(Color.DODGERBLUE);
				text.setEffect(new Lighting());
				text.setFont(Font.font(Font.getDefault().getFamily(), 25));
				Button close = new Button("OK");
				close.setDefaultButton(true);
				vBox.getChildren().addAll(iv,text,close);
				
				
				close.setOnAction(new EventHandler<ActionEvent>() {
					@Override
                    public void handle(ActionEvent event) {
						stage1.close();
					}
                });
				textArea.requestFocus();
			}else if(i < string1.length()){
				new_string1 = string1.substring(0,3);
				new_string2 = string1.substring(3);
				textArea.setText(new_string1+ "waja"+new_string2);
				textArea.requestFocus();
			}
		}
});
	commandButton1.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent actionEvent) {
			textArea.setText("");
			textArea.requestFocus();
		}
	});

stage.setScene(scene);
stage.setTitle("JavaFX");
stage.setWidth(500); stage.setHeight(300);
stage.show();
}

public static void main(String[] args) {
	Application.launch(A5.class, args);
}
}