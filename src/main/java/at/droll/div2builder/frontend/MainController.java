package at.droll.div2builder.frontend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.statistic.Statistic;
import at.droll.div2builder.core.statistic.StatsItem;
import at.droll.div2builder.core.statistic.StatsItemComparator;

public class MainController {	
	
	World world = new World();
	
// Maybe we remove them
// Map<String, TreeItem<StatsItem>> statisticReferences = new HashMap<>();
//	Map<String, Map<String, TreeItem<StatsItem>>> statisticReferences = new HashMap<>();
//	
//	// Initialisiator the for 
//	{
//		statisticReferences.put("PRIMARY", null);
//		statisticReferences.put("SECONDARY", null);
//		statisticReferences.put("PISTOL", null);
//	}
	
	
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
    private TitledPane titledpanekneepad;
    
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
    private ImageView kneepadbrandimage;
    
    @FXML
    private ImageView glovebrandimage;
    
    @FXML
    private CheckBox keenerwatch;   
    
    
    /**
     * Initializing of the controller
     */
	public void initialize() {
		
		// Putting the world bootstrap 
		world.bootstrap("Test", true);
		
		Inventory inventory = new Inventory();
		inventory = inventory.createMockupInventory();
		world.getPlayer().getLoadout("Default").setInventory(inventory);
		
		initializeStatisticsView(inventory);
		initializeAttributesCount(inventory);		
		initializeInventoryView(inventory);
		
		// Register the event handler
		keenerwatch.setOnAction(e -> keenerwatchAction(e));
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
				
		List<StatsItem> primaryItems = new ArrayList<>();
		List<StatsItem> secondaryItems = new ArrayList<>();
		List<StatsItem> pistolItems = new ArrayList<>();
		List<StatsItem> basestatsItems = new ArrayList<>();
		
		Map<String, Map<Attribute, Double>> values = world.getPlayer().getLoadout("Default")
																	  .getStatistic()
																	  .calculate(inventory);
		
		
		Map<String, Map<Attribute, Double>> brandsetValues = world.getPlayer().getLoadout("Default")
																 .getStatistic()
																 .getBonusByBrandset(inventory);
		
		Map<Attribute, Double> basestatValue = world.getPlayer().getLoadout("Default")
				 								 .getStatistic()
				 								 .getData();
				
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
		TreeItem<StatsItem> primaryNode = new TreeItem<>(new StatsItem("Primary", ""));
							primaryNode.setExpanded(true);
		TreeItem<StatsItem> secondaryNode = new TreeItem<>(new StatsItem("Secondary", ""));
							secondaryNode.setExpanded(true);
		TreeItem<StatsItem> pistolNode = new TreeItem<>(new StatsItem("Pistol", ""));
							pistolNode.setExpanded(true);
							
		TreeItem<StatsItem> detailNode = new TreeItem<>(new StatsItem("Other", ""));
							detailNode.setExpanded(true);
							
		TreeItem<StatsItem> primaryOffensiveNode = new TreeItem<>(new StatsItem("Offensive", ""));		
							primaryOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> primaryDefensiveNode = new TreeItem<>(new StatsItem("Defensive", ""));
							primaryDefensiveNode.setExpanded(true);
		TreeItem<StatsItem> primarySkillNode = new TreeItem<>(new StatsItem("Skill", ""));
							primarySkillNode.setExpanded(true);
							
		TreeItem<StatsItem> secondaryOffensiveNode = new TreeItem<>(new StatsItem("Offensive", ""));		
							secondaryOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> secondaryDefensiveNode = new TreeItem<>(new StatsItem("Defensive", ""));
							secondaryDefensiveNode.setExpanded(true);
		TreeItem<StatsItem> secondarySkillNode = new TreeItem<>(new StatsItem("Skill", ""));
							primarySkillNode.setExpanded(true);
							
		TreeItem<StatsItem> pistolOffensiveNode = new TreeItem<>(new StatsItem("Offensive", ""));		
							pistolOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> pistolDefensiveNode = new TreeItem<>(new StatsItem("Defensive", ""));
							pistolDefensiveNode.setExpanded(true);
		TreeItem<StatsItem> pistolSkillNode = new TreeItem<>(new StatsItem("Skill", ""));
							pistolSkillNode.setExpanded(true);
							
		TreeItem<StatsItem> brandsetNode = new TreeItem<>(new StatsItem("Brandset Bonus", ""));		
							brandsetNode.setExpanded(true);
							
		TreeItem<StatsItem> basestatNode = new TreeItem<>(new StatsItem("Base Stats", ""));		
							basestatNode.setExpanded(true);
				
		// Creating StatsItems for the returned statistics to sort them
		values.forEach((weaponslot, stats) -> {
			
			stats.forEach((attribute, value) -> {
				StatsItem item;
				if (value != 0.0 || attribute != null) {
					item = new StatsItem(attribute, value);
					
					switch(weaponslot) {
						case "PRIMARY" -> primaryItems.add(item);
						case "SECONDARY" -> secondaryItems.add(item);
						case "PISTOL" -> pistolItems.add(item);
					}
				}
			});						
		});
		
		brandsetValues.forEach((manufacturer, attributes) -> {			
			TreeItem<StatsItem> manuNode = new TreeItem<>(new StatsItem(manufacturer, ""));
			brandsetNode.getChildren().add(manuNode);
			manuNode.setExpanded(true);
			
			attributes.forEach((attribute, value) -> {
				StatsItem item;
				
				if (attribute.toString().equals(Attribute.WEAPONDAMAGE.toString()) != true) {
					item = new StatsItem(attribute, value);
					TreeItem<StatsItem> tempItem = new TreeItem<>(item);
					manuNode.getChildren().add(tempItem);
				}
			});
		});
		
		basestatValue.forEach((attribute, value) -> {
			StatsItem item;
			if (value != 0.0 || attribute != null) {
				item = new StatsItem(attribute, value);
				basestatsItems.add(item);
			}
		});
		
		// Sorting the items
		Collections.sort(primaryItems, new StatsItemComparator());
		Collections.sort(secondaryItems, new StatsItemComparator());
		Collections.sort(pistolItems, new StatsItemComparator());
		Collections.sort(basestatsItems, new StatsItemComparator());
		
		
		primaryItems.forEach(item -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(item); 
			switch(item.getCategory()) {
				case "offensive" -> primaryOffensiveNode.getChildren().add(tempItem);
				case "defensive" -> primaryDefensiveNode.getChildren().add(tempItem);					
				case "skill" 	 -> primarySkillNode.getChildren().add(tempItem);
			}
		});
		
		secondaryItems.forEach(item -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(item);
			switch(item.getCategory()) {
				case "offensive" -> secondaryOffensiveNode.getChildren().add(tempItem);
				case "defensive" -> secondaryDefensiveNode.getChildren().add(tempItem);					
				case "skill" 	 -> secondarySkillNode.getChildren().add(tempItem);
			}
		});
		
		pistolItems.forEach(item -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(item);
			switch(item.getCategory()) {
				case "offensive" -> pistolOffensiveNode.getChildren().add(tempItem);
				case "defensive" -> pistolDefensiveNode.getChildren().add(tempItem);					
				case "skill" 	 -> pistolSkillNode.getChildren().add(tempItem);
			}
		});
		
		basestatsItems.forEach(item -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(item);
			basestatNode.getChildren().add(tempItem);
		});	

		rootNode.getChildren().addAll(List.of(primaryNode, secondaryNode, pistolNode, detailNode));
		primaryNode.getChildren().addAll(List.of(primaryOffensiveNode, primaryDefensiveNode, primarySkillNode));
		secondaryNode.getChildren().addAll(List.of(secondaryOffensiveNode, secondaryDefensiveNode, secondarySkillNode));
		pistolNode.getChildren().addAll(List.of(pistolOffensiveNode, pistolDefensiveNode, pistolSkillNode));
		detailNode.getChildren().addAll(List.of(brandsetNode, basestatNode));
		
		
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
		titledpanekneepad.setCollapsible(false);
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
			titledpanekneepad.setText("Improvised kneepad");
		} else if (kneepad.isNamedItem()) {
			titledpanekneepad.setText(kneepad.getName());
		} else {
			titledpanekneepad.setText("Normal " + holster.getManufacturer().getName() + " kneepads");
		}
		
		if (kneepad.isImprovisedItem() == false) {
			kneepadbrandimage.setImage(new Image(
				App.class.getResource("assets/brands/"+ kneepad.getManufacturer().getShortname() + ".png").toExternalForm(),
				true
			));
		}
	}
	
	/**
	 * Action if the level40 Checkbox was clicked
	 * @param event
	 */
	private void keenerwatchAction(Event event) {
		
		// Deactivating level 40
		if (((CheckBox) event.getSource()).isSelected() == false) {
			world.getPlayer().getLoadout("Default").setStatistic(new Statistic(false));
		} else {
			world.getPlayer().getLoadout("Default").setStatistic(new Statistic(true));
		}
		
		// Updating the the TreeView
		statistics.getRoot().getChildren().clear();
		statistics.getColumns().clear();		
		statistics.setRoot(null);
		
		initializeStatisticsView(world.getPlayer().getLoadout("Default").getInventory());
	}
}
