package org.ceva.ch04.classes_objects.model;

import org.ceva.ch05.inheritance.Person;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.random.RandomGenerator;

/*
 * En lo casos donde una clase parece requerir multiples constructores con la misma firma, reemplace
 * los constructores con metodos de fabrica static y nombres cuidadosamente elegidos para resaltar
 * sus diferencias.
 * A la interface Comparable le proporcionamos un parametro de tipo.
 */
public class Employee  extends Person implements Cloneable, Comparable<Employee>{
    private static final RandomGenerator generator = RandomGenerator.getDefault();
    private static int nextId;

    private int id;
    //private String name;
    private double salary;
    private LocalDate hireDay;

    /*
     * Bloque de Inicializacion. Hay tres formas de inicializar un campo de instancia
     * 1. Asigandole un valor en el constructor
     * 2. Asignandole un valor en la declaracion
     * 3. Mediante un bloque de inicializacion
     *
     * Un clase puede tener todos los bloques de inicializacion que necesite. Estos bloques
     * se ejecutan primero cuando un objeto de clase es construido.
     *
     */
//    {
//        id = advancedId(); // inicializacion llamando a un metodo.
//    }

    // bloque de inicializacion static
    static {
        nextId = generator.nextInt(10000);

        ClassLoader loader = Employee.class.getClassLoader();
        InputStream inputStream = loader.getResourceAsStream("app.properties");
        if(inputStream != null){
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
                if(properties.containsKey("MAIN_VERSION")){
                    System.out.println(properties.getProperty("MAIN_VERSION"));
                }
            }
            catch (IOException ex){}
        }

        Class<?> clazz = Employee.class;
        Package pack = clazz.getPackage();
        if (pack != null)
            System.out.println(pack.getImplementationVersion());
    }

    // Constructor con valores por defecto
    public Employee(){
        super("");
        //name = "";
        salary = 0;
        hireDay = LocalDate.now();
    }

    // Metodo static de Fabrica
    public static Employee create(String name, double salary, int year, int month, int day){
        return new Employee(name, salary, year, month, day);
    }

    // Constructor publico
    public Employee(String name, double salary, int year, int month, int day){
        super(Objects.requireNonNull(name, "The name cannot be null"));
        id = advancedId(); // inicializacion llamando a un metodo.
        // evitamos recibir un valor null
        //this.name = Objects.requireNonNull(name, "The name cannot be null");
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public static int advancedId(){
        int r = nextId;
        nextId++;
        return r;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String getDescription(){
        return "an employee with a salary of %,.2f".formatted(salary);
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPercentage){
        double raise = salary * ( byPercentage / 100);
        this.salary += raise;
    }

    /*
     * equals() prueba si dos referencias a objetos son identicas. Hay ocasiones donde se necesita
     * implementar pruebas de igualdad basadas en el estado, en las que dos objetos se consideran
     * iguales cuando tienen el mismo estado.
     */
    @Override
    public boolean equals(Object otherObject){
        // una rapida prueba si los objetos son identicos
        if(this == otherObject) return true;

        // false si el parametro es null
        if(otherObject == null) return false;

        // getClass retorna la clase del objeto. Si las clases no coinciden no pueden ser iguales
        // 2 objetos solo pueden ser iguales cuando pertenecen a la misma clase.
        if(this.getClass() != otherObject.getClass()) return  false;

        // ahora sabemos que otherObject no es un Employee null
        var other = (Employee) otherObject;

        // pruebamos si los campos contienen identicos valores
        return Objects.equals(super.getName(), other.getName()) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    // hashCode safe-null with Objects.hashCode
    @Override
    public int hashCode(){
//        return 7 * Objects.hashCode(this.name) + 11 * Double.hashCode(this.salary) +
//                13 * Objects.hashCode(this.hireDay);
        return Objects.hash(super.getName(), salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[name='" + super.getName() + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay + "]";
    }
    /**
     * Compares employees by salary.
     * @param other another Employee object
     * @return a negative value if first argument (this employee) has a lower salary than second argument
     * (other param), 0 if the salaries are the same, a positive value otherwise
     */
    @Override
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }

    public Employee clone()throws CloneNotSupportedException{
        return (Employee) super.clone();
    }

    public static List<Employee> payroll(){

        return Arrays.asList(
                new Employee("Juan Fernando", 800000, 2020, 10, 11),
                new Employee("Ana Sofía", 750000, 2021, 5, 15),
                new Employee("Carlos Andrés", 920000, 2019, 11, 28),
                new Employee("Laura Camila", 680000, 2022, 3, 10),
                new Employee("Diego Alejandro", 880000, 2020, 7, 22),
                new Employee("Valentina Isabel", 710000, 2023, 1, 5),
                new Employee("Mateo Santiago", 950000, 2018, 9, 18),
                new Employee("Sofía Antonella", 650000, 2024, 4, 1),
                new Employee("Sebastián David", 820000, 2021, 12, 8),
                new Employee("Martina Emilia", 780000, 2019, 6, 20),
                new Employee("Nicolás Benjamín", 910000, 2022, 2, 14),
                new Employee("Emilia Guadalupe", 700000, 2023, 8, 25),
                new Employee("Gabriel Ignacio", 850000, 2020, 1, 30),
                new Employee("Florencia Agustina", 730000, 2024, 5, 7),
                new Employee("Joaquín Salvador", 980000, 2018, 10, 2),
                new Employee("Victoria Montserrat", 670000, 2021, 7, 12),
                new Employee("Benicio Tomás", 890000, 2019, 3, 16),
                new Employee("Catalina Esperanza", 760000, 2022, 9, 29),
                new Employee("Máximo Jerónimo", 930000, 2020, 4, 5),
                new Employee("Renata Paz", 690000, 2023, 11, 19),
                new Employee("Agustín Baltazar", 810000, 2021, 6, 2),
                new Employee("Isabella Trinidad", 790000, 2019, 12, 23),
                new Employee("Santino Uriel", 960000, 2022, 7, 8),
                new Employee("Camila Belén", 660000, 2024, 2, 21),
                new Employee("Thiago Ezequiel", 870000, 2018, 8, 14),
                new Employee("Julieta Pilar", 720000, 2023, 3, 27),
                new Employee("Bautista Gael", 900000, 2020, 9, 1),
                new Employee("Antonella Abril", 740000, 2021, 4, 17),
                new Employee("Lorenzo Valentín", 990000, 2019, 10, 10),
                new Employee("Josefina Candela", 640000, 2022, 1, 24),
                new Employee("Mateo Salvador", 830000, 2023, 12, 3),
                new Employee("Emilia Paz", 770000, 2020, 6, 9),
                new Employee("Benjamín Ignacio", 940000, 2024, 3, 22),
                new Employee("Martina Guadalupe", 705000, 2018, 11, 5),
                new Employee("Lucas Alexander", 860000, 2021, 8, 18),
                new Employee("Sofía Trinidad", 735000, 2019, 5, 30),
                new Employee("Agustín Mateo", 970000, 2022, 10, 13),
                new Employee("Valentina Emilia", 665000, 2023, 4, 26),
                new Employee("Carlos Sebastián", 840000, 2020, 1, 9),
                new Employee("Ana Florencia", 785000, 2024, 6, 21),
                new Employee("Diego Joaquín", 915000, 2018, 9, 4),
                new Employee("Laura Victoria", 695000, 2021, 7, 17),
                new Employee("Nicolás Benicio", 825000, 2019, 3, 1),
                new Employee("Isabella Catalina", 755000, 2022, 8, 24),
                new Employee("Gabriel Máximo", 955000, 2020, 5, 7),
                new Employee("Florencia Renata", 675000, 2023, 12, 11),
                new Employee("Joaquín Agustín", 895000, 2021, 2, 25),
                new Employee("Victoria Isabella", 715000, 2019, 9, 8),
                new Employee("Benicio Carlos", 925000, 2022, 4, 21),
                new Employee("Catalina Ana", 655000, 2024, 1, 4),
                new Employee("Máximo Diego", 805000, 2018, 10, 17)
        );
    }
}
