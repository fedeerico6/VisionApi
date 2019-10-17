package com.seminario.apiVision.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiVisionRequest {
    private String clave;
    private String valor;
}
