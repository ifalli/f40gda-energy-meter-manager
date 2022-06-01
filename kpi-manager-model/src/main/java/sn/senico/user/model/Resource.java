package sn.senico.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Bean for Machine
 *
 * @author ibrahima.fall
 */
@Data
public class Resource {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private String description;
    @ApiModelProperty
    private Machine machineBottleneck;
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Date creationDate;
    @ApiModelProperty
    private Standard standardEntity;
    @ApiModelProperty
    private Office office;
}
