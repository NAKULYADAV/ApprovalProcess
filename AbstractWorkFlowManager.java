package approvalProcess;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractWorkFlowManager
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
		return startProcess();
	}

	private Boolean startProcess()
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

	public abstract void createHierarchy();

}
