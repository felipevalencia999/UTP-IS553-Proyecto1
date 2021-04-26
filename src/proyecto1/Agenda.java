package proyecto1;

import java.util.Scanner;
import java.io.*;

public class Agenda {

    Scanner readinput = new Scanner(System.in);
    Scanner sn = new Scanner(System.in);

    File ficherodeposito = new File("agenda.txt");

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

            BufferedReader leer = new BufferedReader(new FileReader("agenda.txt"));
            String linea = "";
            encontrado = false;
            while ((linea = leer.readLine()) != null) {
                if (linea.indexOf(nombre) != -1) {
                    //System.out.println("Se encontro el registro");

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

            BufferedReader leer = new BufferedReader(new FileReader("agenda.txt"));
            String linea = "";
            encontrado = false;
            while ((linea = leer.readLine()) != null) {
                if (linea.indexOf(telefono) != -1) {
                    //System.out.println("Se encontro el registro");

                    encontrado = true;
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return encontrado;

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
                    agregarAlArchivoTexto(c);
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
                System.out.println("El lugar donde lo conocio es: " + contactos[i].getLugar());
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
                System.out.println("El lugar donde lo conocio es: "+contactos[i].getLugar());
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
                System.out.println("El lugar donde lo conocio es: "+contactos[i].getLugar());
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
                System.out.println("El lugar donde lo conocio es: "+contactos[i].getLugar());
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
                System.out.println("El lugar donde lo conocio es: "+contactos[i].getLugar());
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
                eliminarArchivoTexto();
                llenarArchivoTexto(c);
                System.out.println("");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se ha eliminado el contacto");
            System.out.println("");
        }

    }

    public void añadirContactoEditado(Contacto c) {

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
                    agregarAlArchivoTexto(c);
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
        String auxNombre, auxCorreo, auxDireccion, auxAlias, auxTelefono, auxLugar;

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

                System.out.println("Ingrese el nuevo correo");
                auxCorreo = readinput.nextLine();

                System.out.println("Ingrese la nueva direccion");
                auxDireccion = readinput.nextLine();

                System.out.println("Ingrese el nuevo alias");
                auxAlias = readinput.nextLine();
                
                System.out.println("Escribe un nuevo lugar");
                auxLugar = readinput.nextLine();
                for (i = 0; auxLugar.equals(""); i++) {
                    System.out.println("Debes agregar un lugar");
                    auxLugar = readinput.nextLine();

                    if (auxLugar == "") {

                        break;
                    }
                }
                
                System.out.println("");

                eliminarContactoAux(c);

                c = new Contacto(auxNombre, auxTelefono, auxCorreo, auxDireccion, auxAlias, auxLugar);
                añadirContactoEditado(c);
                eliminarArchivoTexto();
                llenarArchivoTexto(c);
                break;
            }

        }
        encontrado = true;

        if (!encontrado) {
            System.out.println("No se ah encontrado el contacto");
            System.out.println("");
        }

    }

    public void leerTexto() {
        try {

            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficherodeposito, true)));
            BufferedReader leer = new BufferedReader(new FileReader("agenda.txt"));

            String linea = "";
            while ((linea = leer.readLine()) != null) {

                String[] contacto = linea.split(";");
                Contacto c = new Contacto(contacto[0], contacto[1], contacto[2], contacto[3], contacto[4], contacto [5]);
                añadirContacto2(c);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregarAlArchivoTexto(Contacto c) {
        try {

            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficherodeposito, true)));
            BufferedReader leer = new BufferedReader(new FileReader("agenda.txt"));

            if (c != null) {

                if (verificarNombre(c.getNombre(), false) || verificarTelefono(c.getTelefono(), false) == true) {

                }
                {
                    Fescribe.write(c.getNombre() + ";" + c.getTelefono() + ";" + c.getCorreo() + ";"
                            + c.getDireccion() + ";" + c.getAlias() + ";" + c.getLugar() + ";");
                    Fescribe.write("\n");
                }
            }

            Fescribe.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void añadirContacto2(Contacto c) {

        boolean encontrado = false;
        boolean aux = true;

        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equals(c.getNombre())) {

                aux = false;
            }
        }

        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getTelefono().equals(c.getTelefono())) {

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

        }
    }

    public void eliminarArchivoTexto() {

        try {
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficherodeposito, false)));
            Fescribe.write("");
            Fescribe.close();

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void llenarArchivoTexto(Contacto c) {

        for (int i = 0; i < contactos.length; i++) {

            if (contactos[i] != null) {

                c = contactos[i];
                agregarAlArchivoTexto(c);

            }
        }

    }

    public void importarContactos() {

        String direccion = "agendaImportar.txt";

        try {

            BufferedReader leer = new BufferedReader(new FileReader(direccion));

            String linea = "";
            while ((linea = leer.readLine()) != null) {

                String[] contacto = linea.split(";");
                Contacto c = new Contacto(contacto[0], contacto[1], contacto[2], contacto[3], contacto[4], contacto [5]);
                if (verificarNombre(contacto[0], false) == false && verificarTelefono(contacto[1], false) == false) {

                    agregarAlArchivoTexto(c);
                    añadirContacto2(c);
                    System.out.println("Contacto importado");

                } else {
                    System.out.println("El contacto no se importo por nombre o numero de telefono repetido");
                }

            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    

}
