package approvalProcess;

import java.util.HashMap;

public class TraderRequest
{
	/* Class contains request details */
	private String traderName;

	private String requestName;

	private volatile Boolean fundApproved;

	private Integer fundRecevied;

	private Integer fundRequired;

	private String status;

	private HashMap<String, Object> proValues;

	TraderRequest(String traderName, String requestName, Integer fundRequired)
	{
		this(traderName, requestName, fundRequired, "Processing", new HashMap<String, Object>());
	}

	TraderRequest(String traderName, String requestName, Integer fundRequired, String status,
			HashMap<String, Object> proValues)
	{
		this.traderName = traderName;
		this.requestName = requestName;
		this.fundRequired = fundRequired;
		this.status = status;
		this.proValues = proValues;
	}

	public String getTraderName()
	{
		return traderName;
	}

	public void setTraderName(String traderName)
	{
		this.traderName = traderName;
	}

	public String getRequestName()
	{
		return requestName;
	}

	public void setRequestName(String requestName)
	{
		this.requestName = requestName;
	}

	public Boolean getFundApproved()
	{
		return fundApproved;
	}

	public void setFundApproved(Boolean fundApproved)
	{
		this.fundApproved = fundApproved;
	}

	public Integer getFundRecevied()
	{
		return fundRecevied;
	}

	public void setFundRecevied(Integer fundRecevied)
	{
		this.fundRecevied = fundRecevied;
	}

	public Integer getFundRequired()
	{
		return fundRequired;
	}

	public void setFundRequired(Integer fundRequired)
	{
		this.fundRequired = fundRequired;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public HashMap<String, Object> getProValues()
	{
		return proValues;
	}

	public void setProValues(HashMap<String, Object> proValues)
	{
		this.proValues = proValues;
	}

}
