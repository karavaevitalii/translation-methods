package ru.ifmo.ctddev.karavaev.translations.generator.impl;

import ru.ifmo.ctddev.karavaev.translations.generator.Generator;
import ru.ifmo.ctddev.karavaev.translations.generator.impl.utils.GeneratorContext;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TokensGenerator extends GeneratorBase implements Generator {
    public TokensGenerator(final File grammarFile) throws IOException {
        super(grammarFile);
    }

    @Override
    public File generate() throws IOException {
        final String className = grammarName + TOKENS;
        final String fileName = className + EXTENSION;

        File file = new File(outputDirName + File.separator + fileName);
        try(PrintWriter pw = new PrintWriter(file)) {
            GeneratorContext context = new GeneratorContext(pw);

            if (!listener.getPckg().isEmpty())
                context.printPackage(listener.getPckg());
            if (!listener.getImports().isEmpty())
                context.printImport(listener.getImports());

            context.printClassBegin(GeneratorContext.Modifier.PUBLIC,
                    GeneratorContext.ClassType.ENUM, className);
            context.printEnumFields(new ArrayList<>(listener.getTerminals().keySet()));
            context.printClassEnd();
            return file;
        }
    }
}
