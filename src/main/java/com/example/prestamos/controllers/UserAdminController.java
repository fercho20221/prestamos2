package com.example.prestamos.controllers;

import com.example.prestamos.dto.updateUserDTO;
import com.example.prestamos.entities.TipoDocumento;
import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.TipoDocumentoService;
import com.example.prestamos.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("admin")
public class UserAdminController extends BaseController {

   // private UserService service;
    private TipoDocumentoService docService;

    public UserAdminController(UserService service, TipoDocumentoService documentoService){
       // this.service = service;
        this.docService = documentoService;
    }


    @GetMapping("usuarios")
    public String usuariosregistrados(Model usuarios){
        ArrayList<User> usersDB = this.service.selectAll();
        usuarios.addAttribute("usuarios",usersDB);
        usuarios.addAttribute("usuarioautenticado",seguridad());
        return "/useradmin/usuariosregistrados";
    }

    @GetMapping("edituser/{id}")  ///  Edit user que recibe un parametro y retorna una vista con un modelo
    public String edituser(@PathVariable int id, Model data){
        User userinfo = this.service.selectById(id);
        data.addAttribute("user",userinfo);

        ArrayList<TipoDocumento> documentos =  this.docService.selectAll();
        data.addAttribute("misdocumentos",documentos);

        return "/useradmin/edituser";
    }

    @PostMapping("edituserpost")
    public RedirectView edituserpost(updateUserDTO data){


        //mapping de los datos
        User newUser = new User();
        newUser.setId(data.getId());
        newUser.setNombres(data.getNombres());
        newUser.setApellidos(data.getApellidos());
        Response response = this.service.updateUserName(newUser);

        return new RedirectView("/admin/usuarios");
    }

    @GetMapping("deleteuser/{id}")
    public RedirectView deleteUser(@PathVariable int id){
        Response response = this.service.deleteUserById(id);
        return new  RedirectView("/admin/usuarios");
    }

    @GetMapping("tiposdocumento")
    public  String tipodocumento(Model data)
    {
        data.addAttribute("tiposdocumento",this.docService.selectAll());
        data.addAttribute("titulopagina","Administracion de documentos");
        return"useradmin/tipodocumento";
    }

}