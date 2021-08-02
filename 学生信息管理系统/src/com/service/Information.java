package com.service;

import com.jdbc.Jdbc;

import java.sql.Connection;
import java.sql.ResultSet;

public class Information {
        public void information(int id) {
                Jdbc.information(id);
        }
}
