package Graph;

public class PersonComparable implements Comparable<PersonComparable>{
	String name;
	    int age;
	     

	    public PersonComparable(String name, int age) {
	        this.name = name;
	        this.age = age;

	    }

	    public int getAge() {

	        return this.age;

	    }

	    public String getName() {

	        return this.name;

	    }

	    @Override

	    public String toString() {

	        return "";

	    }


	    @Override
	    public int compareTo(PersonComparable per) {
	    	if (this.age == per.age)
	            return 0;
	        else
	            return this.age > per.age ? 1 : -1;
	    }
	    public static void main (String[] args){
	    	PersonComparable per1 = new PersonComparable("Percy", 21);
	    	PersonComparable per2 = new PersonComparable("Claire", 19);
	    	System.out.println(per1.compareTo(per2));
	    }


}
