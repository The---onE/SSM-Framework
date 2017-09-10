package xmx.util;

import java.util.List;

public class ListResult<T> {
	private int status;
	private String prompt;
	private List<T> object;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public List<T> getObject() {
		return object;
	}

	public void setObject(List<T> object) {
		this.object = object;
	}
}
