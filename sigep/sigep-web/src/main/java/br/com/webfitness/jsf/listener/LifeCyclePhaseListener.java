/**
 * Desenvolvido por Everton 12/05/2016
 */
package br.com.webfitness.jsf.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 * @author Everton
 * Data: 12/05/2016
 */
public class LifeCyclePhaseListener implements PhaseListener {
	private static final long serialVersionUID = 8076040788756476570L;

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
	 */
	@Override
	public void afterPhase(PhaseEvent fase) {
		System.out.println("Finalizou a fase: "+fase.getPhaseId());

	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 */
	@Override
	public void beforePhase(PhaseEvent fase) {
		System.out.println("Vai iniciar a fase: "+fase.getPhaseId());
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
