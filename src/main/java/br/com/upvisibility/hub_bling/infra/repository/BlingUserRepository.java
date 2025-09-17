package br.com.upvisibility.hub_bling.infra.repository;

import br.com.upvisibility.hub_bling.infra.entity.BlingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlingUserRepository extends JpaRepository<BlingUser, Long> {
    Optional<BlingUser> findBlingUserByUserId(Long userId);

    Optional<BlingUser> findBlingUserByCompanyEmail(String email);
}
