package com.projetb32.GSA.repository;

import java.util.Optional;

import com.projetb32.GSA.entity.Role;
import com.projetb32.GSA.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
