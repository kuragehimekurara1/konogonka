/*
    Copyright 2019-2020 Dmitry Isaenko

    This file is part of Konogonka.

    Konogonka is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Konogonka is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Konogonka.  If not, see <https://www.gnu.org/licenses/>.
*/
package konogonka.Controllers.NCA;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import konogonka.Controllers.NSP.NSPController;
import konogonka.LoperConverter;
import konogonka.Tools.PFS0.IPFS0Provider;

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

    public void populateFields(IPFS0Provider pfs0, LinkedList<byte[]> sha256hashList) {
        resetTab();
        SectionPFS0Controller.setData(pfs0, null);
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
