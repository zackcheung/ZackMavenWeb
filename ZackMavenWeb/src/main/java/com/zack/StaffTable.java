package com.zack;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StaffTable extends DefaultTableModel{

	public StaffTable() {

		String col[] = {"ID","Name","Phone", "Address"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		JTable table = new JTable(tableModel);
		        
	}

	public void addRow(int id, String name, String phone, String address) {
		// TODO Auto-generated method stub
		
	}

}
