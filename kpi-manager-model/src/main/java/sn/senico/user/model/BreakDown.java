package sn.senico.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Bean for BreakDownEntity
 *
 * @author ibrahima.fall
 */
@Data
public class BreakDown {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String description;
}
