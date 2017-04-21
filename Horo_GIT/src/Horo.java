
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Horo extends Application{
	Label myLabel;
	private Text horo = new Text();
	private int height = 600;
	private int width = 800;
	ComboBox<String> monthsBox;
	ComboBox<String> daysBox;
	
	public static String httpGet(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();

		conn.disconnect();
		return sb.toString();
	}
	
	public static Pane createHorizontalButtonBox2(
            final List<ToggleButton> buttons,
            final Pos alignment,
            final double spacing,
            final boolean sameWidth,
            Label a) {


        return createSameWidthHorizontalButtonBox2(
                      buttons, 
                      alignment, 
                      spacing,
                      a);
                
    }
	
	public static Pane createHorizontalButtonBox(
            final List<ToggleButton> buttons,
            final Pos alignment,
            final double spacing,
            final boolean sameWidth,
            Label a) {


        return createSameWidthHorizontalButtonBox(
                      buttons, 
                      alignment, 
                      spacing,
                      a);
                
    }

	private static String cleanUp(String a){
            try{
		JSONObject obj = new JSONObject(a);
		String horoscope = obj.getString("horoscope");
		horoscope = horoscope.replace("['", "");
		horoscope = horoscope.replaceAll("\\\\u2014", ",");
		horoscope = horoscope.replaceAll("\\\\u2019", "'");
		horoscope = horoscope.replaceAll("\\(c\\) Kelli Fox, The Astrologer, http://new.theastrologer.com", "");
		//horoscope = horoscope.substring(3, horoscope.length());
		return horoscope;
            }catch(JSONException e){
                return null;
            }
	}
	
	private static Pane createSameWidthHorizontalButtonBox2(
            List<ToggleButton> buttons,
            Pos alignment,
            double spacing,
            Label a)
    {
        TilePane tiles = new TilePane(
                Orientation.HORIZONTAL,
                spacing,
                0,
                buttons.toArray(
                        new ToggleButton[buttons.size()]
                )
        );
        tiles.setMinWidth(800);
        tiles.setPrefRows(1);
        tiles.setAlignment(alignment);
        tiles.setVgap(20);

        buttons.forEach(b -> {
            b.setMinWidth(ToggleButton.USE_PREF_SIZE);
            b.setMaxWidth(Double.MAX_VALUE);
        });
        
        buttons.get(0).setOnAction(new EventHandler<ActionEvent>(){				//click Capricorn
        	@Override
        	public void handle(ActionEvent event){
        		String capricornT = "[Strengths]: Responsible, disciplined, self-control, good managers\n"+
        							"[Weaknesses]: Know-it-all, unforgiving, condescending, expecting the worst\n"+
        							"[Capricorn likes]: Family, tradition, music, understated status, quality craftsmanship\n"+
        							"[Capricorn dislikes]: Almost everything at some point";
				a.setText(capricornT);
				
        	}
        });
        
        buttons.get(1).setOnAction(new EventHandler<ActionEvent>(){				//click Aquarius
        	@Override
        	public void handle(ActionEvent event){

        			String aquariusT = "[Strengths]: Progressive, original, independent, humanitarian\n"+
							"[Weaknesses]: Runs from emotional expression, temperamental\n"+
							"[Aquarius likes]: Fun with friends, helping others, intellectual conversation, a good listener\n"+
							"[Aquarius dislikes]: Limitations, broken promises, being lonely, people who disagree with them";
					a.setText(aquariusT);
        	}
        });
        
        buttons.get(2).setOnAction(new EventHandler<ActionEvent>(){				//click Pisces
        	@Override
        	public void handle(ActionEvent event){
        		String piscesT = "[Strengths]: Compassionate, artistic, intuitive, gentle, wise, musical\n"+
						"[Weaknesses]: Fearful, overly trusting, sad, desire to escape reality\n"+
						"[Pisces likes]: Being alone, sleeping, music, romance, spiritual themes\n"+
						"[Pisces dislikes]: Know-it-all, being criticized, the past coming back to haunt";
					a.setText(piscesT);
	
        	}
        });
        
        buttons.get(3).setOnAction(new EventHandler<ActionEvent>(){				//click Aries
        	@Override
        	public void handle(ActionEvent event){
        		String ariesT = "[Strengths]: Courageous, determined, confident, enthusiastic, optimistic\n"+
						"[Weaknesses]: Impatient, moody, short-tempered, impulsive, aggressive\n"+
						"[Aries likes]: Taking on leadership roles, physical challenges, individual sports\n"+
						"[Aries dislikes]: Inactivity, delays, work that does not use one's talents";
					a.setText(ariesT);
        	}
        });
        
        buttons.get(4).setOnAction(new EventHandler<ActionEvent>(){				//click Taurus
        	@Override
        	public void handle(ActionEvent event){
        		String taurusT = "[Strengths]: Reliable, patient, practical, devoted, responsible, stable\n"+
						"[Weaknesses]: Stubborn, possessive, uncompromising\n"+
						"[Taurus likes]: Gardening, cooking, music, romance, working with hands\n"+
						"[Taurus dislikes]: Sudden changes, complications, insecurity of any kind";
					a.setText(taurusT);
        	}
        });
        
        buttons.get(5).setOnAction(new EventHandler<ActionEvent>(){				//click Gemini
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/gemini/today/");
					String geminiH = cleanUp(temp);
					a.setText(geminiH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(6).setOnAction(new EventHandler<ActionEvent>(){				//click Cancer
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/cancer/today/");
					String cancerH = cleanUp(temp);
					a.setText(cancerH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(7).setOnAction(new EventHandler<ActionEvent>(){				//click Leo
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/leo/today/");
					String leoH = cleanUp(temp);
					a.setText(leoH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(8).setOnAction(new EventHandler<ActionEvent>(){				//click Virgo
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/virgo/today/");
					String virgoH = cleanUp(temp);
					a.setText(virgoH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(9).setOnAction(new EventHandler<ActionEvent>(){				//click Libra
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/libra/today/");
					String libraH = cleanUp(temp);
					a.setText(libraH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(10).setOnAction(new EventHandler<ActionEvent>(){				//click Scorpio
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/scorpio/today/");
					String scorpioH = cleanUp(temp);
					a.setText(scorpioH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(11).setOnAction(new EventHandler<ActionEvent>(){				//click Sagittarius
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/sagittarius/today/");
					String sagittariusH = cleanUp(temp);
					a.setText(sagittariusH);                       
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        return tiles;
    }
	
	private static Pane createSameWidthHorizontalButtonBox(
            List<ToggleButton> buttons,
            Pos alignment,
            double spacing,
            Label a)
    {
        TilePane tiles = new TilePane(
                Orientation.HORIZONTAL,
                spacing,
                0,
                buttons.toArray(
                        new ToggleButton[buttons.size()]
                )
        );
        tiles.setMinWidth(800);
        tiles.setPrefRows(1);
        tiles.setAlignment(alignment);
        tiles.setVgap(20);

        buttons.forEach(b -> {
            b.setMinWidth(ToggleButton.USE_PREF_SIZE);
            b.setMaxWidth(Double.MAX_VALUE);
        });
        
        buttons.get(0).setOnAction(new EventHandler<ActionEvent>(){				//click Capricorn
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/capricorn/today/");
					String capricornH = cleanUp(temp);
					a.setText(capricornH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(1).setOnAction(new EventHandler<ActionEvent>(){				//click Aquarius
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/aquarius/today/");
					String aquariusH = cleanUp(temp);
					a.setText(aquariusH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(2).setOnAction(new EventHandler<ActionEvent>(){				//click Pisces
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/pisces/today/");
					String piscesH = cleanUp(temp);
					a.setText(piscesH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(3).setOnAction(new EventHandler<ActionEvent>(){				//click Aries
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/aries/today/");
					String ariesH = cleanUp(temp);
					a.setText(ariesH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(4).setOnAction(new EventHandler<ActionEvent>(){				//click Taurus
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/taurus/today/");
					String taurusH = cleanUp(temp);
					a.setText(taurusH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(5).setOnAction(new EventHandler<ActionEvent>(){				//click Gemini
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/gemini/today/");
					String geminiH = cleanUp(temp);
					a.setText(geminiH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(6).setOnAction(new EventHandler<ActionEvent>(){				//click Cancer
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/cancer/today/");
					String cancerH = cleanUp(temp);
					a.setText(cancerH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(7).setOnAction(new EventHandler<ActionEvent>(){				//click Leo
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/leo/today/");
					String leoH = cleanUp(temp);
					a.setText(leoH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(8).setOnAction(new EventHandler<ActionEvent>(){				//click Virgo
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/virgo/today/");
					String virgoH = cleanUp(temp);
					a.setText(virgoH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(9).setOnAction(new EventHandler<ActionEvent>(){				//click Libra
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/libra/today/");
					String libraH = cleanUp(temp);
					a.setText(libraH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(10).setOnAction(new EventHandler<ActionEvent>(){				//click Scorpio
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/scorpio/today/");
					String scorpioH = cleanUp(temp);
					a.setText(scorpioH);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        buttons.get(11).setOnAction(new EventHandler<ActionEvent>(){				//click Sagittarius
        	@Override
        	public void handle(ActionEvent event){
        		try {
					String temp = httpGet("http://sandipbgt.com/theastrologer/api/horoscope/sagittarius/today/");
					String sagittariusH = cleanUp(temp);
					a.setText(sagittariusH);                       
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        });
        
        return tiles;
    }
	
	public void start(Stage stage) {
		final Label lbl = new Label();

        lbl.setLayoutX(80);
        lbl.setLayoutY(300);
        lbl.setPrefWidth(650);
        lbl.setWrapText(true);
        lbl.setFont(Font.font("Verdana", 16));
            Pane root = new Pane();
            Scene scene = new Scene(root, 800, 800);
            VBox layout = new VBox(
		            10,
		            createHorizontalButtonBox(
		                Arrays.stream("Capricorn Aquarius Pisces Aries Taurus Gemini Cancer Leo Virgo Libra Scorpio Sagittarius".split(" "))
		                        .map(ToggleButton::new)
		                        .collect(Collectors.toList()),
		                Pos.CENTER,
		                30,
		                true,
		                lbl
		            )
		    );
            layout.setPadding(new Insets(10));
            layout.setLayoutY(120);
            
            
            VBox layout2 = new VBox(
		            10,
		            createHorizontalButtonBox2(
		                Arrays.stream("Capricorn Aquarius Pisces Aries Taurus Gemini Cancer Leo Virgo Libra Scorpio Sagittarius".split(" "))
		                        .map(ToggleButton::new)
		                        .collect(Collectors.toList()),
		                Pos.CENTER,
		                30,
		                true,
		                lbl
		            )
		    );
            layout2.setPadding(new Insets(10));
            layout2.setLayoutY(620);
          
            
            ToggleButton button = new ToggleButton();
            button.setText("Don't know your sign? Click Here!");
            button.setLayoutX(280);
            button.setLayoutY(240);
            button.setOnAction(new EventHandler<ActionEvent>(){				
            	@Override
            	public void handle(ActionEvent event) {
                    final Stage dialog = new Stage();
                    dialog.initModality(Modality.APPLICATION_MODAL);
                    dialog.initOwner(null);
                    final Label sign = new Label();
                    sign.setAlignment(Pos.CENTER);
                    sign.setLayoutX(80);
                    sign.setLayoutY(300);
                    sign.setPrefWidth(650);
                    sign.setWrapText(true);
                    sign.setFont(Font.font("Verdana", 18));
                    ObservableList<String> months = 
                    	    FXCollections.observableArrayList(
                    	        "January",
                    	        "February",
                    	        "March",
                    	        "April",
                    	        "May",
                    	        "June",
                    	        "July",
                    	        "August",
                    	        "September",
                    	        "October",
                    	        "November",
                    	        "December"
                    	    );
                    monthsBox = new ComboBox(months);
                    ObservableList<String> days =
                    		FXCollections.observableArrayList(
                    				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13", "14", "15", "16", "17",
                    				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
                    		);
                    daysBox = new ComboBox(days);

                    Button subbutton = new Button("Submit");
                    subbutton.setOnAction(e->processSign(sign));
             
                    
                    VBox dialogVbox = new VBox(20);
                    Text text = new Text("Enter your birth date month and day: ");
                    text.setId("ericastext");
                    dialogVbox.getChildren().add(text);
                    dialogVbox.getChildren().add(monthsBox);
                    dialogVbox.getChildren().add(daysBox);
                    dialogVbox.getChildren().add(subbutton);
                    dialogVbox.getChildren().add(sign);
                    dialogVbox.setAlignment(Pos.CENTER);
                    Scene dialogScene = new Scene(dialogVbox, 400, 300);
                    dialogScene.getStylesheets().add("togglebutton3.css");
                    dialog.setScene(dialogScene);
                    dialog.show();
                }

				private void processSign(Label sign) {
					String month = monthsBox.getValue();
					int day = Integer.parseInt(daysBox.getValue());
					switch(month){
					case "January":
						if(day < 20)
							sign.setText("Your sign is: Capricorn");
						else
							sign.setText("Your sign is: Aquarius");
						break;
					case "February":
						if(day < 19)
							sign.setText("Your sign is: Aquarius");
						else
							sign.setText("Your sign is: Pisces");
						break;
					case "March":
						if(day < 21)
							sign.setText("Your sign is: Pisces");
						else
							sign.setText("Your sign is: Aries");
						break;
					case "April":
						if(day < 20)
							sign.setText("Your sign is: Aries");
						else
							sign.setText("Your sign is: Taurus");
						break;
					case "May":
						if(day < 21)
							sign.setText("Your sign is: Taurus");
						else
							sign.setText("Your sign is: Gemini");
						break;
					case "June":
						if(day < 21)
							sign.setText("Your sign is: Gemini");
						else
							sign.setText("Your sign is: Cancer");
						break;
					case "July":
						if(day < 23)
							sign.setText("Your sign is: Cancer");
						else
							sign.setText("Your sign is: Leo");
						break;
					case "August":
						if(day < 23)
							sign.setText("Your sign is: Leo");
						else
							sign.setText("Your sign is: Virgo");
						break;
					case "September":
						if(day < 23)
							sign.setText("Your sign is: Virgo");
						else
							sign.setText("Your sign is: Libra");
						break;
					case "October":
						if(day < 23)
							sign.setText("Your sign is: Libra");
						else
							sign.setText("Your sign is: Scorpio");
						break;
					case "November":
						if(day < 22)
							sign.setText("Your sign is: Scorpio");
						else
							sign.setText("Your sign is: Sagittarius");
						break;
					case "December":
						if(day < 22)
							sign.setText("Your sign is: Sagittarius");
						else
							sign.setText("Your sign is: Capricorn");
						break;
					}
				}
            });
            
            scene.getStylesheets().add("togglebutton2.css");          
            Text text = new Text(140, 50, "Welcome to the Horoscope Application!");
            text.setId("ericastext");
            //text.setFont(Font.font ("Verdana", 20));
            root.getChildren().addAll(layout);
            root.getChildren().addAll(layout2);
            //root.getChildren().add(text);
            root.getChildren().add(lbl);
            root.getChildren().add(button);
            
            stage.setScene(scene);
            stage.show();	        
	}
        
     

	public static void main(String[] args) throws IOException {

		launch(args);

	}

}
