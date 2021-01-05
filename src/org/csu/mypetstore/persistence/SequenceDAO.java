package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Sequence;

public interface SequenceDAO {
    Sequence getSequence(Sequence sequence) throws Exception;
    void updateSequence(Sequence sequence) throws Exception;
}
