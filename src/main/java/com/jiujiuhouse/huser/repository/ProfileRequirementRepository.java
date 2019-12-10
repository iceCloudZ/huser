package com.jiujiuhouse.huser.repository;

import com.jiujiuhouse.huser.entity.ProfileRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author zihao.zhao
 */
@RepositoryRestResource
public interface ProfileRequirementRepository extends JpaRepository<ProfileRequirement, Integer> {

}
