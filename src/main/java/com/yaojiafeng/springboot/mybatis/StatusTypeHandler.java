package com.yaojiafeng.springboot.mybatis;

import com.yaojiafeng.springboot.statemachine.OrderStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yaojiafeng
 * @create 2018-01-11 下午2:33
 */
public class StatusTypeHandler extends BaseTypeHandler<OrderStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OrderStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.ordinal());
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return OrderStatus.values()[rs.getInt(columnName)];
    }

    @Override
    public OrderStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return OrderStatus.values()[rs.getInt(columnIndex)];
    }

    @Override
    public OrderStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return OrderStatus.values()[cs.getInt(columnIndex)];
    }

}
