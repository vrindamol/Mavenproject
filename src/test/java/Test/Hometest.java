package Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Basepkg.Baceclass;
import Page.Homepage;
import Utilities.Excelutils;

public class Hometest extends Baceclass {
	@Test
	public void homePage() throws InterruptedException, IOException
	{ 
	Homepage hp=new Homepage(driver);
		
		hp.popUpclick();
		hp.loginsetValue("9400473080");
		hp.verifyOtp();
		String currenturl=driver.getCurrentUrl();
		if(baseurl.equals(currenturl))
		{
			System.out.println("login failed");
		}
		else
		{ 
			System.out.println("Login sucess");
		}
	
		hp.verifytitle();
		hp.Logo();
		hp.screenshot();
		hp.scollDown();
		hp.shop();
		
		List <WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println("Total no of links ----"+li.size());
		for (WebElement x:li)
		{
			String link=x.getAttribute("href");
			String linktext=x.getText();
			System.out.println(link+ "-----"+linktext);
		}
		
			try
			{
				URL u=new URL(baseurl);
				HttpURLConnection con=(HttpURLConnection)u.openConnection();
				con.connect();
				System.out.println(con.getResponseCode());
			} 
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			hp.cart();
			String x1="D:\\Documents\\Project\\address.xlsx";
			String Sheet="Sheet1";
			int rowCount=Excelutils.getRowCount(x1,Sheet);
			for(int i=1;i<=rowCount;i++)
			{
				String Name=Excelutils.getCellValue(x1, Sheet, i, 0);
				System.out.println("Name is"+Name);
				String Address1=Excelutils.getCellValue(x1, Sheet, i, 1);
				String Address2=Excelutils.getCellValue(x1, Sheet, i, 2);
				String City=Excelutils.getCellValue(x1, Sheet, i, 3);
				String District=Excelutils.getCellValue(x1, Sheet, i, 4);
				String Pincode=Excelutils.getCellValue(x1, Sheet, i, 5);
				String Phone=Excelutils.getCellValue(x1, Sheet, i, 6);
				hp.setAddress(Name, Address1, Address2, City, District,Pincode, Phone);
				
			}
		

			hp.save();
			hp.confirmaddaddress();
			hp.profile();
			
			
	}
}


