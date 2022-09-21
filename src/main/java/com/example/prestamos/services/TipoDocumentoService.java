package com.example.prestamos.services;

import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.repository.ITipoDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TipoDocumentoService {

    private ITipoDocumentRepository repository;

    public TipoDocumentoService(ITipoDocumentRepository rep){
        this.repository = rep;
    }
    public ArrayList<TipoDocumento> selectAll(){   // PARA CONSULTAR TODOS LOS DOCUMENTOS
        return (ArrayList<TipoDocumento>) this.repository.findAll();
    }




    //Metodo que permite registrar un documento
    public Response createDocumento(TipoDocumento data){

        //Debo validar si el documento existe
       ArrayList<TipoDocumento> documentos =  this.repository.findByNombre(data.getNombre());  // aca yo valido con la base de datos
       if(documentos != null && documentos.size() >0 ){
           Response response = new Response();
           response.setCode(500);
           response.setMessage("Este documento ya existe");
           return response;

        }

        this.repository.save(data);

       // this.repository.

        Response response = new Response();
        response.setCode(200);
        response.setMessage("Documento creado exitosamente");
        return response;
    }
}
