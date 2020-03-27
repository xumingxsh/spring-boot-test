package hi.xmr.springboot.model;

/**
 * @brief HTTP请求的返回对象类，一般用于RESTful接口
 * @author xuminrong
 *
 * @param <T> 成功后返回的对象类型， 该类型要可以转换为JSON对象
 */
public class HiHttpResult {
	public final static int SUCCESS = 200;
	public final static int SYSTEM_EXCEPTION = 500;
	public final static int USER_EXCEPTION = 503;

	public static <T> HiHttpResult onSuccess(T val) {
		HiHttpResult ret = new HiHttpResult();
		ret.setStatus(SUCCESS);
		ret.setData(val);
		ret.setMesssage("");
		return ret;
	}

	public static HiHttpResult onException(Exception ex) {
		return onException(ex, true);
	}

	public static HiHttpResult onException(Exception ex, boolean isWant) {
		HiHttpResult ret = new HiHttpResult();
		if (isWant) {
			ret.setStatus(USER_EXCEPTION);
		} else {
			ret.setStatus(SYSTEM_EXCEPTION);
		}
		ret.setData(null);
		if (ex != null) {
			ret.setMesssage(ex.getMessage());
		}
		return ret;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMesssage() {
		return messsage;
	}
	public void setMesssage(String messsage) {
		this.messsage = messsage;
	}

	/**
	 * 调用成功时，返回的数据
	 */
	private Object data;

	/**
	 * 调用返回的状态码。
	 * 200： 成功
	 * 500: 非预期的异常
	 * 503: 后台主动抛出的异常
	 */
	private int status;

	/**
	 * 返回的消息，一般为错误消息
	 */
	private String messsage;
}
