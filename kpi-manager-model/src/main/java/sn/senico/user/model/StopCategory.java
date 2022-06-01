package sn.senico.user.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import sn.senico.user.model.enums.StopTypeEnum;

import java.util.Date;
import java.util.List;
/**
 * Bean for Stop Category
 *
 * @author ibrahima.fall
 */
@Data
public class StopCategory {

    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Long id;
    @ApiModelProperty
    private String name;
    @ApiModelProperty
    private StopTypeEnum stopType;
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private Date creationDate;
    @ApiModelProperty(accessMode = ApiModelProperty.AccessMode.READ_ONLY, readOnly = true)
    private List<StopSubCategory> stopSubCategories;
}
