package sn.senico.entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the stopsubcategory database table.
 */
@Data
@Entity
@Table(name = "stopsubcategory")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "stopsubcategoryGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "stopsubcategory_id", initialValue = 0, allocationSize = 1)
public class StopSubCategoryEntity {

    @Id
    @Column(name = "stop_subcategory_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "stopsubcategoryGen")
    private Long id;
    @Column
    private String name;
    @Column(name = "creation_date")
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "stop_category_id")
    private StopCategoryEntity stopCategory;
}
