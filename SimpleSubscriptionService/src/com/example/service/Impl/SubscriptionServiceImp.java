package com.example.service.Impl;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.service.SubscriptionService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class SubscriptionServiceImp implements SubscriptionService{
	
	private final int weeks=13;
	
	private static String FILE = "/Users/arpitadas/Documents/FirstPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

	@Override
	public String generateInvoive(String invoiceCharge, String subsType, String period, String startDate, String endDate) throws Exception,ParseException {
		String format = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date startingDate = sdf.parse(startDate);
		Date endingDate = sdf.parse(endDate);
		// TODO Auto-generated method stub	
		long result=getDateDiff(startDate,endDate);
		if(result>90){
			throw new Exception("Invalid period passed");
		}
		List<String> weeklyList=new ArrayList<String>();
		List<String> monthlyList=new ArrayList<String>();
		if(subsType.equalsIgnoreCase("WEEKLY")){
			Date date=new Date(startDate);
			String nameOfTheWeek=getNameOfWeek(convertToLocalDateViaInstant(date));
			for(int i=0;i<13;i++){
				Date dateWeeklly=getInvoiceDate(startingDate,nameOfTheWeek,period);
				weeklyList.add(dateWeeklly.toGMTString());
			}
			createInvoice(invoiceCharge,subsType,weeklyList);
			return weeklyList.toString();
		}
		if(subsType.equalsIgnoreCase("MONTHLY")){
			Date date1=addDays(startingDate, 30);
			Date date2=addDays(date1, 30);
			Date date3=addDays(date2, 30);
			monthlyList.add(date1.toGMTString());
			monthlyList.add(date2.toGMTString());
			monthlyList.add(date3.toGMTString());
			createInvoice(invoiceCharge,subsType,monthlyList);
			return monthlyList.toString();
		}
		return null;
		 
	}
	
	public String getNameOfWeek(LocalDate date) { 
		DayOfWeek day = date.getDayOfWeek(); 
		return day.name(); 
	} 
	
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public  long getDateDiff(String date1, String date2) {
		String format = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dateObj1=null;
		Date dateObj2=null;
		try {
			dateObj1 = sdf.parse(date1);
			dateObj2 = sdf.parse(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long diff = dateObj2.getTime() - dateObj1.getTime();
		int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
	    return diffDays;
	}

	private String createInvoice(String invoiceCharge, String subsType,List<String> invoiceDates){
		generatePDF(invoiceCharge,subsType,invoiceDates);
		return null;
	}
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	private Date getInvoiceDate(Date currentdate, String dayOfWeek, String period){
		Date billingDate = null;
		if((null!= dayOfWeek) && (period!=null) && (dayOfWeek.equalsIgnoreCase("MONDAY"))){
			if(period.equalsIgnoreCase("Monday")){
				billingDate=addDays(currentdate,0);
			}
			if(period.equalsIgnoreCase("TUESDAY")){
				billingDate=addDays(currentdate,1);
			}
			if(period.equalsIgnoreCase("WEDNESDAY")){
				billingDate=addDays(currentdate,2);
			}
			if(period.equalsIgnoreCase("THURSDAY")){
				billingDate=addDays(currentdate,3);
			}
			if(period.equalsIgnoreCase("FRIDAY")){
				billingDate=addDays(currentdate,4);
			}
			if(period.equalsIgnoreCase("SATURDAY")){
				billingDate=addDays(currentdate,5);
			}
			if(period.equalsIgnoreCase("SUNDAY")){
				billingDate=addDays(currentdate,6);
			}
		}
		if((null!= dayOfWeek) &&  (period!=null) && (dayOfWeek.equalsIgnoreCase("TUESDAY"))){
			if(period.equalsIgnoreCase("Monday")){
				billingDate=addDays(currentdate,6);
			}
			if(period.equalsIgnoreCase("TUESDAY")){
				billingDate=addDays(currentdate,0);
			}
			if(period.equalsIgnoreCase("WEDNESDAY")){
				billingDate=addDays(currentdate,1);
			}
			if(period.equalsIgnoreCase("THURSDAY")){
				billingDate=addDays(currentdate,2);
			}
			if(period.equalsIgnoreCase("FRIDAY")){
				billingDate=addDays(currentdate,3);
			}
			if(period.equalsIgnoreCase("SATURDAY")){
				billingDate=addDays(currentdate,4);
			}
			if(period.equalsIgnoreCase("SUNDAY")){
				billingDate=addDays(currentdate,5);
			}
			
			
		}
		if((null!= dayOfWeek) && (period!=null) && (dayOfWeek.equalsIgnoreCase("WEDNESDAY"))){
			
			if(period.equalsIgnoreCase("Monday")){
				billingDate=addDays(currentdate,5);
			}
			if(period.equalsIgnoreCase("TUESDAY")){
				billingDate=addDays(currentdate,6);
			}
			if(period.equalsIgnoreCase("WEDNESDAY")){
				billingDate=addDays(currentdate,0);
			}
			if(period.equalsIgnoreCase("THURSDAY")){
				billingDate=addDays(currentdate,1);
			}
			if(period.equalsIgnoreCase("FRIDAY")){
				billingDate=addDays(currentdate,2);
			}
			if(period.equalsIgnoreCase("SATURDAY")){
				billingDate=addDays(currentdate,3);
			}
			if(period.equalsIgnoreCase("SUNDAY")){
				billingDate=addDays(currentdate,4);
			}
			
		}
		if((null!= dayOfWeek) &&  (period!=null) && (dayOfWeek.equalsIgnoreCase("THURSDAY"))){
			if(period.equalsIgnoreCase("Monday")){
				billingDate=addDays(currentdate,4);
			}
			if(period.equalsIgnoreCase("TUESDAY")){
				billingDate=addDays(currentdate,5);
			}
			if(period.equalsIgnoreCase("WEDNESDAY")){
				billingDate=addDays(currentdate,6);
			}
			if(period.equalsIgnoreCase("THURSDAY")){
				billingDate=addDays(currentdate,0);
			}
			if(period.equalsIgnoreCase("FRIDAY")){
				billingDate=addDays(currentdate,1);
			}
			if(period.equalsIgnoreCase("SATURDAY")){
				billingDate=addDays(currentdate,2);
			}
			if(period.equalsIgnoreCase("SUNDAY")){
				billingDate=addDays(currentdate,3);
			}
			
		}
		if((null!= dayOfWeek) && (period!=null) && (dayOfWeek.equalsIgnoreCase("FRIDAY"))){
			if(period.equalsIgnoreCase("Monday")){
				billingDate=addDays(currentdate,3);
			}
			if(period.equalsIgnoreCase("TUESDAY")){
				billingDate=addDays(currentdate,4);
			}
			if(period.equalsIgnoreCase("WEDNESDAY")){
				billingDate=addDays(currentdate,5);
			}
			if(period.equalsIgnoreCase("THURSDAY")){
				billingDate=addDays(currentdate,6);
			}
			if(period.equalsIgnoreCase("FRIDAY")){
				billingDate=addDays(currentdate,0);
			}
			if(period.equalsIgnoreCase("SATURDAY")){
				billingDate=addDays(currentdate,1);
			}
			if(period.equalsIgnoreCase("SUNDAY")){
				billingDate=addDays(currentdate,2);
			}
			
		}
		if((null!= dayOfWeek) &&  (period!=null) && (dayOfWeek.equalsIgnoreCase("SATURDAY"))){
			if(period.equalsIgnoreCase("Monday")){
				billingDate=addDays(currentdate,2);
			}
			if(period.equalsIgnoreCase("TUESDAY")){
				billingDate=addDays(currentdate,3);
			}
			if(period.equalsIgnoreCase("WEDNESDAY")){
				billingDate=addDays(currentdate,4);
			}
			if(period.equalsIgnoreCase("THURSDAY")){
				billingDate=addDays(currentdate,5);
			}
			if(period.equalsIgnoreCase("FRIDAY")){
				billingDate=addDays(currentdate,6);
			}
			if(period.equalsIgnoreCase("SATURDAY")){
				billingDate=addDays(currentdate,0);
			}
			if(period.equalsIgnoreCase("SUNDAY")){
				billingDate=addDays(currentdate,1);
			}
			
		}
		if((null!= dayOfWeek) &&  (period!=null) && (dayOfWeek.equalsIgnoreCase("SUNDAY"))){
			if(period.equalsIgnoreCase("Monday")){
				billingDate=addDays(currentdate,1);
			}
			if(period.equalsIgnoreCase("TUESDAY")){
				billingDate=addDays(currentdate,2);
			}
			if(period.equalsIgnoreCase("WEDNESDAY")){
				billingDate=addDays(currentdate,3);
			}
			if(period.equalsIgnoreCase("THURSDAY")){
				billingDate=addDays(currentdate,4);
			}
			if(period.equalsIgnoreCase("FRIDAY")){
				billingDate=addDays(currentdate,5);
			}
			if(period.equalsIgnoreCase("SATURDAY")){
				billingDate=addDays(currentdate,6);
			}
			if(period.equalsIgnoreCase("SUNDAY")){
				billingDate=addDays(currentdate,0);
			}
			
		}
		
		return billingDate;
	}
	
	
	public void generatePDF(String amount, String subType, List<String> invoiceDate){
		try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document,amount,subType,invoiceDate);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	
	private int getPeriodForWeekly(String Period){
		return 0;
		
	}
	
	private void addMetaData(Document document) {
        document.addTitle("Invoice");
        document.addSubject("For below Subscrption");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Arpita Das");
        document.addCreator("Arpita Das");
    }
	
	private void addTitlePage(Document document, String amount, String subType, List<String> invoiceDates)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Invoice of Current Subscription", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph(
                "Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                smallBold));
        addEmptyLine(preface, 4);
        preface.add(new Paragraph(
                "Amount " + amount,
                smallBold));
        addEmptyLine(preface, 5);
        preface.add(new Paragraph(
                "Subscription Type " + subType,
                smallBold));
        addEmptyLine(preface, 6);
        preface.add(new Paragraph(
                "Invoice Date/Dates " + invoiceDates.toString(),
                smallBold));
        
        addEmptyLine(preface, 7);
        preface.add(new Paragraph(
                "This document describes something which is very important ",
                smallBold));

        //addEmptyLine(preface, 8);

        preface.add(new Paragraph(
                "This document is a preliminary version and not subject to your license agreement or any other agreement with EazyPay.com ;-).",
                redFont));

        document.add(preface);
    }
	
	 public  Date addDays(Date d, int days)
	    {
	        d.setTime(d.getTime() + days * 1000 * 60 * 60 * 24);
	        return d;
	    }
	
	private  void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
