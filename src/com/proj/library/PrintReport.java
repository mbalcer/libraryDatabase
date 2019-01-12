/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proj.library;


import java.sql.Connection;
import javax.swing.JFrame;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Mateusz
 */
public class PrintReport extends JFrame {
    Connection conn = SQLConnection.DbConnector();
    
    public PrintReport() {}
    
    public void showReport(String reportPath) {
        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
            JRViewer viewer = new JRViewer(JasperPrint);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            
            this.add(viewer);
            this.setSize(900,800);
            this.setVisible(true);
            
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public void showReport(JasperPrint js) {
    	try {
    		JRViewer viewer = new JRViewer(js);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            
            this.add(viewer);
            this.setSize(900,500);
            this.setVisible(true);
    	} catch(Exception e) {
            System.out.println(e);
        }
    	
    }
    
}
