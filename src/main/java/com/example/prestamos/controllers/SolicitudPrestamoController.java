package com.example.prestamos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("solicitud")
public class SolicitudPrestamoController {



    @GetMapping("solicitud")
    public String solicitud(Model data){
        data.addAttribute("titulopagina","Solicitud de Prestamos..");
        return "solicitudprestamo/solicitud";
    }

}
