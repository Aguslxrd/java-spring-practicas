package com.practicasspring.practicasenspring.dao;

import com.practicasspring.practicasenspring.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
    public Usuario verificarCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> listaUsuarios = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        String hashedPassword = listaUsuarios.get(0).getPasswd();

        if (!listaUsuarios.isEmpty()) {//Agregar try catch para evitar null pointers

            Argon2PasswordEncoder arg2SpringSecurity = new Argon2PasswordEncoder(16, 32, 1, 60000, 10);
            if (arg2SpringSecurity.matches(usuario.getPasswd(), hashedPassword)){
                return listaUsuarios.get(0); //devuelve el primero
            }
            return null;
        }
        return null;
    }

    @Override
    public Usuario getUsuarioPorId(long id) {
        String queryString = "SELECT u FROM Usuario u WHERE u.id = :userId"; // Corregir la consulta
        TypedQuery<Usuario> query = entityManager.createQuery(queryString, Usuario.class);
        query.setParameter("userId", id); // Establecer el parámetro del ID
        List<Usuario> usuarios = query.getResultList();

        if (!usuarios.isEmpty()) {
            return usuarios.get(0); // Devolver el primer usuario encontrado
        } else {
            return null; // No se encontró ningún usuario con ese ID
        }
    }




}
