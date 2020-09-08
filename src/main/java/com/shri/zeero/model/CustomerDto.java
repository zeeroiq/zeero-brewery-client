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
public class CustomerDto implements Serializable {

    private final UUID uid = UUID.randomUUID();

    private UUID customerId;
    private String name;
}
