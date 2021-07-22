package at.droll.div2builder.frontend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
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
import at.droll.div2builder.core.Talent;
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
    private ComboBox<Label> maskCoreAttributeComboBox;
        
    /**
     * Holds the spinner for the mask's core attribute value
     */
    @FXML
    private Spinner<Number> maskCoreAttributeValueSpinner;
    
    /**
     * Holds the instance of the ComboBox for the mask's first attrbute to select
     */
    @FXML
    private ComboBox<Label> maskFirstAttributeComboBox;
        
    /**
     * Holds the spinner for the mask's first attribute value
     */
    @FXML
    private Spinner<Number> maskFirstAttributeValueSpinner;
    
    /**
     * Holds the instance of the ComboBox for the mask's second attribute to select
     */
    @FXML
    private ComboBox<Label> maskSecondAttributeComboBox;
        
    /**
     * Holds the spinner for the mask's second attribute value
     */
    @FXML
    private Spinner<Number> maskSecondAttributeValueSpinner;
    
    
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
    private ComboBox<Label> backpackCoreAttributeComboBox;
        
    /**
     * Holds the spinner for the backpack core attribute value
     */
    @FXML
    private Spinner<Number> backpackCoreAttributeValueSpinner;
    
    /**
     * Holds the instance of the ComboBox for the backpack first attrbute to select
     */
    @FXML
    private ComboBox<Label> backpackFirstAttributeComboBox;
        
    /**
     * Holds the spinner for the backpack first attribute value
     */
    @FXML
    private Spinner<Number> backpackFirstAttributeValueSpinner;
    
    /**
     * Holds the instance of the ComboBox for the backpack's second attribute to select
     */
    @FXML
    private ComboBox<Label> backpackSecondAttributeComboBox;
        
    /**
     * Holds the spinner for the backpack's second attribute value
     */
    @FXML
    private Spinner<Number> backpackSecondAttributeValueSpinner;
        
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
    private ComboBox<Label> armorCoreAttributeComboBox;
        
    /**
     * Holds the spinner for the armor core attribute value
     */
    @FXML
    private Spinner<Number> armorCoreAttributeValueSpinner;
    
    /**
     * Holds the instance of the ComboBox for the armor first attrbute to select
     */
    @FXML
    private ComboBox<Label> armorFirstAttributeComboBox;
        
    /**
     * Holds the spinner for the armor first attribute value
     */
    @FXML
    private Spinner<Number> armorFirstAttributeValueSpinner;
    
    /**
     * Holds the instance of the ComboBox for the armor second attribute to select
     */
    @FXML
    private ComboBox<Label> armorSecondAttributeComboBox;
        
    /**
     * Holds the spinner for the armor's second attribute value
     */
    @FXML
    private Spinner<Number> armorSecondAttributeValueSpinner;
        
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
     * Initializing of the controller
     */
	public void initialize() {
		
		// Putting the world bootstrap 
		world.bootstrap("Test", true);
		
		Inventory inventory = new Inventory();
		inventory = inventory.createMockupInventory();
		world.getPlayer().getLoadout("Default").setInventory(inventory);
		
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
	 * @param inventory Inventory to operate on
	 * TODO Remove later weaponPanes or leave it if it's not longer used
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
		//System.arraycopy(sidePanes, 0, panes, equipmentPanes.length + weaponPanes.length, sidePanes.length);
		
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

		// Register combobox / spinner pair für the Attribute : Value combinations
		initializeComboBox(maskCoreAttributeComboBox, maskCoreAttributeValueSpinner);
		initializeComboBox(maskFirstAttributeComboBox, maskFirstAttributeValueSpinner);
		initializeComboBox(maskSecondAttributeComboBox, maskSecondAttributeValueSpinner);
		initializeComboBox(maskModComboBox, maskModSpinner);
		
		initializeComboBox(backpackCoreAttributeComboBox, backpackCoreAttributeValueSpinner);
		initializeComboBox(backpackFirstAttributeComboBox, backpackFirstAttributeValueSpinner);
		initializeComboBox(backpackSecondAttributeComboBox, backpackSecondAttributeValueSpinner);
		initializeComboBox(backpackModComboBox, backpackModSpinner);
		initializeComboBox(backpackTalentComboBox);
		
		initializeComboBox(armorCoreAttributeComboBox, armorCoreAttributeValueSpinner);
		initializeComboBox(armorFirstAttributeComboBox, armorFirstAttributeValueSpinner);
		initializeComboBox(armorSecondAttributeComboBox, armorSecondAttributeValueSpinner);
		initializeComboBox(armorModComboBox, armorModSpinner);
		initializeComboBox(armorTalentComboBox);
		
		
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
			
			switch(slot) {
				case MASK:
					comboBoxSpinnerPreselection(maskCoreAttributeComboBox, maskCoreAttributeValueSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(maskFirstAttributeComboBox, maskFirstAttributeValueSpinner, equipment.getFirstAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
					comboBoxSpinnerPreselection(maskSecondAttributeComboBox, maskSecondAttributeValueSpinner, equipment.getSecondAttribute().toString(), 0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					comboBoxSpinnerPreselection(maskModComboBox, maskModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());	
				
				break;
				
				case BACKPACK:
					comboBoxSpinnerPreselection(backpackCoreAttributeComboBox, backpackCoreAttributeValueSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(backpackFirstAttributeComboBox, backpackFirstAttributeValueSpinner, equipment.getFirstAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
					comboBoxSpinnerPreselection(backpackSecondAttributeComboBox, backpackSecondAttributeValueSpinner, equipment.getSecondAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					comboBoxSpinnerPreselection(backpackModComboBox, backpackModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());
					comboBoxPreselection(backpackTalentComboBox, equipment.getTalent().toString(), equipment.isNamedItem());
										
					if (equipment.isNamedItem()) {
						backpackTalentComboBox.setDisable(true);
					}
				
				break;
				
				case ARMOR:
					comboBoxSpinnerPreselection(armorCoreAttributeComboBox, armorCoreAttributeValueSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
					comboBoxSpinnerPreselection(armorFirstAttributeComboBox, armorFirstAttributeValueSpinner, equipment.getFirstAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());
					comboBoxSpinnerPreselection(armorSecondAttributeComboBox, armorSecondAttributeValueSpinner, equipment.getSecondAttribute().toString(), .0, Attribute.getMinorAttributes().get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
					comboBoxSpinnerPreselection(armorModComboBox, armorModSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());
					
					comboBoxPreselection(armorTalentComboBox, equipment.getTalent().toString(),	equipment.isNamedItem());
										
					if (equipment.isNamedItem()) {
						armorTalentComboBox.setDisable(true);
					}
				
				break;
				
				default:
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
		
		switch(comboBox.getId()) {
			default:
			case "maskCoreAttributeComboBox":
			case "backpackCoreAttributeComboBox":
			case "armorCoreAttributeComboBox":
				attributes = Attribute.getCoreAttributes();
				break;
			case "maskFirstAttributeComboBox":
			case "maskSecondAttributeComboBox":
			case "backpackFirstAttributeComboBox":
			case "backpackSecondAttributeComboBox":
			case "armorFirstAttributeComboBox":
			case "armorSecondAttributeComboBox":
				attributes = Attribute.getMinorAttributes();
				break;
			case "maskModComboBox":
			case "backpackModComboBox":
			case "armorModComboBox":
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
		
		initializeStatisticsView(world.getPlayer().getLoadout("Default").getInventory());
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
		
		switch(fxId) {	
			case "maskCoreAttributeComboBox":
			case "backpackCoreAttributeComboBox":
			case "armorCoreAttributeComboBox":
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
			
			case "maskFirstAttributeComboBox":
			case "maskSecondAttributeComboBox":
			case "backpackFirstAttributeComboBox":
			case "backpackSecondAttribtueComboBox":
			case "armorFirstAttributeComboBox":
			case "armorSecondAttributeComboBox":
				
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
}
