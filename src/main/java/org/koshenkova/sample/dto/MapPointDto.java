package org.koshenkova.sample.dto;

import org.koshenkova.sample.domain.MapPoint;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by asus-pc on 29.02.2016.
 */
//@Projection(name = "map_view", types = {MapPoint.class})
public interface MapPointDto {

    String getName();

    String getLink();

}
