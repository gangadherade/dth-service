package com.dth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumpyData {
    private String id;
    private String title;
    private double[] values;
    private String dataType;
    private int shape;
}
