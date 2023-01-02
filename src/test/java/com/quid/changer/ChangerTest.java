package com.quid.changer;

import java.util.Arrays;
import junny.land.xlsx.builder.Changer;
import junny.land.xlsx.builder.output.Type;
import junny.land.xlsx.builder.type.ExtractType;
import org.junit.jupiter.api.Test;

public class ChangerTest {

    @Test
    public void test() {
        Changer.Companion.create(
                Arrays.asList(new Sample(12, "asd"),
                    new Sample(13, "qwe"))
            ).classType(Sample.class)
            .type(ExtractType.XLSX)
            .name("sample")
            .defaultTemporary()
            .output(Type.FILE)
            .path("C:\\Users\\quid\\Desktop")
            .extract();
    }

}
