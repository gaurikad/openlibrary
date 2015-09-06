package org.openlibrary;

import javax.persistence.Entity;

import com.google.appengine.api.datastore.Key;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNumberOfCopiesAvailable() {
		return numberOfCopiesAvailable;
	}
	public void setNumberOfCopiesAvailable(int numberOfCopiesAvailable) {
		this.numberOfCopiesAvailable = numberOfCopiesAvailable;
	}
	public Key getKey() {
		return key;
	}
	
	private String name;
	private String author;
	private String genre;
	private String ageGroup; // child, teen, adult, all
	private String ISBN;
	private float price;
	private int numberOfCopiesAvailable;
	
	public boolean isWishList() {
		return wishList;
	}
	public void setWishList(boolean wishList) {
		this.wishList = wishList;
	}

	private boolean wishList;

}
