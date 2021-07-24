/****************************************************************
 * Program : To read Inventory json file and print the value for each inventory
 * @author Bathala Haresh
***************************************************************/
package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;

public class InventoryJson 
{
	public static void main(String[]args)
	{
		 JSONParser jsonParser = new JSONParser();
         JSONArray array=new  JSONArray();
         JSONObject object=new  JSONObject();
	       
         Calculation c=new Calculation();
         
         try 
	        {
	            //Read JSON file
	            object = (JSONObject) jsonParser.parse(new FileReader("F:\\inventory.json.txt"));
	            @SuppressWarnings({ "resource", "unused" })
				Scanner s=new Scanner(System.in);
	            array = (JSONArray)object.get("Rice");
	            System.out.print("For Rice: ");
	            c.inventoryCalculation(array);
	            System.out.println();
	            
	            array = (JSONArray)object.get("Wheat");
	    		System.out.print("For Wheat: ");
	    		c.inventoryCalculation(array);
	    		System.out.println();
	    		
	            array = (JSONArray)object.get("Pulses");
	    		System.out.print("For Pulses: ");
	    		c.inventoryCalculation(array);
	    		System.out.println();
	  
	        } catch (FileNotFoundException e) 
         	{
	            e.printStackTrace();
	        } catch (IOException e) 
         	{
	            e.printStackTrace();
	        } catch (Exception e) 
         	{
	        	e.printStackTrace();
	        }
	 }
}
class Calculation extends InventoryJson
{
	public void inventoryCalculation(JSONArray array)
    {
	 	Iterator<?> iterator = array.iterator();	
	 	//iterator to iterate
	 	while(iterator.hasNext()) 
	 	{
	 		JSONObject obj = (JSONObject)iterator.next();
	 		long weight = (long)obj.get("weight");
	 		long price = (long)obj.get("price");
	 		
	 		System.out.print(weight * price);
	 	}
    }
}