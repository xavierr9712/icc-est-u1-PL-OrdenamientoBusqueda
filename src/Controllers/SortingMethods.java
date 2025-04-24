package Controllers;

import Models.Person;

public class SortingMethods  {


    public void sortByNameWithBubble (Person [] persons) {

        int n = persons.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (persons[j].getName().compareTo(persons[j + 1].getName()) > 0) {
                    // swap temp and arr[i]
                    Person temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
        
    }
    public void sortByNameWithSelectionDes(Person [] persons) {

        int n = persons.length;
        for (int i = 0; i < n - 1; i++) {
            int max_idx = i;
            for (int j = i + 1; j < n; j++)
                if (persons[j].getName().compareTo(persons[max_idx].getName()) > 0)
                    max_idx = j;

         
            Person temp = persons[max_idx];
            persons[max_idx] = persons[i];
            persons[i] = temp;
        }

    }
    public void sortByAgeWithInsertion (Person [] persons) {

        int n = persons.length;
        for (int i = 1; i < n; ++i) {
            Person key = persons[i];
            int j = i - 1;

            while (j >= 0 && persons[j].getAge() > key.getAge()) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            persons[j + 1] = key;
        }

    }
    public void sortByNameWithInsertion (Person [] persons) {

        int n = persons.length;
        for (int i = 1; i < n; ++i) {
            Person key = persons[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && persons[j].getName().compareTo(key.getName()) > 0) {
                persons[j + 1] = persons[j];
                j = j - 1;
            }
            persons[j + 1] = key;
        }
    }    
}
