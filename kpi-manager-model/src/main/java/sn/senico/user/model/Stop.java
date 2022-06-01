package sn.senico.user.model;

import java.util.Date;
import javax.validation.Valid;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Data;

/**
 * Bean for Stop
 *
 * @author ibrahima.fall
 */
@Data
public class Stop {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Long id;
    @ApiModelProperty
    private Date startDate;
    @ApiModelProperty
    private Date endDate;
    @ApiModelProperty
    private String description;
    @ApiModelProperty
    private boolean affectBottleneck = true;
    @ApiModelProperty
    private StopSubCategory stopSubCategory;
    @ApiModelProperty
    Machine machine;
}
