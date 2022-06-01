package sn.senico.entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import sn.senico.user.model.enums.StopTypeEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the stop category database table.
 */
@Data
@Entity
@Table(name = "stopcategory")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "stopcategoryGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "stopcategory_id", initialValue = 0, allocationSize = 1)
public class StopCategoryEntity {

    @Id
    @Column(name = "stop_category_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "stopcategoryGen")
    private Long id;
    @Column
    private String name;
    @Column(name = "creation_date")
    private Date creationDate;
    @Enumerated
    @Column(name = "stop_type")
    private StopTypeEnum stopType;

}
