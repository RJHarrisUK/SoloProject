package com.soloproject.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.soloproject.persistence.domain.Ingredient;
import com.soloproject.persistence.repository.IngredientDBRepository;
import com.soloproject.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class IngredientDBRepositoryTest {

	@InjectMocks
	private IngredientDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;


	private static final String MOCK_DATA_ARRAY = "[{\"title\":\"Alien\",\"ageRating\":\"15\"}]";

	private static final String MOCK_OBJECT = "{\"title\":\"Alien\",\"ageRating\":\"15\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllMovies() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Alien", "15"));
		Mockito.when(query.getResultList()).thenReturn(movies);
		System.out.println(repo.getAllMovies());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllMovies());
	}

	@Test
	public void testCyclemovies() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("Alien", "15"));
		Mockito.when(query.getResultList()).thenReturn(movies);
		Assert.assertEquals(1, repo.cycleMovies("Alien"));

	}

	@Test
	public void testCreateMovie() {
		String reply = repo.createMovie(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"movie has been sucessfully added\"}");
	}

	@Test
	public void testDeleteMovie() {
		String reply = repo.deleteMovie(1L);
		Assert.assertEquals(reply, "{\"message\": \"movie successfully deleted\"}");
	}

}