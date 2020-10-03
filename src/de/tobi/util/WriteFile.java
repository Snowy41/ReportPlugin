package de.tobi.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    private String path;
    private boolean append_to_file = true;


    public WriteFile(String file_path, boolean append_value){
        append_to_file = append_value;
        path = file_path;
    }

    public void writeToFile(String textLine) throws IOException {

        FileWriter write = new FileWriter(path , append_to_file);
        PrintWriter print_line = new PrintWriter( write );
        print_line.print(textLine);
        print_line.close();


    }





    }
