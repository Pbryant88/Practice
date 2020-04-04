package WaitEvents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.SDL_Homepage;


public class SyncEvents extends SDL_Homepage

{
	
	public SyncEvents(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	static int windowID = 0;
	WebDriverWait wait;
	public static HashMap<String, List<String>> messageList = new HashMap<String, List<String>>();
	
	
	/// <summary>
	///  Events on browser object
	/// </summary>
	public enum WindowEvents
	{
	    /// <summary>
	    /// Window loading 
	    /// </summary>
	    WINDOW_LOADING,
	
	    /// <summary>
	    /// Window is ready, i.e any involved workflows have finished running. This 
	    /// WindowEvent is particularly useful when you want to wait for completion of 
	    /// event processing, etc. 
	    /// </summary>
	    WINDOW_READY,

	} ;
	
	//Supportive Function to Wait Events
	public Object RunScript(String strScript) throws Exception
	
	{
		
		Object o = null;
		
		SyncEvents.setWindowID(SyncEvents.windowID);
		if (driver instanceof JavascriptExecutor) {
			o =  ((JavascriptExecutor) driver)
				.executeScript(strScript);
		}
		
		if(SyncEvents.getMessageList().isEmpty() || SyncEvents.getMessageList() != null)
			SyncEvents.setMessageList(SyncEvents.getMessageList());
		if(SyncEvents.getWindowID() != SyncEvents.windowID) SyncEvents.windowID = SyncEvents.getWindowID();
		
		return o;
		
	}	
	
	//Synchronization event related functions
	
	public boolean WaitForEvent(WindowEvents winEvent, int timeout) throws Exception
	{
		return WaitForEvent(winEvent, timeout, SyncEvents.windowID);
	}
	
	public boolean WaitForEvent(WindowEvents winEvent, int timeout, int windowID) throws Exception
	{
		boolean value = false;
		switch(winEvent)
		{
			case WINDOW_LOADING:
			{
				value = waitForBrowserLoaded(timeout);
				
			}
			break;
			
			default:
				throw new Exception("Unhandled WindowEvent in CheckEvent");
		}
		return value;
	}
	
	//Function to handle the wait event
	public boolean waitForBrowserLoaded(int timeout) throws Exception
	{
		Thread.sleep(1000);
		long startTime = System.currentTimeMillis();
		String previousContents="";
		String currentContents = "";		
		int previousNodeCount, currentNodeCount = 0;
		long currentTime;
		
		do
		{			
			previousContents = currentContents;
			previousNodeCount = currentNodeCount;
			Thread.sleep(1000);
			try{
				currentNodeCount = driver.findElements(By.xpath("//*")).size();
				currentContents = (String)RunScript("return document.body.innerHTML;");
			}catch(Exception e){}
			currentTime = System.currentTimeMillis();
		}while(!(currentNodeCount != previousNodeCount && !currentContents.equals(previousContents)) &&  currentTime - startTime < timeout * 1000);
		return false;
		
	}
	
	//Function to handle Synchronization
	public boolean waitForBrowserReady(int timeout) throws Exception
	{
		return waitForBrowserReady(SyncEvents.windowID);
	}
	
	
	public static void setMessageList(HashMap<String, List<String>> messageList) 
	{
		SyncEvents.messageList = messageList;
	}  

	public static int getWindowID() 
    {
		return windowID;
    }

	public static void setWindowID(int windowID) 
	{
	    SyncEvents.windowID = windowID;
	}

	public static HashMap<String, List<String>> getMessageList() 
	{
		return messageList;
	}   
	
	//Function to get the default timeout value from DataInput.properties file
	public static String readConfig(String ConfigParameter)
	{
        Properties props=new Properties();
       
        String fileName = System.getProperty("user.dir")+"/src/test/resources/properties/DataInput.properties";        
        String value=null;
        try {
            props.load(new FileInputStream(fileName));
            value=props.getProperty(ConfigParameter, String.valueOf(ConfigParameter));
        } catch (IOException ioe) {
            System.err.println("I/O Exception on loading "+fileName+" file:\n"+ioe.getMessage());
            System.exit(1);
        }
        return value;
    }

}

	
		

