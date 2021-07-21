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
     * Holds the instance of the TitledPane specialization on the left side
     */
    @FXML
    private TitledPane specializationTitledPane;
    
    /**
     * Holds the instance of the TitledPane placeholder1 on the left side
     */
    @FXML
    private TitledPane placeholder1TitledPane;
    
    /**
     * Holds the instance of the TitledPane placeholder2 on the left side
     */
    @FXML
    private TitledPane placeholder2TitledPane;
        
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
		maskCoreAttributeComboBox.setOnAction(e -> inventoryComboBoxAction(e, maskCoreAttributeValueSpinner));
		maskFirstAttributeComboBox.setOnAction(e -> inventoryComboBoxAction(e, maskFirstAttributeValueSpinner));
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
			primaryTitledPane, secondaryTitledPane, pistolTitledPane, specializationTitledPane, placeholder1TitledPane, placeholder2TitledPane
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
		}
		
		initializeComboBox(maskCoreAttributeComboBox);
		initializeComboBox(maskFirstAttributeComboBox);
	}
	
	/**
	 * Initialize the combobox
	 */
	private void initializeComboBox(ComboBox<Label> comboBox) {
		ObservableList<Label> options = FXCollections.observableArrayList();
		Map<Attribute, Number> attributes;
		
		switch(comboBox.getId()) {
			case "maskCoreAttributeComboBox":
				attributes = Attribute.getCoreAttributes();
				attributes.forEach((attribute, value) -> {
					createItemsForComboBox(comboBox, options, attribute, value);
				});					
				break;				
			case "maskFirstAttributeComboBox":				
				attributes = Attribute.getMinorAttributes();
				attributes.forEach((attribute, value) -> {					
					createItemsForComboBox(comboBox, options, attribute, value);
				});
				comboBox.setItems(options);
				break;
		}
		
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
	 * ComboBox Action for the inventory
	 * 
	 * @param attribtuebox
	 * @param spinnerbox
	 * @param event Caused event of the action
	 */
	@SuppressWarnings("unchecked")
	private void inventoryComboBoxAction(Event event, Spinner<?> spinnerbox) {
		
		ComboBox<Label> comboBox = (ComboBox<Label>)event.getSource();
		String fxId = comboBox.getId();

		Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
		Label select = (Label)selectedItem;
		String attribute = select.getText().substring(0, select.getText().indexOf(" "));
		
		Spinner<Double> doubleSpinner = (Spinner<Double>) spinnerbox;
		Spinner<Integer> intSpinner	  = (Spinner<Integer>) spinnerbox;
		
		SpinnerValueFactory<Double> doubleFactory;
		SpinnerValueFactory<Integer> integerFactory;
		
		switch(fxId) {	
			case "maskCoreAttributeComboBox":
				switch(attribute) {				
					case "WEAPONDAMAGE":
						doubleFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(
							.0,
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							0.1
						);
						doubleSpinner.setValueFactory((SpinnerValueFactory<Double>) doubleFactory);
						spinnerbox.setDisable(false);
					break;
					case "ARMOR":
						
						integerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
							0,
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).intValue(),
							10000
						);
						
						intSpinner.setValueFactory((SpinnerValueFactory<Integer>) integerFactory);
						spinnerbox.setDisable(false);	
					break;
						
					case "SKILLTIER":
						 integerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
							1, 1
						);
						intSpinner.setValueFactory((SpinnerValueFactory<Integer>) integerFactory);
						spinnerbox.setDisable(true);	
					break;
				}
			break;
			
			case "maskFirstAttributeComboBox":
				
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
						
						doubleFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(
							.0,
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							0.1
						);
						doubleSpinner.setValueFactory((SpinnerValueFactory<Double>) doubleFactory);
						spinnerbox.setDisable(false);
					
					break;
					
					case "ARMOR":
					case "HEALTH":
					case "ARMORREGEN":
						
						integerFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
							0,
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).intValue(),
							1000
						);
						intSpinner.setValueFactory((SpinnerValueFactory<Integer>) integerFactory);
						spinnerbox.setDisable(false);
					break;
				}
				
			break;
			
		} // closing fxId
	}
	
	
	/**
	 * Create items for comboBoxes
	 * 
	 * @param options
	 * @param attribute
	 * @param value
	 * @param image
	 */
	private void createItemsForComboBox(ComboBox<Label> comboBox, ObservableList<Label> options, Attribute attribute, Number value) {
		ImageView imageView;
		
		switch(attribute) {
			case WEAPONDAMAGE -> imageView = createAttributeImage("offensive");
			case CRITICALHITCHANCE -> imageView = createAttributeImage("offensive");
			case CRITICALHITDAMAGE -> imageView = createAttributeImage("offensive");
			case HEADSHOTDAMAGE -> imageView = createAttributeImage("offensive");
			case WEAPONHANDLING -> imageView = createAttributeImage("offensive");
			case ARMOR -> imageView = createAttributeImage("defensive");
			case ARMORREGEN -> imageView = createAttributeImage("defensive");
			case HAZARDPROTECTION -> imageView = createAttributeImage("defensive");
			case HEALTH -> imageView = createAttributeImage("defensive");
			case EXPLOSIVERESISTANCE -> imageView = createAttributeImage("defensive");			
			case SKILLTIER -> imageView = createAttributeImage("utility");
			case SKILLDAMAGE -> imageView = createAttributeImage("utility");
			case REPAIRSKILLS -> imageView = createAttributeImage("utility");
			case SKILLHASTE -> imageView = createAttributeImage("utility");
			case STATUSEFFECTS -> imageView = createAttributeImage("utility");
			default -> imageView = createAttributeImage("utility");
		}
		
		Label lbl = new Label(attribute.toString() + " +" + value.toString());
		lbl.setGraphic(imageView);
		lbl.setUserData(value);
		options.add(lbl);
		comboBox.setItems(options);			
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
