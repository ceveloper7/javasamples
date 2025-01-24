package com.ceva.ch02.zip;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTest {

    public static void showContents(String zipname) throws IOException
    {
        // Here, we use the classic zip API.
        try (var zin = new ZipInputStream(new FileInputStream(zipname)))
        {
            boolean done = false;
            while (!done)
            {
                ZipEntry entry = zin.getNextEntry();
                if (entry == null)
                    done = true;
                else
                {
                    // leemos el contenido del archivo zip
                    System.out.println(entry.getName());
                    var in = new Scanner(zin);
                    while (in.hasNextLine())
                        System.out.println("   " + in.nextLine());
                    // DO NOT CLOSE zin
                    zin.closeEntry();
                }
            }
        }
    }

    public static void showContents2(String zipname) throws IOException
    {
        FileSystem fs = FileSystems.newFileSystem(Path.of(zipname));
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<>()
        {
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException
            {
                System.out.println(path);
                for (String line : Files.readAllLines(path))
                    System.out.println("   " + line);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException{
        String zipname = args[0];
        showContents(zipname);
        System.out.println("---");
        showContents2(zipname);
    }
}
