package approvalProcess;

public class TestDriver
{
	public static void main(String[] args)
	{
		WorkFlowManager workFlowManager = new WorkFlowManager();

		workFlowManager.setRequest(new TraderRequest("testUser", "testing", 100000));

		workFlowManager.setResearchAnalyst(new ResearchAnalyst("researchHeadName", "researchAnalyst"));

		workFlowManager.setFundManager(new FundManager("fundManagerName", "fundManager"));

		workFlowManager.setDivisionHead(new DivisionHead("divisionHeadName", "divisionHead"));

		workFlowManager.setOperationsHead(new OperationsHead("operationsHeadName", "operationsHead"));

		/*
		 * create hierarchy or set your own using
		 * workFlowManager.setHierarchy(hierarchy);
		 */
		workFlowManager.createHierarchy();
		
		workFlowManager.process();
	}
}
