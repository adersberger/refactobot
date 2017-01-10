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
import spoon.reflect.reference.CtTypeReference;

/**
 * TODO: comment
 *
 * @author a.zitzelsberger
 */
public class RenameTypeRefProcessor extends AbstractProcessor<CtTypeReference<?>> {

    @Override
    public boolean isToBeProcessed(CtTypeReference<?> candidate) {
        return candidate.getQualifiedName().equals("com.zacharyfox.rmonitor.entities.Competitor");
    }

    @Override
    public void process(CtTypeReference<?> element) {
        element.setSimpleName("Archenemy");
    }
}
