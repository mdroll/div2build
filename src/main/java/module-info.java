module at.droll.div2builder {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;

    opens at.droll.div2builder to javafx.fxml;
    exports at.droll.div2builder;    
    exports at.droll.div2builder.framework.statistic;
}
