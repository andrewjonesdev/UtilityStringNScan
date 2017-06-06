package utilityForHire;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class UtilityStringNScan {

	public static String consoleTextFormatter(String text, int nextLine)
	{
		String[] listOfStrings = text.split(" ");
		String output = "";
		for (int count = 0; count < listOfStrings.length; count++){
			if (count%nextLine==0 && count!=0){
				output+=(listOfStrings[count] + "\n");
			}
			else if(count == listOfStrings.length-1){
				output+=listOfStrings[count];
			}
			else{
				output+=(listOfStrings[count] + " ");
			}
				
		}
		return output;
	}
	public static ArrayList <String> capitalizeSentence(String split){
		String [] postSplit = split.split(" ");
		ArrayList <String> output = new ArrayList();
		if(postSplit.length>1){
			for(int count = 0; count < postSplit.length; count++){
				if(count==postSplit.length-1){
					output.add(capitalizeWord(postSplit[count]));
				}
				else{
					output.add(capitalizeWord(postSplit[count]) + " ");
				}
			}
		}
		else{
			output.add(capitalizeWord(postSplit[0]));
		}
		return output;
	}
	public static String capitalizeWord(String word){
		return ((word.substring(0, 1)).toUpperCase() + (word.substring(1)).toLowerCase());
	}
	public static boolean letsGoAgain(String yesOrNo, boolean again, Scanner strScan){
		do{
			System.out.println("Do you want to continue? Y or N");
			yesOrNo = strScan.nextLine();
			//in case the user types "y" or "n" it will still go through
			yesOrNo = yesOrNo.toUpperCase();
			if(yesOrNo.equals("Y")){
				again = true;
			}
			else if(yesOrNo.equals("N")){
				again = false;
			}
			else{
				System.out.println("You didn't type \"Y\" or \"N\". please try again");
			}
			
		}while((!(yesOrNo.equals("Y"))) && (!(yesOrNo.equals("N"))));
		
		return again;
	}
	public static String sentenceCheck(String question1, String invalid1, boolean keepLooping, ArrayList <String> list, int whichVar, Scanner strScan ){
		String output = "";
		do{
				System.out.println(question1);

			try{
				list = capitalizeSentence(strScan.nextLine());	
			}catch (IndexOutOfBoundsException e)
			{
				System.out.println(invalid1);
				keepLooping = true;
				continue;
			}
			output =list.get(0);
			if(list.size()>1){
				for(int count = 1; count < list.size(); count ++){
					output += list.get(count);
				}
			}
			keepLooping=false;
		}while(keepLooping);	
		return output;
	}
	public static int intCheck(String question1/*, String invalid1, boolean testInvalid*/, boolean keepLooping, Scanner numScan){
		int output = 0;
		do{
		System.out.println(question1);
		//checks if letters are input
			if (numScan.hasNextInt()){
				output = numScan.nextInt();
				keepLooping = false;
				//checks if the user has given a date that hasn't occured yet

				//checks if date is real or not. B.C. is not accepted
				/*if(testInvalid){
					System.out.println(invalid1);	
					keepLooping = true;
				}*/

			}else{
				System.out.println("You didn't submit a whole number. Please try again.");
				numScan.next();
				keepLooping = true;
				continue;
			}
		}while(keepLooping);
		return output;
	}
	public static double doubleCheck(String question1/*, String invalid1, boolean testInvalid*/, boolean keepLooping, Scanner numScan){
		double output = 0;
		do{
		System.out.println(question1);
		//checks if letters are input
			if (numScan.hasNextDouble()){
				output = numScan.nextDouble();
				keepLooping = false;
				//checks if the user has given a date that hasn't occured yet

				//checks if date is real or not. B.C. is not accepted
				/*if(testInvalid){
					System.out.println(invalid1);	
					keepLooping = true;
				}*/

			}else{
				System.out.println("You didn't submit a whole number. Please try again.");
				numScan.next();
				keepLooping = true;
				continue;
			}
		}while(keepLooping);
		return output;
	}
	public static String objectPrinter(ArrayList <String> list){
		String output = "";
		if (!list.isEmpty()){
			if (list.size()>1){
				for (int count = 0; count < list.size(); count++){
					if (count==list.size()-1){
						output+=(list.get(count));
					}
					else{
						output+=(list.get(count)+"\n");
					}
				}
			}
			else{
				output+=list.get(0);
			}
		}
		else{
			output = "ArrayList is empty!";
		}
		return output;	
	}
}
