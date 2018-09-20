package approvalProcess;

import java.util.concurrent.Callable;

public class ApprovalProcessingThread implements Callable<Boolean>
{
	/* Class executes a thread */
	private TraderRequest request;

	private AbstractApprover levelNode;

	ApprovalProcessingThread(TraderRequest request, AbstractApprover levelNode)
	{
		this.request = request;
		this.levelNode = levelNode;
	}

	@Override
	public Boolean call() throws Exception
	{
		// System.out.println("Request Processed by "+ levelNode.getApproverName());
		return levelNode.processApproval(request);
	}

}
