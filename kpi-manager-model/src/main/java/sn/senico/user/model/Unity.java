package sn.senico.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Bean for Unity
 *
 * @author ibrahima.fall
 */
@Data
public class Unity {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String description;
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Date creationDate;

}
