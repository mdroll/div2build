module at.droll.div2builder {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.droll.div2builder to javafx.fxml;
    exports at.droll.div2builder;
}
