package approvalProcess;

import java.util.HashMap;

public abstract class AbstractApprover
{
	/* class contains default approver details */
	protected String approverName;

	protected String designation;

	protected HashMap<String, Object> mandatoryRequirements;

	public String getApproverName()
	{
		return approverName;
	}

	public void setApproverName(String approverName)
	{
		this.approverName = approverName;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public HashMap<String, Object> getMandatoryRequirements()
	{
		return mandatoryRequirements;
	}

	public void setMandatoryRequirements(HashMap<String, Object> mandatoryRequirements)
	{
		this.mandatoryRequirements = mandatoryRequirements;
	}

	public void init(String approverName, String designation)
	{
		this.approverName = approverName;
		this.designation = designation;
		mandatoryRequirements = new HashMap<String, Object>();
		mandatoryRequirements.put("FundFor", "trade");

	}

	// actual processing for approval happens here
	public abstract Boolean processApproval(TraderRequest request);

}
