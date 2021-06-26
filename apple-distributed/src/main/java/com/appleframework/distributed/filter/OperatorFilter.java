package com.appleframework.distributed.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.distributed.context.DistributedOperatorContext;
import com.appleframework.model.Operator;

@Activate
public class OperatorFilter implements Filter {
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		if(RpcContext.getContext().isConsumerSide()) {
			Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
			if (null != operator) {
				DistributedOperatorContext.getInstance().setOperator(operator);
			}
		}
		else if(RpcContext.getContext().isProviderSide()) {
			Operator operator = DistributedOperatorContext.getInstance().getOperator();
			if (null != operator) {
				ThreadLocalOperatorContext.getInstance().setOperator(operator);
			}
		}
		else {
			
		}
		return invoker.invoke(invocation);
	}
}
