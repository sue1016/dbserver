package com.lab.dbserver.Utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class SequenceKeyUtilsTest {

    @Test
    public void genSequenceKey() {
        System.out.println(SequenceKeyUtils.genSequenceKey(new Date(),1));
    }
}