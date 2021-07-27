/**
 * module-info
 * @author Marco Droll
 */
module at.droll.div2builder {
    requires transitive javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.base;
	requires java.base;
	requires java.desktop;

    opens at.droll.div2builder.frontend to javafx.fxml;
    exports at.droll.div2builder.frontend;  
    exports at.droll.div2builder;
    exports at.droll.div2builder.core.inventory;
    exports at.droll.div2builder.core.attribute;
    exports at.droll.div2builder.core.item;
    exports at.droll.div2builder.core.item.equipment;
    exports at.droll.div2builder.core.statistic;
    exports at.droll.div2builder.core;
    exports at.droll.div2builder.core.mod;
}
