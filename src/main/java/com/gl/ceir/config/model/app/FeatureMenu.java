package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FeatureMenu {
    private static final long serialVersionUID = 1L;
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logo, name,englishName,khmerName;

    @OneToMany(mappedBy = "featureMenuId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<FeatureSubmenu> featureList;

}
