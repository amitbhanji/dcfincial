package com.dcfin.idp.arch;

import java.io.InputStream;
import java.util.Map;

import com.dcfin.idp.model.Action;

public class ApplicationConfigurator {

	public static synchronized Map<String, Action> buildActionClassMapping(InputStream appConfigInput) {
		return StaxParser.parse(appConfigInput);
	}

	}