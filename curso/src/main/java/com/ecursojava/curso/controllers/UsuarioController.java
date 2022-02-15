package com.ecursojava.curso.controllers;

import com.ecursojava.curso.dao.UsuarioDao;
import com.ecursojava.curso.models.Usuario;
import com.ecursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios/{id}",method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Guillermo");
        usuario.setApellido("Ramirez");
        usuario.setEmail("memo0p2@hotmail.com");
        usuario.setTelefono("5512345678");
        usuario.setPassword("memo");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios",method = RequestMethod.GET)
    public  List<Usuario> getUsuarios(@RequestHeader (value = "Authorization") String token){
        if(!validarToken(token)){return  null ;}

        return usuarioDao.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;

    }

    @RequestMapping(value = "api/usuarios",method = RequestMethod.POST)
    public  void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }


    @RequestMapping(value = "api/usuarios/{id}",method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader (value = "Authorization") String token,@PathVariable Long id ){
        usuarioDao.eliminar(id);
    }

}
