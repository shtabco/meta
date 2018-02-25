package com.shtabco.meta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shtabco.meta.domain.MediaFile;
import com.shtabco.meta.domain.MediaFileRepository;

@Service
public class MediaFileService {

	@Autowired
	private MediaFileRepository mediaFileRepository;
	
	public Iterable<MediaFile> getAllMediaFiles() {
		return mediaFileRepository.findAll();
	}
	
	public Iterable<MediaFile> findMediaFilesByPath(String path) {
		return mediaFileRepository.findByPath(path);
	}
	
	
	
	
}
