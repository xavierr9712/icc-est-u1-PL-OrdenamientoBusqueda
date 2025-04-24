package Controllers;

import Models.Person;

public class SearchMethods {

    private boolean sortedByAge = false;
    private boolean sortedByName = false;
   

    public Person binarySearchByAge (Person [] persons, int age ) {

        int low = 0;
        int high = persons.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (persons[mid].getAge() == age) {
                return persons[mid];
            } else if (persons[mid].getAge() < age) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;

    }
    public Person binarySearchByName (Person [] persons, String name) {

        int low = 0;
        int high = persons.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = persons[mid].getName().compareTo(name);
            if (comparison == 0) {
                return persons[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
        

    }
    public boolean isSortedByAge(Person[] persons) {
        return sortedByAge;
    }


    public void setSortedByAge(boolean sortedByAge) {
        this.sortedByAge = sortedByAge;
    }


    public boolean isSortedByName(Person[] persons) {
        return sortedByName;
    }


    public void setSortedByName(boolean sortedByName) {
        this.sortedByName = sortedByName;
    }
    
}
