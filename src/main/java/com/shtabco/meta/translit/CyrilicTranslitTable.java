package com.shtabco.meta.translit;

public class CyrilicTranslitTable implements TranslitTable {

	char[] from =
		{'а', 'б', 'в', 'г', 'д', 'е', 'ё',  'ж',  'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч',  'ш',  'щ',    'ъ', 'ы', 'ь', 'э',  'ю',  'я', 
	     'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё',  'Ж',  'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч',  'Ш',  'Щ',    'Ь', 'Ы', 'Ъ', 'Э',  'Ю',  'Я'}; 

	String[] to =
		{"a", "b", "v", "g", "d", "e", "jo", "zh", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "c", "ch", "sh", "cshh", "",  "y",  "", "je", "ju", "ja", 
	     "A", "B", "V", "G", "D", "E", "Jo", "Zh", "Z", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "C", "Ch", "Sh", "Cshh", "",  "Y",  "", "Je", "Ju", "Ja"};

	@Override
	public char[] getFrom() {
		return from;
	}

	@Override
	public String[] getTo() {
		return to;
	}

	@Override
	public boolean isPartOf(char c) {
	    return (c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я');
	}   

}
