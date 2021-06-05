package halilulkr.HRMS.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult() {
		super(null, true);
	}
	
	public SuccessDataResult(final T data) {
		super(data, true);
	}
	
	public SuccessDataResult(final String message) {
		super(null, true, message);
	}
	
	public SuccessDataResult(final T data, String message) {
		super(data, true, message);
	}
}
