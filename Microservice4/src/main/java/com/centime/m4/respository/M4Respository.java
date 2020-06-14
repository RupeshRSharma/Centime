/**
 * 
 */
package com.centime.m4.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centime.m4.entity.M4Entity;

/**
 * JPA respository for M4 entity.
 * 
 * @author Rupesh Sharma
 *
 */
@Repository
public interface M4Respository extends JpaRepository<M4Entity, Long>{

}
