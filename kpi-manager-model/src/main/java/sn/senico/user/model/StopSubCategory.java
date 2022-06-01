package sn.senico.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Bean for Stop sub category
 *
 * @author ibrahima.fall
 */
@Data
public class StopSubCategory {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Date creationDate;
    @ApiModelProperty
    private StopCategory stopCategory;
}
