/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-5
 */
package com.appleframework.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 徐少敏
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class TimeoutException extends AppleException {

	private static final long serialVersionUID = -4131567927036108840L;

    private static final String SERVICE_TIMEOUT = "-timeout";

    public TimeoutException() {
    }

    public TimeoutException(Class<?> clazz) {
		super(SERVICE_TIMEOUT);
		this.clazz = getInterfaceName(clazz);
	}
	
	public TimeoutException(Throwable throwable) {
		super(SERVICE_TIMEOUT, throwable);
	}

	public TimeoutException(Class<?> clazz, Throwable throwable) {
		super(SERVICE_TIMEOUT, throwable);
		this.clazz = getInterfaceName(clazz);
	}

	public TimeoutException(Class<?> clazz, Throwable throwable, Object... params) {
		super(SERVICE_TIMEOUT, throwable);
		this.clazz = getInterfaceName(clazz);
		this.params = params;
	}
}
