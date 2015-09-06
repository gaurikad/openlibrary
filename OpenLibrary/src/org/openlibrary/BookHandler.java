package org.openlibrary;

import java.util.List;

import javax.persistence.EntityManager;

public class BookHandler { 
 public void addBook(String _sname, String _sauthor, String _sgenre, String  _sageGroup, String _sISBN, float price, 
		 int numberOfCopies) {
	 
  
  Book book = new Book();
  
  book.setName(_sname);
  book.setAuthor(_sauthor);
  book.setGenre(_sgenre);
  book.setAgeGroup(_sageGroup);
  book.setISBN(_sISBN);
  book.setPrice(price);
  book.setNumberOfCopiesAvailable(numberOfCopies);
  
  EntityManager em = EMF.get().createEntityManager();
  em.getTransaction().begin();
  
  em.persist(book);
  
  em.getTransaction().commit();
  
 }
 
 public List<Book> getAllBooks(){
  
  EntityManager em = EMF.get().createEntityManager();
  
  em.getTransaction().begin();
  List<Book> result = em.createQuery( "select Book from Book book", Book.class ).getResultList();
  em.getTransaction().commit();
  
  return result;
 }
 
 public List<Book> getAllBooks(String matchName){
	  
	  EntityManager em = EMF.get().createEntityManager();
	  
	  em.getTransaction().begin();
	  List<Book> result = em.createQuery( "select Book from Book Book where Book.name = '" + matchName + "'", Book.class ).getResultList();
	  em.getTransaction().commit();
	  
	  return result;
	 }

}
