package com.cognizant.moviecruiser.model;

import java.util.Date;

import com.cognizant.moviecruiser.util.DateUtil;

public class MovieList {
	private long id;
	private String title;
	private long gross;
	private Boolean active;
	private Date dateOfLaunch;
	private String genre;
	private Boolean hasTeaser;

	public MovieList(long id, String title, long gross, Boolean active, Date dateOfLaunch, String genre,
			Boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.gross = gross;
		this.active = active;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public MovieList() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getGross() {
		return gross;
	}

	public void setGross(long gross) {
		this.gross = gross;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Boolean getHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(Boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public String toString() {
		return "MovieList [id=" + id + ", title=" + title + ", gross=" + gross + ", active=" + active
				+ ", dateOfLaunch=" + new DateUtil().convertToString(dateOfLaunch) + ", genre=" + genre + ", hasTeaser="
				+ hasTeaser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((dateOfLaunch == null) ? 0 : dateOfLaunch.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (int) (gross ^ (gross >>> 32));
		result = prime * result + ((hasTeaser == null) ? 0 : hasTeaser.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieList other = (MovieList) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (dateOfLaunch == null) {
			if (other.dateOfLaunch != null)
				return false;
		} else if (!dateOfLaunch.equals(other.dateOfLaunch))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (gross != other.gross)
			return false;
		if (hasTeaser == null) {
			if (other.hasTeaser != null)
				return false;
		} else if (!hasTeaser.equals(other.hasTeaser))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
