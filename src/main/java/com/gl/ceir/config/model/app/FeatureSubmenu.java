package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FeatureSubmenu {
    private static final long serialVersionUID = 1L;
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private Integer featureMenuId;

    private String  link, name,englishName,khmerName;

    //  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    //   @JoinColumn(name = "feature_list_id", nullable = false)
    //  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "featureMenuId")
//    private FeatureMenu featureMenu;

    @Override
    public String toString() {
        return "FeatureList{" +
                "englishName='" + englishName + '\'' +
                ", khmerName='" + khmerName + '\'' +
                ", link='" + link + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
