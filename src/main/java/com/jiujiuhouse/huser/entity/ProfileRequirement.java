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

    /**
     * 用户id
     */
    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "profile_name", length = 128)
    private String profileName;//客户姓名

    @Column(name = "profile_phone", length = 11)
    private String profilePhone;//客户电话

    @Column(name = "address_name", length = 512)
    private String addressName;//地址名

    @Column(name = "address_real", length = 512)
    private String addressReal;//实际

    /**
     * 门牌号
     */
    @Column(name = "comment_address", length = 512)
    private String commentAddress;

    /**
     * 价格，单位为 元
     */
    @Column(name = "price")
    private Integer price;

    /**
     * 面积，单位为dm2
     */
    @Column(name = "area")
    private Integer area;

    /**
     * 有房是否提醒
     */
    @Column(name = "notify")
    private Boolean notify;

    /**
     * 用户需求类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "requirement_type")
    private RequirementTypeEnum requirementType = RequirementTypeEnum.BUY;

    public static enum RequirementTypeEnum {
        /**
         * 买房
         */
        BUY,
        /**
         * 租房
         */
        RENT
    }


}
