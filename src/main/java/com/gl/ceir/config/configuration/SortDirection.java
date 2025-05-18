/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.gl.ceir.config.configuration;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
@Component
public class SortDirection {

	public static Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.DESC;
	  }
}
