package com.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

  public static void saveMovie(EntityManager em) {
    try {
      Movie movie = new Movie();

      movie.setId(12L);
      movie.setMovieName("The Godfather");
      movie.setReleaseYear(1972);
      movie.setLanguage("English");
      em.getTransaction().begin();
      em.persist(movie);
      em.getTransaction().commit();
      System.out.println("Done!");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence
        .createEntityManagerFactory("com.mycompany.just_hibernate");

    EntityManager entityManager = emf.createEntityManager();
    saveMovie(entityManager);
    emf.close();
    //entity manager close not needed since it is dependent from factory
  }
}
