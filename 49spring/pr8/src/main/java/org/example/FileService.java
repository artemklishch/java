package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Scope(scopeName = "prototype")
public class FileService {
    private File file;

    public FileService(File file) {
        this.file = file;
    }

    private void write(String content) {
    }

    private String read() {
        return "";
    }
}
