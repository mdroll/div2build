package at.droll.div2builder.frontend;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import at.droll.div2builder.core.Talent;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
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
	 * The Godpane
	 */
	@FXML
	private Pane godPane;
	
	/**
	 * Holds the instance of the ThreeTableView on the right side
	 */
    @FXML
    private TreeTableView<StatsItem> statisticsTreeTableView = new TreeTableView<StatsItem>();
        
    /**
     * Holds the instance of the TitledPane mask on the left side
     */
    @FXML
    private TitledPane maskTitledPane; 
    
    /**
     * Holds the instance of the TitledPane backpack on the left side
     */
    @FXML
    private TitledPane backpackTitledPane;
    
    /**
     * Holds the instance of the TitledPane armor on the left side
     */
    @FXML
    private TitledPane armorTitledPane;
    
    /**
     * Holds the instance of the TitledPane glove on the left side
     */
    @FXML
    private TitledPane gloveTitledPane;
    
    /**
     * Holds the instance of the TitledPane holster on the left side
     */
    @FXML
    private TitledPane holsterTitledPane;
    
    /**
     * Holds the instance of the TitledPane kneepad on the left side
     */
    @FXML
    private TitledPane kneepadTitledPane;
    
    
    /**
     * Holds the instance of the TitledPane primary weapon on the left side
     */
    @FXML
    private TitledPane primaryTitledPane;
    
    /**
     * Holds the instance of the TitledPane secondary weapon on the left side
     */
    @FXML
    private TitledPane secondaryTitledPane;
    
    /**
     * Holds the instance of the TitledPane pistol weapon on the left side
     */
    @FXML
    private TitledPane pistolTitledPane;
    
    
    /**
     * Hols the instance of the mask AnchorPane
     */
    @FXML
    private AnchorPane maskAnchorPane;
    
    
    /**
     * Hols the instance of the backpack AnchorPane
     */
    @FXML
    private AnchorPane backpackAnchorPane;
    
    
    /**
     * Hols the instance of the armor AnchorPane
     */
    @FXML
    private AnchorPane armorAnchorPane;
    
    /**
     * Hols the instance of the glove AnchorPane
     */
    @FXML
    private AnchorPane gloveAnchorPane;
    
    /**
     * Hols the instance of the holster AnchorPane
     */
    @FXML
    private AnchorPane holsterAnchorPane;
        
    /**
     * Hols the instance of the kneepad AnchorPane
     */
    @FXML
    private AnchorPane kneepadAnchorPane;
    
    
    /**
     * Holds the instance of the Label for the core red color 
     */
    @FXML
    private Label coreredLabel;
    
    /**
     * Holds the instance of the Label for the core blue color 
     */
    @FXML
    private Label coreblueLabel;
    
    /**
     * Holds the instance of the Label for the core yellow color 
     */
    @FXML
    private Label coreyellowLabel;
    
    /**
     * Holds the instance of the Label for the minor red color 
     */
    @FXML
    private Label minorredLabel;
    
    /**
     * Holds the instance of the Label for the minor blue color 
     */
    @FXML
    private Label minorblueLabel;
    
    /**
     * Holds the instance of the Label for the minor yellow color 
     */
    @FXML
    private Label minoryellowLabel;
    
    /**
     * Holds the instance of the ImageView for the mask brand 
     */
    @FXML
    private ImageView maskImageView;
    
    /**
     * Holds the instance of the ImageView for the holster brand 
     */
    @FXML
    private ImageView holsterImageView;
    
    /**
     * Holds the instance of the ImageView for the armor brand 
     */
    @FXML
    private ImageView armorImageView;
    
    /**
     * Holds the instance of the ImageView for the backpack brand 
     */
    @FXML
    private ImageView backpackImageView;
    
    /**
     * Holds the instance of the ImageView for the kneepad brand 
     */
    @FXML
    private ImageView kneepadImageView;
    
    /**
     * Holds the instance of the ImageView for the glvoe brand 
     */
    @FXML
    private ImageView gloveImageView;
    
    /**
     * Holds the instance of the CheckBox for the keener watch 
     */
    @FXML
    private CheckBox keenerwatchCheckBox;   
    
    /**
     * Holds the instance of the ComboBox for the mask's core attribute to select
     */
    @FXML
    private ComboBox<Label> maskCoreComboBox;
        
    /**
     * Holds the spinner for the mask's core attribute value
     */
    @FXML
    private Spinner<Number> maskCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the mask's first attrbute to select
     */
    @FXML
    private ComboBox<Label> maskFirstComboBox;
        
    /**
     * Holds the spinner for the mask's first attribute value
     */
    @FXML
    private Spinner<Number> maskFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the mask's second attribute to select
     */
    @FXML
    private ComboBox<Label> maskSecondComboBox;
        
    /**
     * Holds the spinner for the mask's second attribute value
     */
    @FXML
    private Spinner<Number> maskSecondSpinner;
    
    
    /**
     * Holds the instance of the ComboBox for the mask's mod attribute to select
     */
    @FXML
    private ComboBox<Label> maskModComboBox;
        
    /**
     * Holds the spinner for the mask's mod attribute value
     */
    @FXML
    private Spinner<Number> maskModSpinner;    
    
    /**
     * Holds the instance of the ComboBox for the backpack attribute to select
     */
    @FXML
    private ComboBox<Label> backpackCoreComboBox;
        
    /**
     * Holds the spinner for the backpack core attribute value
     */
    @FXML
    private Spinner<Number> backpackCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the backpack first attrbute to select
     */
    @FXML
    private ComboBox<Label> backpackFirstComboBox;
        
    /**
     * Holds the spinner for the backpack first attribute value
     */
    @FXML
    private Spinner<Number> backpackFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the backpack's second attribute to select
     */
    @FXML
    private ComboBox<Label> backpackSecondComboBox;
        
    /**
     * Holds the spinner for the backpack's second attribute value
     */
    @FXML
    private Spinner<Number> backpackSecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the backpack's mod attribute to select
     */
    @FXML
    private ComboBox<Label> backpackModComboBox;
        
    /**
     * Holds the spinner for the backpacks's mod attribute value
     */
    @FXML
    private Spinner<Number> backpackModSpinner;
    
    /**
     * Holds the instance of the ComboBox for the backpack's talent to select
     */
    @FXML
    private ComboBox<Label> backpackTalentComboBox;
    
    /**
     * Holds the instance of the ComboBox for the armor attribute to select
     */
    @FXML
    private ComboBox<Label> armorCoreComboBox;
        
    /**
     * Holds the spinner for the armor core attribute value
     */
    @FXML
    private Spinner<Number> armorCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the armor first attrbute to select
     */
    @FXML
    private ComboBox<Label> armorFirstComboBox;
        
    /**
     * Holds the spinner for the armor first attribute value
     */
    @FXML
    private Spinner<Number> armorFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the armor second attribute to select
     */
    @FXML
    private ComboBox<Label> armorSecondComboBox;
        
    /**
     * Holds the spinner for the armor's second attribute value
     */
    @FXML
    private Spinner<Number> armorSecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the armor mod attribute to select
     */
    @FXML
    private ComboBox<Label> armorModComboBox;
        
    /**
     * Holds the spinner for the armor's mod attribute value
     */
    @FXML
    private Spinner<Number> armorModSpinner;
    
    /**
     * Holds the instance of the ComboBox for the armor's talent to select
     */
    @FXML
    private ComboBox<Label> armorTalentComboBox;
    
    /**
     * Holds the instance of the ComboBox for the glove attribute to select
     */
    @FXML
    private ComboBox<Label> gloveCoreComboBox;
        
    /**
     * Holds the spinner for the glove core attribute value
     */
    @FXML
    private Spinner<Number> gloveCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the glove first attrbute to select
     */
    @FXML
    private ComboBox<Label> gloveFirstComboBox;
        
    /**
     * Holds the spinner for the glove first attribute value
     */
    @FXML
    private Spinner<Number> gloveFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the glove second attribute to select
     */
    @FXML
    private ComboBox<Label> gloveSecondComboBox;
        
    /**
     * Holds the spinner for the gloves second attribute value
     */
    @FXML
    private Spinner<Number> gloveSecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the glove mod attribute to select
     */
    @FXML
    private ComboBox<Label> gloveModComboBox;
        
    /**
     * Holds the spinner for the glove's mod attribute value
     */
    @FXML
    private Spinner<Number> gloveModSpinner; 
    
    /**
     * Holds the instance for the glove's mod label
     */
    @FXML
    private Label gloveModLabel;
    
    /**
     * Holds the instance of the ComboBox for the holster attribute to select
     */
    @FXML
    private ComboBox<Label> holsterCoreComboBox;
        
    /**
     * Holds the spinner for the holster core attribute value
     */
    @FXML
    private Spinner<Number> holsterCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the holster first attrbute to select
     */
    @FXML
    private ComboBox<Label> holsterFirstComboBox;
        
    /**
     * Holds the spinner for the holster first attribute value
     */
    @FXML
    private Spinner<Number> holsterFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the holster second attribute to select
     */
    @FXML
    private ComboBox<Label> holsterSecondComboBox;
        
    /**
     * Holds the spinner for the holster second attribute value
     */
    @FXML
    private Spinner<Number> holsterSecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the holster mod attribute to select
     */
    @FXML
    private ComboBox<Label> holsterModComboBox;
        
    /**
     * Holds the spinner for the holster mod attribute value
     */
    @FXML
    private Spinner<Number> holsterModSpinner; 
    
    /**
     * Holds the instance for the holster's mod label
     */
    @FXML
    private Label holsterModLabel;
    
    /**
     * Holds the instance of the ComboBox for the holster attribute to select
     */
    @FXML
    private ComboBox<Label> kneepadCoreComboBox;
        
    /**
     * Holds the spinner for the kneepad core attribute value
     */
    @FXML
    private Spinner<Number> kneepadCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the kneepad first attrbute to select
     */
    @FXML
    private ComboBox<Label> kneepadFirstComboBox;
        
    /**
     * Holds the spinner for the kneepad first attribute value
     */
    @FXML
    private Spinner<Number> kneepadFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the kneepad second attribute to select
     */
    @FXML
    private ComboBox<Label> kneepadSecondComboBox;
        
    /**
     * Holds the spinner for the kneepad second attribute value
     */
    @FXML
    private Spinner<Number> kneepadSecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the kneepad mod attribute to select
     */
    @FXML
    private ComboBox<Label> kneepadModComboBox;
        
    /**
     * Holds the spinner for the kneepad mod attribute value
     */
    @FXML
    private Spinner<Number> kneepadModSpinner; 
    
    /**
     * Holds the instance for the kneepads mod label
     */
    @FXML
    private Label kneepadModLabel;
   
    /**
     * Holds instance of the primaryLabel
     */
    @FXML
    private Label primaryLabel;
    
    /**
     * Holds instance of the secondaryLabel
     */
    @FXML
    private Label secondaryLabel;
    
    /**
     * Holds instance of the pistolLabel
     */
    @FXML
    private Label pistolLabel;
    
    /**
     * Holds instance of the primaryDamageLabel
     */
    @FXML
    private Label primaryDamageLabel;
    
    /**
     * Holds instance of the secondaryDamageLabel
     */
    @FXML
    private Label secondaryDamageLabel;
    
    /**
     * Holds instance of the pistolDamageLabel
     */
    @FXML
    private Label pistolDamageLabel;
    
    /**
     * Holds instance of the headshot chance spinner
     */
    @FXML
    private Spinner<Integer> headshotChanceSpinner;
    
    /**
     * Initializing of the controller
     */
	@SuppressWarnings("unchecked")
	public void initialize() {
		
		// Putting the world bootstrap 
		world.bootstrap("Test", true);
		
		Inventory inventory = new Inventory();
		inventory = inventory.createMockupInventory();
		world.getPlayer().getLoadout("Default").setInventory(inventory);
		
		// Adding recognizing
		AnchorPane[] anchorPaneList = {
			maskAnchorPane, backpackAnchorPane, armorAnchorPane,
			gloveAnchorPane, holsterAnchorPane, kneepadAnchorPane  
		};
		
		for (AnchorPane pane : anchorPaneList) {			
			for (Node node : pane.getChildren()) {
			
				if (node instanceof Spinner) {
					Spinner<Number> spinner = (Spinner<Number>)node;
					
					if (node instanceof Spinner) {
						
						spinner.valueProperty().addListener((observable, oldValue, newValue) -> {							
							if (oldValue != null && oldValue != newValue) {								
								
								Inventory inv = world.getPlayer().getLoadout("Default").getInventory();
								if (inv.update(spinner, spinner.getUserData().toString(), observable, oldValue, newValue)) {
									// Updating the statistics
									statisticsTreeTableView.getRoot().getChildren().clear();
									statisticsTreeTableView.getColumns().clear();		
									statisticsTreeTableView.setRoot(null);
									initializeStatisticsView(inv);
									initializeDamageStats(headshotChanceSpinner.getValue().toString(), inv);
									initializeAttributesColorCount(inv);
								}
							}
						});
					}
				} 
			}
		}		
		
		initializeStatisticsView(inventory);
		initializeAttributesColorCount(inventory);		
		initializeInventoryView(inventory);
		
		// Register the event handler
		keenerwatchCheckBox.setOnAction(e -> keenerwatchAction(e));
    }
	
	/**
	 * Initializing of the attributes count view with the colors
	 * @param inventory The inventory to count the core and minor attribute colors
	 */
	private void initializeAttributesColorCount(Inventory inventory) {
		
		Map<String, Map<String, Integer>> values = world.getPlayer().getLoadout("Default")
							 										.getStatistic()
							 										.determineRedYellowBlueColors(inventory);
		
		coreredLabel.setText(values.get("core").get("red").toString());
		coreblueLabel.setText(values.get("core").get("blue").toString());
		coreyellowLabel.setText(values.get("core").get("yellow").toString());
		
		minorredLabel.setText(values.get("minor").get("red").toString());
		minorblueLabel.setText(values.get("minor").get("blue").toString());
		minoryellowLabel.setText(values.get("minor").get("yellow").toString());
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
		//columnAttribute.setWi
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
				
        statisticsTreeTableView.setRoot(rootNode);
        statisticsTreeTableView.getColumns().add(columnAttribute);
        statisticsTreeTableView.getColumns().add(columnValue);                
        
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
	 * @param inventory Inventory to operate on	 * 
	 */
	private void initializeInventoryView(Inventory inventory) {
		
		TitledPane[] equipmentPanes = {
			maskTitledPane, armorTitledPane, backpackTitledPane, gloveTitledPane, kneepadTitledPane, holsterTitledPane,
		};
		
		TitledPane[] weaponPanes = {
			primaryTitledPane, secondaryTitledPane, pistolTitledPane
		};
		
		TitledPane[] panes = new TitledPane[equipmentPanes.length + weaponPanes.length];
		System.arraycopy(equipmentPanes, 0, panes, 0, equipmentPanes.length);		
		System.arraycopy(weaponPanes,    0, panes, equipmentPanes.length, weaponPanes.length);
				
		// Damage calculation for the weapons
		SpinnerValueFactory<Integer> intSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 50);		
		headshotChanceSpinner.setValueFactory(intSpinner);
			
		
		headshotChanceSpinner.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {			
			initializeDamageStats(newValue, inventory);
		});
		
		
		// Assignment of InventorySlot to corresponding ImageView
		Map<InventorySlot, ImageView> images = Map.of(
			InventorySlot.MASK, maskImageView,
			InventorySlot.ARMOR, armorImageView,
			InventorySlot.BACKPACK, backpackImageView,
			InventorySlot.GLOVE, gloveImageView,
			InventorySlot.HOLSTER, holsterImageView,
			InventorySlot.KNEEPAD, kneepadImageView
		);
		

		for (TitledPane pane : panes) {			
			pane.setCollapsible(false);
		}

		// Register combobox / spinner pair for the Attribute : Value combinations
		initializeComboBox(maskCoreComboBox, maskCoreSpinner);
		initializeComboBox(maskFirstComboBox, maskFirstSpinner);
		initializeComboBox(maskSecondComboBox, maskSecondSpinner);
		initializeComboBox(maskModComboBox, maskModSpinner);
		
		initializeComboBox(backpackCoreComboBox, backpackCoreSpinner);
		initializeComboBox(backpackFirstComboBox, backpackFirstSpinner);
		initializeComboBox(backpackSecondComboBox, backpackSecondSpinner);
		initializeComboBox(backpackModComboBox, backpackModSpinner);
		initializeComboBox(backpackTalentComboBox);
		
		initializeComboBox(armorCoreComboBox, armorCoreSpinner);
		initializeComboBox(armorFirstComboBox, armorFirstSpinner);
		initializeComboBox(armorSecondComboBox, armorSecondSpinner);
		initializeComboBox(armorModComboBox, armorModSpinner);
		initializeComboBox(armorTalentComboBox);
		
		initializeComboBox(gloveCoreComboBox, gloveCoreSpinner);
		initializeComboBox(gloveFirstComboBox, gloveFirstSpinner);
		initializeComboBox(gloveSecondComboBox, gloveSecondSpinner);
		initializeComboBox(gloveModComboBox, gloveModSpinner);
		
		initializeComboBox(holsterCoreComboBox, holsterCoreSpinner);
		initializeComboBox(holsterFirstComboBox, holsterFirstSpinner);
		initializeComboBox(holsterSecondComboBox, holsterSecondSpinner);
		initializeComboBox(holsterModComboBox, holsterModSpinner);
		
		initializeComboBox(kneepadCoreComboBox, kneepadCoreSpinner);
		initializeComboBox(kneepadFirstComboBox, kneepadFirstSpinner);
		initializeComboBox(kneepadSecondComboBox, kneepadSecondSpinner);
		initializeComboBox(kneepadModComboBox, kneepadModSpinner);
		
		
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
			
			// Initialize the combobox with values from the settet inventory / equipment
			switch(slot) {
				case MASK:
					comboBoxSpinnerPreselection(maskCoreComboBox, maskCoreSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(maskFirstComboBox, maskFirstSpinner, equipment.getFirstAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
					comboBoxSpinnerPreselection(maskSecondComboBox, maskSecondSpinner, equipment.getSecondAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					comboBoxSpinnerPreselection(maskModComboBox, maskModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());	
				
				break;
				
				case BACKPACK:
					comboBoxSpinnerPreselection(backpackCoreComboBox, backpackCoreSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(backpackFirstComboBox, backpackFirstSpinner, equipment.getFirstAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
					comboBoxSpinnerPreselection(backpackSecondComboBox, backpackSecondSpinner, equipment.getSecondAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					comboBoxSpinnerPreselection(backpackModComboBox, backpackModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());
					comboBoxPreselection(backpackTalentComboBox, equipment.getTalent().toString(), equipment.isNamedItem());
										
					if (equipment.isNamedItem()) {
						backpackTalentComboBox.setDisable(true);
					}
				
				break;
				
				case ARMOR:
					comboBoxSpinnerPreselection(armorCoreComboBox, armorCoreSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(armorFirstComboBox, armorFirstSpinner, equipment.getFirstAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());
					comboBoxSpinnerPreselection(armorSecondComboBox, armorSecondSpinner, equipment.getSecondAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					comboBoxSpinnerPreselection(armorModComboBox, armorModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());
					
					comboBoxPreselection(armorTalentComboBox, equipment.getTalent().toString(),	equipment.isNamedItem());
										
					if (equipment.isNamedItem()) {
						armorTalentComboBox.setDisable(true);
					}
				
				break;
				
				case GLOVE:
					comboBoxSpinnerPreselection(gloveCoreComboBox, gloveCoreSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(gloveFirstComboBox, gloveFirstSpinner, equipment.getFirstAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
					comboBoxSpinnerPreselection(gloveSecondComboBox, gloveSecondSpinner, equipment.getSecondAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					
					if (equipment.isImprovisedItem() == true && equipment.getMod() != null) {					
						comboBoxSpinnerPreselection(gloveModComboBox, gloveModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());
					} else {
						gloveModComboBox.setVisible(false);
						gloveModSpinner.setVisible(false);
						gloveModLabel.setVisible(false);
					}
					
				break;
				
				case HOLSTER:
					comboBoxSpinnerPreselection(holsterCoreComboBox, holsterCoreSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(holsterFirstComboBox, holsterFirstSpinner, equipment.getFirstAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
					comboBoxSpinnerPreselection(holsterSecondComboBox, holsterSecondSpinner, equipment.getSecondAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					
					if (equipment.isImprovisedItem() == true && equipment.getMod() != null) {					
						comboBoxSpinnerPreselection(holsterModComboBox, holsterModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());
					} else {
						holsterModComboBox.setVisible(false);
						holsterModSpinner.setVisible(false);
						holsterModLabel.setVisible(false);
					}
					
				break;
				
				case KNEEPAD:
					comboBoxSpinnerPreselection(kneepadCoreComboBox, kneepadCoreSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(kneepadFirstComboBox, kneepadFirstSpinner, equipment.getFirstAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
					comboBoxSpinnerPreselection(kneepadSecondComboBox, kneepadSecondSpinner, equipment.getSecondAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
				
					if (equipment.isImprovisedItem() == true && equipment.getMod() != null) {					
						comboBoxSpinnerPreselection(kneepadModComboBox, kneepadModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());					
					} else {
						kneepadModComboBox.setVisible(false);
						kneepadModSpinner.setVisible(false);
						kneepadModLabel.setVisible(false);
					}
				break;
				
				default:
			}
		}
		
		// Initialize weapon panes
		initializeDamageStats(headshotChanceSpinner.getValue().toString(), inventory);
		
		for (TitledPane pane : weaponPanes) {
						
			String slotName = pane.getText().toUpperCase();			
			InventorySlot slot = InventorySlot.valueOf(slotName);
			Weapon weapon = (Weapon) inventory.getEquipment(slot);			
					
			switch(slot) {
				case PRIMARY -> {
					primaryLabel.setText(weapon.getName());					
				}
				case SECONDARY -> {
					secondaryLabel.setText(weapon.getName());					
				}
				case PISTOL -> {
					pistolLabel.setText(weapon.getName());					
				}
				default -> {}
			}
		}
	}
	
	
	/**
	 * Preselection of Item inside combobox, prefill of spinner with factory and values
	 * 
	 * @param comboBox The ComboBox to preselect
	 * @param spinner The spinner to set the value
	 * @param toSelect Select Identifier in ComboBox i.e. WEAPONDAMAGE, CRITICALHITCHANCE as String
	 * @param min Minimum for the spinner
	 * @param max Maximum for the spinner
	 * @param step Step for the spinner
	 * @param value The desired value to set
	*/	
	private void comboBoxSpinnerPreselection(
		ComboBox<Label> comboBox,
		Spinner<?> spinner,
		String toSelect,
		Number min,
		Number max,
		Number step,
		Number value
	) {
		
		ObservableList<Label> options = comboBox.getItems();
		options.forEach(select -> {
			String attribute = select.getText().substring(0, select.getText().indexOf(" "));
			if (attribute.contains(toSelect)) {
				comboBox.setValue(select);		
				spinner.setUserData(attribute);
				
				spinnerInitialize(
					spinner,
					min,
					max,
					value,
					step
				);
			}			
		});
	}
	
	/**
	 * Preselect of normal comboboxes	 * 
	 * @param comboBox The specific combobox where to preselect something
	 * @param toSelect Selectable String to preselect
	 * @param isperfectTalent
	 */
	private void comboBoxPreselection(
			ComboBox<Label> comboBox,
			String toSelect,
			boolean isPerfectTalent
	) {			
		ObservableList<Label> options = comboBox.getItems();
		options.forEach(select -> {
			String attribute = select.getText();
			
			if (attribute.contains(toSelect)) {//
				select.setText("PERFECT " + select.getText());
				comboBox.setValue(select);
			}			
		});
	}
	
	
	/**
	 * Initialize a spinner with the type given by arguments i.e. DoubleSpinnerValue or IntegerSpinnerValue
	 * @param spinner The spinnerbox to initialize
	 * @param min Minimum value as Number Wrapper
	 * @param max Maximum value as Number Wrapper
	 * @param initial value as Number Wrapper
	 * @param step Step as Number Wrapper
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private void spinnerInitialize(Spinner<?> spinner, Number min, Number max, Number initial, Number step) {
		
		if (initial instanceof Double) {
			Spinner<Double> doubleSpinner = (Spinner<Double>) spinner;
			SpinnerValueFactory<Double> doubleFactory;
			
			doubleFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(
				min.doubleValue(),
				max.doubleValue(),
				initial.doubleValue(),
				step.doubleValue()
			);
			
			doubleSpinner.setValueFactory((SpinnerValueFactory<Double>) doubleFactory);
			
		} else if (initial instanceof Integer) {
			
			Spinner<Integer> intSpinner = (Spinner<Integer>) spinner;
			SpinnerValueFactory<Integer> intFactory;
			
			if (initial.intValue() == 0 && step.intValue() == 0) {
				
				intFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
						min.intValue(),
						max.intValue()
				);
				
			} else {			
			
				intFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
					min.intValue(),
					max.intValue(),
					initial.intValue(),
					step.intValue()
				);
			}
			
			intSpinner.setValueFactory((SpinnerValueFactory<Integer>) intFactory);
			
		} else {
			throw new IllegalArgumentException("The spinner can't be initialize!");
		}
	}
	
	/**
	 * Initialize the combobox, creating items for it and set the action handler
	 *
	 * @param comboBox ComboBox to initialize
	 * @param spinnerbox Assoociated spinnerbox for the ComboBox
	 */
	private void initializeComboBox(ComboBox<Label> comboBox, Spinner<?> spinnerbox) {
		ObservableList<Label> options = FXCollections.observableArrayList();
		Map<Attribute, Number> attributes;		
		
		// With what Attributes should the combobox be filled
		switch(comboBox.getId()) {
			default:
			case "maskCoreComboBox":
			case "backpackCoreComboBox":
			case "armorCoreComboBox":
			case "gloveCoreComboBox":
			case "holsterCoreComboBox":
			case "kneepadCoreComboBox":
				attributes = Attribute.getCoreAttributes();
				break;
			case "maskFirstComboBox":
			case "maskSecondComboBox":
			case "backpackFirstComboBox":
			case "backpackSecondComboBox":
			case "armorFirstComboBox":
			case "armorSecondComboBox":
			case "gloveFirstComboBox":
			case "gloveSecondComboBox":
			case "holsterFirstComboBox":
			case "holsterSecondComboBox":
			case "kneepadFirstComboBox":
			case "kneepadSecondComboBox":
				attributes = Attribute.getMinorAttributes();
				break;
			case "maskModComboBox":
			case "backpackModComboBox":
			case "armorModComboBox":
			case "gloveModComboBox":
			case "holstereModComboBox":
			case "kneepadModComboBox":
				attributes = Attribute.getModAttributes();
				break;
		}
				
		attributes.forEach((attribute, value) -> {
			
			ImageView imageView;
			
			switch(attribute) {
				case WEAPONDAMAGE:
				case CRITICALHITCHANCE: 
				case CRITICALHITDAMAGE:
				case HEADSHOTDAMAGE:
				case WEAPONHANDLING:
					imageView = createAttributeImage("offensive");
					break;
					
				case ARMOR:
				case ARMORREGEN:
				case ARMORONKILL:
				case PROTECTIONFROMELITES:				
				case HAZARDPROTECTION:
				case HEALTH:
				case EXPLOSIVERESISTANCE:
				case INCOMINGREPAIRS:
				case RESISTANCEBLEED:
				case RESISTANCEBLIND:
				case RESISTANCEBURN:
				case RESISTANCEDISRUPT:
				case RESISTANCEESNARE:
				case RESISTANCEDESORIENT:
				case RESISTANCESHOCK:
					imageView = createAttributeImage("defensive");
					break;				
				
				default:
				case SKILLTIER:
				case SKILLDAMAGE:
				case REPAIRSKILLS:
				case SKILLHASTE:
				case SKILLDURATION:
				case STATUSEFFECTS:
					imageView = createAttributeImage("utility");
					break;
			}
			
			Label lbl = new Label(attribute.toString() + " Max: " + value.toString());
			lbl.setGraphic(imageView);
			lbl.setUserData(value);
			options.add(lbl);
			comboBox.setItems(options);
		});				
		
		ListCell<Label> buttonCell = new ListCell<Label>() {
			@Override
			protected void updateItem(Label item, boolean isEmpty) {
				super.updateItem(item, isEmpty);
				setText(item == null ? "" : item.getText());        
			}
		};
		
		comboBox.setButtonCell(buttonCell);
		comboBox.setOnAction(e -> inventoryComboBoxActionHandler(e, spinnerbox));
	}
	
	/**
	 * Initialize the combobox, creating items for it and set the action handler
	 *
	 * @param comboBox ComboBox to initialize
	 * @param spinnerbox Assoociated spinnerbox for the ComboBox
	 */
	private void initializeComboBox(ComboBox<Label> comboBox) {
		ObservableList<Label> options = FXCollections.observableArrayList();
		List<Talent> talents;		
		
		switch(comboBox.getId()) {
			default:
			case "backpackTalentComboBox":			
				talents = Talent.getBackpackTalents();
				break;
			case "armorTalentComboBox":
				talents = Talent.getArmorTalents();
				break;
		}
				
		talents.forEach(talent -> {
			Label lbl = new Label(talent.toString());
//			lbl.setUserData(value);
			options.add(lbl);
			comboBox.setItems(options);
		});				
		
		ListCell<Label> buttonCell = new ListCell<Label>() {
			@Override
			protected void updateItem(Label item, boolean isEmpty) {
				super.updateItem(item, isEmpty);
				setText(item == null ? "" : item.getText());        
			}
		};
		
		comboBox.setButtonCell(buttonCell);
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
		statisticsTreeTableView.getRoot().getChildren().clear();
		statisticsTreeTableView.getColumns().clear();		
		statisticsTreeTableView.setRoot(null);
		
		Inventory inventory = world.getPlayer().getLoadout("Default").getInventory();
		initializeStatisticsView(inventory);
		initializeDamageStats(headshotChanceSpinner.getValue().toString(), inventory);
	}
		
	
	
	/**
	 * ComboBox actionhandler target for the inventory
	 * 
	 * @param event The caused event
	 * @param spinner The associated spinnerbox to the event
	 * 
	 */
	@SuppressWarnings("unchecked")
	private void inventoryComboBoxActionHandler(Event event, Spinner<?> spinnerbox) {
		
		ComboBox<Label> comboBox = (ComboBox<Label>)event.getSource();
		String fxId = comboBox.getId();

		Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
		Label select = (Label)selectedItem;
		String attribute = select.getText().substring(0, select.getText().indexOf(" "));

		// Ditching selected Attribute from combobox to spinner, to access later in changeListener
		spinnerbox.setUserData(attribute);
		
		switch(fxId) {	
			case "maskCoreComboBox":
			case "backpackCoreComboBox":
			case "armorCoreComboBox":
			case "gloveCoreComboBox":
			case "holsterCoreComboBox":
			case "kneepadCoreComboBox":
				switch(attribute) {				
					case "WEAPONDAMAGE":
						spinnerInitialize(
							spinnerbox, 
							.0,
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							0.1
						);
						
						spinnerbox.setDisable(false);
					break;
					case "ARMOR":
						
						spinnerInitialize(
							spinnerbox,
							0,
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).intValue(),
							10000
						);
						
						spinnerbox.setDisable(false);	
					break;
						
					case "SKILLTIER":
						spinnerInitialize(
							spinnerbox,
							1,
							1,
							0,
							0
						);
						 
						spinnerbox.setDisable(true);	
					break;
				}
			break;
			
			case "maskFirstComboBox":
			case "maskSecondComboBox":
			case "backpackFirstComboBox":
			case "backpackSecondComboBox":
			case "armorFirstComboBox":
			case "armorSecondComboBox":
			case "gloveFirstComboBox":
			case "gloveSecondComboBox":
			case "holsterFirstComboBox":
			case "holsterSecondComboBox":
			case "kneepadFirstComboBox":
			case "kneepadSecondComboBox":
				
				switch(attribute) {
					case "CRITICALHITCHANCE":
					case "CRITICALHITDAMAGE":
					case "HEADSHOTDAMAGE":
					case "WEAPONHANDLING":
					case "HAZARDPROTECTION":
					case "EXPLOSIVERESISTANCE":
					case "SKILLDAMAGE":
					case "STATUSEFFECTS":
					case "REPAIRSKILLS":
					case "SKILLHASTE":
						
						spinnerInitialize(
							spinnerbox,
							.0,
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							0.1
						);
						spinnerbox.setDisable(false);
					
					break;
					
					case "ARMOR":
					case "HEALTH":
					case "ARMORREGEN":
						
						spinnerInitialize(
							spinnerbox,
							0,
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).intValue(),
							1000
						);						
						spinnerbox.setDisable(false);
					break;
				}
			
				break;
				
			case "maskModComboBox":
			case "backpackModComboBox":
			case "armorModComboBox":
			case "gloveModComboBox":
			case "holsterModComboBox":
			case "kneepadModComboBox":
				
				switch(attribute) {
					case "CRITICALHITCHANCE":
					case "CRITICALHITDAMAGE":
					case "HEADSHOTDAMAGE":
					case "INCOMINGREPAIRS":
					case "PROTECTIONFROMELITES":
					case "RESISTANCEBLEED":
					case "RESISTANCEBLIND":
					case "RESISTANCEBURN":
					case "RESISTANCEDISRUPT":
					case "RESISTANCEESNARE":
					case "RESISTANCEDESORIENT":
					case "RESISTANCESHOCK":				
					case "REPAIRSKILLS":
					case "SKILLHASTE":
					case "SKILLDURATION":
						
						spinnerInitialize(
							spinnerbox,
							.0,
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							0.1
						);						
						spinnerbox.setDisable(false);
					break;
					
					case "ARMORONKILL":
						spinnerInitialize(
							spinnerbox,
							0,
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).intValue(),
							1000
						);						
						spinnerbox.setDisable(false);
					break;
				}
					
			break;
						
		} // closing fxId
	}
	
	/**
	 * Create an image with the appropriate symbol
	 * @return Image
	 */
	private ImageView createAttributeImage(String type) {
		ImageView imageView = new ImageView();
		Image image;
		
		switch(type) {
			case "offensive" -> image = new Image(App.class.getResource("assets/offence.png").toExternalForm());
			case "defensive" -> image = new Image(App.class.getResource("assets/defence.png").toExternalForm());
			default -> image = new Image(App.class.getResource("assets/utility.png").toExternalForm());
		}
		
		imageView.setImage(image);
		imageView.setFitHeight(16.0);
		imageView.setFitWidth(16.0);

		return imageView;
	}
	
	/**
	 * Initialize the weapon damage statistics
	 * @param headshotChance As String (Depends on spinner because it's a String)
	 * @param inventory The inventory to make the calculations on
	 */   
	
	public void initializeDamageStats(String headshotChanceString, Inventory inventory) {
		
		Double headshotChance = Double.parseDouble(headshotChanceString);		
		headshotChance = headshotChance / 100;
		Map<String, Double> damage;
		
		damage = world.getPlayer().getLoadout("Default").getStatistic()
														.calculateWeaponDamage(inventory, headshotChance);
		DecimalFormat decimalFormat = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.GERMAN));
		
		primaryDamageLabel.setText(decimalFormat.format(damage.get("PRIMARY")) + " SPS");
		secondaryDamageLabel.setText(decimalFormat.format(damage.get("SECONDARY")) + " SPS");
		pistolDamageLabel.setText(decimalFormat.format(damage.get("PISTOL")) + " SPS");
	}
}
