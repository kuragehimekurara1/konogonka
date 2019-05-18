package konogonka.Controllers.NCA;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import konogonka.Controllers.NSP.NSPController;
import konogonka.LoperConverter;
import konogonka.Tools.PFS0.PFS0Provider;

import java.io.File;
import java.util.LinkedList;

public class NCASectionContentController{
    @FXML
    private NSPController SectionPFS0Controller;
    @FXML
    private VBox sha256pane;

    public void resetTab() {
        SectionPFS0Controller.resetTab();
        sha256pane.getChildren().clear();
    }

    public void populateFields(PFS0Provider pfs0, File file, LinkedList<byte[]> sha256hashList) {
        resetTab();
        SectionPFS0Controller.setData(pfs0, file);
        if (sha256hashList != null){
            for (int i = 0; i < sha256hashList.size(); i++){
                Label numberLblTmp = new Label(String.format("%10d", i));
                numberLblTmp.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
                Label sha256LblTmp = new Label(LoperConverter.byteArrToHexString(sha256hashList.get(i)));
                sha256LblTmp.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));

                sha256pane.getChildren().add(new HBox(numberLblTmp, sha256LblTmp));
            }
        }
    }
}
