package proyecto1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        Scanner readinput = new Scanner(System.in);
        
        Agenda agendaTelefonica = new Agenda(100);
        Agenda objeto1 = new Agenda(100);

        String nombre;
        String telefono;
        String correo;
        String direccion;
        String alias;
        Contacto c;

        while (!salir) {

            objeto1.existearchivo();
            System.out.println("1-Añadir contacto");
            System.out.println("2-Eliminar contacto");
            System.out.println("3-Buscar contacto por nombre");
            System.out.println("4-Buscar contacto por telefono");
            System.out.println("5-Buscar contacto por correo");
            System.out.println("6-Buscar contacto por direccion");
            System.out.println("7-Buscar contacto por alias");
            System.out.println("8-Editar contacto");
            System.out.println("9-Agregar contactos al archivo de texto");
            System.out.println("10-Salir");
            System.out.println("");
            System.out.println("Ingresa una opcion");
            opcion = sn.nextInt();
            System.out.println("");

            switch (opcion) {

                case 1:

                    System.out.println("Escribe un nombre");
                    nombre = readinput.nextLine();
                    if (nombre.equals("")) {
                        for (int i = 0; nombre.equals(""); i++) {
                            System.out.println("Debes agregar un nombre");
                            nombre = readinput.nextLine();
                        }
                    }

                    System.out.println("Escribe un telefono");
                    telefono = readinput.nextLine();
                    if (telefono.equals("")) {
                        for (int i = 0; telefono.equals(""); i++) {
                            System.out.println("Debes agregar un telefono");
                            telefono = readinput.nextLine();
                        }
                    }
                    // telefono = Long.parseLong(tel);

                    System.out.println("Escribe un correo");
                    correo = readinput.nextLine();

                    System.out.println("Direccion");
                    direccion = readinput.nextLine();

                    System.out.println("Escribe un alias");
                    alias = readinput.nextLine();

                    c = new Contacto(nombre, telefono, correo, direccion, alias);
                    agendaTelefonica.añadirContacto(c);

                    break;

                case 2:

                    System.out.println("Escribe nombre de contacto a eliminar");
                    nombre = readinput.nextLine();

                    c = new Contacto(nombre, "", "", "", "");
                    agendaTelefonica.eliminarContacto(c);

                    break;

                case 3:

                    System.out.println("Escribe un nombre");
                    nombre = readinput.nextLine();

                    agendaTelefonica.buscarPorNombre(nombre);

                    break;

                case 4:

                    System.out.println("Escribe un telefono");
                    telefono = readinput.nextLine();

                    agendaTelefonica.buscarPorTelefono(telefono);

                    break;

                case 5:

                    System.out.println("Escribe un correo");
                    correo = readinput.nextLine();

                    agendaTelefonica.buscarPorCorreo(correo);

                    break;

                case 6:

                    System.out.println("Escribe la direccion");
                    direccion = readinput.nextLine();

                    agendaTelefonica.buscarPorDireccion(direccion);

                    break;

                case 7:

                    System.out.println("Escribe el alias");
                    alias = readinput.nextLine();

                    agendaTelefonica.buscarPorAlias(alias);

                    break;

                case 8:

                    System.out.println("Escriba el nombre del contacto a editar");
                    nombre = readinput.nextLine();

                    c = new Contacto(nombre, "", "", "", "");
                    agendaTelefonica.editarContacto(c);

                    break;

                case 9:
                    c = new Contacto("", "", "", "", "");
                    agendaTelefonica.agregarAlArchivoTexto(c);

                    break;

                case 10:

                    salir = true;

                    break;

                default:
                    System.out.println("Solo numeros del 1 al 10");

            }

        }

    }

}
