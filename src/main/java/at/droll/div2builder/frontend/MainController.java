package at.droll.div2builder.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.statistic.StatsItem;
import at.droll.div2builder.core.statistic.StatsItemComparator;

public class MainController {	
	
	World world = new World();
	
	Map<String, TreeItem<StatsItem>> statisticReferences = new HashMap<>();	
        
    @FXML
    private TreeTableView<StatsItem> statistics = new TreeTableView<StatsItem>();
        
    @FXML
    private TitledPane titledpanemask;
    
    @FXML
    private TitledPane titledpanebackpack;
    
    @FXML
    private TitledPane titledpanearmor;
    
    @FXML
    private TitledPane titledpaneglove;
    
    @FXML
    private TitledPane titledpaneholster;
    
    @FXML
    private TitledPane titledpanekneepads;
    
    @FXML
    private TitledPane titledpaneprimary;
    
    @FXML
    private TitledPane titledpanesecondary;
    
    @FXML
    private TitledPane titledpanepistol;
        
    @FXML
    private Label corered;
    
    @FXML
    private Label coreblue;
    
    @FXML
    private Label coreyellow;
    
    @FXML
    private Label minorred;
    
    @FXML
    private Label minorblue;
    
    @FXML
    private Label minoryellow;
    
    @FXML
    private ImageView maskbrandimage;
    
    @FXML
    private ImageView holsterbrandimage;
    
    @FXML
    private ImageView armorbrandimage;
    
    @FXML
    private ImageView backpackbrandimage;
    
    @FXML
    private ImageView kneepadsbrandimage;
    
    @FXML
    private ImageView glovebrandimage;
    
    
    /**
     * Initializing of the controller
     */
	public void initialize() {
		
		// Putting the world bootstrap 
		world.bootstrap("Test", true);
		
		Inventory inventory = new Inventory();
		inventory = inventory.createMockupInventory();
		
		initializeStatisticsView(inventory);
		initializeAttributesCount(inventory);		
		initializeInventoryView(inventory);
    }
	
	/**
	 * Initializing of the attributes count view
	 * @param inventory The inventory to count the core and minor attribute colors
	 */
	private void initializeAttributesCount(Inventory inventory) {
		
		Map<String, Map<String, Integer>> values = world.getPlayer().getLoadout("Default")
							 										.getStatistic()
							 										.determineRedYellowBlueColors(inventory);
		
		corered.setText(values.get("core").get("red").toString());
		coreblue.setText(values.get("core").get("blue").toString());
		coreyellow.setText(values.get("core").get("yellow").toString());
		
		minorred.setText(values.get("minor").get("red").toString());
		minorblue.setText(values.get("minor").get("blue").toString());
		minoryellow.setText(values.get("minor").get("yellow").toString());
	}
	
	/**
	 * Initializing of the tree table view with the default statistic values of the player
	 * @param inventory The Inventory to do the statistics calculation
	 */
	private void initializeStatisticsView(Inventory inventory) {
		
		List<StatsItem> items = new ArrayList<>();
		
		Map<String, Map<Attribute, Double>> values = world.getPlayer().getLoadout("Default")
																	  .getStatistic()
																	  .calculate(inventory);
		
		Map<Attribute, Double> brandsetValues = world.getPlayer().getLoadout("Default")
																 .getStatistic()
																 .calculateBrandsetBonus(inventory);
				
		// Setting up main columns
		TreeTableColumn<StatsItem, String> columnAttribute = new TreeTableColumn<>("Attribute");
		columnAttribute.setPrefWidth(150);
		columnAttribute.setCellValueFactory(new TreeItemPropertyValueFactory<>("attribute"));
				
		TreeTableColumn<StatsItem, String> columnValue = new TreeTableColumn<>("Value");
		columnValue.setPrefWidth(100);
		columnValue.setCellValueFactory(new TreeItemPropertyValueFactory<>("value"));
		
		// Setting up the main child nodes of root and expand them all
		TreeItem<StatsItem> rootNode = new TreeItem<>(new StatsItem("Statistics", ""));
							rootNode.setExpanded(true);		
		TreeItem<StatsItem> brandsetNode = new TreeItem<>(new StatsItem("Brandset Bonus", ""));		
							brandsetNode.setExpanded(true);
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
		
		brandsetValues.forEach((attribute, value) -> {
			StatsItem item;
			if (value != 0.0 || attribute != null) {
				item = new StatsItem(attribute, value);
				brandsetNode.getChildren().add(new TreeItem<>(item));
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
		
		rootNode.getChildren().addAll(List.of(brandsetNode, offensiveNode, defensiveNode, skillNode));
        statistics.setRoot(rootNode);
        statistics.getColumns().add(columnAttribute);
        statistics.getColumns().add(columnValue);                
        
        // Updating the raw for critical hit chance 
        //statisticReferences.get("CRITICALHITCHANCE").setValue(new StatsItem("CRITICALHITCHANCE", "150.0"));
	}
	
	/**
	 * Initialize the inventory view
	 * @param inventory
	 */
	private void initializeInventoryView(Inventory inventory) {
		
		titledpanemask.setCollapsible(false);
		titledpanearmor.setCollapsible(false);
		titledpanebackpack.setCollapsible(false);
		titledpaneglove.setCollapsible(false);
		titledpanekneepads.setCollapsible(false);
		titledpaneholster.setCollapsible(false);
		titledpaneprimary.setCollapsible(false);
		titledpanesecondary.setCollapsible(false);
		titledpanepistol.setCollapsible(false);
		
		titledpanemask.setStyle("-fx-background-color:blue;");
		
		// Mask
		Equipment mask = (Equipment) inventory.getEquipment(InventorySlot.MASK);				
				
		if (mask.isNamedItem()) {
			titledpanemask.setText(mask.getName());
		} else {
			titledpanemask.setText("Normal " + mask.getManufacturer().getName() + " mask");
		}
		
		maskbrandimage.setImage(new Image(
			App.class.getResource("assets/brands/"+ mask.getManufacturer().getShortname() + ".png").toExternalForm(),
			true
		));
		
		// Backpack
		Equipment backpack = (Equipment) inventory.getEquipment(InventorySlot.BACKPACK);				
				
		if (backpack.isNamedItem()) {
			titledpanebackpack.setText(backpack.getName());
		} else {
			titledpanebackpack.setText("Normal " + mask.getManufacturer().getName() + " backpack");
		}
		
		backpackbrandimage.setImage(new Image(
			App.class.getResource("assets/brands/"+ backpack.getManufacturer().getShortname() + ".png").toExternalForm(),
			true
		));
		
		// Armor
		Equipment armor = (Equipment) inventory.getEquipment(InventorySlot.ARMOR);
		
		if (armor.isNamedItem()) {
			titledpanearmor.setText(armor.getName());
		} else {
			titledpanearmor.setText("Normal " + mask.getManufacturer().getName() + " armor chest");
		}
		
		armorbrandimage.setImage(new Image(
			App.class.getResource("assets/brands/"+ armor.getManufacturer().getShortname() + ".png").toExternalForm(),
			true
		));
		
		
		// Glove
		Equipment glove = (Equipment) inventory.getEquipment(InventorySlot.GLOVE);
		
		if (glove.isImprovisedItem() == true) {
			titledpaneglove.setText("Improvised glove");
		} else if (glove.isNamedItem()) {
			titledpaneglove.setText(glove.getName());
		} else {
			titledpaneholster.setText("Normal " + glove.getManufacturer().getName() + " gloves");
		}
		
		if (glove.isImprovisedItem() == false) {
			glovebrandimage.setImage(new Image(
				App.class.getResource("assets/brands/"+ glove.getManufacturer().getShortname() + ".png").toExternalForm(),
				true
			));
		}
		
		// Holster
		Equipment holster = (Equipment) inventory.getEquipment(InventorySlot.HOLSTER);
		if (holster.isImprovisedItem() == true) {
			titledpaneholster.setText("Improvised holster");
		} else if (holster.isNamedItem()) {
			titledpaneholster.setText(holster.getName());
		} else {
			titledpaneholster.setText("Normal " + holster.getManufacturer().getName() + " holster");
		}
		
		if (holster.isImprovisedItem() == false) {
			holsterbrandimage.setImage(new Image(
				App.class.getResource("assets/brands/"+ holster.getManufacturer().getShortname() + ".png").toExternalForm(),
				true
			));
		}
		
		// Kneepad
		Equipment kneepad = (Equipment) inventory.getEquipment(InventorySlot.KNEEPAD);
		if (kneepad.isImprovisedItem() == true) {
			titledpanekneepads.setText("Improvised kneepad");
		} else if (kneepad.isNamedItem()) {
			titledpanekneepads.setText(kneepad.getName());
		} else {
			titledpanekneepads.setText("Normal " + holster.getManufacturer().getName() + " kneepads");
		}
		
		if (kneepad.isImprovisedItem() == false) {
			kneepadsbrandimage.setImage(new Image(
				App.class.getResource("assets/brands/"+ kneepad.getManufacturer().getShortname() + ".png").toExternalForm(),
				true
			));
		}
	}
}
