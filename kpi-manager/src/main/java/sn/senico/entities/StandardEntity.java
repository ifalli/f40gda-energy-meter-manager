package sn.senico.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * The persistent class for the standard database table.
 */
@Data
@Entity
@Table(name = "standard")
@EntityListeners(AuditingEntityListener.class)
@TableGenerator(name = "standardGen", table = "JPA_SEQUENCES", pkColumnName = "SEQ_KEY", valueColumnName = "SEQ_VALUE", pkColumnValue = "standard_id", initialValue = 0, allocationSize = 1)
public class StandardEntity {

    @Id
    @Column(name = "standard_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "standardGen")
    private Long id;
    @Column
    private String name;
    @Column
    private String version;
    @NotNull
    @Column
    private Long speed;
    @NotNull
    @Column(name = "mass_name")
    private String massName;
    @NotNull
    @Column(name = "package_name")
    private String packageName;
    @Column(name = "creation_date")
    private Date creationDate;
}
