/*
 * ______________________________________________________________________________
 *
 *      Project: BMW APRIL
 * ______________________________________________________________________________
 *
 *      created by:    a.zitzelsberger
 *      creation date: 2017-01-10
 *      changed by:    $Author$
 *      change date:   $Date$
 *      revision:      $Revision$
 * ______________________________________________________________________________
 *
 *      Copyright: BMW AG
 * ______________________________________________________________________________
 */
package de.qaware.refactobot;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtType;

/**
 * TODO: comment
 *
 * @author a.zitzelsberger
 */
public class RenameTypeProcessor extends AbstractProcessor<CtType<?>> {
    @Override
    public boolean isToBeProcessed(CtType<?> candidate) {
        return candidate.getQualifiedName().equals("com.zacharyfox.rmonitor.entities.Competitor");
    }

    @Override
    public void process(CtType<?> element) {
        element.setSimpleName("Archenemy");
    }
}
