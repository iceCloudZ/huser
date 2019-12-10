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
@Entity//声明此类是个实体类
@NoArgsConstructor
@Table(name = "jj_profile_requirement")//配置实体类和标的映射关系
public class ProfileRequirement extends BaseEntity {

    @Id//声明主键
    @SequenceGenerator(sequenceName = "profile_requirement_sequence", name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")//主键的生成策略
    @Column(name = "id")
    private Integer id;

    @Column(name = "cust_name",columnDefinition="varchar(10) not null")
    private String custName;//客户姓名

    @Column(name = "cust_phone",columnDefinition="varchar(11) not null")
    private String custPhone;//客户电话

    @Column(name = "address_name",columnDefinition="varchar(50) not null")
    private String address;//地址

    @Column(name = "address_real",columnDefinition="varchar(50) not null")
    private String addressReal;//地址

    @Column(name = "buildingFloorNum",columnDefinition="varchar(20)")
    private String buildingFloorNum;

    @Column(name = "rent",columnDefinition="varchar(20) not null")
    private int rent;

    @Column(name = "useArea",columnDefinition="varchar(20) not null")
    private String useArea;






}
