package sn.senico.entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the office database table.
 */
@Data
@Entity
@Table(name = "office")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "officeGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "office_id", initialValue = 0, allocationSize = 1)
public class OfficeEntity {

    @Id
    @Column(name = "office_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "officeGen")
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToMany(mappedBy = "office")
    private List<ResourceEntity> resourceEntities;
    @ManyToOne()
    @JoinColumn(name = "unity_id")
    private UnityEntity unity;
}
