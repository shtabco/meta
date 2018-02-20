package com.shtabco.meta.mediafiles;

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
    private String album;
    private String artist;
    private Boolean warning;
    private Boolean international;
    private Boolean error;
    private String note;
	
    public MediaFile() {
    	
    }
    public MediaFile(Long id, String path, String title, String album, String artist, Boolean warning,
			Boolean international, Boolean error, String note) {
		this.id = id;
		this.path = path;
		this.title = title;
		this.album = album;
		this.artist = artist;
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
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
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