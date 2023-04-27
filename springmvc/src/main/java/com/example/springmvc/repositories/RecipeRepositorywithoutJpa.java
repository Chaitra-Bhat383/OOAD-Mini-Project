package com.example.springmvc.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


@Repository
public class RecipeRepositorywithoutJpa{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    // public JdbcTemplate getJdbcTemplate() {
    //     return jdbcTemplate;
    // }
    // @Autowired
    // public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    //     this.jdbcTemplate = jdbcTemplate;
    // }

    public void deleteItem(Long id){
        //if(this.jdbcTemplate!=null) {
        jdbcTemplate.update("DELETE FROM RECIPE WHERE ID = ?",new Object[] {
                id
            });
        //}
        // else return 0;
    }
    
}