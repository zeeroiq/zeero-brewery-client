/*
 * Created by zeeroiq on 9/8/20, 2:43 AM
 */

package com.shri.zeero.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable {

    private final UUID version = UUID.randomUUID();

    private UUID beerId;
    private String beerName;
    private String style;
    private long upc;
}
