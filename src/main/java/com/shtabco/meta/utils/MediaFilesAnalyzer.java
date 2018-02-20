package com.shtabco.meta.utils;

import java.io.File;
import java.io.PrintWriter;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shtabco.meta.mediafiles.MediaFile;
import com.shtabco.meta.mediafiles.MediaFileRepository;
import com.shtabco.meta.translit.Translit;

@Service
public class MediaFilesAnalyzer {

	PrintWriter allLog = null;
	PrintWriter warningLog = null;
	PrintWriter problemLog = null;
	PrintWriter internationalLog = null;
	Translit translit = Translit.getInstance();
	
	@Autowired
	MediaFileRepository mediaFileRepository; 

	public void analyze(String sourceRootDir) {
		System.out.println("root Boo" + sourceRootDir);
		float start = System.nanoTime();

		FileTreeWalker walker = new FileTreeWalker(new File(sourceRootDir), (file) -> analyzeFile(file));
		walker.start();

		System.out.printf("Sec : %.10f\n", ((System.nanoTime() - start) / 10E8));
	}

//	public String adaptString(String source) {
//		StringBuffer res = new StringBuffer();
//		for (int i = 0; i < source.length(); i++) {
//			char charAt = source.charAt(i);
//			if (charAt == ' ')
//				charAt = '_';
//			if (charAt != '.' && charAt != '"' && charAt != '@' && charAt != '!' && charAt != '?')
//				res.append(translit.translate(charAt));
//		}
//		return res.toString();
//	}

	private void analyzeFile(File file) {
		boolean warning = false;
		boolean international = false;
		boolean error = false;
		String note = null;
		String path = file.getPath();
				
		if (!file.isDirectory()) {

			MediaFile mediaFile = null;
			
			AudioFile audioFile = null;
			String title = "";
			String artist = "";
			String album = "";

			try {
				audioFile = AudioFileIO.read(file);
				title = audioFile.getTag().getFirst(FieldKey.TITLE);
				artist = audioFile.getTag().getFirst(FieldKey.ARTIST);
				album = audioFile.getTag().getFirst(FieldKey.ALBUM);
			} catch (Exception e) {
				error = true;
				note = e.getMessage();
			}

			international = translit.hasInternationalChars(path) || translit.hasInternationalChars(title)
					|| translit.hasInternationalChars(artist) || translit.hasInternationalChars(album);

			if (title != null && title.trim().length() < 4) {
				warning = true;
			}
			if (artist != null && artist.trim().length() < 4) {
				warning = true;
			}
			if (album != null && album.trim().length() < 4) {
				warning = true;
			}
			mediaFile = new MediaFile(null, path, title, album, artist, warning, international, error, note);
			mediaFileRepository.save(mediaFile);
		}
	}
}
