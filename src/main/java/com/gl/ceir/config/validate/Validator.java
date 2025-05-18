package com.gl.ceir.config.validate;

import java.util.List;

public interface Validator {

	public boolean contains(List<String> pool, String target);
	
	public boolean contains(List<Integer> pool, Integer target);
	
	public boolean matchLength();
}
