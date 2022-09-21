package com.example.prestamos.controllers;

import com.example.prestamos.entities.User;
import com.example.prestamos.services.Response;
import com.example.prestamos.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("index")
public class IndexController {

    // Se coloca una propiedad del tipo Userservice para poder trabajar con la logica de negocio de la aplicacion
    private UserService userService;

    public IndexController(UserService service){
        this.userService = service;

    }



    @RequestMapping("index")  // este es punto de entrada
    public String index(){
        return "hola dev";
    }

    @RequestMapping("getusuarios")
    public ArrayList<User> getUsuarios(){
        return this.userService.selectAll();
    }

    @RequestMapping("getuser/{id}")  // lo que esta dentro de llaves es un parametro puede ser un 1 o 2 o 3....
    public User getusuario(@PathVariable int id){
        return this.userService.selectById(id);
    }

    @PostMapping("create")
    public Response createuser(@RequestBody User request){
        return this.userService.createUser(request);
    }

    @DeleteMapping("delete/{id}") // es igual que el Get
    public Response deleteUsuario(@PathVariable int id) {
        return this.userService.deleteUserById(id);
    }

    @PutMapping("update")
    public Response updateUser(@RequestBody User request){
        return this.userService.updateUser(request);


    }

    @PutMapping("login")
    public Response auth(@RequestBody User request){
        return this.userService.loginUser(request);
    }


}
