package com.company.connectionSQL.repo;

import com.company.connectionSQL.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Integer> {

}
