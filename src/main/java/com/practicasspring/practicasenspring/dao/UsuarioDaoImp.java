package com.practicasspring.practicasenspring.dao;

import com.practicasspring.practicasenspring.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<Usuario> getUsuarios() {

        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarUsuario(long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario); //se puede utilizar persist ya que no actualizo la entidad como tal.
    }
    @Override
    public boolean verificarCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> listaUsuarios = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        String hashedPassword = listaUsuarios.get(0).getPasswd();

        if (!listaUsuarios.isEmpty()) {//Agregar try catch para evitar null pointers

            Argon2PasswordEncoder arg2SpringSecurity = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
            return arg2SpringSecurity.matches(usuario.getPasswd(), hashedPassword);
        }
        return false;
    }

}
