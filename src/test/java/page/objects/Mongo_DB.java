package page.objects;

import com.google.common.collect.Iterables;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import WaitEvents.SyncEvents;
import WaitEvents.SyncEvents.WindowEvents;
import framework.ParentPage;

import static glue.Driver.driver;
import static org.testng.Assert.assertEquals;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;
import java.util.*;
import java.util.List;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

 public class Mongo_DB  extends ParentPage {

     Properties mongo_out_properties;
     Properties mongo_in_properties;

     SyncEvents Page= new SyncEvents(driver);
     public int TESTING_TIMEOUT = Integer.parseInt(SyncEvents.readConfig("Default_Timeout"));

     public Mongo_DB(WebDriver driver) {
         super(driver);
         mongo_out_properties = readMongoDB_OUT_Propertyfile();
         mongo_in_properties  = readMongoDB_IN_Propertyfile();
     }


}
