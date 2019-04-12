package application;
	
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.sun.javafx.css.converters.StringConverter;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;



public class Main extends Application {
	
	private TableView<Lancamento>  table = new TableView<Lancamento>();
	

    TableColumn<Lancamento, Double> tcLatitude = new TableColumn<Lancamento, Double> ("Latitude(Y)");
    TableColumn<Lancamento, Double>  tcLongitude = new TableColumn<Lancamento, Double> ("Longitude(X)");
    TableColumn<Lancamento, String>  tcAreaContribuicao = new TableColumn<Lancamento, String> ("Área de Contribuição");
    TableColumn<Lancamento, String>  tcImpermeabilizacao = new TableColumn<Lancamento, String> ("% de impermeabilização");
    TableColumn<Lancamento, String>  tcVazaoMaxima = new TableColumn<Lancamento, String> ("Vazão máxima estimada ");
    
    ObservableList<Lancamento> obsList = FXCollections.observableArrayList();
    
	Lancamento lan1;
	Lancamento lan2;

	
	  String t = "-----";
	  
	Lancamento lan;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		try {
			
			Scene scene = new Scene(new Group());
	        stage.setTitle("Table View Sample");
	        stage.setWidth(940);
	        stage.setHeight(400);
	 
	        final Label label = new Label("Address Book");
	        label.setFont(new Font("Arial", 20));
	 
	        table.setEditable(true);
	    
	        table.setPrefSize(850, 200);
	 
	        tcLatitude.setCellValueFactory(new PropertyValueFactory<Lancamento,Double>("lanLatitude"));
	        tcLongitude.setCellValueFactory(new PropertyValueFactory<Lancamento,Double>("lanLongitude"));
	        tcAreaContribuicao.setCellValueFactory(new PropertyValueFactory<Lancamento,String>("lanAreaContribuicao")); 
	        tcImpermeabilizacao.setCellValueFactory(new PropertyValueFactory<Lancamento,String>("lanImpermeabilizacao")); 
	        tcVazaoMaxima.setCellValueFactory(new PropertyValueFactory<Lancamento,String>("lanVazaoMaxima")); 
	        
	        tcLatitude.setPrefWidth(135.0);
	        tcLongitude.setPrefWidth(135.0);
	        tcAreaContribuicao.setPrefWidth(200.0);
	        tcImpermeabilizacao.setPrefWidth(200.0);
	        tcVazaoMaxima.setPrefWidth(200.0);
	        
	        table.getColumns().addAll(tcLatitude, tcLongitude,tcAreaContribuicao,tcImpermeabilizacao,tcVazaoMaxima);
	        
	        /*
	    	ArrayList<TableColumn<Lancamento, String>> listNodes = new ArrayList<TableColumn<Lancamento, String>>();
		        listNodes.add(tcLatitude);
		        	listNodes.add(tcLongitude);
		        		listNodes.add(tcAreaContribuicao);
		        			listNodes.add(tcImpermeabilizacao);
		        				listNodes.add(tcVazaoMaxima);
	        
	        
		        				double [] prefWidth  = {135.0, 135.0, 200.0, 200.0, 200.0};
	    	
						        for (int i = 0; i<listNodes.size();i++) {
						        	
						        	((TableColumn<Lancamento, String>)listNodes.get(i)).setPrefWidth(prefWidth[i]);
						        	table.getColumns().add(listNodes.get(i));
						        }
	        */
	        
	      
	      
	        Button btn1 = new Button("+");
	        Button btn2 = new Button("-");
	        Button btn3 = new Button("Res");
	        
	        btn1.setPrefSize(30, 30);
	        btn1.setLayoutX(880);
	        btn1.setLayoutY(66);
	        
	        btn2.setPrefSize(30, 30);
	        btn2.setLayoutX(880);
	        btn2.setLayoutY(108);
	        
	        btn2.setPrefSize(30, 30);
	        btn2.setLayoutX(880);
	        btn2.setLayoutY(120);
	        
	        
	        btn1.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	
	                Lancamento lan = new Lancamento(-15.0, -47.0, "?", "?", "?");
	              
	                obsList.add(lan);
	            }
	        });
	        
	        
	        btn2.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                obsList.remove(lan);
	            }
	        });
	        
	     
	        btn3.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                
	            	List<Lancamento> lanList = new ArrayList<Lancamento>();
	            	
	            	lanList = obsList;
	            	
	            	for(Lancamento lan : lanList) {

	            		System.out.println(
	            					"Lançamentos: " 
	            					+ "Latitude: " + lan.getLanLatitude()
	            					+ "\n Longitude: " + lan.getLanLongitude()
	            					+ "\n Área de Contribuição: " + lan.getLanAreaContribuicao()
	            				
	            				);
	            	}
	            	
	            	
	            }
	        });
	        
	        
	        editarColunas ();
	        
	        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
				
				public void changed(ObservableValue<?> observable , Object oldValue, Object newValue) {
				
				lan = (Lancamento) newValue;
				
				String s = "--- XX --"; 	//
				
				try {
					System.out.println((t+=s));
					System.out.println(lan.getLanAreaContribuicao());
					
				}
				
				catch (Exception e) {
					System.out.println("objeto null");
				}
				
				
			} // fim do metodo changed
				
				
		}); // fim do selection model
	        
	        
	        
	        obsList.add(new Lancamento (-15.0,-47.0,"111111", "22222", "3333333"));
	        obsList.add(new Lancamento (-16.0,-50.0,"44444", "55555", "66666"));
	        
	        
	        table.setItems(obsList); 
	        
	        final VBox vbox = new VBox();
	        vbox.setSpacing(5);
	        vbox.setPadding(new Insets(10, 0, 0, 10));
	        vbox.getChildren().addAll(label, table, btn1, btn2, btn3);
	 
	        ((Group) scene.getRoot()).getChildren().addAll(vbox);
	 
	        stage.setScene(scene);
	        stage.show();
	        
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void editarColunas () {
		
			 tcLatitude.setCellValueFactory(
		                new PropertyValueFactory<Lancamento, Double>("lanLatitude"));
			 			tcLatitude.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
			 			tcLatitude.setOnEditCommit(
		                new EventHandler<CellEditEvent<Lancamento, Double>>() {
		                    @Override
		                    public void handle(CellEditEvent<Lancamento, Double> t) {
		                        ((Lancamento) t.getTableView().getItems().get(
		                        		t.getTablePosition().getRow())
		                            ).setLanLatitude(t.getNewValue()); 
		                        	//l.setLanLatitude(t.getNewValue()); 
		                       
		                    }
		                }
		            );
        	        	
		 			 tcLongitude.setCellValueFactory(
				                new PropertyValueFactory<Lancamento, Double>("lanLongitude"));
		 			 			tcLongitude.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		 			 			tcLongitude.setOnEditCommit(
				                new EventHandler<CellEditEvent<Lancamento, Double>>() {
				                    @Override
				                    public void handle(CellEditEvent<Lancamento, Double> t) {
				                        ((Lancamento) t.getTableView().getItems().get(
				                        		t.getTablePosition().getRow())
				                            ).setLanLongitude(t.getNewValue()); 
				                        
				                       // l.setLanLongitude(t.getNewValue());
				                    }
				                }
				            );
        	        	        		
	        		 		tcAreaContribuicao.setCellValueFactory(
	        		 	                new PropertyValueFactory<Lancamento, String>("lanAreaContribuicao"));
	        		 	        		tcAreaContribuicao.setCellFactory(TextFieldTableCell.forTableColumn());
	        		 	        		tcAreaContribuicao.setOnEditCommit(
	        		 	                new EventHandler<CellEditEvent<Lancamento, String>>() {
	        		 	                    @Override
	        		 	                    public void handle(CellEditEvent<Lancamento, String> t) {
	        		 	                        ((Lancamento) t.getTableView().getItems().get(
	        		 	                        		t.getTablePosition().getRow())
	        		 	                            ).setLanAreaContribuicao(t.getNewValue());
	        		 	                        
	        		 	                       //l.setLanAreaContribuicao(t.getNewValue());
	        		 	                    
	        		 	                    }
	        		 	                }
	        		 	            );
	        		 	        		    		
    	        	        		 tcImpermeabilizacao.setCellValueFactory(
    	        	        	                new PropertyValueFactory<Lancamento, String>("lanImpermeabilizacao"));
    	        	        		 			tcImpermeabilizacao.setCellFactory(TextFieldTableCell.forTableColumn());
    	        	        		 			tcImpermeabilizacao.setOnEditCommit(
    	        	        	                new EventHandler<CellEditEvent<Lancamento, String>>() {
    	        	        	                    @Override
    	        	        	                    public void handle(CellEditEvent<Lancamento, String> t) {
    	        	        	                        ((Lancamento) t.getTableView().getItems().get(
    	        	        	                        		t.getTablePosition().getRow())
    	        	        	                            ).setLanImpermeabilizacao(t.getNewValue());
    	        	        	                        
    	        	        	                      //  l.setLanImpermeabilizacao(t.getNewValue());
    	        	        	                         
    	        	        	                    }
    	        	        	                }
    	        	        	            );
	        	        		 			
	        	        		 			 tcVazaoMaxima.setCellValueFactory(
	     	        	        	                new PropertyValueFactory<Lancamento, String>("lanVazaoMaxima"));
	        	        		 			 		tcVazaoMaxima.setCellFactory(TextFieldTableCell.forTableColumn());
	        	        		 			 		tcVazaoMaxima.setOnEditCommit(
	     	        	        	                new EventHandler<CellEditEvent<Lancamento, String>>() {
	     	        	        	                    @Override
	     	        	        	                    public void handle(CellEditEvent<Lancamento, String> t) {
	     	        	        	                        ((Lancamento) t.getTableView().getItems().get(
	     	        	        	                        		t.getTablePosition().getRow())
	     	        	        	                            ).setLanVazaoMaxima(t.getNewValue());
	     	        	        	                        
	     	        	        	                     //   l.setLanVazaoMaxima(t.getNewValue());
	     	        	        	                         
	     	        	        	                    }
	     	        	        	                }
	     	        	        	            );
       
		
	}
	
	
}
