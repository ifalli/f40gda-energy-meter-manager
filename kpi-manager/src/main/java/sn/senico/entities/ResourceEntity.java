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
@Table(name = "resource")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "resourceGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "resource_id", initialValue = 0, allocationSize = 1)
public class ResourceEntity {

    @Id
    @Column(name = "resource_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "resourceGen")
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "creation_date")
    private Date creationDate;
    @OneToOne
    @JoinColumn(name = "machine_bottleneck_id", nullable = true)
    private MachineEntity machineBottleneck;
    @OneToOne
    @JoinColumn(name = "standard_id")
    private StandardEntity standardEntity;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private OfficeEntity office;
    @OneToMany(mappedBy = "resource")
    private List<MachineEntity> machines;
}
