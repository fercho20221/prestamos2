package com.example.prestamos.repository;

import com.example.prestamos.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository    /// permite identificar que este repositorio va a trabajar como base de datos
public interface IUserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u where u.correoElectronico = ?1 and u.password = ?2")
    ArrayList<User>validaCredenciales(String usuario, String password);

    @Query("SELECT p FROM User p where p.correoElectronico = ?1")
    ArrayList<User>existeCorreo( String correoElectronico);

    @Query("SELECT p FROM User p where p.correoElectronico = ?1")
    User findByUserName( String correoElectronico);



}
