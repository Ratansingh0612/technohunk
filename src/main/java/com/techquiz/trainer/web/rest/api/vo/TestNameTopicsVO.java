package com.techquiz.trainer.web.rest.api.vo;

import java.util.List;

public class TestNameTopicsVO {
	private List<String> qbankNameList;
	private List<String> topics;

	public List<String> getQbankNameList() {
		return qbankNameList;
	}

	public void setQbankNameList(List<String> qbankNameList) {
		this.qbankNameList = qbankNameList;
	}

	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "TestNameTopicsVO [qbankNameList=" + qbankNameList + ", topics=" + topics + "]";
	}

}
