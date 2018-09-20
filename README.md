# ApprovalProcess
Trading Request Approval PRocess

The driver class is WorkFlowDriver

In WorkFlowDriver we instantiate the the Request(TraderRequest) class and Approver classes(ResearchAnalyst,FundManager,DivisionHead,OperationsHead) 

and we create the hierarchy for the parallel execution of the process, we have a hashmap which contains priority or level of ececution for the request.

it is assumed that all Approver will approve the request.

AbstractApprover contains the default properties for the approver.

ApprovalManager performs the process using the ApprovalProcessingThread using ExecutorService and it takes request and configurale rule(hashMap) as input
