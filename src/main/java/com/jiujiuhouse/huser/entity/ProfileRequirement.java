package com.jiujiuhouse.huser.entity;

import com.jiujiuhouse.huser.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户需求
 *
 * @author zihao.zhao
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "jj_profile_requirement")
public class ProfileRequirement extends BaseEntity {

    @Id
    @SequenceGenerator(sequenceName = "profile_requirement_sequence", name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "id")
    private Integer id;




}
