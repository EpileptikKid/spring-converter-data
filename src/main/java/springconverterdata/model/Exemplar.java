package springconverterdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springconverterdata.config.TestProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "csv_data")
public class Exemplar {

    @Id
    @Column(name = TestProperties.param1)
    private long id;

    @Column(name = TestProperties.param2)
    private String param2;

    @Column(name = TestProperties.param3)
    private String param3;

    @Column(name = TestProperties.param4)
    private String param4;

    @Column(name = TestProperties.param5)
    private String param5;

    @Column(name = TestProperties.param6)
    private String param6;

    @Column(name = TestProperties.param7)
    private String param7;

    @Column(name = TestProperties.param8)
    private String param8;

    @Column(name = TestProperties.param9)
    private String param9;

    @Column(name = TestProperties.param10)
    private String param10;

    @Column(name = TestProperties.param11)
    private String param11;

    @Column(name = TestProperties.param12)
    private String param12;

    @Column(name = TestProperties.param13)
    private String param13;

    @Column(name = TestProperties.param14)
    private String param14;

    @Column(name = TestProperties.param15)
    private String param15;

    @Column(name = TestProperties.param16)
    private String param16;

    @Column(name = TestProperties.param17)
    private String param17;

    @Column(name = TestProperties.param18)
    private String param18;

    @Column(name = TestProperties.param19)
    private String param19;

    @Column(name = TestProperties.param20)
    private String param20;

    @Column(name = TestProperties.param21)
    private String param21;

    @Column(name = TestProperties.param22)
    private String param22;

    @Column(name = TestProperties.param23)
    private String param23;

    @Column(name = TestProperties.param24)
    private String param24;

    @Column(name = TestProperties.param25)
    private String param25;

    @Column(name = TestProperties.param26)
    private String param26;

    @Column(name = TestProperties.param27)
    private String param27;

    @Column(name = TestProperties.param28)
    private String param28;

    @Column(name = TestProperties.param29)
    private String param29;

    @Column(name = TestProperties.param30)
    private String param30;

    public List<String> refactorToCsv() {
        List<String> result = Arrays.asList(
                String.valueOf(this.id),
                this.param2, this.param3, this.param4, this.param5, this.param6, this.param7,
                this.param8, this.param9, this.param10, this.param11, this.param12, this.param13,
                this.param14, this.param15, this.param16, this.param17, this.param18, this.param19,
                this.param20, this.param21, this.param22, this.param23, this.param24, this.param25,
                this.param26, this.param27, this.param28, this.param29, this.param30);
        return result;
    }
}
