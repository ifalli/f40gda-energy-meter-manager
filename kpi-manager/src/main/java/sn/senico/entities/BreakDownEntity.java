package sn.senico.entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the breakdown database table.
 */
@Data
@Entity
@Table(name = "breakdown")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "breakdownGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "breakdown_id", initialValue = 0, allocationSize = 1)
public class BreakDownEntity {

    @Id
    @Column(name = "breakdown_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "breakdownGen")
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "creation_date")
    private Date creationDate;
}
