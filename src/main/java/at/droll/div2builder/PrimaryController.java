package at.droll.div2builder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import at.droll.div2builder.framework.World;
import at.droll.div2builder.framework.attribute.Attribute;
import at.droll.div2builder.framework.statistic.StatsItem;
import at.droll.div2builder.framework.statistic.StatsItemComparator;

public class PrimaryController {	
	
	World world = new World();
	
	Map<String, TreeItem<StatsItem>> statisticReferences = new HashMap<>();
	
    @FXML
    private void switchToSecondary() throws IOException {
       App.setRoot("secondary");
    }
    
    @FXML
    private TreeTableView<StatsItem> statistics = new TreeTableView<StatsItem>();
        
    /**
     * Initializing of the controller
     */
	public void initialize() {
		// Putting the world bootstrap 
		world.bootstrap("Test", true);
		initializeStatisticsView();
    }
	
	/**
	 * Initializing of the tree table view with the default statistic values of the player
	 */
	private void initializeStatisticsView() {
		
		ArrayList<StatsItem> offensiveItems = new ArrayList<>();
		ArrayList<StatsItem> defensiveItems = new ArrayList<>();
		ArrayList<StatsItem> skillItems		= new ArrayList<>();
		
		// Getting the default values
		Map<Attribute, Double> values = world.getPlayer().getLoadout("Default")
								 						 .getStatistic()
								 						 .getData();
		
		
		// Defining Setting up main columns
		TreeTableColumn<StatsItem, String> columnAttribute = new TreeTableColumn<>("Attribute");
										   columnAttribute.setPrefWidth(300);
										   columnAttribute.setCellValueFactory(new TreeItemPropertyValueFactory<>("attribute"));
				
		TreeTableColumn<StatsItem, String> columnValue = new TreeTableColumn<>("Value");
										   columnValue.setPrefWidth(100);
										   columnValue.setCellValueFactory(new TreeItemPropertyValueFactory<>("value"));
		

		
		// Setting up the main child nodes of root and expand em
		TreeItem<StatsItem> rootNode = new TreeItem<>(new StatsItem("Statistics", ""));
							rootNode.setExpanded(true);							
		TreeItem<StatsItem> offensiveNode = new TreeItem<>(new StatsItem("Offensive", ""));		
							offensiveNode.setExpanded(true);		
		TreeItem<StatsItem> defensiveNode = new TreeItem<>(new StatsItem("Defensive", ""));
							defensiveNode.setExpanded(true);
		TreeItem<StatsItem> skillNode = new TreeItem<>(new StatsItem("Skill", ""));
							skillNode.setExpanded(true);
				
		// Separating the default player statistc data into the three nodes Offensive, Defensive, Skills
		// TODO Sort values before? Adding a filter 
		values.forEach((attribute, value) -> {
			StatsItem item;
			
			if (value != 0.0 || attribute == null) {
				item = new StatsItem(attribute, value);
				
				if (item.getAttribute() != "") {
					switch(item.getCategory()) {
						case "offensive":
							offensiveItems.add(item);
							break;
						case "defensive":
							defensiveItems.add(item);
							break;
						case "skill":
							skillItems.add(item);
							break;
					}
				}
			}
		});
		
		// Sorting all statistic values via alphabetic
		Collections.sort(offensiveItems, new StatsItemComparator());
		Collections.sort(defensiveItems, new StatsItemComparator());
		Collections.sort(skillItems, new StatsItemComparator());
			
		offensiveItems.forEach(offensiveItem -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(offensiveItem);
			offensiveNode.getChildren().add(tempItem);
			statisticReferences.put(tempItem.getValue().getAttribute(), tempItem);
		});
		
		defensiveItems.forEach(defensiveItem -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(defensiveItem);
			defensiveNode.getChildren().add(tempItem);
			statisticReferences.put(tempItem.getValue().getAttribute(), tempItem);
		});
		
		skillItems.forEach(skillItem -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(skillItem);
			skillNode.getChildren().add(tempItem);
			statisticReferences.put(tempItem.getValue().getAttribute(), tempItem);
		});
		
    	rootNode.getChildren().addAll(offensiveNode, defensiveNode, skillNode);
        statistics.setRoot(rootNode);
        statistics.getColumns().add(columnAttribute);
        statistics.getColumns().add(columnValue);                
        
        // Updating the raw for critical hit chance 
        //statisticReferences.get("CRITICALHITCHANCE").setValue(new StatsItem("CRITICALHITCHANCE", "150.0"));
	}
}
