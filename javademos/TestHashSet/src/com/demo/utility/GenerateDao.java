package com.demo.utility;

import com.demo.dao.EmployeeDao;

public class GenerateDao {
	public static EmployeeDao getDao(int i) {
		if(i==1) {
			return new EmployeeDaoImpl();
		}
		
		return null;
	}

}
