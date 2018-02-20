package com.shtabco.meta.translit;

public class Translit {

	static private Translit instance = null;
	
	static private TranslitTable[] tables = {
				new CyrilicTranslitTable()
	};
	
	static public Translit getInstance() {
		if (instance == null) {
			instance = new Translit();
		}
		return instance;
	}
	
	public String translate(char c) {
		for(int i = 0; i < tables.length; i++) {
			TranslitTable table = tables[i];
			if (table.isPartOf(c)) {
				char[] from = table.getFrom();
				String[] to = table.getTo();
				for(int j = 0; j < from.length; j++) {
					if(from[j] == c) {
						return to[j];
					}
				}
			} 
		}
		return "" + c;
	}
	
	public String translate(String str) {
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			res.append(c);
		}
		return res.toString();
	}

	public boolean hasInternationalChars(String str) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < tables.length; j++) {
				if(tables[j].isPartOf(str.charAt(i))) {
					return true;
				}
			}
		}
		return false;
	}
}
