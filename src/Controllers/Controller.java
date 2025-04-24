package Controllers;

import java.util.Scanner;

import Models.Person;
import Views.View;

public class Controller {

    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private Person[] persons;
    
    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethodss) {
        
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethodss;

    }


    public void start () {

        int opcion;
        do {
            opcion = view.showMenu();
            switch (opcion) {
                case 1:
                    imputPerson(); 
                    break;
                case 2:
                    addPerson();
                case 3:
                    sortPerson();
                    break;
                case 4:
                    Person resultado = searchPerson();
                    view.displaySearchResult(resultado);
                    break;
                case 5:
                    view.displayPerson(persons);
                    break;
                case 0:
                    view.showMessage("Adios");
                    break;
                default:

                    view.showMessage(" Opcion invalida intetelo de nuevo ");
                    break;
            }
        }while (opcion != 0);
            
    }

    
    public void imputPerson () {

        int numPersons = view.inputInt(" Ingrese el nuemro de la persona a ingresar ");
        persons = new Person[numPersons];

        for (int i = 0; i < numPersons; i++) {

            System.out.println( " Ingresar los datos de la parsona " + (i + i) + ":");
            persons [i] = view.inputPerson();

        } 

    }

    public void addPerson () {

        searchMethods.isSortedByAge(persons);
        searchMethods.isSortedByName(persons);
        if (persons == null){
            view.showMessage("No existe el arreglo, ingrese las personas por primera vez");
            imputPerson();
        } else {
            int numeroPersonas = view.inputInt("Ingrese el numero de persona a adicionar: ");
        
        Person[] personsTemp = new Person[persons.length + numeroPersonas];

        for (int i = 0; i < persons.length; i++){
            personsTemp[i] = persons[i];
        }

        for (int i = persons.length; i < personsTemp.length; i++){
            personsTemp[i] = view.inputPerson();
        }
        }
        
    }

    public void sortPerson () {

        int sortingOption = view.selectSortingMethod();
        switch (sortingOption) {
            case 1:
                sortingMethods.sortByNameWithBubble(persons);
                searchMethods.setSortedByName(true);
                searchMethods.setSortedByAge(false);
                break;

            case 2:
                sortingMethods.sortByNameWithSelectionDes(persons);
                searchMethods.setSortedByName(true);
                searchMethods.setSortedByAge(false);
                break;

            case 3:
                sortingMethods.sortByAgeWithInsertion(persons);
                searchMethods.setSortedByAge(true);
                searchMethods.setSortedByName(false);
                break;

            case 4:
                sortingMethods.sortByNameWithInsertion(persons);
                searchMethods.setSortedByName(true);
                searchMethods.setSortedByAge(false);
                break;

            default:
                view.showMessage("Opcion no valida :/");
                break;
        }
        
    }

    public Person searchPerson () {   
        
    int searchOption = view.selectSearchCriterion();
    Person resultado = null; 
    switch (searchOption) {
        case 1:
            if (searchMethods.isSortedByName(persons)) {
                String name = view.inputName();
                resultado = searchMethods.binarySearchByName(persons, name); 
            } else {
                view.showMessage("No se puede buscar en el arreglo si no está ordenado por nombre :/");
            }
            break;
        case 2:
            if (searchMethods.isSortedByAge(persons)) {
                int age = view.inputAge();
                resultado = searchMethods.binarySearchByAge(persons, age); 
            } else {
                view.showMessage("No se puede buscar en el arreglo si no está ordenado por edad :/");
            }
            break;
        default:
            view.showMessage("Opción no válida :/");
            break;
    }
    return resultado;

    }
    public static int validacion(Scanner leer, String mensaje, boolean permitirNegativos){
            
        int arrayLength = 0;

        do{
            System.out.print(mensaje);
            while (!leer.hasNextInt()) {
                System.out.println("Debes ingresar un entero  positivo valido :/");
                System.out.print(mensaje);
                leer.next();
            }
            arrayLength = leer.nextInt();
            if (!permitirNegativos && arrayLength < 0){
                System.out.println("Opcion incorrecta :/");
            }
        } while(! permitirNegativos && arrayLength < 0);
        return arrayLength;
    
    }

}
