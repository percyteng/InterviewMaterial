package interviewGoogle;

public class ComparablePerson implements Comparable {
    private int person_id;
    private String name;
    public int getPersonId(){
    	return person_id;
    }
    /**
     * Compare current person with specified person
     * return zero if person_id for both person is same 
     * return negative if current person_id is less than specified one
     * return positive if specified person_id is greater than specified one
     */
    @Override 
    public int compareTo(Object o) {
        ComparablePerson p = (ComparablePerson) o; 
        return this.person_id - p.person_id ;
    }
}
