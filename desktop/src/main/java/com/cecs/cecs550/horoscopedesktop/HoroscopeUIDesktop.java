package com.cecs.cecs550.horoscopedesktop;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import core.SunSign;
import core.SunSignHelper;
import jdk.nashorn.internal.ir.annotations.Ignore;
import net.HoroscopeSource;
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
import util.JSONFormatUtils;

public class HoroscopeUIDesktop extends Application{
	Label myLabel;
	private Text horo = new Text();
	private int height = 600;
	private int width = 800;
    private final static ArrayList<SunSign> sunSigns = new ArrayList<>(Arrays.asList(SunSign.values()));
	ComboBox<String> monthsBox;
	ComboBox<String> daysBox;
	
	/*public static String httpGet(String urlStr) throws IOException {
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
	}*/
	
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

        ArrayList<String> sunSignInfo = new ArrayList<>();
        /*"[Strengths]: Responsible, disciplined, self-control, good managers\n"+
                "[Weaknesses]: Know-it-all, unforgiving, condescending, expecting the worst\n"+
                "[Capricorn likes]: Family, tradition, music, understated status, quality craftsmanship\n"+
                "[Capricorn dislikes]: Almost everything at some point";*/
        for(int i = 0; i < sunSigns.size(); i++)
        {
            buttons.get(i).setMinWidth(ToggleButton.USE_PREF_SIZE);
            buttons.get(i).setMaxWidth(Double.MAX_VALUE);
            int finalI = i;
            buttons.get(i).setOnAction(event -> {
                    String signInfo = sunSignInfo.get(finalI);
                    a.setText(signInfo);

            });
        }

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

		for(int i = 0; i < sunSigns.size(); i++) {
            buttons.get(i).setMinWidth(ToggleButton.USE_PREF_SIZE);
            buttons.get(i).setMaxWidth(Double.MAX_VALUE);
            HoroscopeSource horoscopeSource = new HoroscopeSource();
            int finalI = i;
            buttons.get(i).setOnAction(event -> {
                    String temp = horoscopeSource.getHoroscopeFor(sunSigns.get(finalI));
                    String horoscope = JSONFormatUtils.cleanUp("horoscope", temp, "\\(c\\) Kelli Fox, The Astrologer, http://new.theastrologer.com");
                    a.setText(horoscope);
            });
        }
        
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
                    subbutton.setOnAction(e-> SunSignHelper.determineSunSign(monthsBox.getValue(),Integer.getInteger(daysBox.getValue())));
             
                    
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
