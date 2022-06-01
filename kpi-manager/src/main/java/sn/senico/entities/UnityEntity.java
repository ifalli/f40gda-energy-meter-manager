package sn.senico.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the unity database table.
 */
@Data
@Entity
@Table(name = "unity")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "unityGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "unity_id", initialValue = 0, allocationSize = 1)
public class UnityEntity {

    @Id
    @Column(name = "unity_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "unityGen")
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToMany(mappedBy = "unity", fetch = FetchType.LAZY)
    private List<OfficeEntity> offices = new ArrayList<>();
}
