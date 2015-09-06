package org.openlibrary;

import java.util.List;

import javax.inject.Named;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;


@Api(name = "book"
, version = "v1"
, clientIds = {Constants.WEB_CLIENT_ID}
, audiences = {"https://micro-environs-104602.appspot.com"}
, scopes = {"https://www.googleapis.com/auth/userinfo.email"}
)


public class BookEndPoint {

  @ApiMethod(name = "book.add"
    , path = "book/add"
    , httpMethod = HttpMethod.PUT)
  public void addBook(@Named("name") String _sname
    , @Named("author") String _sauthor
    , @Named("genre") String _sgenre
  , @Named("ageGroup") String _sageGroup
  , @Named("ISBN") String _sISBN
  , @Named("price") String _sprice
  , @Named("numberOfCopiesAvailable") String _snumberOfCopiesAvailable) {
	  
   BookHandler ch = new BookHandler();
   ch.addBook(_sname, _sauthor, _sgenre, _sageGroup, _sISBN, Float.parseFloat(_sprice), Integer.parseInt(_snumberOfCopiesAvailable));
 }  

  // url -->  https://vehicleBookx.appspot.com/_ah/api/Book/v1/readall
  // sample url --> https://vehicleBookx.appspot.com/_ah/api/Book/v1/readall?fields=items(brand%2Cmodel%2Cyear)
  @ApiMethod(name = "readall"
    , path = "readall"
    , httpMethod = HttpMethod.GET)
  public List <Book> readall(){

   BookHandler ch = new BookHandler();
   List<Book> Books = ch.getAllBooks();
   
      return Books;
  }
  
  @ApiMethod(name = "readmatching"
		    , path = "readmatching"
		    , httpMethod = HttpMethod.GET)
		  public List <Book> readmatching(@Named("brand") String _sbrand){

		   BookHandler ch = new BookHandler();
		   List<Book> Books = ch.getAllBooks(_sbrand);
		   
		      return Books;
		  }

}
