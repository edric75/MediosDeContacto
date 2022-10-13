package mx.gob.sat.sicre.web.utils;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LifeCycleListener implements PhaseListener {

    private static final long serialVersionUID = 1L;

    public LifeCycleListener() {
    	 // Do nothing because of X and Y.
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        event.getPhaseId();
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        event.getPhaseId();

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
