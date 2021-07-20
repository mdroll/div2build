/**
 * module-info
 * @author Marco Droll
 */
module at.droll.div2builder {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires transitive javafx.graphics;
	requires javafx.base;

    opens at.droll.div2builder.frontend to javafx.fxml;
    exports at.droll.div2builder.frontend;  
    exports at.droll.div2builder;
    exports at.droll.div2builder.core.inventory;
    exports at.droll.div2builder.core.attribute;
    exports at.droll.div2builder.core.item;
    exports at.droll.div2builder.core.statistic;
}
