package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModal extends AbstractTableModel {

    private int NumColum = 4;
    private ArrayList<String []> dataArrayList;

    public TableModal(){
        dataArrayList = new ArrayList<String[]>();
        for(int i = 0; i < dataArrayList.size();i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }
    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return NumColum;
    }

    @Override
    public String getColumnName(int ColumnIndex){
        switch (ColumnIndex){
            case 0: return "id";
            case 1: return "Name";
            case 2: return "Family";
            case 3: return "Age";
        }
        return null;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String []rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    public void AddDate(String []row){
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);

    }
}
