
package com.ufps.conferencia.repository;

import com.ufps.conferencia.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    
}
