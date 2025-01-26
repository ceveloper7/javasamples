package com.ceva.ch02.textFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAndPaths {


    public static void main(String[] args) {
        String baseDir = System.getProperty("user.home");
        Path basePath = Path.of(baseDir);
        System.out.println(basePath.toString());

        Path workRelative = Path.of("local-projects");
        Path workPath = basePath.resolve(workRelative);
        System.out.println(workPath.toString());

        Path repoPath = workPath.resolveSibling("local-repos");
        System.out.println(repoPath.toString());

        System.out.println(basePath.toAbsolutePath());

    }
}
