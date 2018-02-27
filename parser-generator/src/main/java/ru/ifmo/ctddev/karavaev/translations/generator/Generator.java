package ru.ifmo.ctddev.karavaev.translations.generator;

import java.io.File;
import java.io.IOException;

public interface Generator {
    File generate() throws IOException;
}
