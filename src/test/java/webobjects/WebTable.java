package webobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.sl.In;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selectors.*;

public class WebTable {

    SelenideElement tableContent;
    SelenideElement tableHeader;
    SelenideElement table;

    public WebTable(SelenideElement table) {
        this.table = table;
        tableContent = table.$(byAttribute("role","treegrid"));
        tableHeader = table.$(byAttribute("role", "grid"));
    }

    public SelenideElement getTableContent(){
        return tableContent;
    }

    public SelenideElement getTableHeader(){
        return tableHeader;
    }

    public SelenideElement getCellElementByIndex(int rowIndex, int columnIndex ){
        return tableContent.$$(byTagName("tr")).get(rowIndex).$$(byTagName("td")).get(columnIndex);
    }

    public SelenideElement getCellByText(String cellText){
        Map<String, Integer> pos = getRowColumnIndex(cellText);
        if (pos.size() == 0){
            return null;
        }else {
            SelenideElement cell = getCellElementByIndex(pos.get("RowIndex"), pos.get("ColumnIndex"));
            return cell;
        }
    }

    public int getColumnIndex(String columnName){
        int columnIndex = 0;
        ElementsCollection columnHeaders =  tableContent.$(byTagName("tr")).$$(byTagName("th"));
        for (SelenideElement columnHeader:columnHeaders
             ) {
            if (columnHeader.getText().equals(columnName))
            {
                return columnIndex;
            }
            columnIndex++;
        }
        return columnIndex;
    }

    public Map<String, Integer> getRowColumnIndex(String cellText){
        int rowIndex = 0;
        int columnIndex = 0;
        Map<String, Integer> pos = new HashMap<>();
        ElementsCollection rows = tableContent.$$(byTagName("tr"));
        for (SelenideElement row:rows
             ) {
            ElementsCollection cells = row.$$(byTagName("td"));
            for (SelenideElement cell:cells
                 ) {
                if(cell.getText().equals(cellText)) {
                    pos.put("RowIndex", rowIndex);
                    pos.put("ColumnIndex", columnIndex);
                    return pos;
                }
                columnIndex++;
            }
            rowIndex++;
        }
        return pos;
    }

    public int getNumRows(){
        return tableContent.$$(byTagName("tr")).size();
    }

    public boolean doesCellTextExist(String cellText){
        Map<String, Integer> pos = getRowColumnIndex(cellText);
        if(pos.size() == 0){
            return false;
        }else {
            return true;
        }
    }
}
