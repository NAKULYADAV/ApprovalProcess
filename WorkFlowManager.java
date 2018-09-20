package approvalProcess;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkFlowManager
{
	private TraderRequest request;

	private ResearchAnalyst researchAnalyst;

	private FundManager fundManager;

	private DivisionHead divisionHead;

	private OperationsHead operationsHead;

	private HashMap<Integer, ArrayList<AbstractApprover>> hierarchy;

	public TraderRequest getRequest()
	{
		return request;
	}

	public void setRequest(TraderRequest request)
	{
		this.request = request;
	}

	public ResearchAnalyst getResearchAnalyst()
	{
		return researchAnalyst;
	}

	public void setResearchAnalyst(ResearchAnalyst researchAnalyst)
	{
		this.researchAnalyst = researchAnalyst;
	}

	public FundManager getFundManager()
	{
		return fundManager;
	}

	public void setFundManager(FundManager fundManager)
	{
		this.fundManager = fundManager;
	}

	public DivisionHead getDivisionHead()
	{
		return divisionHead;
	}

	public void setDivisionHead(DivisionHead divisionHead)
	{
		this.divisionHead = divisionHead;
	}

	public OperationsHead getOperationsHead()
	{
		return operationsHead;
	}

	public void setOperationsHead(OperationsHead operationsHead)
	{
		this.operationsHead = operationsHead;
	}

	public HashMap<Integer, ArrayList<AbstractApprover>> getHierarchy()
	{
		return hierarchy;
	}

	public void setHierarchy(HashMap<Integer, ArrayList<AbstractApprover>> hierarchy)
	{
		this.hierarchy = hierarchy;
	}

	public Boolean process()
	{
		if (hierarchy == null || request == null)
		{
			return Boolean.FALSE;
		}

		// processing request
		ApprovalManager manager = new ApprovalManager(request, hierarchy);

		manager.getRequestProcessed();

		if (request.getFundApproved())
		{
			System.out.println("Request Approved");
		} else
		{
			System.out.println("Request Disapproved");
		}

		return request.getFundApproved();

	}

	public void createHierarchy()
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
