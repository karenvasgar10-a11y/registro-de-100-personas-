import java.util.Scanner;

public class Persona {
    // 1. Atributos privados (Encapsulamiento) [cite: 36, 37]
    private String nombre;
    private int edad;
    private int documento;
    private char sexo;
    private float sueldo;

    // 2. Constructor [cite: 38]
    public Persona(String nombre, int edad, int documento, char sexo, float sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.sexo = sexo;
        this.sueldo = sueldo;
    }

    // 3. Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getDocumento() { return documento; }
    public void setDocumento(int documento) { this.documento = documento; }
    // (Puedes agregar los demás getters/setters si los necesitas)

    @Override
    public String toString() {
        return "ID: " + documento + " | Nombre: " + nombre + " | Edad: " + edad + " | Sexo: " + sexo + " | Sueldo: " + sueldo;
    }

    // --- LÓGICA DEL PROGRAMA (EL MÉTODO MAIN) --- [cite: 30, 31]
    
    private static Persona[] lista = new Persona[100]; // Arreglo de 100 [cite: 17, 34]
    private static int total = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Registrar");
            System.out.println("2. Ver lista");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Salir");
            System.out.print("Seleccione: ");
            op = sc.nextInt();
            sc.nextLine(); 

            if (op == 1) registrar();
            else if (op == 2) listar();
            else if (op == 3) buscar();

        } while (op != 4);
    }

    private static void registrar() {
        if (total < 100) {
            System.out.print("Nombre: "); String n = sc.nextLine();
            System.out.print("Edad: "); int e = sc.nextInt();
            System.out.print("Documento: "); int d = sc.nextInt();
            System.out.print("Sexo (M/F): "); char s = sc.next().charAt(0);
            System.out.print("Sueldo: "); float su = sc.nextFloat();
            
            lista[total] = new Persona(n, e, d, s, su);
            total++;
            System.out.println("Guardado.");
        }
    }

    private static void listar() {
        for (int i = 0; i < total; i++) {
            System.out.println(lista[i]);
        }
    }

    private static void buscar() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        for (int i = 0; i < total; i++) {
            if (lista[i].getDocumento() == id) {
                System.out.println("Encontrado: " + lista[i]);
                return;
            }
        }
        System.out.println("No encontrado.");
    }
}