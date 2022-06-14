import java.io.*;
import java.text.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String studentName = bufferedReader.readLine();
				String strings[] = studentName.split(",");
				for(String string : strings) {
				System.out.println(string.trim());
				}
			} 
			catch (Exception e){

			} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String line = bufferedReader.readLine();
				//System.out.println(line);
				String i[] = line.split(",");
				Random random = new Random();
				int number = random.nextInt(i.length);
				System.out.println(i[number].trim());
			} 
			catch (Exception e){

			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt", true));
				String string = args[0].substring(1);
	        	Date date = new Date();
	        	String dateFormations = "dd/mm/yyyy-hh:mm:ss a";
	       		DateFormat dateFormat = new SimpleDateFormat(dateFormations);
	        	String fd= dateFormat.format(date);
				bufferedWriter.write(", "+string+"\nList last updated on "+fd);
				bufferedWriter.close();
			} 
			catch (Exception e){

			}					
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String line = bufferedReader.readLine();
				String i[] = line.split(",");
				boolean done = false;
				String string = args[0].substring(1);
				for(int index = 0; index<i.length && !done; index++) {
					if(i[index].equals(string)) {
						System.out.println("We found it!");
						done=true;
				}
			}
			} 
			catch (Exception e){

			} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String line = bufferedReader.readLine();
				char chars[] = line.toCharArray();
				boolean in_word = false;
				int count=0;
				for(char c:chars) {
					if(c ==' ') {
						if (!in_word) {	count++; in_word =true;	
						}
						else { 
							in_word=false;
						}			
				}
			}
			System.out.println(count +" word(bufferedReader) found ");
			} 
			catch (Exception e){
				
			} 
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Invalid Arguments");	
		}
		
	}
}