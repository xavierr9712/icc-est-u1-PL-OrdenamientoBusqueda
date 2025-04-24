package Views;

import java.util.Scanner;

import Models.Person;

public class View {

    private Scanner scanner = new Scanner(System.in);

    public int showMenu() {

        System.out.println("\n--- Menú ---");

        System.out.println(" 1. Ingresar personas ");
        System.out.println(" 2. Agregar persona ");
        System.out.println(" 2. Ordenar personas ");
        System.out.println(" 3. Buscar persona ");
        System.out.println(" 5. Mostrar personas ");
        System.out.println(" 0. salir ");
       
        return Controllers.Controller.validacion(scanner, "Ingrese la opcion que desea resalizar: ", false);

    }

    public Person inputPerson () {

        String name = inputName();
        int age = inputAge();
        return new Person(name, age);

    }
    public int selectSortingMethod (){

        
        System.out.println("\n--- Métodos de Ordenamiento ---");

        System.out.println(" 1. Ordenar por nombre ( Metodo Burbuja) ");
        System.out.println(" 2. ordenar por nombre ( Metodo Selección Desendente)");
        System.out.println(" 3. Ordenar por Edad ( Metodo Insección )");
        System.out.println(" 4. Ordenart por Nombre ( Metodo inserción)");
        return Controllers.Controller.validacion(scanner, "Ingrese la opcion que desea realizar: ", false);
    }
    public int selectSearchCriterion () {

        System.out.println("\n--- Criterios de Búsqueda ---");

        System.out.println(" 1. Buscar por Edad");
        System.out.println(" 2. Buscar por Nombre ");
        return Controllers.Controller.validacion(scanner, "Ingrese la opcion que desea realizar: ", false);

    }
    public void displayPerson (Person [] persons) {

        if (persons == null){
            System.out.println("El arreglo de personas esta vacio, ingrese personas");
        } else {
            for(Person person : persons){
                System.out.println("Nombre: " + person.getName() + "  Edad: " + person.getAge());
            }
        }
       

    }
    
    public void printObjeto(Person person) {
        System.out.println("El dato buscado corresponde a:");
        System.out.println("Nombre: " + person.getName() + "  Edad: " + person.getAge());
    }
    
    public void displaySearchResult (Person resultado) {
        if (resultado == null){
            System.out.println("No se encuentra");
        } else {
            printObjeto(resultado);
        }
    }
    
    public int inputAge () {

        return Controllers.Controller.validacion(scanner, "Ingrese la edad: ", false);


    }
    public String inputName () {

        System.out.println("Ingrese el nombre: ");
        return scanner.next();
        

    }
    public int inputInt(String mensaje){
        return Controllers.Controller.validacion(scanner, mensaje, false);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

}
