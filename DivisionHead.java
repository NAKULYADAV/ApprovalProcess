package approvalProcess;

import java.util.HashMap;

public class DivisionHead extends AbstractApprover
{
	/* Class Contains DivisionHead details */
	private HashMap<String, Object> designationSpecificRequirements;

	DivisionHead(String approverName, String designation)
	{
		this(approverName, designation, new HashMap<String, Object>());
	}

	DivisionHead(String approverName, String designation, HashMap<String, Object> designationSpecificRequirements)
	{
		init(approverName, designation);
		this.designationSpecificRequirements = designationSpecificRequirements;

	}

	public HashMap<String, Object> getDesignationSpecificRequirements()
	{
		return designationSpecificRequirements;
	}

	public void setDesignationSpecificRequirements(HashMap<String, Object> designationSpecificRequirements)
	{
		this.designationSpecificRequirements = designationSpecificRequirements;
	}

	@Override
	public Boolean processApproval(TraderRequest request)
	{
		Boolean approved = Boolean.TRUE;
		if (approved)
		{
			System.out.println(approverName + " Approved the request");
		} else
		{
			System.out.println(approverName + " Disapproved the request");
		}
		return approved;
	}

}
