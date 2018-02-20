package com.shtabco.meta.translit;

public interface TranslitTable {
	char[] getFrom();
	String[] getTo();
	public boolean isPartOf(char c);

}
