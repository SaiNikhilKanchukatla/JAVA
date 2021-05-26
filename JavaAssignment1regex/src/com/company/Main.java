package com.company;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main  {

    public static void main(String[] args) throws IOException {
        Path startDir = Paths.get("/home/saink");
        String pattern = "*.{txt,doc}";
        FileSystem fs = FileSystems.getDefault();
        System.out.println(fs);
        final PathMatcher matcher = fs.getPathMatcher("glob:" + pattern);
        FileVisitor<Path> matcherVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attribs) {
                Path name = file.getFileName();
                if (matcher.matches(name)) {
                    System.out.print(String.format("Found matched file: '%s'.%n", file));
                }
                return FileVisitResult.CONTINUE;
            }
        };
        Files.walkFileTree(startDir, matcherVisitor);
    }

}
