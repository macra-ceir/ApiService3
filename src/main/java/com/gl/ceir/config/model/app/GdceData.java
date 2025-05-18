package com.gl.ceir.config.model.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


//@NotNull
//@Size(min = 6, max = 20)
//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).*$", message = "Password must contain at least one digit, one letter, and one special character")
@Setter
@Entity
@Getter

@AllArgsConstructor
@NoArgsConstructor
public class GdceData {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore// not seen in swagger
    private Long id;

    @NotNull

    //  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).*$", message = "Password must contain at least one digit, one letter, and one special character")
    private String imei;

    @NotNull
    private String serial_number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "registration_date")
    //  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime date_of_registration;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime date_of_actual_import;

    @Transient
    private String goods_description;

    @Transient
    private String customs_duty_tax;

    @JsonIgnore
    private int isCustomTaxPaid;

    @Transient   // not in db
    private String device_type;
    @Transient
    private String brand;
    @Transient
    private String model;
    @Transient
    private int sim;

    private int is_used;

    private String importer_id;

    private String importer_name;

//    @JsonIgnore// not seen in swagger
//    private String imei_status;
//    @JsonIgnore// not seen in swagger
//    private String status_remarks;
    @JsonIgnore
    private String actual_imei;
    @JsonIgnore
    private String request_id;
    @JsonIgnore
    private String source;

    @Override
    public String toString() {
        return "{" +
                "importer_name='" + importer_name + '\'' +
                ", importer_id='" + importer_id + '\'' +
                ", is_used=" + is_used +
                ", sim=" + sim +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", device_type='" + device_type + '\'' +
                ", customs_duty_tax='" + customs_duty_tax + '\'' +
                ", goods_description='" + goods_description + '\'' +
                ", date_of_actual_import=" + date_of_actual_import +
                ", date_of_registration=" + date_of_registration +
                ", serial_number='" + serial_number + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }


//    public GdceData(String imei, String serial_number, LocalDateTime date_of_registration, LocalDateTime date_of_actual_import, String goods_description, String customs_duty_tax, String device_type, String brand, String model, int sim, int is_used, String importer_id, String importer_name, String actual_imei, String transaction_id, String source) {
//        this.imei = imei;
//        this.serial_number = serial_number;
//        this.date_of_registration = date_of_registration;
//        this.date_of_actual_import = date_of_actual_import;
//        this.goods_description = goods_description;
//        this.customs_duty_tax = customs_duty_tax;
//        this.device_type = device_type;
//        this.brand = brand;
//        this.model = model;
//        this.sim = sim;
//        this.is_used = is_used;
//        this.importer_id = importer_id;
//        this.importer_name = importer_name;
//        this.actual_imei = actual_imei;
//        this.transaction_id = transaction_id;
//        this.source = source;
//    }
}
