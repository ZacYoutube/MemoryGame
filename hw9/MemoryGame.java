package hw9;

import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MemoryGame extends Application{
	int sec = 0;
	int min = 0;
	Text text;
	Timeline time;
	  void count(Text text) {
	     	if(sec == 60) {
	     		min++;
	     		sec = 0;
	     	}
	     	//display time format.
	     	if(min/10 == 0 && sec/10 == 0) {
	     		text.setText("Time: "+"0" + min + ":" + "0" + sec);
	             sec++;     	
	     	}else if(min/10!=0&&sec/10==0) {
	     		text.setText("Time: "+"" + min + ":" + "0" + sec);
	             sec++;
	     	}else if(min/10!=0&&sec/10!=0) {
	     		text.setText("Time: "+"" + min + ":" + "" + sec);
	             sec++;
	     	}else if(min/10==0&&sec/10!=0) {
	     		text.setText("Time: "+"0" + min + ":" + "" + sec);
	             sec++;
	     	}	    	
	     
}
	
	@Override
	public void start(Stage primaryStage){  
	    //create MenuItems to display the options
  	        MenuItem Theme_1 = new MenuItem("Emoji Matching");
	        MenuItem Theme_2 = new MenuItem("Singer Or Actor Matching");
	        MenuItem Theme_3 = new MenuItem("Game Character Matching");
	        //add the items to MenuButton to add to StackPane
	        MenuButton menuButton = new MenuButton("Themes", null, Theme_1, Theme_2, Theme_3);	       
	        StackPane stack = new StackPane(menuButton);
	        //set background image for the StackPane
	        Image image = new Image("memory/Funny-Brain.jpg");
	       BackgroundImage BI = new BackgroundImage(image, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
	       stack.setBackground(new Background(BI));
	       stack.setAlignment(Pos.TOP_RIGHT);
	        Scene scene = new Scene(stack,400,400);
			    primaryStage.setTitle("MEMORY GAME THEME"); 
			    primaryStage.setScene(scene);
			    //close the primaryStage
			    primaryStage.show(); 			    
Theme_1.setOnAction(e->{
        	MenuItem option1= new MenuItem("4 * 4");   
 	        MenuItem option2 = new MenuItem("6 * 6");
 	        MenuItem option3 = new MenuItem("10 * 10");
 	        MenuButton Option = new MenuButton("Emoji_Sizes", null, option1,option2,option3);	        
 	        StackPane stack1 = new StackPane(Option);
 	       Image image1 = new Image("memory/Emoji_Blush.png");
 	       BackgroundImage BI1 = new BackgroundImage(image1, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
	       stack1.setBackground(new Background(BI1));
	       stack1.setAlignment(Pos.TOP_RIGHT);
	        Scene scene1 = new Scene(stack1,300,270);
	         Stage thirdStage = new Stage();
			    thirdStage.setTitle("Sizes"); 
			    thirdStage.setScene(scene1);
			    thirdStage.show(); 
			    primaryStage.close();
 	        
	option1.setOnAction(event ->{ 
		text = new Text("Time: 00:00");
		text.setFill(Color.BROWN);
		text.setFont(new Font(50));
		text.setLayoutX(450);
		text.setLayoutY(50);
		time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
            	count(text);
			}
		}));
		time.setCycleCount(Timeline.INDEFINITE);
		time.setAutoReverse(false);
		Pane pane = new Pane();
		pane.setPrefSize(800, 400);
		ArrayList<Card> array = new ArrayList<>();
		for(int i =0;i<8;i++) {
			array.add(new Card("emoji/"+(i+1)+".png",4));
			array.add(new Card("emoji/"+(i+1)+".png",4));		
		}
		Collections.shuffle(array);
 
   Card card = null;	
	for(int i =0;i<16;i++) {
		card = array.get(i);
		card.setTranslateX(100*(i%4));//setTranslateX make sure that the node would be moved in x direction within the bound pixels.
		card.setTranslateY(100*(i/4));//setTranslateY make sure that the node would be moved in y direction within the bound pixels.	
		pane.getChildren().add(card);
	}
	   pane.getChildren().add(text);
	   Image image4 = new Image("memory/dolphin.png");
       BackgroundImage BI4 = new BackgroundImage(image4, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
       pane.setBackground(new Background(BI4));	   
    	Scene scene2 = new Scene(pane);		    
		Stage Stage1 = new Stage();
		Stage1.setTitle("EMOJI"); 
		Stage1.setScene(scene2);
		Stage1.show();
		//close the Size option window for first theme(thirdStage)
		thirdStage.close();	
					  	   
			  });
option2.setOnAction(v->{
	text = new Text("Time: 00:00");
	text.setFill(Color.BROWN);
	text.setFont(new Font(50));
	text.setLayoutX(800);
	text.setLayoutY(50);
	time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
        	count(text);
		}
	}));
	time.setCycleCount(Timeline.INDEFINITE);
	time.setAutoReverse(false);
	
	Pane pane = new Pane();
	pane.setPrefSize(1220, 601);
	ArrayList<Card> array = new ArrayList<>();
	for(int i =0;i<18;i++) {
		array.add(new Card("emoji/"+(i+1)+".png",6));
		array.add(new Card("emoji/"+(i+1)+".png",6));
	}
	Collections.shuffle(array);

for(int i = 0;i<array.size();i++) {
	Card card = array.get(i);
	card.setTranslateX((i%6)*100);
	card.setTranslateY(100*(i/6));
	pane.getChildren().add(card);

}
pane.getChildren().add(text);
Image image5 = new Image("memory/dol.png");
BackgroundImage BI5 = new BackgroundImage(image5, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
pane.setBackground(new Background(BI5));
	    Scene scene3 = new Scene(pane);		    
		    Stage Stage2 = new Stage();
		    Stage2.setTitle("EMOJI"); 
		    Stage2.setScene(scene3);
		    Stage2.show();
		    thirdStage.close();	
	
});
option3.setOnAction(v->{
	
	Pane pane = new Pane();
	pane.setPrefSize(1700, 1000);
	ArrayList<Card> array = new ArrayList<>();
	for(int i =0;i<50;i++) {
		array.add(new Card("emoji/"+(i+1)+".png",10));
		array.add(new Card("emoji/"+(i+1)+".png",10));
	}
	Collections.shuffle(array);

for(int i = 0;i<array.size();i++) {
	Card card = array.get(i);
	card.setTranslateX(100*(i%10));
	card.setTranslateY(100*(i/10));
	pane.getChildren().add(card);

}
text = new Text("Time: 00:00");
text.setFill(Color.BLACK);
text.setFont(new Font(50));
text.setLayoutX(1200);
text.setLayoutY(300);
time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
    	count(text);
	}
}));
time.setCycleCount(Timeline.INDEFINITE);
time.setAutoReverse(false);
pane.getChildren().add(text);
Image image3 = new Image("memory/dolp.jpg");
BackgroundImage BI3 = new BackgroundImage(image3, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
pane.setBackground(new Background(BI3));
		    Scene scene4 = new Scene(pane);		    
		    Stage Stage3 = new Stage();
		    Stage3.setTitle("EMOJI"); 
		    Stage3.setScene(scene4);
		    Stage3.show();
		    thirdStage.close();	
	
});
	
	});

Theme_2.setOnAction(e->{
	
	MenuItem option1= new MenuItem("4 * 4");
     MenuItem option2 = new MenuItem("6 * 6");
     MenuItem option3 = new MenuItem("10 * 10");
     MenuButton Option = new MenuButton("Singer_or_Actor_Sizes", null, option1,option2,option3);
     StackPane stack1 = new StackPane(Option);
     Image image2 = new Image("memory/taylor.jpg");
      BackgroundImage BI2 = new BackgroundImage(image2, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
     stack1.setBackground(new Background(BI2));
     stack1.setAlignment(Pos.TOP_LEFT);

    Scene scene5 = new Scene(stack1,400,200);
     Stage Stage4 = new Stage();
	    Stage4.setTitle("Show Sizes"); 
	    Stage4.setScene(scene5);
	    Stage4.show(); 
	    primaryStage.close();
	
  option1.setOnAction(event ->{ 
	  text = new Text("Time: 00:00");
		text.setFill(Color.BROWN);
		text.setFont(new Font(50));
		text.setLayoutX(450);
		text.setLayoutY(50);
		time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
          	count(text);
			}
		}));
		time.setCycleCount(Timeline.INDEFINITE);
		time.setAutoReverse(false);
	  Pane pane = new Pane();
	  pane.setPrefSize(760, 402);
	  ArrayList<Card> tiles = new ArrayList<>();
	  for(int i = 0; i<8;i++) {
		 int random = (int)(Math.random()*(50-1)+1);
		  tiles.add(new Card("singer_and_actor/"+random+".png",4));
		  tiles.add(new Card("singer_and_actor/"+random+".png",4));
	  }
	   Collections.shuffle(tiles);
	   for(int i = 0; i<tiles.size();i++) {
		   Card tile = tiles.get(i);
		   tile.setTranslateX((i%4)*100);
		   tile.setTranslateY((i/4)*100);
		   pane.getChildren().add(tile);
	   }   
	   pane.getChildren().add(text);
	   Image image4 = new Image("memory/justin.jpg");
       BackgroundImage BI4 = new BackgroundImage(image4, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
       pane.setBackground(new Background(BI4));	  
	    Scene scene6 = new Scene(pane);		    
	    Stage Stage5 = new Stage();
	    Stage5.setTitle("NUMBER"); 
	    Stage5.setScene(scene6);
	    Stage5.show();
	    //close the option size window for second theme(Stage4)
	    Stage4.close();		
	    	
	    });
  option2.setOnAction(event->{
	text = new Text("Time: 00:00");
	text.setFill(Color.BLACK);
	text.setFont(new Font(50));
	text.setLayoutX(730);
	text.setLayoutY(50);
	time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
      	count(text);
		}
	}));
	time.setCycleCount(Timeline.INDEFINITE);
	time.setAutoReverse(false);
	
	Pane pane = new Pane();
	pane.setPrefSize(1220, 601);
ArrayList<Card> tiles = new ArrayList<>();
for(int i = 0; i<18;i++) {
	int random = (int)(Math.random()*(50-1)+1);
	  tiles.add(new Card("singer_and_actor/"+random+".png",6));
	  tiles.add(new Card("singer_and_actor/"+random+".png",6));
}
 Collections.shuffle(tiles);
 for(int i = 0; i<tiles.size();i++) {
	   Card tile = tiles.get(i);
	   tile.setTranslateX((i%6)*100);
	   tile.setTranslateY((i/6)*100);
	   pane.getChildren().add(tile);
 }
 pane.getChildren().add(text);
 Image image5 = new Image("memory/emily.jpg");
 BackgroundImage BI5 = new BackgroundImage(image5, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
 pane.setBackground(new Background(BI5));
  Scene scene7 = new Scene(pane);		    
  Stage Stage6 = new Stage();
  Stage6.setTitle("NUMBER"); 
  Stage6.setScene(scene7);
  Stage6.show();
  Stage4.close();		
	  
  });
	
option3.setOnAction(event->{

Pane pane = new Pane();
pane.setPrefWidth(1700);
pane.setPrefHeight(1000);;
ArrayList<Card> tiles = new ArrayList<>();
for(int i = 0; i<50;i++) {
	int random = (int)(Math.random()*(50-1)+1);
	  tiles.add(new Card("singer_and_actor/"+random+".png",10));
	  tiles.add(new Card("singer_and_actor/"+random+".png",10));
}
Collections.shuffle(tiles);
for(int i = 0; i<tiles.size();i++) {
   Card tile = tiles.get(i);
   tile.setTranslateX(100*(i%10));
   tile.setTranslateY(100*(i/10));
   pane.getChildren().add(tile);
}
text = new Text("Time: 00:00");
text.setFill(Color.BLACK);
text.setFont(new Font(50));
text.setLayoutX(1200);
text.setLayoutY(100);
time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
    	count(text);
	}
}));
time.setCycleCount(Timeline.INDEFINITE);
time.setAutoReverse(false);
pane.getChildren().add(text);
Image image3 = new Image("memory/chris.jpg");
BackgroundImage BI3 = new BackgroundImage(image3, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
pane.setBackground(new Background(BI3));
Scene scene7 = new Scene(pane);		    
Stage Stage6 = new Stage();
Stage6.setTitle("NUMBER"); 
Stage6.setScene(scene7);
Stage6.show();
Stage4.close();		
	
	
	
});

	});
Theme_3.setOnAction(e->{
	
	MenuItem option1= new MenuItem("4 * 4");
     MenuItem option2 = new MenuItem("6 * 6");
     MenuItem option3 = new MenuItem("10 * 10");
     MenuButton Option = new MenuButton("Character_Sizes", null, option1,option2,option3);
     StackPane stack1 = new StackPane(Option);
     Image image1 = new Image("memory/elsword.jpg");
      BackgroundImage BI1 = new BackgroundImage(image1, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
     stack1.setBackground(new Background(BI1));
     stack1.setAlignment(Pos.TOP_RIGHT);
    Scene scene8 = new Scene(stack1,610,345);
     Stage Stage7 = new Stage();
	    Stage7.setTitle("Show Sizes"); 
	    Stage7.setScene(scene8);
	    Stage7.show(); 
	    primaryStage.close();

option1.setOnAction(event->{
	text = new Text("Time: 00:00");
	text.setFill(Color.CHOCOLATE);
	text.setFont(new Font(50));
	text.setLayoutX(450);
	text.setLayoutY(50);
	time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
      	count(text);
		}
	}));
	time.setCycleCount(Timeline.INDEFINITE);
	time.setAutoReverse(false);	
	Pane pane = new Pane();
	pane.setPrefSize(760, 402);
	ArrayList<Card> array = new ArrayList<>();
	for(int i =0;i<8;i++) {
		array.add(new Card("elsword/"+(i+1)+".png",4));
		array.add(new Card("elsword/"+(i+1)+".png",4));
	}
	Collections.shuffle(array);

for(int i = 0;i<array.size();i++) {
	Card card = array.get(i);
	card.setTranslateX(100*(i%4));
	card.setTranslateY(100*(i/4));
	pane.getChildren().add(card);

}
pane.getChildren().add(text);
Image image4 = new Image("memory/aether.jpg");
BackgroundImage BI4 = new BackgroundImage(image4, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
pane.setBackground(new Background(BI4));	
	Scene scene9 = new Scene(pane);		    
	Stage Stage8 = new Stage();
	Stage8.setTitle("CHARACTER"); 
	Stage8.setScene(scene9);
	Stage8.show();
	//close the size option window for third theme(Stage7)
	Stage7.close();	
});
option2.setOnAction(event->{
	text = new Text("Time: 00:00");
	text.setFill(Color.BROWN);
	text.setFont(new Font(50));
	text.setLayoutX(730);
	text.setLayoutY(50);
	time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
      	count(text);
		}
	}));
	time.setCycleCount(Timeline.INDEFINITE);
	time.setAutoReverse(false);
	
	Pane pane = new Pane();
	pane.setPrefSize(1220, 601);
	ArrayList<Card> array = new ArrayList<>();
	for(int i =0;i<18;i++) {
		array.add(new Card("elsword/"+(i+1)+".png",6));
		array.add(new Card("elsword/"+(i+1)+".png",6));
	}
	Collections.shuffle(array);

for(int i = 0;i<array.size();i++) {
	Card card = array.get(i);
	card.setTranslateX(100*(i%6));
	card.setTranslateY(100*(i/6));
	pane.getChildren().add(card);

}
pane.getChildren().add(text);
Image image5 = new Image("memory/vishnu.png");
BackgroundImage BI5 = new BackgroundImage(image5, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
pane.setBackground(new Background(BI5));
	Scene scene10 = new Scene(pane);		    
	Stage Stage9 = new Stage();
	Stage9.setTitle("CHARACTER"); 
	Stage9.setScene(scene10);
	Stage9.show();
	Stage7.close();	
});
option3.setOnAction(event->{
	Pane pane = new Pane();
	pane.setPrefSize(1700, 1000);
	ArrayList<Card> array = new ArrayList<>();
	for(int i =0;i<50;i++) {
		 
		array.add(new Card("elsword/"+(i+1)+".png",10));
		array.add(new Card("elsword/"+(i+1)+".png",10));
	}
	Collections.shuffle(array);

for(int i = 0;i<array.size();i++) {
	Card card = array.get(i);
	card.setTranslateX(100*(i%10));
	card.setTranslateY(100*(i/10));
	pane.getChildren().add(card);

}
text = new Text("Time: 00:00");
text.setFill(Color.BLACK);
text.setFont(new Font(50));
text.setLayoutX(1200);
text.setLayoutY(100);
time = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
	@Override
	public void handle(ActionEvent event) {
    	count(text);
	}
}));
time.setCycleCount(Timeline.INDEFINITE);
time.setAutoReverse(false);
pane.getChildren().add(text);
Image image3 = new Image("memory/code.jpg");
BackgroundImage BI3 = new BackgroundImage(image3, null, null, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);;
pane.setBackground(new Background(BI3));
	Scene scene11 = new Scene(pane);		    
	Stage Stage10 = new Stage();
	Stage10.setTitle("CHARACTER"); 
	Stage10.setScene(scene11);
	Stage10.show();
	Stage7.close();	
});	    
});
	}
	
	    int number = 0;
        Card pic = null;//creates the reference of pictures being clicked,initialize as null
	    class Card extends StackPane {
	    	
			
			
	     ImageView im = new ImageView();
	      Card(String string,int n){ 
                Image image = new Image(string);  
	            im.setImage(image);
	          	Rectangle[][] rect = new Rectangle[n][n];//creates the 2D array of rectangle
	          	for(int i =0;i<n;i++) {
	          		for(int j = 0;j<n;j++) {
	          			rect[i][j]= new Rectangle();
	          			rect[i][j].setFill(Color.TRANSPARENT);
	          			rect[i][j].setStroke(Color.BLACK);
	          			rect[i][j].setWidth(100);
	          			rect[i][j].setHeight(100);
	          			//adds the rectangle node to StackPane.
	          			getChildren().addAll(rect[i][j]);
	          		}
	          	}
	          	//adds the ImageView to StackPane
	          	getChildren().add(im);
	          	//set mouse click event(using lambda expression)
	          	try {
	            setOnMouseClicked(e->{             
	            	
	            	 
	            	 if(im.getOpacity()==1)
        				 return;
	            	 if(pic == null) {//if nothing is clicked at moment,sets the pic to null
	            		//then make pic points to the current instance variable.	            	
	            		 pic = this;
	            		 display();	            		 
	            	 }
	            	 else if(pic !=null) {//if the image tile is clicked
	            		     display();
	            			 if (SameImage(pic)==false) {//if the two clicked tiles don't have same URL
	            				 //both tiles close
	                             pic.disappear();
	                             this.disappear();	                            
	                         }
	            			 if(SameImage(pic)) {//if they have same URL
	            				 //both stays open
	            				 pic.display();
	            				 this.display();
	            				 number++;//increments the # of matched pair as one pair is matched.
	            			 }
	                         pic = null; //nullify pic as later it can be assigned new clicked tile.                        	            		 
	            	 }
	            	 if(number<(n*n)/2) {//if the matched pair is less than the total pair, keep counting
	            		 time.play(); 
	            	 }
	            	 
	            	 if(number == (n*n)/2) {//if the matched pair reaches the max pair, timer stops
	            		 time.pause();	            		 
	            	 }
	            });
	            disappear();	           
	            }catch(NullPointerException e){
	            	System.out.println("Error");
	            }	      
	      }
	      
	        public void display() {
	        	//make image appear by setting the opacity to 1
	        	im.setOpacity(1);
	        }
	        public void disappear() {
	           //use the FadeTransition to create a fading animation
	           //takes Duration and the object being fading as its parameters.
	           FadeTransition fade = new FadeTransition(Duration.seconds(0.5),im);	 
	           //Starts from the node's opacity of 1
	           fade.setFromValue(1);
	           //Stops at the node's opacity of 0
	           fade.setToValue(0);
	           //plays the animation
	           fade.play();	           
	        }	        
	        public boolean SameImage(Card secondImage) {	
	        	//Image().getUrl() returns a string of the image's relative path
	        	//in this case, both im.getImage() and the image from Card's instance can 
	        	// be compared by their string of relative paths
	        	//I tried this with the lab computer, but it doesn't have getUrl() method
	        	//I think the newer version of JDK has getUrl() method, the older version
	        	// uses impl_getUrl() method.
	            if(im.getImage().getUrl().equals(secondImage.im.getImage().getUrl())) 
	            //or  if(im.getImage().impl_getUrl().equals(secondImage.im.getImage().impl_getUrl())) 
	            return true;
				return false;	            
	        }	      
	    }               
	    public static void main(String[] args) {
			Application.launch(args);
		}	
}


