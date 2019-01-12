package com.proj.library;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReportGUI {

	private JFrame frame;
	private JTextField firstNameReport5;
	private JTextField lastNameReport5;
	private JComboBox monthReport3;
	private JComboBox cityReport4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportGUI window = new ReportGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReportGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel title = new JPanel();
		frame.getContentPane().add(title, BorderLayout.NORTH);
		title.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRaportyBazyBiblioteki = new JLabel("Baza danych Biblioteka");
		lblRaportyBazyBiblioteki.setFont(new Font("Tahoma", Font.BOLD, 18));
		title.add(lblRaportyBazyBiblioteki);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel report1 = new JPanel();
		tabbedPane.addTab("Raport 1", null, report1, null);
		FlowLayout fl_report1 = new FlowLayout(FlowLayout.CENTER, 100, 50);
		report1.setLayout(fl_report1);
		
		JLabel lblSpisKsiekAutorw = new JLabel("Spis ksi\u0105\u017Cek autor\u00F3w");
		lblSpisKsiekAutorw.setHorizontalAlignment(SwingConstants.CENTER);
		report1.add(lblSpisKsiekAutorw);
		
		JButton btnReport1 = new JButton("Poka\u017C raport");
		btnReport1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrintReport report1 = new PrintReport();
				report1.showReport("E:\\Eclipse-workspace\\LibraryDatabase\\Reports\\authorsBooks.jrxml");
			}
		});
		report1.add(btnReport1);
		
		JPanel report2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) report2.getLayout();
		flowLayout.setVgap(50);
		flowLayout.setHgap(100);
		tabbedPane.addTab("Raport 2", null, report2, null);
		
		JLabel lblWykresLiczbyKsiek = new JLabel("Wykres liczby ksi\u0105\u017Cek w zale\u017Cno\u015Bci od roku wydania");
		report2.add(lblWykresLiczbyKsiek);
		
		JButton btnReport2 = new JButton("Poka\u017C raport");
		btnReport2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrintReport report2 = new PrintReport();
				report2.showReport("E:\\Eclipse-workspace\\LibraryDatabase\\Reports\\yearPublications.jrxml");
			}
		});
		report2.add(btnReport2);
		
		JPanel report3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) report3.getLayout();
		flowLayout_1.setVgap(40);
		flowLayout_1.setHgap(100);
		tabbedPane.addTab("Raport 3", null, report3, null);
		
		JLabel lblWykresLiczbyWypoycze = new JLabel("Wykres liczby wypo\u017Cycze\u0144");
		report3.add(lblWykresLiczbyWypoycze);
		
		JLabel lblMiesic = new JLabel("Miesi\u0105c:");
		report3.add(lblMiesic);
		
		monthReport3 = new JComboBox();
		monthReport3.setModel(new DefaultComboBoxModel(new String[] {"2018-10", "2018-11"}));
		report3.add(monthReport3);
		
		JButton btnReport3 = new JButton("Poka\u017C raport");
		btnReport3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sourcePath = "E:\\Eclipse-workspace\\LibraryDatabase\\Reports\\bookLoansInMonth.jasper";
				BorrowBooksList borrowBooksList = new BorrowBooksList();
		    	ArrayList<BorrowBooks> dataList = borrowBooksList.select(monthReport3.getSelectedItem().toString());

		        JRBeanCollectionDataSource beanColDataSource = new 
		           JRBeanCollectionDataSource(dataList);
		        Map parameters = new HashMap();
		        try {
		           JasperPrint js = JasperFillManager.fillReport( 
		        		sourcePath, parameters, beanColDataSource);
		           
		           PrintReport report = new PrintReport();
		           report.showReport(js);
		        } catch (JRException e) {
		           e.printStackTrace();
		        }
			}
		});
		report3.add(btnReport3);
		
		JPanel report4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) report4.getLayout();
		flowLayout_2.setVgap(40);
		flowLayout_2.setHgap(100);
		tabbedPane.addTab("Raport 4", null, report4, null);
		
		JLabel lblSpisFiliiW = new JLabel("     Spis filii w miastach     ");
		report4.add(lblSpisFiliiW);
		
		JLabel lblMiasto = new JLabel("Miasto:");
		report4.add(lblMiasto);
		
		cityReport4 = new JComboBox();
		cityReport4.setModel(new DefaultComboBoxModel(new String[] {"Bydgoszcz", "Toru\u0144", "Gda\u0144sk", "Nak\u0142o nad Noteci\u0105"}));
		report4.add(cityReport4);
		
		JButton btnReport4 = new JButton("Poka\u017C raport");
		btnReport4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sourcePath = "E:\\Eclipse-workspace\\LibraryDatabase\\Reports\\branchesInCities.jasper";
				BranchCityList branchCityList = new BranchCityList();
		    	ArrayList<BranchCity> dataList = branchCityList.select(cityReport4.getSelectedItem().toString());

		        JRBeanCollectionDataSource beanColDataSource = new 
		           JRBeanCollectionDataSource(dataList);
		        Map parameters = new HashMap();
		        try {
		           JasperPrint js = JasperFillManager.fillReport( 
		        		sourcePath, parameters, beanColDataSource);
		           
		           PrintReport report = new PrintReport();
		           report.showReport(js);
		        } catch (JRException e) {
		           e.printStackTrace();
		        }
			}
		});
		report4.add(btnReport4);
		
		JPanel report5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) report5.getLayout();
		flowLayout_3.setVgap(25);
		flowLayout_3.setHgap(100);
		tabbedPane.addTab("Raport 5", null, report5, null);
		
		JLabel lblSpisKsiekCzytelnika = new JLabel("     Spis ksi\u0105\u017Cek czytelnika     ");
		report5.add(lblSpisKsiekCzytelnika);
		
		JLabel lblImi = new JLabel("Imi\u0119:");
		report5.add(lblImi);
		
		firstNameReport5 = new JTextField();
		report5.add(firstNameReport5);
		firstNameReport5.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		report5.add(lblNazwisko);
		
		lastNameReport5 = new JTextField();
		report5.add(lastNameReport5);
		lastNameReport5.setColumns(10);
		
		JButton btnReport5 = new JButton("Poka\u017C raport");
		btnReport5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sourcePath = "E:\\Eclipse-workspace\\LibraryDatabase\\Reports\\readerAndBooks.jasper";
				ReaderBooksList readerBooksList = new ReaderBooksList();
		    	ArrayList<ReaderBooks> dataList = readerBooksList.select(firstNameReport5.getText(), lastNameReport5.getText());

		        JRBeanCollectionDataSource beanColDataSource = new 
		           JRBeanCollectionDataSource(dataList);
		        Map parameters = new HashMap();
		        try {
		           JasperPrint js = JasperFillManager.fillReport( 
		        		sourcePath, parameters, beanColDataSource);
		           
		           PrintReport report = new PrintReport();
		           report.showReport(js);
		        } catch (JRException e) {
		           e.printStackTrace();
		        }
			}
		});
		report5.add(btnReport5);
		
		JPanel footer = new JPanel();
		frame.getContentPane().add(footer, BorderLayout.SOUTH);
		
		JLabel lblAutorMateuszBalcer = new JLabel("Autor: Mateusz Balcer");
		lblAutorMateuszBalcer.setFont(new Font("Tahoma", Font.ITALIC, 12));
		footer.add(lblAutorMateuszBalcer);
	}
}
