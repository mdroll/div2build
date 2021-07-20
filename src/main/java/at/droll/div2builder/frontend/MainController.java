package at.droll.div2builder.frontend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

/**
 * Main controller / Business logic for the ui

 * @author Marco Droll
 */
public class MainController {	
	
	/**
	 * Holds the World with the data factories, player information and so on
	 */
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
	
	/**
	 * Holds the instance of the ThreeTableView on the right side
	 */
    @FXML
    private TreeTableView<StatsItem> statistics = new TreeTableView<StatsItem>();
        
    /**
     * Holds the instance of the TitledPane mask on the left side
     */
    @FXML
    private TitledPane titledpanemask;
    
    /**
     * Holds the instance of the TitledPane backpack on the left side
     */
    @FXML
    private TitledPane titledpanebackpack;
    
    /**
     * Holds the instance of the TitledPane armor on the left side
     */
    @FXML
    private TitledPane titledpanearmor;
    
    /**
     * Holds the instance of the TitledPane glove on the left side
     */
    @FXML
    private TitledPane titledpaneglove;
    
    /**
     * Holds the instance of the TitledPane holster on the left side
     */
    @FXML
    private TitledPane titledpaneholster;
    
    /**
     * Holds the instance of the TitledPane kneepad on the left side
     */
    @FXML
    private TitledPane titledpanekneepad;
    
    /**
     * Holds the instance of the TitledPane primary weapon on the left side
     */
    @FXML
    private TitledPane titledpaneprimary;
    
    /**
     * Holds the instance of the TitledPane secondary weapon on the left side
     */
    @FXML
    private TitledPane titledpanesecondary;
    
    /**
     * Holds the instance of the TitledPane pistol weapon on the left side
     */
    @FXML
    private TitledPane titledpanepistol;
    
    /**
     * Holds the instance of the TitledPane specialization on the left side
     */
    @FXML
    private TitledPane titledpanespecialization;
    
    /**
     * Holds the instance of the TitledPane placeholder1 on the left side
     */
    @FXML
    private TitledPane titledpaneplaceholder1;
    
    /**
     * Holds the instance of the TitledPane placeholder2 on the left side
     */
    @FXML
    private TitledPane titledpaneplaceholder2;
        
    /**
     * Holds the instance of the Label for the core red color 
     */
    @FXML
    private Label corered;
    
    /**
     * Holds the instance of the Label for the core blue color 
     */
    @FXML
    private Label coreblue;
    
    /**
     * Holds the instance of the Label for the core yellow color 
     */
    @FXML
    private Label coreyellow;
    
    /**
     * Holds the instance of the Label for the minor red color 
     */
    @FXML
    private Label minorred;
    
    /**
     * Holds the instance of the Label for the minor blue color 
     */
    @FXML
    private Label minorblue;
    
    /**
     * Holds the instance of the Label for the minor yellow color 
     */
    @FXML
    private Label minoryellow;
    
    /**
     * Holds the instance of the ImageView for the mask brand 
     */
    @FXML
    private ImageView maskbrandimage;
    
    /**
     * Holds the instance of the ImageView for the holster brand 
     */
    @FXML
    private ImageView holsterbrandimage;
    
    /**
     * Holds the instance of the ImageView for the armor brand 
     */
    @FXML
    private ImageView armorbrandimage;
    
    /**
     * Holds the instance of the ImageView for the backpack brand 
     */
    @FXML
    private ImageView backpackbrandimage;
    
    /**
     * Holds the instance of the ImageView for the kneepad brand 
     */
    @FXML
    private ImageView kneepadbrandimage;
    
    /**
     * Holds the instance of the ImageView for the glvoe brand 
     */
    @FXML
    private ImageView glovebrandimage;
    
    /**
     * Holds the instance of the CheckBox for the keener watch 
     */
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
		List<StatsItem> basestatItems = new ArrayList<>();
		List<List<StatsItem>> items = List.of(primaryItems, secondaryItems, pistolItems, basestatItems);
		
		// Retrieve the statistic data from the world
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
				
		
		// Setting up all the treeItem nodes 
		TreeItem<StatsItem> rootNode = new TreeItem<>(new StatsItem("Statistics", ""));
							rootNode.setExpanded(true);
	
		TreeItem<StatsItem> primaryNode = new TreeItem<>(new StatsItem("Primary Weapon", ""));
							primaryNode.setExpanded(true);
		TreeItem<StatsItem> secondaryNode = new TreeItem<>(new StatsItem("Secondary Weapon", ""));
//							secondaryNode.setExpanded(true);
		TreeItem<StatsItem> pistolNode = new TreeItem<>(new StatsItem("Pistol", ""));
//							pistolNode.setExpanded(true);
							
		TreeItem<StatsItem> detailNode = new TreeItem<>(new StatsItem("Other", ""));
		detailNode.setExpanded(true);
					
		StatsItem offensiveStatsItem = new StatsItem("Offensive", "");
		StatsItem defensiveStatsItem = new StatsItem("Defensive", "");
		StatsItem skillStatsItem = new StatsItem("Skill", "");		
		
		// Nodes for the primary weapon
		TreeItem<StatsItem> primaryOffensiveNode = new TreeItem<>(offensiveStatsItem);		
							primaryOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> primaryDefensiveNode = new TreeItem<>(defensiveStatsItem);
//							primaryDefensiveNode.setExpanded(true);
		TreeItem<StatsItem> primarySkillNode = new TreeItem<>(skillStatsItem);
//							primarySkillNode.setExpanded(true);
			
		// Nodes for the secondary weapon
		TreeItem<StatsItem> secondaryOffensiveNode = new TreeItem<>(offensiveStatsItem);		
							secondaryOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> secondaryDefensiveNode = new TreeItem<>(defensiveStatsItem);
							secondaryDefensiveNode.setExpanded(true);
		TreeItem<StatsItem> secondarySkillNode = new TreeItem<>(skillStatsItem);
							secondarySkillNode.setExpanded(true);
							
		// Nodes for the pistol weapon
		TreeItem<StatsItem> pistolOffensiveNode = new TreeItem<>(offensiveStatsItem);		
							pistolOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> pistolDefensiveNode = new TreeItem<>(defensiveStatsItem);
							pistolDefensiveNode.setExpanded(true);
		TreeItem<StatsItem> pistolSkillNode = new TreeItem<>(skillStatsItem);
							pistolSkillNode.setExpanded(true);
						
		// Nodes for the basestat
		TreeItem<StatsItem> basestatOffensiveNode = new TreeItem<>(offensiveStatsItem);		
							basestatOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> basestatDefensiveNode = new TreeItem<>(defensiveStatsItem);
							basestatDefensiveNode.setExpanded(true);
		TreeItem<StatsItem> basestatSkillNode = new TreeItem<>(skillStatsItem);
							basestatSkillNode.setExpanded(true);
			
		// Nodes for the brandsetstat
		TreeItem<StatsItem> brandsetNode = new TreeItem<>(new StatsItem("Brandset", ""));		
//							brandsetNode.setExpanded(true);
							
		TreeItem<StatsItem> basestatNode = new TreeItem<>(new StatsItem("Base", ""));		
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
				basestatItems.add(item);
			}
		});		
		
		// Sorting the items
		items.forEach(item -> Collections.sort(item, new StatsItemComparator()));
		
		// Adding the offensive/primary/skill attributes 
		addItemsToCorrectNode(primaryItems, primaryOffensiveNode, primaryDefensiveNode, primarySkillNode);
		addItemsToCorrectNode(secondaryItems, secondaryOffensiveNode, secondaryDefensiveNode, secondarySkillNode);
		addItemsToCorrectNode(pistolItems, pistolOffensiveNode, pistolDefensiveNode, pistolSkillNode);
		addItemsToCorrectNode(basestatItems, basestatOffensiveNode, basestatDefensiveNode, basestatSkillNode);
		
		rootNode.getChildren().addAll(List.of(primaryNode, secondaryNode, pistolNode, detailNode));
		primaryNode.getChildren().addAll(List.of(primaryOffensiveNode, primaryDefensiveNode, primarySkillNode));
		secondaryNode.getChildren().addAll(List.of(secondaryOffensiveNode, secondaryDefensiveNode, secondarySkillNode));
		pistolNode.getChildren().addAll(List.of(pistolOffensiveNode, pistolDefensiveNode, pistolSkillNode));
		basestatNode.getChildren().addAll(List.of(basestatOffensiveNode, basestatDefensiveNode, basestatSkillNode));
		detailNode.getChildren().addAll(List.of(brandsetNode, basestatNode));
				
        statistics.setRoot(rootNode);
        statistics.getColumns().add(columnAttribute);
        statistics.getColumns().add(columnValue);                
        
        // Updating the raw for critical hit chance 
        //statisticReferences.get("CRITICALHITCHANCE").setValue(new StatsItem("CRITICALHITCHANCE", "150.0"));
	}
	
	/**
	 * Adding items to the correct child nodes Offensive, Defensive, Skill
	 * 
	 * @param items List of StatsItem
	 * @param offensiveNode TreeItem Offensive Node
	 * @param defensiveNode TreeItem Defensive Node
	 * @param skillNode TreeItem Skill Node
	 */
	private void addItemsToCorrectNode(
			List<StatsItem> items,
			TreeItem<StatsItem> offensiveNode,
			TreeItem<StatsItem> defensiveNode,
			TreeItem<StatsItem> skillNode
	) {
		
		items.forEach(item -> {
			TreeItem<StatsItem> tempItem = new TreeItem<>(item); 
			switch(item.getCategory()) {
				case "offensive" -> offensiveNode.getChildren().add(tempItem);
				case "defensive" -> defensiveNode.getChildren().add(tempItem);					
				case "skill" 	 -> skillNode.getChildren().add(tempItem);
			}
		});
	}
	
	/**
	 * Initialize the inventory view (on the left side)
	 * @param inventory Inventory to operate on
	 * TODO Remove later weaponPanes or leave it if it's not longer used
	 */
	private void initializeInventoryView(Inventory inventory) {
		
		TitledPane[] equipmentPanes = {
			titledpanemask, titledpanearmor, titledpanebackpack, titledpaneglove, titledpanekneepad, titledpaneholster,
		};
		
		TitledPane[] weaponPanes = {
			titledpaneprimary, titledpanesecondary, titledpanepistol, titledpanespecialization, titledpaneplaceholder1, titledpaneplaceholder2
		};
		
		TitledPane[] panes = new TitledPane[equipmentPanes.length + weaponPanes.length];
		System.arraycopy(equipmentPanes, 0, panes, 0, equipmentPanes.length);		
		System.arraycopy(weaponPanes,    0, panes, equipmentPanes.length, weaponPanes.length);
		//System.arraycopy(sidePanes, 0, panes, equipmentPanes.length + weaponPanes.length, sidePanes.length);
		
		// Assignment of InventorySlot to corresponding ImageView
		Map<InventorySlot, ImageView> images = Map.of(
			InventorySlot.MASK, maskbrandimage,
			InventorySlot.ARMOR, armorbrandimage,
			InventorySlot.BACKPACK, backpackbrandimage,
			InventorySlot.GLOVE, glovebrandimage,
			InventorySlot.HOLSTER, holsterbrandimage,
			InventorySlot.KNEEPAD, kneepadbrandimage
		);
		
		// Collapse	
		for (TitledPane pane : panes) {			
			pane.setCollapsible(false);
		}
				
		for (TitledPane pane : equipmentPanes) {
			String slotName = pane.getText().toUpperCase();			
			InventorySlot slot = InventorySlot.valueOf(slotName);
			Equipment equipment = (Equipment) inventory.getEquipment(slot);
						
			if (equipment.isImprovisedItem()) {
				pane.setText("Improvised " + pane.getText());
			} else if(equipment.isNamedItem()) {
				pane.setText(equipment.getName());
				pane.getStyleClass().add("namedItem");
			} else {
				pane.setText("Normal " + equipment.getManufacturer().getShortname() + " " + pane.getText());
			}
			
			if (equipment.isImprovisedItem() == false) {
				images.get(slot).setImage(new Image(
					App.class.getResource("assets/brands/"+ equipment.getManufacturer().getShortname() + ".png").toExternalForm(),
					true
				));
			}
			
			// Dependly on the core Attribute colorize the background of the pane
			switch(equipment.getCoreAttribute()) {
				default -> { }
				case WEAPONDAMAGE -> pane.getStyleClass().add("coreAttributeRed");
				case ARMOR -> pane.getStyleClass().add("coreAttributeBlue");
				case SKILLTIER -> pane.getStyleClass().add("coreAttributeYellow");
			}
			
			
			
//			final Node node = pane.lookup(".root");
//			System.out.println(node);
			//node.setStyle("-fx-background-color:red;");
		}
	}
	
	/**
	 * Action if the Keener watch CheckBox was hitted
	 * @param event Caused event of the action
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
