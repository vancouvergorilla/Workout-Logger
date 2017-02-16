import java.util.Date;


public class appUse {
	public static void main(String[] args){
		DataList first=null;
		 System.out.println("Welcome to the Workout Logger! Select an option below:\n"+
				 "1) add a workout\n"+"2) remove a workout\n"+"3) display all workouts\n"
	                +"4) display all workouts with buddy\n"+"5) display workouts for a certain location\n"
	                +"6) PB: display personal best time for a prompted location\n"
	                     +"7) quit\n");
		while(true){
		System.out.println("Select an option above:");
		int number=TextIO.getlnInt();
		while(number>7 || number<1){
			System.out.println("Wrong Number! Try again.");
			number=TextIO.getlnInt();
		}
		if(number==7){
			System.out.println("Are you sure you want to quit? - all your data will be lost.");
			System.out.println("Please reply by Y(Yes) or N(No)");
			char quit=TextIO.getlnChar();
			if(quit=='Y'||quit=='y'){
				System.out.println("Thank you for using. Bye.");
				break;
			}
			if(quit=='N'||quit=='n'){
			}	
		}
		if(number==1){
			System.out.println("Please enter a workout location.");
			String location=TextIO.getlnString();
			System.out.println("Please enter a workout buddy(optional). If you work alone, please hit return.");
			String buddy=TextIO.getln();
			if(first==null)
				first=new DataList(location, buddy);
			else{
				first=new DataList(location, buddy, first);
			}
			System.out.println("Hit return to start workout:");
			TextIO.getln();
			first.setStartingTime(new Date());
			long start=System.currentTimeMillis();
			System.out.println("Hit return to end workout:");
			TextIO.getln();
			long end=System.currentTimeMillis();
			first.setDuration(end-start);
			System.out.println("Provide the miles covered:");
			first.setMilesCovered(TextIO.getlnDouble());
			System.out.println("Provide a rating to workout (1: great; 10 poor):");
			first.setRating(TextIO.getlnInt());
		}
        if(number==2){
        	if(first==null)
        		System.out.println("Sorry, there is no work to delete. Please add one first");   
        	else{
        	first.displayWorkout(1);
			System.out.println("Which one do you want to delete?");
			int delete=TextIO.getlnInt();
			DataList before=first;
			DataList after=first;
			if(delete==1){
				first=first.getNext();
			}
			else{
			    for(int i=0;i<delete-2;i++){
				    before=before.getNext();
			    }
			    for(int i=0;i<delete;i++){
				    after=after.getNext();
			    }
			    before.setNext(after);
			}
        	}
		}
        if(number==3){
        	if(first!=null)
			    first.displayWorkout(1);
        	else
        		System.out.println("Sorry, there is no work to display.");
		}
        if(number==4){
        	System.out.println("Please enter a buddy name:");
        	String enteredName=TextIO.getlnString();
        	String partResult="";
			String workout=first.displayWorkoutWithBuddy(enteredName, partResult);
			if(workout.equals(""))
				System.out.println("Sorry, no workouts found.");
			else
				System.out.println(workout);
		}
        if(number==5){
        	System.out.println("Please enter a location:");
        	String enteredLocation=TextIO.getlnString();
        	DataList[] data=new DataList[0];
        	DataList[] result=first.certainLocationList(enteredLocation, 0, data);
        	DataList.selectionSort(result, 0, result.length-1);
        	if(result.length==0){
        		System.out.println("Sorry, no workouts found.");
        	}
        	else{
        	    for(int i=0;i<result.length;i++){
        		    System.out.println(result[i].getSingleWorkout());
        	    }
        	}
       
		}
        if(number==6){
        	System.out.println("Please enter a mileage:");
        	double mileage=TextIO.getlnDouble();
        	DataList[] data=new 
        			DataList[0];
            DataList[] result=first.correctMileage(mileage, 0, data);
            DataList.selectionSortForPB(result, 0, result.length-1);
            if(result.length==0){
            	System.out.println("Sorry, no workouts found.");
            }
            else{
        	    System.out.println(result[0].getSingleWorkout());
            }
		}
        
		}
	}
	
}
