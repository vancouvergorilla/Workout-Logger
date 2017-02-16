import java.util.Date;



public class DataList {
	private Date startingTime;
	private String location;
	private String buddy;
	private double milesCovered;
	private DataList next;
	private long duration;
	private int rating;
	
	public DataList(String location,String buddy){
		if(!buddy.equals("\n"))
		    this.buddy=buddy;
		else
			this.buddy=null;
		this.location=location;
	}
	
	public DataList(String location,String buddy , DataList data){
		if(!buddy.equals("None"))
		    this.buddy=buddy;
		else
			this.buddy=null;
		this.location=location;
		this.next=data;
	}
	
	public void setStartingTime(Date date){
		this.startingTime=date;
	}
	
	public void setDuration(long duration){
		this.duration=duration;
	}
	
	public void setMilesCovered(double milesCovered){
		this.milesCovered=milesCovered;
	}
	
	public DataList getNext(){
		return this.next;
	}
	
	public void setNext(DataList next){
		this.next=next;
	}
	
	public void setRating(int rating){
		this.rating=rating;
	}
	
	public void add(String location, String buddy){
		if(next==null){
			next=new DataList(location, buddy);
		}
		else
			next.add(location, buddy);
	}
	public void remove(){
		
	}
	public void displayWorkout(int n){
		if(next==null){
			if(this.buddy!=null)
			    System.out.println(n+"."+"Location:"+this.location+"  "+"Buddy:"+buddy+"  "
			    		+"Start Date:"+startingTime+"  "+"Duration:"+duration+"  "+"Rating:"+rating+
			    		"  "+"Miles Covered:"+milesCovered);
			else
				System.out.println(n+"."+"Location:"+this.location+"  "
			    		+"Start Date:"+startingTime+"  "+"Duration:"+duration+"  "+"Rating:"+rating
			    		+"  "+"Miles Covered:"+milesCovered);
		}
		else{
			if(this.buddy!=null)
			    System.out.println(n+"."+"Location:"+this.location+"  "+"Buddy:"+buddy+"  "
			    		+"Start Date:"+startingTime+"  "+"Duration:"+duration+"  "+"Rating:"+rating
			    		+"  "+"Miles Covered:"+milesCovered);
			else
				System.out.println(n+"."+"Location:"+this.location+"  "
			    		+"Start Date:"+startingTime+"  "+"Duration:"+duration+"  "+"Rating:"+rating
			    		+"  "+"Miles Covered:"+milesCovered);
		    next.displayWorkout(n+1);
		}
	}
	
	public String getSingleWorkout(){
		return "Location:"+this.location+"  "+"Buddy:"+buddy+"  "
	    		+"Start Date:"+startingTime+"  "+"Duration:"+duration+"  "+"Rating:"+rating
	    		+"  "+"Miles Covered:"+milesCovered;
	}
	
	public String displayWorkoutWithBuddy(String name, String partResult){
		if(next==null){
			if(name.toLowerCase().equals(buddy.toLowerCase())){
				return partResult+"\n"+this.getSingleWorkout();
			}
			else{
				return partResult;
			}
		}
		else{
			if(name.toLowerCase().equals(buddy.toLowerCase())){
				return next.displayWorkoutWithBuddy(name, partResult+"\n"+this.getSingleWorkout());
			}
			else{
				return next.displayWorkoutWithBuddy(name, partResult);
			}
		}
	}
	public DataList[] certainLocationList(String location, int count, DataList[] data){
		if(next==null){
			if(location.toLowerCase().equals(this.location.toLowerCase())){
				DataList[] temp=new DataList[count+1];
				for(int i=0;i<count;i++)
					temp[i]=data[i];
				temp[count]=this;
				data=temp;
				return data;
			}
			else
				return data;
		}
		else{
			if(location.toLowerCase().equals(this.location.toLowerCase())){
				DataList[] temp=new DataList[count+1];
				for(int i=0;i<count;i++)
					temp[i]=data[i];
				temp[count]=this;
				data=temp;
				return next.certainLocationList(location, count+1, data);
			}
			else{
				return next.certainLocationList(location, count, data);
			}
		}
	}
	
	public static void swap(DataList[]data, int i, int j){
		DataList temp=data[i];
		data[i]=data[j];
		data[j]=temp;
	}
	
	public static int findMin(DataList[]data, int lo, int hi){
        if (lo == hi)
		      return lo;
		else {
		      int min = findMin(data, lo + 1, hi);
		      if (data[lo].rating<= data[min].rating)
		         return lo;
		      else
		         return min;
		}
	}
	
	public static void selectionSort(DataList[] data, int lo, int hi)
	{
	if (lo < hi) {
	      int min = findMin(data, lo, hi);
	      swap(data, lo, min);
	      selectionSort(data, lo+1, hi);
	    }
    }
	
	public DataList[] correctMileage(double mileage, int count, DataList[] data){
		if(next==null){
			if(this.milesCovered==mileage){
				DataList[] temp=new DataList[count+1];
				for(int i=0;i<count;i++)
					temp[i]=data[i];
				temp[count]=this;
				data=temp;
				return data;
			}
			else
				return data;
		}
		else{
			if(this.milesCovered==mileage){
				DataList[] temp=new DataList[count+1];
				for(int i=0;i<count;i++)
					temp[i]=data[i];
				temp[count]=this;
				data=temp;
				return next.correctMileage(mileage, count+1, data);
			}
			else{
				return next.correctMileage(mileage, count, data);
			}
		}
	}
	
	public static int findMinForPB(DataList[]data, int lo, int hi){
        if (lo == hi)
		      return lo;
		else {
		      int min = findMinForPB(data, lo + 1, hi);
		      if (data[lo].duration<= data[min].duration)
		         return lo;
		      else
		         return min;
		}
	}
	
	public static void selectionSortForPB(DataList[] data, int lo, int hi)
	{
	if (lo < hi) {
	      int min = findMinForPB(data, lo, hi);
	      swap(data, lo, min);
	      selectionSortForPB(data, lo+1, hi);
	    }
    }
}
