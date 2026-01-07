package com.dth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DthData {
    private Long id;
    private String name;
    private String description;
    private Object data;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
