package com.jiujiuhouse.huser.repository;

import com.jiujiuhouse.huser.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author zihao.zhao
 */
@RepositoryRestResource
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    /**
     * 根据openId查询用户
     *
     * @param openId openId
     * @return 用户
     */
    Profile findByOpenId(String openId);

    /**
     * 根据sessionKey查询用户
     * @param sessionKey sessionKey
     * @return 用户
     */
    Profile findBySessionKey(String sessionKey);
}
