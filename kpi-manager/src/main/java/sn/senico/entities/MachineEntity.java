package sn.senico.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the machine database table.
 */
@Data
@Entity
@Table(name = "machine")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "machineGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "machine_id", initialValue = 0, allocationSize = 1)
public class MachineEntity {

    @Id
    @Column(name = "machine_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "machineGen")
    private Long id;
    @Column
    private String name;
    @Column
    private String function;
    @Column
    private String description;
    @Column
    private String speed;
    @Column(name = "creation_date")
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resource;
}
