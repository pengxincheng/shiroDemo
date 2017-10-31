package com.pxc;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Created by pxc on 2017/10/30.
 */
public class CreateTable {

    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();

        SchemaExport export = new SchemaExport(cfg);

        export.create(true, true);
    }
}
