import java.io.*;
import java.text.*;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println(Constant.dataLoading);
			try {
				String[] strings = getStrings();
				for(String string : strings) {
				System.out.println(string.trim());
				}
			} 
			catch (Exception e){

			} 
			System.out.println(Constant.dataStatus);
		}
		else if(args[0].equals("r")) {
			System.out.println(Constant.dataLoading);
			try {
				String i[] = getStrings();
				Random random = new Random();
				int number = random.nextInt(i.length);
				System.out.println(i[number].trim());
			} 
			catch (Exception e){

			} 
			System.out.println(Constant.dataStatus);
		}
		else if(args[0].contains("+")){
			System.out.println(Constant.dataLoading);
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(Constant.fileName, true));
				String string = args[0].substring(1);
	        	String dateFormations = Constant.dateFormat;
	       		DateFormat dateFormat = new SimpleDateFormat(dateFormations);
	        	String fd= dateFormat.format(new Date());
				bufferedWriter.write(", "+string+ Constant.updateReport +fd);
				bufferedWriter.close();
			} 
			catch (Exception e){

			}					
			System.out.println(Constant.dataStatus);
		}
		else if(args[0].contains("?")) {
			System.out.println(Constant.dataLoading);
			try {
				String i[] = getStrings();
				boolean done = false;
				String string = args[0].substring(1);
				for(int index = 0; index<i.length && !done; index++) {
					if(i[index].equals(string)) {
						System.out.println(Constant.founded);
						done=true;
				}
			}
			} 
			catch (Exception e){

			} 
			System.out.println(Constant.dataStatus);
		}
		else if(args[0].contains("c")) {
			System.out.println(Constant.dataLoading);
			try {
				BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constant.fileName)));
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
			System.out.println(count + Constant.found);
			} 
			catch (Exception e){
				
			} 
			System.out.println(Constant.dataStatus);
		}
		else{
			System.out.println(Constant.error);
		}
		
	}

	private static String[] getStrings() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(
					new FileInputStream(Constant.fileName)));
		String studentName = bufferedReader.readLine();
		String strings[] = studentName.split(",");
		return strings;
	}
}