package at.droll.div2builder.frontend;

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
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.statistic.StatsItem;
import at.droll.div2builder.core.statistic.StatsItemComparator;

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
		
		List<StatsItem> items = new ArrayList<>();
							
		// Getting the default values
//		Map<Attribute, Double> values = world.getPlayer().getLoadout("Default")
//								 						 .getStatistic()
//								 						 .getData();
		
		Inventory inventory = new Inventory();
		inventory = inventory.createMockupInventory();
		Map<String, Map<Attribute, Double>> values = world.getPlayer().getLoadout("Default")
														 .getStatistic()
														 .calculate(inventory);

				
		// Setting up main columns
		TreeTableColumn<StatsItem, String> columnAttribute = new TreeTableColumn<>("Attribute");
										   columnAttribute.setPrefWidth(300);
										   columnAttribute.setCellValueFactory(new TreeItemPropertyValueFactory<>("attribute"));
				
		TreeTableColumn<StatsItem, String> columnValue = new TreeTableColumn<>("Value");
										   columnValue.setPrefWidth(100);
										   columnValue.setCellValueFactory(new TreeItemPropertyValueFactory<>("value"));
		
		// Setting up the main child nodes of root and expand them all
		TreeItem<StatsItem> rootNode = new TreeItem<>(new StatsItem("Statistics", ""));
							rootNode.setExpanded(true);							
		TreeItem<StatsItem> offensiveNode = new TreeItem<>(new StatsItem("Offensive", ""));		
							offensiveNode.setExpanded(true);		
		TreeItem<StatsItem> defensiveNode = new TreeItem<>(new StatsItem("Defensive", ""));
							defensiveNode.setExpanded(true);
		TreeItem<StatsItem> skillNode = new TreeItem<>(new StatsItem("Skill", ""));
							skillNode.setExpanded(true);
				
		// Creating StatsItems what are needed for the TableView
		values.get("PRIMARY").forEach((attribute, value) -> {			
			StatsItem item;
			if (value != 0.0 || attribute != null) {
				item = new StatsItem(attribute, value);
				items.add(item);
			}
		});
		Collections.sort(items, new StatsItemComparator());
	
		
		items.forEach(item -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(item);
			statisticReferences.put(tempItem.getValue().getAttribute(), tempItem);
			
			// New way of case 
			switch(item.getCategory()) {
				case "offensive" -> offensiveNode.getChildren().add(tempItem);
				case "defensive" -> defensiveNode.getChildren().add(tempItem);					
				case "skill" 	 -> skillNode.getChildren().add(tempItem);
			}
		});
		
		rootNode.getChildren().addAll(List.of(offensiveNode, defensiveNode, skillNode));
        statistics.setRoot(rootNode);
        statistics.getColumns().add(columnAttribute);
        statistics.getColumns().add(columnValue);                
        
        // Updating the raw for critical hit chance 
        //statisticReferences.get("CRITICALHITCHANCE").setValue(new StatsItem("CRITICALHITCHANCE", "150.0"));
	}
}
