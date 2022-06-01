package sn.senico.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Bean for Standard
 *
 * @author ibrahima.fall
 */
@Data
public class Standard {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String version;
    @ApiModelProperty
    private Long speed;
    @ApiModelProperty
    private String massName;
    @ApiModelProperty
    private String packageName;
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Date creationDate;
}
