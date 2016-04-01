package problem3;

public class AscendinglyOrderedStringList implements AscendinglyOrderedStringListInterface  {
	protected String[] strings = new String[3];
	protected int numItems;

	public AscendinglyOrderedStringList(){
		numItems = 0;
	}

	public boolean isEmpty(){
		return (numItems>0);
	}

	public int size(){
		return numItems;
	}

	public void add(String item)
	{
		Integer index = null;
		if(numItems==0){
			index = 0;
		}

		else{
			index = Math.abs(search(item));
			if(index == numItems){
				System.out.println("last index case");
				index = numItems;
			}
			else{
				if(numItems == strings.length){
					resize();				
				}
				System.out.println("Copy");
				for(int i = numItems-1; i>=index; i--)
				{
					strings[i+1] = strings[i];
				}
			}
		}
		System.out.println("Current index " + index);
		strings[index] = item;
		numItems++;
	}

	public void remove(int index)throws ListIndexOutOfBoundsException{


		if (index >= 0 && index < numItems)
		{
			for(int i = index + 1; i<numItems; i++){
				strings[i - 1] = strings[i]; 
			}
			numItems--;
			strings[numItems] = null;
		}
		else

		{
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on remove");
		}  // end if
	}


	public String get(int index) throws ListIndexOutOfBoundsException{    

		if (index >= 0 && index < numItems)
		{
			return strings[index];
		}
		else
		{
			// index out of range
			throw new ListIndexOutOfBoundsException(
					"ListIndexOutOfBoundsException on get");
		}  // end if
	} // end get



	public int search(String item){	
		int lo = 0;
		int high = numItems - 1;
		int mid = 0;

		while(lo<high){
			mid =  (lo+high)/2;		
			if(item.compareTo(strings[mid]) <= 0){
				high = mid;
			}
			else {
				lo = mid + 1;
			}			
		}	

		if(item.compareTo(strings[mid])==0){
			return mid;
		}
		else{
			return mid*-1 ; //If value not found make it negative so we can 
							//differentiate between found and not found.
		}
	}



	//private resize method
	private void resize(){
		String[] temp = new String[strings.length + strings.length/2 + 1];
		for(int i = 0; i<strings.length; i++){
			temp[i] = strings[i];
		}
		strings = temp;
		System.out.println(this);
	}

	public String toString()
	{
		String s = "";
		for(int i =0; i<numItems; i++){			
			s += strings[i] + " ";
		}
		return s;
	}



}
