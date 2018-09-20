package approvalProcess;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkFlowDriver
{
	private TraderRequest request;

	private ResearchAnalyst researchAnalyst;

	private FundManager fundManager;

	private DivisionHead divisionHead;

	private OperationsHead operationsHead;

	private HashMap<Integer, ArrayList<AbstractApprover>> hierarchy;

	public static void main(String[] args)
	{
		/* creating the request and Approver objects */
		WorkFlowDriver workFlowManager = new WorkFlowDriver();

		workFlowManager.request = new TraderRequest("testUser", "testing", 100000);

		workFlowManager.researchAnalyst = new ResearchAnalyst("researchHeadName", "researchAnalyst");

		workFlowManager.fundManager = new FundManager("fundManagerName", "fundManager");

		workFlowManager.divisionHead = new DivisionHead("divisionHeadName", "divisionHead");

		workFlowManager.operationsHead = new OperationsHead("operationsHeadName", "operationsHead");

		// create the levels so that those can be parallelized
		workFlowManager.createHierarchy();

		// processing request
		ApprovalManager manager = new ApprovalManager(workFlowManager.request, workFlowManager.hierarchy);

		manager.getRequestProcessed();

		if (workFlowManager.request.getFundApproved())
		{
			System.out.println("Request Approved");
		} else
		{
			System.out.println("Request Disapproved");
		}

	}

	private void createHierarchy()
	{
		hierarchy = new HashMap<Integer, ArrayList<AbstractApprover>>();

		ArrayList<AbstractApprover> approverlevel1 = new ArrayList<AbstractApprover>();
		approverlevel1.add(researchAnalyst);
		approverlevel1.add(fundManager);
		hierarchy.put(1, approverlevel1);

		ArrayList<AbstractApprover> approverlevel2 = new ArrayList<AbstractApprover>();
		approverlevel2.add(divisionHead);
		hierarchy.put(2, approverlevel2);

		ArrayList<AbstractApprover> approverlevel3 = new ArrayList<AbstractApprover>();
		approverlevel3.add(operationsHead);
		hierarchy.put(3, approverlevel3);
	}

}
