package com.example.TestCreateProject.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.TestCreateProject.Model.Book;
import com.example.TestCreateProject.Model.Episode;
import com.example.TestCreateProject.Model.TypeBook;

@Repository
public class BookRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int createBook(Book book, List<TypeBook> tbList) {

		String sql = "INSERT INTO book (name_fiction, preview, id_user, img_book) VALUES (?, ?, ?, ?) ";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int insert = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, book.getName_fiction());
				ps.setString(2, book.getPreview());
				ps.setInt(3, book.getId_user());
				ps.setString(4, book.getImg_book());
				return ps;
			}
		}, keyHolder);

		if (insert == 1) {

			String sql2 = "INSERT INTO type_book (id_book, id_type) VALUES (?, ?) ";

			int insert2 = 0;
			for (TypeBook tb : tbList) {
				insert2 = jdbcTemplate.update(sql2, keyHolder.getKey().intValue(), tb.getId_type());
			}

			if (insert2 == 1) {
				return keyHolder.getKey().intValue();
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

	public List<Book> getBookByUser(int id_user) {

		String sql = "SELECT * FROM book WHERE id_user = ? ";
		List<Book> books = new ArrayList<Book>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { id_user });

		for (Map<String, Object> row : rows) {
			Book book = new Book();
			book.setId_book((int) row.get("id_book"));
			book.setName_fiction((String) row.get("name_fiction"));
			book.setCreate_day((Date) row.get("create_day"));
			book.setId_user((int) row.get("id_user"));
			book.setPreview((String) row.get("preview"));
			book.setImg_book((String) row.get("img_book"));
			books.add(book);
		}
		return books;
	}

	public List<Book> getBookByOrder(int start, int end) {

		String sql = "SELECT b.id_book, b.name_fiction, b.create_day, b.preview, b.id_user, b.img_book, u.penname, SUM(e.view) AS view FROM book b \r\n"
				+ "INNER JOIN user u ON u.id_user = b.id_user \r\n"
				+ "INNER JOIN episode e ON e.id_book = b.id_book\r\n" + "GROUP BY b.id_book\r\n"
				+ "ORDER BY create_day DESC LIMIT ?, ?";
		List<Book> books = new ArrayList<Book>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, start, end);

		for (Map<String, Object> row : rows) {
			int id_book = (int) row.get("id_book");
			Book book = new Book();
			book.setId_book((int) row.get("id_book"));
			book.setName_fiction((String) row.get("name_fiction"));
			book.setCreate_day((Date) row.get("create_day"));
			book.setId_user((int) row.get("id_user"));
			book.setPreview((String) row.get("preview"));
			book.setImg_book((String) row.get("img_book"));
			book.setView(((BigDecimal) row.get("view")).intValue());
			book.setPanname((String) row.get("penname"));
			sql = "SELECT tb.id_type, t.name_type FROM type_book tb " + "INNER JOIN type t ON t.id_type = tb.id_type "
					+ "WHERE tb.id_book = ?";

			List<Map<String, Object>> type_books = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setTypebook(type_books);
			sql = "SELECT e.id_episode, e.name_episode, e.view, e.content FROM episode e\r\n"
					+ "WHERE e.id_book = ? ORDER BY e.id_episode DESC limit 0, 3";
			List<Map<String, Object>> episode = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setEpisode(episode);
			books.add(book);
		}
		return books;
	}

	public List<Book> getBookByOrderView(int start, int end) {

		String sql = "SELECT SUM(e.view) AS view, b.id_book, b.name_fiction, b.create_day, b.preview, b.img_book, b.id_user, u.penname FROM episode e\r\n"
				+ "INNER JOIN book b ON b.id_book = e.id_book\r\n" + "INNER JOIN user u ON u.id_user = b.id_user\r\n"
				+ "GROUP BY e.id_book\r\n" + "ORDER BY SUM(e.view) DESC LIMIT ?, ?";
		List<Book> books = new ArrayList<Book>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, start, end);

		for (Map<String, Object> row : rows) {
			int id_book = (int) row.get("id_book");
			Book book = new Book();
			book.setId_book((int) row.get("id_book"));
			book.setName_fiction((String) row.get("name_fiction"));
			book.setCreate_day((Date) row.get("create_day"));
			book.setId_user((int) row.get("id_user"));
			book.setPreview((String) row.get("preview"));
			book.setImg_book((String) row.get("img_book"));
			book.setView(((BigDecimal) row.get("view")).intValue());
			book.setPanname((String) row.get("penname"));
			sql = "SELECT tb.id_type, t.name_type FROM type_book tb " + "INNER JOIN type t ON t.id_type = tb.id_type "
					+ "WHERE tb.id_book = ?";

			List<Map<String, Object>> type_books = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setTypebook(type_books);
			sql = "SELECT e.id_episode, e.name_episode, e.view, e.content FROM episode e\r\n"
					+ "WHERE e.id_book = ? ORDER BY e.id_episode DESC limit 0, 3";
			List<Map<String, Object>> episode = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setEpisode(episode);
			books.add(book);
		}
		return books;
	}

	public List<Book> getBookByOrderType(int type, int start, int end) {

		String sql = "SELECT b.id_book, b.name_fiction, b.create_day, b.preview, b.id_user, b.img_book, u.penname, SUM(e.view) AS view FROM book b\r\n"
				+ "INNER JOIN (SELECT * FROM type_book tb WHERE tb.id_type = ?) tb ON b.id_book= tb.id_book\r\n"
				+ "INNER JOIN user u ON u.id_user = b.id_user\r\n" + "INNER JOIN episode e ON e.id_book = b.id_book\r\n"
				+ "GROUP BY b.id_book\r\n" + "ORDER BY b.create_day DESC LIMIT ?, ?";
		List<Book> books = new ArrayList<Book>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, type, start, end);

		for (Map<String, Object> row : rows) {
			int id_book = (int) row.get("id_book");
			Book book = new Book();
			book.setId_book((int) row.get("id_book"));
			book.setName_fiction((String) row.get("name_fiction"));
			book.setCreate_day((Date) row.get("create_day"));
			book.setId_user((int) row.get("id_user"));
			book.setPreview((String) row.get("preview"));
			book.setImg_book((String) row.get("img_book"));
			book.setPanname((String) row.get("penname"));
			book.setView(((BigDecimal) row.get("view")).intValue());

			sql = "SELECT tb.id_type, t.name_type FROM type_book tb " + "INNER JOIN type t ON t.id_type = tb.id_type "
					+ "WHERE tb.id_book = ?";

			List<Map<String, Object>> type_books = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setTypebook(type_books);

			sql = "SELECT e.id_episode, e.name_episode, e.view, e.content FROM episode e\r\n"
					+ "WHERE e.id_book = ? ORDER BY e.id_episode DESC limit 0, 3";
			List<Map<String, Object>> episode = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setEpisode(episode);

			books.add(book);
		}
		return books;
	}

	public List<Book> getBookByOrderViewType(int type, int start, int end) {

		String sql = "SELECT SUM(e.view) AS view, b.id_book, b.name_fiction, b.create_day, b.preview, b.id_user, b.img_book, u.penname FROM book b\r\n"
				+ "INNER JOIN episode e ON e.id_book = b.id_book\r\n"
				+ "INNER JOIN (SELECT * FROM type_book tb WHERE tb.id_type = ?) tb ON tb.id_book = b.id_book\r\n"
				+ "INNER JOIN user u ON u.id_user = b.id_user\r\n" + "GROUP BY b.id_book\r\n"
				+ "ORDER BY view DESC LIMIT ?, ?";
		List<Book> books = new ArrayList<Book>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, type, start, end);

		for (Map<String, Object> row : rows) {
			int id_book = (int) row.get("id_book");
			Book book = new Book();
			book.setId_book((int) row.get("id_book"));
			book.setName_fiction((String) row.get("name_fiction"));
			book.setCreate_day((Date) row.get("create_day"));
			book.setId_user((int) row.get("id_user"));
			book.setPreview((String) row.get("preview"));
			book.setImg_book((String) row.get("img_book"));
			book.setView(((BigDecimal) row.get("view")).intValue());
			book.setPanname((String) row.get("penname"));
			sql = "SELECT tb.id_type, t.name_type FROM type_book tb " + "INNER JOIN type t ON t.id_type = tb.id_type "
					+ "WHERE tb.id_book = ?";

			List<Map<String, Object>> type_books = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setTypebook(type_books);
			sql = "SELECT e.id_episode, e.name_episode, e.view, e.content FROM episode e\r\n"
					+ "WHERE e.id_book = ? ORDER BY e.id_episode DESC limit 0, 3";
			List<Map<String, Object>> episode = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setEpisode(episode);
			books.add(book);
		}
		return books;
	}
	
	public List<Book> getBookByID(int id) {

		String sql = "SELECT SUM(e.view) AS view, b.id_book, b.name_fiction, b.create_day, b.preview, b.id_user, b.img_book, u.penname, COUNT(e.id_episode) AS count_episode FROM book b\r\n" + 
				"INNER JOIN episode e ON e.id_book = b.id_book\r\n" + 
				"INNER JOIN user u ON u.id_user = b.id_user\r\n" + 
				"WHERE b.id_book = ?";
		List<Book> books = new ArrayList<Book>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

		for (Map<String, Object> row : rows) {
			int id_book = (int) row.get("id_book");
			Book book = new Book();
			book.setId_book((int) row.get("id_book"));
			book.setName_fiction((String) row.get("name_fiction"));
			book.setCreate_day((Date) row.get("create_day"));
			book.setId_user((int) row.get("id_user"));
			book.setPreview((String) row.get("preview"));
			book.setImg_book((String) row.get("img_book"));
			book.setView(((BigDecimal) row.get("view")).intValue());
			book.setPanname((String) row.get("penname"));
			book.setCount_episode(((Long) row.get("count_episode")).intValue());
			sql = "SELECT tb.id_type, t.name_type FROM type_book tb " + "INNER JOIN type t ON t.id_type = tb.id_type "
					+ "WHERE tb.id_book = ?";

			List<Map<String, Object>> type_books = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setTypebook(type_books);
			sql = "SELECT e.id_episode, e.name_episode, e.view, e.content FROM episode e\r\n"
					+ "WHERE e.id_book = ? ORDER BY e.id_episode DESC limit 0, 5";
			List<Map<String, Object>> episode = jdbcTemplate.queryForList(sql, new Object[] { id_book });
			book.setEpisode(episode);
			books.add(book);
		}
		return books;
	}

}
