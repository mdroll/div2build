package at.droll.div2builder;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        at.droll.div2builder.App.setRoot("secondary");
    }
}
