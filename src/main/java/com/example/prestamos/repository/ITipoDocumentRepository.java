package com.example.prestamos.repository;

import com.example.prestamos.entities.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ITipoDocumentRepository extends JpaRepository<TipoDocumento,Integer> {

    @Query("SELECT t FROM TipoDocumento t WHERE  t.nombre = ?1")  // se conoce en SQL como el alias mezcla SQL y java
    ArrayList<TipoDocumento> findByNombre(String nombre);


}
