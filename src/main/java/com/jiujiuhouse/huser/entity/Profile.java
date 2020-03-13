package com.jiujiuhouse.huser.entity;

import com.jiujiuhouse.huser.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户表
 * @author zihao.zhao
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "jj_profile")
public class Profile extends BaseEntity {

    @Id
//    @SequenceGenerator(sequenceName = "profile_sequence", name = "seq")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "country_code")
    private String countryCode;

    public Profile(String openId, String sessionKey) {
        this.openId = openId;
        this.sessionKey = sessionKey;
    }

}
