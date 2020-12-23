package src.test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.service.Impl.SubscriptionServiceImp;

public class SubscriptionServiceImplTest {
	
	static SubscriptionServiceImp subscriptionService=null;
	
	@BeforeClass
	public static void initialize(){
		 subscriptionService=new SubscriptionServiceImp();
	}
	
	/**
	 * 
	 * @throws ParseException
	 */
	@Test
	public void testDateDfference() throws ParseException{
		long result=subscriptionService.getDateDiff("20/06/2009", "20/09/2009");
		System.out.println("result value::"+ result); 
	}
	
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testgetNameOfWeek() throws Exception{
		String result=subscriptionService.getNameOfWeek(convertToLocalDateViaInstant(new Date()));
		System.out.println("result value::"+ result); 
		
	}

}
