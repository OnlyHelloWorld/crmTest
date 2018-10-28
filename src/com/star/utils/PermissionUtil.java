package com.star.utils;

import java.lang.reflect.Method;

public class PermissionUtil {

	static public String createExperssion(Method m) {
		StringBuilder exp = new StringBuilder(100).append(
				m.getDeclaringClass().getCanonicalName()).append(m.getName());
		return exp.toString();
	}
}
