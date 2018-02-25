package com.shtabco.meta.domain;

import org.springframework.data.repository.CrudRepository;


public interface MediaFileRepository extends CrudRepository<MediaFile, Long> {
	
	public Iterable<MediaFile> findByPath(String path);

}
