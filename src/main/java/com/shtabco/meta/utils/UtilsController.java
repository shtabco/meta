package com.shtabco.meta.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilsController {
	
	@Autowired
	MediaFilesAnalyzer mediaFileAnalizer;
	
	@RequestMapping("utils/analize")
	public void analizeFiles(@RequestParam String root) {
		System.out.println("root " + root);
		mediaFileAnalizer.analyze(root);
	}
}
