package com.obsm.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.obsm.book.model.Book;

@Repository
public interface IBookModuleRepo extends JpaRepository<Book, Long>{
	
	@Query("SELECT e FROM book_data e ORDER BY e.rating DESC")
	public List<Book> viewFavoriteBooksByRating();
	
	@Query("SELECT e FROM book_data e WHERE e.catogeryId = ?1")
	public List<Book> viewBooksByCatId(long catogeryId);
	
	@Query("SELECT e FROM book_data e ORDER by e.publishDate Desc")
	public List<Book> viewAllRecentlyPublishedBooks();

}
