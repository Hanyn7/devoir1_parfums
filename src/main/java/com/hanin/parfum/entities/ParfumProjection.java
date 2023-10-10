package com.hanin.parfum.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomParf", types = { Parfum.class })
public interface ParfumProjection {
public String getNom();
}