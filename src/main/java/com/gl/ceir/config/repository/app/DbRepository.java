package com.gl.ceir.config.repository.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.SQLException;

@Repository
public class DbRepository {
    private static final Logger logger = LogManager.getLogger(DbRepository.class);

    @PersistenceContext
    private EntityManager em;

    private static Connection conn;

    public Connection getConnection() {
        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) em.getEntityManagerFactory();
        try {
            return info.getDataSource().getConnection();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public Connection connection() {
        if (conn == null) {
            conn = getConnection();
        }
        logger.info("Connection is :" + conn);
        return conn;
    }




}
