package proyecto1;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Agenda {

    Scanner readinput = new Scanner(System.in);
    Scanner sn = new Scanner(System.in);
    
    File ficherodeposito = new File("deposito.txt");

    private Contacto[] contactos;

    public Agenda(int tamaño) {

        this.contactos = new Contacto[tamaño];

    }

    public void existearchivo() {

        try {
            if (ficherodeposito.exists()) {
                // System.out.println("El fichero ya existe");
            } else {
                ficherodeposito.createNewFile();
                System.out.println("Fichero creado");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean verificarNombre(String nombre, boolean encontrado) {
        try {

            BufferedReader leer = new BufferedReader(new FileReader("deposito.txt"));
            String linea = "";
            encontrado = false;
            while ((linea = leer.readLine()) != null) {
                if (linea.indexOf(nombre) != -1) {
                    System.out.println("Se encontro el registro");

                    encontrado = true;
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return encontrado;

    }
    
     public boolean verificarTelefono(String telefono, boolean encontrado) {
        try {

            BufferedReader leer = new BufferedReader(new FileReader("deposito.txt"));
            String linea = "";
            encontrado = false;
            while ((linea = leer.readLine()) != null) {
                if (linea.indexOf(telefono) != -1) {
                    System.out.println("Se encontro el registro");

                    encontrado = true;
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return encontrado;

    }

    public void agregarAlArchivoTexto(Contacto c) {
        try {

            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficherodeposito, true)));
            BufferedReader leer = new BufferedReader(new FileReader("deposito.txt"));

            String linea = "";

            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) {

                    if (verificarNombre(contactos[i].getNombre(), false) || verificarTelefono(contactos[i].getTelefono(), false) == true) {
                        i++;

                    }
                    {
                        Fescribe.write(contactos[i].getNombre() + ";" + contactos[i].getTelefono() + ";" + contactos[i].getCorreo() + ";"
                                + contactos[i].getDireccion() + ";" + contactos[i].getAlias() + ";");
                        Fescribe.write("\n");
                    }
                }
            }

            Fescribe.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void añadirContacto(Contacto c) {

        boolean encontrado = false;
        boolean aux = true;

        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equals(c.getNombre())) {
                System.out.println("Ya existe un contacto con ese nombre");

                aux = false;
            }
        }

        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getTelefono().equals(c.getTelefono())) {
                System.out.println("Ya existe un contacto con ese numero");

                aux = false;
            }
        }

        if (aux) {

            for (int i = 0; i < contactos.length && !encontrado; i++) {

                if (contactos[i] == null) {

                    contactos[i] = c;

                    encontrado = true;
                }
            }

            if (encontrado) {
                System.out.println("Se ha agregado");
                System.out.println("");
            } else {
                System.out.println("No se ha agregado");
                System.out.println("");
            }

        } else {

            System.out.println("No se ha agregado");
            System.out.println("");

        }

    }

    public void buscarPorNombre(String nombre) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equals(nombre)) {
                System.out.println("Su Telefono es: " + contactos[i].getTelefono());
                System.out.println("Su Correo es: " + contactos[i].getCorreo());
                System.out.println("Su Direccion es: " + contactos[i].getDireccion());

                System.out.println("Su Alias es: " + contactos[i].getAlias());
                System.out.println("");

            }
        }
        encontrado = true;

        if (!encontrado) {
            System.out.println("No se ah encontrado el contacto");
            System.out.println("");
        }
    }

    public void buscarPorTelefono(String telefono) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getTelefono().equals(telefono)) {
                System.out.println("Su Nombre es: " + contactos[i].getNombre());
                System.out.println("Su Correo es: " + contactos[i].getCorreo());
                System.out.println("Su Direccion es: " + contactos[i].getDireccion());
                System.out.println("Su Alias es: " + contactos[i].getAlias());
                System.out.println("");

            }
        }
        encontrado = true;

        if (!encontrado) {
            System.out.println("No se ah encontrado el contacto");
            System.out.println("");
        }

    }

    public void buscarPorCorreo(String correo) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getCorreo().equals(correo)) {
                System.out.println("Su Nombre es: " + contactos[i].getNombre());
                System.out.println("Su Telefono es: " + contactos[i].getTelefono());
                System.out.println("Su Direccion es: " + contactos[i].getDireccion());
                System.out.println("Su Alias es: " + contactos[i].getAlias());
                System.out.println("");

            }
        }
        encontrado = true;

        if (!encontrado) {
            System.out.println("No se ah encontrado el contacto");
            System.out.println("");
        }

    }

    public void buscarPorDireccion(String direccion) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getDireccion().equals(direccion)) {
                System.out.println("Su Nombre es: " + contactos[i].getNombre());
                System.out.println("Su Telefono es: " + contactos[i].getTelefono());
                System.out.println("Su correo es: " + contactos[i].getCorreo());
                System.out.println("Su Alias es: " + contactos[i].getAlias());
                System.out.println("");

            }
        }
        encontrado = true;

        if (!encontrado) {
            System.out.println("No se ah encontrado el contacto");
            System.out.println("");
        }

    }

    public void buscarPorAlias(String alias) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getAlias().equals(alias)) {
                System.out.println("Su Nombre es: " + contactos[i].getNombre());
                System.out.println("Su Telefono es: " + contactos[i].getTelefono());
                System.out.println("Su Correo es: " + contactos[i].getCorreo());
                System.out.println("Su Direccion es: " + contactos[i].getDireccion());
                System.out.println("");

            }
        }
        encontrado = true;

        if (!encontrado) {
            System.out.println("No se ah encontrado el contacto");
            System.out.println("");
        }

    }

    public void eliminarContacto(Contacto c) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null;
                System.out.println("Contacto eliminado");
                System.out.println("");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha eliminado el contacto");
            System.out.println("");
        }

    }

    public void añadirContactoAux(Contacto c) {

        boolean encontrado = false;
        boolean aux = true;

        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equals(c.getNombre())) {
                System.out.println("Ya existe un contacto con ese nombre");
                System.out.println("");

                aux = false;
            }
        }

        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getTelefono().equals(c.getTelefono())) {
                System.out.println("Ya existe un contacto con ese numero");
                System.out.println("");

                aux = false;
            }
        }

        if (aux) {
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) {
                    contactos[i] = c;
                    encontrado = true;
                }
            }

            if (encontrado) {
                System.out.println("Se ha editado el contacto");
                System.out.println("");
            } else {
                System.out.println("No se ha agregado");
                System.out.println("");
            }

        } else {

            System.out.println("No se ha agregado");
            System.out.println("");

        }

    }

    public void eliminarContactoAux(Contacto c) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null;

                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha eliminado el contacto");
            System.out.println("");
        }

    }

    public void editarContacto(Contacto c) {

        boolean encontrado = false;
        String auxNombre, auxCorreo, auxDireccion, auxAlias, auxTelefono;
       // Long auxTelefono;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equals(c.getNombre())) {

                System.out.println("Ingrese el nuevo nombre");
                auxNombre = readinput.nextLine();

                for (i = 0; auxNombre.equals(""); i++) {

                    System.out.println("Debes agregar un nombre");
                    auxNombre = readinput.nextLine();
                    if (auxNombre == "") {
                        break;
                    }
                }

                System.out.println("Escribe un nuevo telefono");
                auxTelefono = readinput.nextLine();

                for (i = 0; auxTelefono.equals(""); i++) {
                    System.out.println("Debes agregar un telefono");
                    auxTelefono = readinput.nextLine();

                    if (auxTelefono == "") {

                        break;
                    }
                }

                //auxTelefono = Long.parseLong(tel);

                System.out.println("Ingrese el nuevo correo");
                auxCorreo = readinput.nextLine();

                System.out.println("Ingrese la nueva direccion");
                auxDireccion = readinput.nextLine();

                System.out.println("Ingrese el nuevo alias");
                auxAlias = readinput.nextLine();
                System.out.println("");

                eliminarContactoAux(c);
                c = new Contacto(auxNombre, auxTelefono, auxCorreo, auxDireccion, auxAlias);
                añadirContactoAux(c);

                break;
            }

        }
        encontrado = true;

        if (!encontrado) {
            System.out.println("No se ah encontrado el contacto");
            System.out.println("");
        }

    }

}
