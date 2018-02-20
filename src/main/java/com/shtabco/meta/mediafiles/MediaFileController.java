package com.shtabco.meta.mediafiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shtabco.meta.utils.MediaFilesAnalyzer;

@RestController
public class MediaFileController {
	
	@Autowired
	MediaFileService mediaFileService;
	
	@RequestMapping("mediafiles")
	public Iterable<MediaFile> getMediaFiles() {
		return mediaFileService.getAllMediaFiles();
	}
}
