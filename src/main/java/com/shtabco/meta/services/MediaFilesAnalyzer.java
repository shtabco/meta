package com.shtabco.meta.services;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shtabco.meta.domain.MediaFile;
import com.shtabco.meta.domain.MediaFileRepository;
import com.shtabco.meta.translit.Translit;

@Service
public class MediaFilesAnalyzer {

	String sourceRootDir = null;
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
		this.sourceRootDir = FilenameUtils.normalize(sourceRootDir, true);
		FileTreeWalker walker = new FileTreeWalker(new File(this.sourceRootDir), (file) -> analyzeFile(file));
		walker.start();

		System.out.printf("Sec : %.10f\n", ((System.nanoTime() - start) / 10E8));
	}
	
	public void translateAll() {
		Iterator<MediaFile> iterator = mediaFileRepository.findAll().iterator();
		while(iterator.hasNext()) {
			MediaFile mediaFile = iterator.next();
		}
	}

	private void analyzeFile(File file) {
		boolean warning = false;
		boolean international = false;
		boolean error = false;
		String note = null;
		String path = FilenameUtils.normalize(file.getPath(), true);
	
		if (!file.isDirectory()) {

			boolean isFileSaved = mediaFileRepository.findByPath(path).iterator().hasNext();
			
			System.out.println("isFileSaved " + isFileSaved);
			
			if(!isFileSaved) {
				String relativePath = path.substring(sourceRootDir.length() + 1);
				
				if(FilenameUtils.isExtension(relativePath, "mp3")) {
					System.out.println("relativePath " + relativePath);
					
					String[] parts = relativePath.split("/");
										
					String artistAlt = parts.length >= 1 ? parts[0] : null;
					String albumAlt = parts.length >= 2 ? parts[1] : null;
					String titleAlt = parts.length >= 3 ? FilenameUtils.removeExtension(parts[2]) : null;
					
					MediaFile mediaFile = null;
					
					AudioFile audioFile = null;
					String title = null;
					String artist = null;
					String album = null;
			
					try {
						audioFile = AudioFileIO.read(file);
						title = audioFile.getTag().getFirst(FieldKey.TITLE);
						artist = audioFile.getTag().getFirst(FieldKey.ARTIST);
						album = audioFile.getTag().getFirst(FieldKey.ALBUM);
					} catch (Exception e) {
						error = true;
						note = e.getMessage();
					}
					
					String titleCombined = title != null && !title.isEmpty() ? title : titleAlt;
					String artistCombined = artist != null && !artist.isEmpty() ? artist : artistAlt;
					String albumCombined = album != null && !album.isEmpty() ? album : albumAlt;

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
					mediaFile = new MediaFile(null, path, 
							title, titleAlt, titleCombined, 
							album, albumAlt, albumCombined,
							artist, artistAlt, artistCombined,
							warning, international, error, note);
					mediaFileRepository.save(mediaFile);
					
				}
			}
		}
	}
}
