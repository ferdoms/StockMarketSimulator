/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;
import entities.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Joao pedro Haddad Oliveira
 * 
 */
public interface InvestorRepository extends JpaRepository<Investor, Long>{

}
