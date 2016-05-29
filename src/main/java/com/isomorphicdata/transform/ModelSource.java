package com.isomorphicdata.transform;

public interface ModelSource {
	public String next();
	public Boolean hasNext();
	public void reset(String fileName);
}