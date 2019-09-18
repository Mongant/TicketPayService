package com.mongant.ticketpay.repository;

import com.mongant.ticketpay.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class PaymentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    String routeSql = "insert into TICKET.PAYMENT values (?, ?, ?, ?);";
    String refSql = "select * from TICKET.PAYMENT where STATUS = 'PROCESSING'";

    public void getRoute(Route route) {
        jdbcTemplate.update(routeSql, route.getRef(), route.getRouteNum(), route.getDate(), route.getStatus());
    }

    public List<Route> getProcessingRef() {
        return jdbcTemplate.query(refSql, new ReferencesPrcRowMapper());
    }

    private class ReferencesPrcRowMapper implements RowMapper<Route> {
        public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
            Route route = new Route();
            route.setRef(rs.getString("REF"));
            route.setRouteNum(rs.getString("ROUTE_NUM"));
            route.setDate(rs.getDate("DATE"));
            route.setStatus(rs.getString("STATUS"));
            return route;
        }
    }
}
