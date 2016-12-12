package de.qaware.refactobot;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtParameter;

/**
 * Adds not null check to every Object parameter.
 *
 * from:
 * https://github.com/SpoonLabs/spoon-examples/blob/master/src/main/java/fr/inria/gforge/spoon/transformation/NotNullCheckAdderProcessor.java
 */
public class NotNullCheckAdderProcessor extends AbstractProcessor<CtParameter<?>> {

    @Override
    public boolean isToBeProcessed(CtParameter<?> element) {
        return !element.getType().isPrimitive();// only for objects
    }

    public void process(CtParameter<?> element) {
        // we declare a new snippet of code to be inserted.
        CtCodeSnippetStatement snippet = getFactory().Core().createCodeSnippetStatement();

        // this snippet contains an if check.
        final String value = String.format("if (%s == null) "
                        + "throw new IllegalArgumentException(\"[Spoon inserted check] null passed as parameter\")",
                element.getSimpleName());
        snippet.setValue(value);

        // we insert the snippet at the beginning of the method body.
        if (element.getParent(CtExecutable.class).getBody() != null) {
            element.getParent(CtExecutable.class).getBody().insertBegin(snippet);
        }
    }
}
