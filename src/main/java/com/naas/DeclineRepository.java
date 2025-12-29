package com.naas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclineRepository extends JpaRepository<DeclinePath, Integer> {

    public List<DeclinePath> getByToneContaining(String tone);
}
