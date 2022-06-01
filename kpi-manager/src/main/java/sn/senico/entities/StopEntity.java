package sn.senico.entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the stop database table.
 */
@Data
@Entity
@Table(name = "stop")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "stopGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "stop_id", initialValue = 0, allocationSize = 1)
public class StopEntity {

    @Id
    @Column(name = "stop_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "stopGen")
    private Long id;
    @Column(name="start_date" )
    private Date startDate;
    @Column(name="end_date" )
    private Date endDate;
    @Column
    private String description;
    @Column(name = "affect_bottleneck")
    private boolean affectBottleneck = true;
    @ManyToOne
    @JoinColumn(name = "stop_subcategory_id")
    private StopSubCategoryEntity stopSubCategory;
    @ManyToOne
    @JoinColumn(name = "machine_id")
    private  MachineEntity machine;
}
