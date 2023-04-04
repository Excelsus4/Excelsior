package com.excelsus.excelsior.content;

import com.simibubi.create.content.AllSections;

public class ExcelsiorSections {
	private static AllSections CASTOR;

	public static AllSections getCastor() {
		return CASTOR;
	}

	public static void setCastor(AllSections CASTOR) {
		ExcelsiorSections.CASTOR = CASTOR;
	}
}
