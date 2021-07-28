package at.droll.div2builder.frontend;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
import at.droll.div2builder.core.TalentWeapon;
import at.droll.div2builder.core.World;
import at.droll.div2builder.core.attribute.Attribute;
import at.droll.div2builder.core.inventory.Inventory;
import at.droll.div2builder.core.inventory.InventorySlot;
import at.droll.div2builder.core.item.equipment.Equipment;
import at.droll.div2builder.core.item.weapon.Weapon;
import at.droll.div2builder.core.item.weapon.WeaponType;
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
	
	/**
	 * The Godpane
	 */
	@FXML
	private Pane godPane;
	
	/**
	 * Holds the instance of the ThreeTableView on the right side
	 */
    @FXML
    private TreeTableView<StatsItem> statisticsTreeTableView = new TreeTableView<>();
        
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
     * Holds the instance of the mask AnchorPane
     */
    @FXML
    private AnchorPane maskAnchorPane;
        
    /**
     * Holds the instance of the backpack AnchorPane
     */
    @FXML
    private AnchorPane backpackAnchorPane;
        
    /**
     * Holds the instance of the armor AnchorPane
     */
    @FXML
    private AnchorPane armorAnchorPane;
    
    /**
     * Holds the instance of the glove AnchorPane
     */
    @FXML
    private AnchorPane gloveAnchorPane;
    
    /**
     * Holds the instance of the holster AnchorPane
     */
    @FXML
    private AnchorPane holsterAnchorPane;
        
    /**
     * Holds the instance of the kneepad AnchorPane
     */
    @FXML
    private AnchorPane kneepadAnchorPane;
    
    /**
     * Holds the instance of the primary AnchorPane
     */
    @FXML
    private AnchorPane primaryAnchorPane;
    
    /**
     * Holds the instance of the secondary AnchorPane
     */
    @FXML
    private AnchorPane secondaryAnchorPane;
        
    /**
     * Holds the instance of the pistol AnchorPane
     */
    @FXML
    private AnchorPane pistolAnchorPane;
    
        
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
     * Holds the instance of the ComboBox for the primary weapon's core attribute to select
     */
    @FXML
    private ComboBox<Label> primaryCoreComboBox;
        
    /**
     * Holds the spinner for the primary weapon's core attribute value
     */
    @FXML
    private Spinner<Number> primaryCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the primary weapon's first attrbute to select
     */
    @FXML
    private ComboBox<Label> primaryFirstComboBox;
        
    /**
     * Holds the spinner for the primary weapon's first attribute value
     */
    @FXML
    private Spinner<Number> primaryFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the primary weapon's second attribute to select
     */
    @FXML
    private ComboBox<Label> primarySecondComboBox;
        
    /**
     * Holds the spinner for the primary weapon's second attribute value
     */
    @FXML
    private Spinner<Number> primarySecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the primary weapon's talent attribute to select
     */
    @FXML
    private ComboBox<Label> primaryTalentComboBox;
        
    /**
     * Holds the spinner for the primary weapon's talent attribute value
     */
    @FXML
    private Spinner<Number> primaryTalentSpinner;   
        
    /**
     * Holds the instance of the ComboBox for the secondary weapon's core attribute to select
     */
    @FXML
    private ComboBox<Label> secondaryCoreComboBox;
        
    /**
     * Holds the spinner for the secondary weapon's core attribute value
     */
    @FXML
    private Spinner<Number> secondaryCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the secondary weapon's first attrbute to select
     */
    @FXML
    private ComboBox<Label> secondaryFirstComboBox;
        
    /**
     * Holds the spinner for the secondary weapon's first attribute value
     */
    @FXML
    private Spinner<Number> secondaryFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the secondary weapon's second attribute to select
     */
    @FXML
    private ComboBox<Label> secondarySecondComboBox;
        
    /**
     * Holds the spinner for the secondary weapon's second attribute value
     */
    @FXML
    private Spinner<Number> secondarySecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the secondary weapon's talent attribute to select
     */
    @FXML
    private ComboBox<Label> secondaryTalentComboBox;
        
    /**
     * Holds the spinner for the secondary weapon's talent attribute value
     */
    @FXML
    private Spinner<Number> secondaryTalentSpinner;
    
    /**
     * Holds the instance of the ComboBox for the secondary weapon's core attribute to select
     */
    @FXML
    private ComboBox<Label> pistolCoreComboBox;
        
    /**
     * Holds the spinner for the pistol weapon's core attribute value
     */
    @FXML
    private Spinner<Number> pistolCoreSpinner;
    
    /**
     * Holds the instance of the ComboBox for the pistol weapon's first attrbute to select
     */
    @FXML
    private ComboBox<Label> pistolFirstComboBox;
        
    /**
     * Holds the spinner for the secondary weapon's first attribute value
     */
    @FXML
    private Spinner<Number> pistolFirstSpinner;
    
    /**
     * Holds the instance of the ComboBox for the pistol attribute to select
     */
    @FXML
    private ComboBox<Label> pistolSecondComboBox;
        
    /**
     * Holds the spinner for the secondary weapon's pistol attribute value
     */
    @FXML
    private Spinner<Number> pistolSecondSpinner;
        
    /**
     * Holds the instance of the ComboBox for the pistol weapon's talent attribute to select
     */
    @FXML
    private ComboBox<Label> pistolTalentComboBox;
        
    /**
     * Holds the spinner for the pistol weapon's talent attribute value
     */
    @FXML
    private Spinner<Number> pistolTalentSpinner;
    
    /**
     * Holds the instance of the pistol first label
     */
    @FXML
    private Label pistolFirstlabel;
    
    
    /**
     * The name of the css class for TitledPane in red
     */
    public static final String COREATTRIBUTEBLUECSSCLASSNAME = "coreAttributeBlue";
    
    /**
     * The name of the css class for TitledPane in yellow
     */
    public static final String COREATTRIBUTEYELLOWCSSCLASSNAME = "coreAttributeYellow";
    
    /**
     * The name of the css class for TitledPane in blue
     */
    public static final String COREATTRIBUTEREDCSSCLASSNAME = "coreAttributeRed";
    
    /**
     * The default loadout name
     */
    public static final String DEFAULTLOADOUTNAME = "Default";
    
    /**
     * The Devider for offensive stats or images
     */
    public static final String DEVIDEROFFENSIVE = "offensive";
    
    /**
     * The Devider for defensive stats or images
     */
    public static final String DEVIDERDEFENSIVE = "defensive";
    
    /**
     * The Devider for skill stats or images
     */
    public static final String DEVIDERSKILL = "skill";
        
    /**
     * Initializing of the controller
     */
	@SuppressWarnings("unchecked")
	public void initialize() {
		
		// Putting the world bootstrap 
		world.bootstrap("Test", true);
		
		Inventory inventory = new Inventory();
		inventory = inventory.createMockupInventory();
		world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).setInventory(inventory);
		
		// Adding all main panes to loop over
		AnchorPane[] anchorPaneList = {
			maskAnchorPane, backpackAnchorPane, armorAnchorPane,
			gloveAnchorPane, holsterAnchorPane, kneepadAnchorPane , primaryAnchorPane, secondaryAnchorPane, pistolAnchorPane
		};
		
		// Handler for all combobox / spinner 
		for (AnchorPane pane : anchorPaneList) {			
			for (Node node : pane.getChildren()) {
				
				if (node instanceof Spinner) {
					Spinner<Number> spinner = (Spinner<Number>)node;
					
					spinner.valueProperty().addListener((observable, oldValue, newValue) -> {							
						if (oldValue != null && oldValue != newValue) {									
							
							Inventory inv = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).getInventory();
							
							if (inv.update(spinner, spinner.getUserData().toString(), newValue)) {
								initializeStatisticsView(inv);
								initializeDamageStats(headshotChanceSpinner.getValue().toString(), inv);
								initializeAttributesColorCount(inv);
							}
						}
					});
				} else if (node instanceof ComboBox) {
					ComboBox<Label> comboBox = (ComboBox<Label>)node;
			
					// Core ComboBox Listener 
					if (comboBox.getId().contains("Core")) {
						comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {							
							if (oldValue != null && oldValue != newValue) {
								Label lbl = observable.getValue();
								TitledPane target;
								String classToAdd;
								
								if (lbl.getText().contains(Attribute.ARMOR.toString())) {
									classToAdd = COREATTRIBUTEBLUECSSCLASSNAME;
								} else if (lbl.getText().contains("WEAPONDAMAGE")) {
									classToAdd = COREATTRIBUTEREDCSSCLASSNAME;
								} else {
									classToAdd = COREATTRIBUTEYELLOWCSSCLASSNAME;
								}
																
								if (comboBox.getId().contains("mask")) {
									target = maskTitledPane;
								} else if (comboBox.getId().contains("backpack")) {
									target = backpackTitledPane;
								} else if (comboBox.getId().contains("armor")) {
									target = armorTitledPane;
								} else if (comboBox.getId().contains("glove")) {
									target = gloveTitledPane;
								} else if (comboBox.getId().contains("holster")) {
									target = holsterTitledPane;
								} else {
									target = kneepadTitledPane;
								}	
								
								target.getStyleClass().removeAll(COREATTRIBUTEREDCSSCLASSNAME, COREATTRIBUTEBLUECSSCLASSNAME, COREATTRIBUTEYELLOWCSSCLASSNAME);
								target.getStyleClass().add(classToAdd);
							}
						});
						
					// Talent ComboBox listener
					} else if (comboBox.getId().contains("Talent")) {
						comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
						
							if (oldValue != null && oldValue != newValue) {
								Inventory inv = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).getInventory();
							
								if (inv.update(comboBox.getId(), newValue)) {
									
									initializeStatisticsView(inv);
									initializeDamageStats(headshotChanceSpinner.getValue().toString(), inv);
									initializeAttributesColorCount(inv);
								}
							}
						});
					// Mod comboBox listener
					} else if (comboBox.getId().contains("Mod")) {
						
						comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
							
							if (oldValue != null && oldValue != newValue) {
								Inventory inv = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).getInventory();
								Label lbl = observable.getValue();
								String attribute = lbl.getText().substring(0, lbl.getText().indexOf(" "));
								
								if (inv.update(comboBox.getId(), attribute, newValue)) {
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

		// Checkbox KeenerWatch Action
		keenerwatchCheckBox.setOnAction(event -> {
			
			System.err.println( ((CheckBox) event.getSource()).isSelected() );
			
			if (((CheckBox) event.getSource()).isSelected()) {				
				world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).setStatistic(new Statistic(true));
			} else {
				world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).setStatistic(new Statistic(false));
			}
			
			Inventory inv = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).getInventory();
			initializeStatisticsView(inv);
			initializeDamageStats(headshotChanceSpinner.getValue().toString(), inv);			
		});
		
		// All other initializations
		initializeStatisticsView(inventory);
		initializeInventoryView(inventory);
		initializeAttributesColorCount(inventory);		
    }
	
	/**
	 * Initializing of the attributes count view with the colors
	 * @param inventory The inventory to count the core and minor attribute colors
	 */
	private void initializeAttributesColorCount(Inventory inventory) {
		
		Map<String, Map<String, Integer>> values = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME)
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
		
		// Remove 
		if (statisticsTreeTableView.getRoot() != null) {		
			statisticsTreeTableView.getRoot().getChildren().clear();
			statisticsTreeTableView.getColumns().clear();		
			statisticsTreeTableView.setRoot(null);
		}
		
		// Retrieve the statistic data from the world
		Map<String, Map<Attribute, Double>> values = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME)
																	  .getStatistic()
																	  .calculate(inventory);
		
		
		Map<String, Map<Attribute, Double>> brandsetValues = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME)
																 .getStatistic()
																 .getBonusByBrandset(inventory);
		
		Map<Attribute, Double> basestatValue = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME)
				 								 .getStatistic()
				 								 .getData();
				
		// Setting up main columns
		TreeTableColumn<StatsItem, String> columnAttribute = new TreeTableColumn<>("Attribute");
		columnAttribute.setPrefWidth(310);
		columnAttribute.setId("columnAttribute");
		columnAttribute.setResizable(false);
		//columnAttribute.setWi
		columnAttribute.setCellValueFactory(new TreeItemPropertyValueFactory<>("attribute"));
				
		TreeTableColumn<StatsItem, String> columnValue = new TreeTableColumn<>("Value");
		columnValue.setPrefWidth(60);
		columnValue.setId("columnValue");
		columnValue.setResizable(false);
		columnValue.setCellValueFactory(new TreeItemPropertyValueFactory<>("value"));
				
		
		// Setting up all the treeItem nodes 
		TreeItem<StatsItem> rootNode = new TreeItem<>(new StatsItem("Statistics", ""));
							rootNode.setExpanded(true);
	
		TreeItem<StatsItem> primaryNode = new TreeItem<>(new StatsItem("Primary Weapon", ""));
							primaryNode.setExpanded(true);
		TreeItem<StatsItem> secondaryNode = new TreeItem<>(new StatsItem("Secondary Weapon", ""));
		TreeItem<StatsItem> pistolNode = new TreeItem<>(new StatsItem("Pistol", ""));
							
		TreeItem<StatsItem> detailNode = new TreeItem<>(new StatsItem("Other", ""));
		detailNode.setExpanded(true);
					
		StatsItem offensiveStatsItem = new StatsItem("Offensive", "");
		StatsItem defensiveStatsItem = new StatsItem("Defensive", "");
		StatsItem skillStatsItem = new StatsItem("Skill", "");		
		
		// Nodes for the primary weapon
		TreeItem<StatsItem> primaryOffensiveNode = new TreeItem<>(offensiveStatsItem);		
							primaryOffensiveNode.setExpanded(true);		
		TreeItem<StatsItem> primaryDefensiveNode = new TreeItem<>(defensiveStatsItem);
		TreeItem<StatsItem> primarySkillNode = new TreeItem<>(skillStatsItem);
			
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
						default -> throw new IllegalStateException("Unrecognised weapon slot " + weaponslot);
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
				
				if (!attribute.toString().equals(Attribute.WEAPONDAMAGE.toString())) {
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
				case DEVIDEROFFENSIVE -> offensiveNode.getChildren().add(tempItem);
				case DEVIDERDEFENSIVE -> defensiveNode.getChildren().add(tempItem);					
				default	-> skillNode.getChildren().add(tempItem);
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
				
		
		for (TitledPane pane : equipmentPanes) {
			String slotName = pane.getText().toUpperCase();			
			InventorySlot slot = InventorySlot.valueOf(slotName);
			Equipment equipment = (Equipment) inventory.getEquipment(slot);
			pane.setCollapsible(false);
						
			if (equipment.isImprovisedItem()) {
				pane.setText("Improvised " + pane.getText());
			} else if(equipment.isNamedItem()) {
				pane.setText(equipment.getName());
				pane.getStyleClass().add("namedItem");
			} else {
				pane.setText("Normal " + equipment.getManufacturer().getShortname() + " " + pane.getText());
			}
			
			if (!equipment.isImprovisedItem()) {
				images.get(slot).setImage(new Image(
					App.class.getResource("assets/brands/"+ equipment.getManufacturer().getShortname() + ".png").toExternalForm(),
					true
				));
			}
			
			// Dependly on the core Attribute colorize the background of the pane
			switch(equipment.getCoreAttribute()) {
				case WEAPONDAMAGE -> pane.getStyleClass().add(COREATTRIBUTEREDCSSCLASSNAME);
				case ARMOR -> pane.getStyleClass().add(COREATTRIBUTEBLUECSSCLASSNAME);
				case SKILLTIER -> pane.getStyleClass().add(COREATTRIBUTEYELLOWCSSCLASSNAME);
				default -> throw new IllegalStateException("Unrecognised core attribute " + equipment.getCoreAttribute());
			}			
			
			// Initialize ComboBox und spinner pairs with preselection and selection values
			initializeComboBox(slot, equipment);
		}
		
		// Initialize weapon panes
		initializeDamageStats(headshotChanceSpinner.getValue().toString(), inventory);
		
		for (TitledPane pane : weaponPanes) {				
			
			String slotName = pane.getText().toUpperCase();			
			InventorySlot slot = InventorySlot.valueOf(slotName);
			Weapon weapon = (Weapon) inventory.getEquipment(slot);			
			pane.setCollapsible(false);			
			pane.getStyleClass().add("weapon");
			
			switch(slot) {
				case PRIMARY -> pane.setText("Primary Weapon: " + weapon.getName());
				case SECONDARY -> pane.setText("Secondary Weapon: " + weapon.getName());
				case PISTOL -> pane.setText("Pistol: " + weapon.getName());
				default -> {}
			}
			
			if (weapon.isNamedItem()) {			
				pane.getStyleClass().add("namedItem");
			}
			
			//Initialize ComboBox und spinner pairs with preselection and selection values
			initializeComboBox(slot, weapon);
		}
	}
	
	
	/**
	 * Preselection of item inside combobox, prefill of spinner with factory and values
	 * 
	 * @param comboBox The ComboBox to preselect
	 * @param spinner The spinner to set the value
	 * @param toSelect Select Identifier in ComboBox i.e. WEAPONDAMAGE, CRITICALHITCHANCE as String
	 * @param min Minimum for the spinner
	 * @param max Maximum for the spinner
	 * @param step Step for the spinner
	 * @param value The desired value to set
	*/	
	private void preselectionComboBoxSpinner(
		ComboBox<Label> comboBox,
		Spinner<?> spinner,
		String toSelect,
		Number min,
		Number max,
		Number step,
		Number value
	) {
		
		if (max != null) {
		
			ObservableList<Label> options = comboBox.getItems();
			options.forEach(select -> {
				String attribute = select.getText().substring(0, select.getText().indexOf(" "));
				if (attribute.contains(toSelect)) {
					comboBox.setValue(select);		
					spinner.setUserData(attribute);
					
					initializeSpinner(
						spinner,
						min,
						max,
						value,
						step
					);
				}			
			});
		}
	}
	
	/**
	 * Preselect of normal comboboxes	 * 
	 * @param comboBox The specific combobox where to preselect something
	 * @param toSelect Selectable String to preselect
	 * @param isPerfectTalent Is perfect talent
	 */
	private void preselectionComboBox(
			ComboBox<Label> comboBox,
			String toSelect,
			boolean isPerfectTalent
	) {			
		ObservableList<Label> options = comboBox.getItems();
		options.forEach(select -> {
			String attribute = select.getText();
			
			if (attribute.contains(toSelect)) {
				
				if (isPerfectTalent) {				
					select.setText("PERFECT " + select.getText());
				}
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
	@SuppressWarnings({ "unchecked" })
	private void initializeSpinner(Spinner<?> spinner, Number min, Number max, Number initial, Number step) {
		
		if (initial instanceof Double) {
			Spinner<Double> doubleSpinner = (Spinner<Double>) spinner;
			SpinnerValueFactory<Double> doubleFactory;
			
			doubleFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(
				min.doubleValue(),
				max.doubleValue(),
				initial.doubleValue(),
				step.doubleValue()
			);
			
			doubleSpinner.setValueFactory(doubleFactory);
			
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
			
			intSpinner.setValueFactory(intFactory);
			
		} else {
			throw new IllegalArgumentException("The spinner can't be initialize!");
		}
	}
	
	/**
	 * Initialize the equipment's ComboBoxes
	 * 
	 * @param slot Inventory Slot
	 * @param equipment Equipment
	 */
	private void initializeComboBox(InventorySlot slot, Equipment equipment) {
		
		ComboBox<Label> coreComboBox;
		ComboBox<Label> firstComboBox;
		ComboBox<Label> secondComboBox;
		ComboBox<Label> modComboBox;
		ComboBox<Label> talentComboBox;
		Spinner<Number> coreSpinner;
		Spinner<Number> firstSpinner;
		Spinner<Number> secondSpinner;
		Spinner<Number> modSpinner;
		Label modLabel;
		
		switch(slot) {
			default:
			case MASK:
				coreComboBox 	= maskCoreComboBox;
				firstComboBox 	= maskFirstComboBox;
				secondComboBox 	= maskSecondComboBox;
				modComboBox 	= maskModComboBox;
				coreSpinner 	= maskCoreSpinner;
				firstSpinner 	= maskFirstSpinner;
				secondSpinner 	= maskSecondSpinner;
				modSpinner		= maskModSpinner;
				modLabel		= null;
				talentComboBox	= null;
				break;
			case BACKPACK:
				coreComboBox 	= backpackCoreComboBox;
				firstComboBox 	= backpackFirstComboBox;
				secondComboBox 	= backpackSecondComboBox;
				modComboBox 	= backpackModComboBox;
				coreSpinner 	= backpackCoreSpinner;
				firstSpinner 	= backpackFirstSpinner;
				secondSpinner 	= backpackSecondSpinner;
				modSpinner		= backpackModSpinner;
				talentComboBox	= backpackTalentComboBox;
				modLabel		= null;				
				break;
			case ARMOR:
				coreComboBox 	= armorCoreComboBox;
				firstComboBox 	= armorFirstComboBox;
				secondComboBox 	= armorSecondComboBox;
				modComboBox 	= armorModComboBox;
				coreSpinner 	= armorCoreSpinner;
				firstSpinner 	= armorFirstSpinner;
				secondSpinner 	= armorSecondSpinner;
				modSpinner		= armorModSpinner;
				modLabel		= null;
				talentComboBox	= armorTalentComboBox;
				break;
			case GLOVE:
				coreComboBox 	= gloveCoreComboBox;
				firstComboBox 	= gloveFirstComboBox;
				secondComboBox 	= gloveSecondComboBox;
				modComboBox 	= gloveModComboBox;
				coreSpinner 	= gloveCoreSpinner;
				firstSpinner 	= gloveFirstSpinner;
				secondSpinner 	= gloveSecondSpinner;
				modSpinner		= gloveModSpinner;
				modLabel		= gloveModLabel;
				talentComboBox	= null;
				break;
			case HOLSTER:
				coreComboBox 	= holsterCoreComboBox;
				firstComboBox 	= holsterFirstComboBox;
				secondComboBox 	= holsterSecondComboBox;
				modComboBox 	= holsterModComboBox;
				coreSpinner 	= holsterCoreSpinner;
				firstSpinner 	= holsterFirstSpinner;
				secondSpinner 	= holsterSecondSpinner;
				modSpinner		= holsterModSpinner;
				modLabel		= holsterModLabel;
				talentComboBox	= null;
				break;
				
			case KNEEPAD:
				coreComboBox 	= kneepadCoreComboBox;
				firstComboBox 	= kneepadFirstComboBox;
				secondComboBox 	= kneepadSecondComboBox;
				modComboBox 	= kneepadModComboBox;
				coreSpinner 	= kneepadCoreSpinner;
				firstSpinner 	= kneepadFirstSpinner;
				secondSpinner 	= kneepadSecondSpinner;
				modSpinner		= kneepadModSpinner;
				modLabel		= kneepadModLabel;
				talentComboBox	= null;
				break;
		}
		
		// Initial values of combobox
		initializeComboBoxValues(coreComboBox, coreSpinner, equipment);
		initializeComboBoxValues(firstComboBox, firstSpinner, equipment);
		initializeComboBoxValues(secondComboBox, secondSpinner, equipment);		
		initializeComboBoxValues(modComboBox, modSpinner, equipment);
		
		// Talent preselection
		if (talentComboBox != null && (equipment.getSlot() == InventorySlot.ARMOR || equipment.getSlot() == InventorySlot.BACKPACK)) {
			initializeComboBoxValues(talentComboBox);
			preselectionComboBox(talentComboBox, equipment.getTalent().toString(), equipment.isNamedItem());
		}
				
		// All other preseletions
		preselectionComboBoxSpinner(coreComboBox, coreSpinner, equipment.getCoreAttribute().toString(), .0, Attribute.getCoreAttributes().get(equipment.getCoreAttribute()), 0.1, equipment.getCoreAttributeValue());				
		preselectionComboBoxSpinner(firstComboBox, firstSpinner, equipment.getFirstAttribute().toString(), 0, Attribute.getMinorAttributes(equipment).get(equipment.getFirstAttribute()), 0.1, equipment.getFirstAttributeValue());				
		preselectionComboBoxSpinner(secondComboBox, secondSpinner, equipment.getSecondAttribute().toString(), 0, Attribute.getMinorAttributes(equipment).get(equipment.getSecondAttribute()), 0.1, equipment.getSecondAttributeValue());
				
		// Preselections for mods
		if (equipment.isImprovisedItem() || 
			(
				equipment.getSlot() == InventorySlot.MASK || 
				equipment.getSlot() == InventorySlot.BACKPACK ||
				equipment.getSlot() == InventorySlot.ARMOR
			) 	
		) {		
			preselectionComboBoxSpinner(modComboBox, modSpinner, equipment.getMod().getFirstAttribute().toString(), .0, Attribute.getModAttributes().get(equipment.getMod().getFirstAttribute()), 0.1, equipment.getMod().getFirstAttributeValue());
		}
		
		if (!equipment.isImprovisedItem() && (
			equipment.getSlot() != InventorySlot.BACKPACK &&
			equipment.getSlot() != InventorySlot.ARMOR &&
			equipment.getSlot() != InventorySlot.MASK
		)) {			
			modComboBox.setVisible(false);
			modSpinner.setVisible(false);
			
			if (modLabel != null) {
				modLabel.setVisible(false);
			}
		}
		
		// Fixing combobox by named items with fixed attributes
		if (equipment.isNamedItem()) {
			Stack<Integer> fixed = equipment.getAllFixedAttributes();
			fixed.forEach(nr -> {
				if (nr == 1) {							
					firstComboBox.setDisable(true);
				} else if (nr == 2) {
					secondComboBox.setDisable(true);
				} 
			});
			
			if (talentComboBox != null) {
				talentComboBox.setDisable(true);
			}
		}
	}
	
	/**
	 * Initialize the weapon's ComboBoxes
	 * 
	 * @param slot Inventory Slot
	 * @param weapon Weapon
	 */
	private void initializeComboBox(InventorySlot slot, Weapon weapon) {
		
		ComboBox<Label> coreComboBox;
		ComboBox<Label> firstComboBox;
		ComboBox<Label> secondComboBox;		
		ComboBox<Label> talentComboBox;
		Spinner<Number> coreSpinner;
		Spinner<Number> firstSpinner;
		Spinner<Number> secondSpinner;
		
		switch(slot) {
			default:
			case PRIMARY:
				coreComboBox 	= primaryCoreComboBox;
				firstComboBox 	= primaryFirstComboBox;
				secondComboBox 	= primarySecondComboBox;				
				coreSpinner 	= primaryCoreSpinner;
				firstSpinner 	= primaryFirstSpinner;
				secondSpinner 	= primarySecondSpinner;				
				talentComboBox	= primaryTalentComboBox;
				break;
			case SECONDARY:
				coreComboBox 	= secondaryCoreComboBox;
				firstComboBox 	= secondaryFirstComboBox;
				secondComboBox 	= secondarySecondComboBox;				
				coreSpinner 	= secondaryCoreSpinner;
				firstSpinner 	= secondaryFirstSpinner;
				secondSpinner 	= secondarySecondSpinner;				
				talentComboBox	= secondaryTalentComboBox;
				break;
			case PISTOL:
				coreComboBox 	= pistolCoreComboBox;
				firstComboBox 	= pistolFirstComboBox;
				secondComboBox 	= pistolSecondComboBox;				
				coreSpinner 	= pistolCoreSpinner;
				firstSpinner 	= pistolFirstSpinner;
				secondSpinner 	= pistolSecondSpinner;				
				talentComboBox	= pistolTalentComboBox;
				break;
			
		}
		
		// Initial values of combobox
		initializeComboBoxValues(coreComboBox, coreSpinner, weapon);
		initializeComboBoxValues(firstComboBox, firstSpinner, weapon);
		initializeComboBoxValues(secondComboBox, secondSpinner, weapon);	
		
		
		// Talent preselection
		initializeComboBoxValues(talentComboBox, weapon);
		
		// Preselections
		preselectionComboBox(talentComboBox, weapon.getTalent().toString(), weapon.isNamedItem());
		preselectionComboBoxSpinner(coreComboBox, coreSpinner, weapon.getCoreAttribute().toString(), .0, Attribute.getWeaponCoreAttributes(weapon.getType()).get(weapon.getCoreAttribute()), 0.1, weapon.getCoreAttributeValue());
		preselectionComboBoxSpinner(firstComboBox, firstSpinner, weapon.getFirstAttribute().toString(), .0, Attribute.getWeaponSecondAttributes(weapon.getType()).get(weapon.getFirstAttribute()), 0.1, weapon.getFirstAttributeValue());
		
		preselectionComboBoxSpinner(secondComboBox, secondSpinner, weapon.getSecondAttribute().toString(), .0, Attribute.getWeaponMinorAttributes(weapon.getType()).get(weapon.getSecondAttribute()), 0.1, weapon.getSecondAttributeValue());
		
		// If weapon is a named version, don't allow the change the talent
		if (weapon.isNamedItem()) {
			talentComboBox.setDisable(true);
		}
		
		// Disabling the ability to change the attribute for the core and second
		if (weapon.getType() == WeaponType.PISTOL) {
			pistolFirstlabel.setVisible(false);
			firstComboBox.setVisible(false);
			firstSpinner.setVisible(false);
		}
		
		coreComboBox.setDisable(true);
		firstComboBox.setDisable(true);
	}
	
	/**
	 * Initialize the equipment's ComboBox values creating items for it and set the action handler
	 *
	 * @param comboBox ComboBox to initialize
	 * @param spinnerbox Assoociated spinnerbox for the ComboBox
	 * @param equipment Equipment
	 */
	private void initializeComboBoxValues(ComboBox<Label> comboBox, Spinner<?> spinnerbox, Equipment equipment) {
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
				
				if (equipment.isNamedItem() && 
						(equipment.getSlot() != InventorySlot.BACKPACK &&
						 equipment.getSlot() != InventorySlot.ARMOR)
				) {
					attributes = Attribute.getMinorAttributes(equipment);
				} else {
					attributes = Attribute.getMinorAttributes();
				} 
				
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
				case DAMAGETOTARGETOUTOFCOVER:
					imageView = createAttributeImage(DEVIDEROFFENSIVE);
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
				case RESISTANCEENSNARE:
				case RESISTANCEDESORIENT:
				case RESISTANCESHOCK:
					imageView = createAttributeImage(DEVIDERDEFENSIVE);
					break;				
				
				default:
				case SKILLTIER:
				case SKILLDAMAGE:
				case REPAIRSKILLS:
				case SKILLHASTE:
				case SKILLDURATION:
				case STATUSEFFECTS:
					imageView = createAttributeImage(DEVIDERSKILL);
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
		comboBox.setOnAction(e -> doInventoryComboBoxActionHandler(e, spinnerbox));
	}
	
	/**
	 * Initialize the weapon's ComboBox values creating items for it and set the action handler
	 *
	 * @param comboBox ComboBox to initialize
	 * @param spinnerbox Assoociated spinnerbox for the ComboBox
	 * @param weapon Weapon
	 */
	private void initializeComboBoxValues(ComboBox<Label> comboBox, Spinner<?> spinnerbox, Weapon weapon) {
		ObservableList<Label> options = FXCollections.observableArrayList();
		Map<Attribute, Number> attributes;		
		
		// With what Attributes should the combobox be filled
		switch(comboBox.getId()) {
			default:
			case "primaryCoreComboBox":
			case "secondaryCoreComboBox":
			case "pistolCoreComboBox":			
				attributes = Attribute.getWeaponCoreAttributes(weapon.getType());
				break;
			case "primaryFirstComboBox":
			case "secondaryFirstComboBox":
				attributes = Attribute.getWeaponSecondAttributes(weapon.getType());
				break;
			case "primarySecondComboBox":
			case "secondarySecondComboBox":
			case "pistolSecondComboBox":
				attributes = Attribute.getWeaponMinorAttributes(weapon.getType());
				break;
		}
				
		attributes.forEach((attribute, value) -> {
			
			ImageView imageView;
			
			switch(attribute) {
				case RIFLEDAMAGE:
				case ASSAULTRIFLEDAMAGE:
				case SHOTGUNDAMAGE:
				case MARKSMANRIFLEDAMAGE:
				case SMGDAMAGE:
				case LMGDAMAGE:
				case PISTOLDAMAGE:
				case DAMAGETOARMOR:
				case CRITICALHITCHANCE: 
				case CRITICALHITDAMAGE:
				case HEADSHOTDAMAGE:				
				case DAMAGETOTARGETOUTOFCOVER:
				case SWAPSPEED:
				case MAGSIZE:
				case DAMAGETOHEALTH:
					imageView = createAttributeImage(DEVIDEROFFENSIVE);
					break;
				
				default:
				case RELOADSPEED:
				case STABILITY:
				case ACCURACY:
				case OPTIMALRANGE:
				case RATEOFFIRE:
					imageView = createAttributeImage(DEVIDERSKILL);
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
		comboBox.setOnAction(e -> doInventoryComboBoxActionHandler(e, spinnerbox, weapon));
	}
	
	/**
	 * Initialize the combobox, creating items for it and set the action handler
	 *
	 * @param comboBox ComboBox to initialize
	 */
	private void initializeComboBoxValues(ComboBox<Label> comboBox) {
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
	 * Initialize the combobox, creating items for it and set the action handler
	 *
	 * @param comboBox ComboBox to initialize
	 * @param weapon Weapon
	 */
	private void initializeComboBoxValues(ComboBox<Label> comboBox, Weapon weapon) {
		ObservableList<Label> options = FXCollections.observableArrayList();
		List<TalentWeapon> talents;		
		talents = TalentWeapon.getWeaponTalents(weapon.getType());
				
		talents.forEach(talent -> {
			Label lbl = new Label(talent.toString());
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
	 * Equipment ComboBox ActionHandler target
	 * 
	 * @param event The caused event
	 * @param spinnerbox The associated spinnerbox to the event
	 */
	@SuppressWarnings("unchecked")
	private void doInventoryComboBoxActionHandler(Event event, Spinner<?> spinnerbox) {
		
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
						initializeSpinner(
							spinnerbox, 
							.0,
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							0.1
						);
						
						spinnerbox.setDisable(false);
					break;
					case "ARMOR":
						
						initializeSpinner(
							spinnerbox,
							0,
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getCoreAttributes().get(Attribute.valueOf(attribute)).intValue(),
							10000
						);
						
						spinnerbox.setDisable(false);	
					break;
						
					case "SKILLTIER":
						initializeSpinner(spinnerbox, 1, 1, 0, 0);
						spinnerbox.setDisable(true);	
					break;
					default:
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
					case "DAMAGETOTARGETOUTOFCOVER":
					case "HAZARDPROTECTION":
					case "EXPLOSIVERESISTANCE":
					case "SKILLDAMAGE":
					case "STATUSEFFECTS":
					case "REPAIRSKILLS":
					case "SKILLHASTE":
						
						initializeSpinner(
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
						
						initializeSpinner(
							spinnerbox,
							0,
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getMinorAttributes().get(Attribute.valueOf(attribute)).intValue(),
							1000
						);						
						spinnerbox.setDisable(false);
					break;
					default:
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
					case "RESISTANCEENSNARE":
					case "RESISTANCEDESORIENT":
					case "RESISTANCESHOCK":				
					case "REPAIRSKILLS":
					case "SKILLHASTE":
					case "SKILLDURATION":
						
						initializeSpinner(
							spinnerbox,
							.0,
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).doubleValue(),
							0.1
						);						
						spinnerbox.setDisable(false);
					break;
					
					case "ARMORONKILL":
						initializeSpinner(
							spinnerbox,
							0,
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).intValue(),
							Attribute.getModAttributes().get(Attribute.valueOf(attribute)).intValue(),
							1000
						);						
						spinnerbox.setDisable(false);
					break;
					default:
				}
					
			break;
			default:
						
		} // closing fxId
	}
	
	/**
	 * Weapon ComboBox ActionHandler target
	 * 
	 * @param event The caused event
	 * @param spinnerbox The associated spinnerbox to the event
	 * @param weapon Weapon
	 */
	@SuppressWarnings("unchecked")
	private void doInventoryComboBoxActionHandler(Event event, Spinner<?> spinnerbox, Weapon weapon) {
		
		ComboBox<Label> comboBox = (ComboBox<Label>)event.getSource();
		Object selectedItem = comboBox.getSelectionModel().getSelectedItem();
		Label select = (Label)selectedItem;
		String attribute = select.getText().substring(0, select.getText().indexOf(" "));
		String fxId = comboBox.getId();
		
		// Ditching selected Attribute from combobox to spinner, to access later in changeListener
		spinnerbox.setUserData(attribute);

		switch(fxId) {
			case "primaryCoreComboBox":
			case "secondaryCoreComboBox":
			case "pistolCoreComboBox":
				initializeSpinner(
					spinnerbox, 
					.0,
					Attribute.getWeaponCoreAttributes(weapon.getType()).get(Attribute.valueOf(attribute)).doubleValue(),
					Attribute.getWeaponCoreAttributes(weapon.getType()).get(Attribute.valueOf(attribute)).doubleValue(),
					0.1
				);
			break;
			
			case "primaryFirstComboBox":
			case "secondaryFirstComboBox":
				initializeSpinner(
					spinnerbox, 
					.0,
					Attribute.getWeaponSecondAttributes(weapon.getType()).get(Attribute.valueOf(attribute)).doubleValue(),
					Attribute.getWeaponSecondAttributes(weapon.getType()).get(Attribute.valueOf(attribute)).doubleValue(),
					0.1
				);
			break;
			
			case "primarySecondComboBox":
			case "secondarySecondComboBox":
			case "pistolSecondComboBox":
				initializeSpinner(
					spinnerbox, 
					.0,
					Attribute.getWeaponMinorAttributes(weapon.getType()).get(Attribute.valueOf(attribute)).doubleValue(),
					Attribute.getWeaponMinorAttributes(weapon.getType()).get(Attribute.valueOf(attribute)).doubleValue(),
					0.1
				);
			default:
			break;
		}
	}
	
	/**
	 * Create an image with the appropriate symbol
	 * @param type Offensive, defensive or skill image to create
	 * @return Image
	 */
	private ImageView createAttributeImage(String type) {
		ImageView imageView = new ImageView();
		
		var image = switch(type) {
			case DEVIDEROFFENSIVE ->  new Image(App.class.getResource("assets/offence.png").toExternalForm());
			case DEVIDERDEFENSIVE -> new Image(App.class.getResource("assets/defence.png").toExternalForm());
			default -> new Image(App.class.getResource("assets/utility.png").toExternalForm());
		};
		
		imageView.setImage(image);
		imageView.setFitHeight(16.0);
		imageView.setFitWidth(16.0);

		return imageView;
	}
	
	/**
	 * Initialize the weapon damage statistics
	 * @param headshotChanceString As String (Depends on spinner because it's a String)
	 * @param inventory The inventory to make the calculations on
	 */   
	
	private void initializeDamageStats(String headshotChanceString, Inventory inventory) {
		
		Double headshotChance = Double.parseDouble(headshotChanceString);		
		headshotChance = headshotChance / 100;
		Map<String, Double> damage;
		
		damage = world.getPlayer().getLoadout(DEFAULTLOADOUTNAME).getStatistic()
														.calculateWeaponDamage(inventory, headshotChance);
		DecimalFormat decimalFormat = new DecimalFormat("#,###", new DecimalFormatSymbols(Locale.GERMAN));
		
		primaryDamageLabel.setText(decimalFormat.format(damage.get("PRIMARY")) + " SPS");
		secondaryDamageLabel.setText(decimalFormat.format(damage.get("SECONDARY")) + " SPS");
		pistolDamageLabel.setText(decimalFormat.format(damage.get("PISTOL")) + " SPS");
	}
}
