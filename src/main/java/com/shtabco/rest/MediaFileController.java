package com.shtabco.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shtabco.meta.domain.MediaFile;
import com.shtabco.meta.services.MediaFileService;

@RestController
public class MediaFileController {
	
	@Autowired
	MediaFileService mediaFileService;
	
	@RequestMapping("mediafiles")
	public Iterable<MediaFile> getMediaFiles(@RequestParam Optional<String> path) {
		System.out.println("path is present " + path.get());
		
		if(path.isPresent()) {
			return mediaFileService.findMediaFilesByPath(path.get());
		}
		return mediaFileService.getAllMediaFiles();
	}

}
