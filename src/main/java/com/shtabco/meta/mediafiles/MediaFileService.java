package com.shtabco.meta.mediafiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaFileService {

	@Autowired
	MediaFileRepository mediaFileRepository;
	
	Iterable<MediaFile> getAllMediaFiles() {
		return mediaFileRepository.findAll();
	}
	
}
