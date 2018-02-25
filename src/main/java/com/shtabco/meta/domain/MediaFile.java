package com.shtabco.meta.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MediaFile {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @Column(unique=true)
    private String path;
    
	private String title;
    private String titleAlt;
    private String titleCombined;
    private String album;
    private String albumAlt;
    private String albumCombined;
    private String artist;
    private String artistAlt;
    private String artistCombined;
    private Boolean warning;
    private Boolean international;
    private Boolean error;
    private String note;
	
    public MediaFile() {
    	
    }
    
    public MediaFile(Long id, String path, 
    		String title, 
    		String titleAlt, 
    		String titleCombined, 
    		String album, 
    		String albumAlt, 
    		String albumCombined, 
    		String artist, 
    		String artistAlt, 
    		String artistCombined, 
    		Boolean warning, Boolean international, Boolean error, String note) {
		this.id = id;
		this.path = path;
		this.title = title;
		this.titleAlt = titleAlt;
		this.titleCombined = titleCombined;
		this.album = album;
		this.albumAlt = albumAlt;
		this.albumCombined = albumCombined;
		this.artist = artist;
		this.artistAlt = artistAlt;
		this.artistCombined = artistCombined;
		this.warning = warning;
		this.international = international;
		this.error = error;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleAlt() {
		return titleAlt;
	}

	public void setTitleAlt(String titleAlt) {
		this.titleAlt = titleAlt;
	}

	public String getTitleCombined() {
		return titleCombined;
	}

	public void setTitleCombined(String titleCombined) {
		this.titleCombined = titleCombined;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getAlbumAlt() {
		return albumAlt;
	}

	public void setAlbumAlt(String albumAlt) {
		this.albumAlt = albumAlt;
	}

	public String getAlbumCombined() {
		return albumCombined;
	}

	public void setAlbumCombined(String albumCombined) {
		this.albumCombined = albumCombined;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtistAlt() {
		return artistAlt;
	}

	public void setArtistAlt(String artistAlt) {
		this.artistAlt = artistAlt;
	}

	public String getArtistCombined() {
		return artistCombined;
	}

	public void setArtistCombined(String artistCombined) {
		this.artistCombined = artistCombined;
	}

	public Boolean getWarning() {
		return warning;
	}

	public void setWarning(Boolean warning) {
		this.warning = warning;
	}

	public Boolean getInternational() {
		return international;
	}

	public void setInternational(Boolean international) {
		this.international = international;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}