import Views.View;
import Controllers.*;



public class App {
    public static void main(String[] args) throws Exception {
        /// Crear la vista
        View view = new View();
        // Crear clases con los metodos de ordenamiento y busqueda
        SortingMethods sortingMethods = new SortingMethods();
        SearchMethods searchMethods = new SearchMethods();
        // Crear controlador
        Controller controller = new Controller(view, sortingMethods, searchMethods);
        controller.start();
    
    }
}
