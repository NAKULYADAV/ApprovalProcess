package approvalProcess;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkFlowManager extends AbstractWorkFlowManager
{

	@Override
	public void createHierarchy()
	{
		HashMap<Integer, ArrayList<AbstractApprover>> hierarchy = new HashMap<Integer, ArrayList<AbstractApprover>>();

		ArrayList<AbstractApprover> approverlevel1 = new ArrayList<AbstractApprover>();
		approverlevel1.add(getResearchAnalyst());
		approverlevel1.add(getFundManager());
		hierarchy.put(1, approverlevel1);

		ArrayList<AbstractApprover> approverlevel2 = new ArrayList<AbstractApprover>();
		approverlevel2.add(getDivisionHead());
		hierarchy.put(2, approverlevel2);

		ArrayList<AbstractApprover> approverlevel3 = new ArrayList<AbstractApprover>();
		approverlevel3.add(getOperationsHead());
		hierarchy.put(3, approverlevel3);

		setHierarchy(hierarchy);
	}

}
