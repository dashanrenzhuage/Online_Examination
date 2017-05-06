package edu.mum.onlinetest.service;

import net.sf.jasperreports.engine.JRDataSource;

public interface ReportServiceInterface {
	
	public  JRDataSource getDataSourceStudent(Long id);
}
