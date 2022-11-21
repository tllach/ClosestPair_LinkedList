package com.tabata.File_Management;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Algoritmos Y Complejidad                                 18/11/22
 * Tabata Llach Bruges
 *
 * Class:
 *     Class made for the file management
 */

public final class File_Manager {

    private final String filename;
    private PrintWriter out;

    public File_Manager(String filename){
        this.filename = filename;
        create(filename);
    }

    /**
     * Funcion para crear un archivo
     * @param fname nombre del archivo
     */
    private void create(String fname) {
        // creates a file with given name `filename'

        try {
            // creates a new File object
            File f = new File(fname);

            // creates the new file
            String msg = "creating file `" + fname + "' ... ";
            System.out.println();
            System.out.printf("%s", msg);
            f.createNewFile();
            System.out.println("done");

        } catch (IOException err) {
            // complains if there is an Input/Output Error
            System.out.println("IO Error:");
            err.printStackTrace();
        }

        return;
    }

    public void openWriter() throws FileNotFoundException {
        out = new PrintWriter(filename);
    }

    public void write(String line){
        System.out.println(line);
        out.println(line);
    }

    public void closeWriter() throws FileNotFoundException{
        out.close();
    }
}
