package Graph;

import java.util.Comparator;

public class PersonComparator implements Comparator<PersonComparable>{

	@Override
	public int compare(PersonComparable o1, PersonComparable o2) {
		// TODO Auto-generated method stub
		return o1.age - o2.age;
	}
	public static void main(String[] args){
		PersonComparable per1 = new PersonComparable("percy", 21);
		PersonComparable per2 = new PersonComparable("claire",19);
		PersonComparator comp = new PersonComparator();
		System.out.println(comp.compare(per1, per2));
	}
}
