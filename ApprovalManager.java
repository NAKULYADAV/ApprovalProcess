package approvalProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ApprovalManager
{
	/* manages the approval process by taking request and hierarchy as input */
	private TraderRequest request;

	private HashMap<Integer, ArrayList<AbstractApprover>> hierarchy;

	ApprovalManager(TraderRequest request, HashMap<Integer, ArrayList<AbstractApprover>> hierarchy)
	{
		this.request = request;
		this.hierarchy = hierarchy;
	}

	public TraderRequest getRequest()
	{
		return request;
	}

	public void setRequest(TraderRequest request)
	{
		this.request = request;
	}

	public HashMap<Integer, ArrayList<AbstractApprover>> getHierarchy()
	{
		return hierarchy;
	}

	public void setHierarchy(HashMap<Integer, ArrayList<AbstractApprover>> hierarchy)
	{
		this.hierarchy = hierarchy;
	}

	public void getRequestProcessed()
	{
		ExecutorService threadService = Executors.newFixedThreadPool(5);
		Integer limit = hierarchy.size();
		Boolean result = true;
		for (int i = 1; i <= limit; i++)
		{
			ArrayList<AbstractApprover> level = hierarchy.get(i);
			List<Future<Boolean>> futureObject = new ArrayList<Future<Boolean>>();
			for (AbstractApprover node : level)
			{
				futureObject.add(threadService.submit(new ApprovalProcessingThread(request, node)));
			}
			for (Future<Boolean> approved : futureObject)
			{
				try
				{
					result = result && approved.get();

				} catch (InterruptedException e)
				{
					e.printStackTrace();
				} catch (ExecutionException e)
				{
					e.printStackTrace();
				}
			}
			if (!result)
			{
				request.setFundApproved(false);
				break;
			}

		}
		threadService.shutdown();
		if (result)
		{
			request.setFundApproved(true);
			request.setFundRecevied(request.getFundRequired());
			request.setStatus("Approved");
		}
	}
}
