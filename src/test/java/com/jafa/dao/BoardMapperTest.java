package com.jafa.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
//import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.config.RootConfig;
import com.jafa.config.ServletConfig;
import com.jafa.dto.Board;
import com.jafa.dto.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,ServletConfig.class})
@WebAppConfiguration

public class BoardMapperTest {

	@Autowired
	BoardMapper mapper;
	
	@Autowired
	DataSource dataSource;
	
	
	@After
	public void setup() throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader("sql/sql_board2.sql");
		ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
		runner.runScript(reader);
	}
	
	@Test
	public void getListtest() {
		Criteria criteria = new Criteria();
		List<Board> list = mapper.getList(criteria);
		assertEquals(3,list.size());
	}
	@Test
	public void insertTest() {
		Board board = new Board();
		board.setTitle("제목입니다. ");
		board.setContent("내용입니다.");
		board.setWriter("글쓴이11");
		mapper.insert(board);
		System.out.println("가장최신글번호"+ board.getBno());//회원번호
		Criteria criteria = new Criteria();    
		List<Board> list = mapper.getList(criteria); 
		assertEquals(4, list.size());
	}
	@Test
	public void findByBno() {
		Board findByBno = mapper.findByBno(1L);
		assertEquals("게시물 제목입니다1.", findByBno.getTitle());
		assertEquals("잠꾸러기1", findByBno.getWriter());
		assertEquals("잠이온다1", findByBno.getContent());
	}
	@Test
	public void deleteTest() {
		mapper.delete(1L);
		Board board = mapper.findByBno(1L);
		assertNull(board);

	}
	@Test
	public void updateTest() {
		Board board = mapper.findByBno(1L);
		board.setTitle("1번글 제목 수정");
		mapper.update(board);
		Board updated = mapper.findByBno(1L);
		assertEquals("1번글 제목 수정", updated.getTitle());
		assertEquals(board.getContent(), updated.getContent());
	}
}
