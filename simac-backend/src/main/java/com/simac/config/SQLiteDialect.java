package com.simac.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.query.sqm.function.SqmFunctionRegistry;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.boot.model.TypeContributions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.spi.TypeConfiguration;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
        registerHibernateType(Types.INTEGER, StandardBasicTypes.INTEGER.getName());
        registerHibernateType(Types.VARCHAR, StandardBasicTypes.STRING.getName());
        registerHibernateType(Types.FLOAT, StandardBasicTypes.FLOAT.getName());
        registerHibernateType(Types.DOUBLE, StandardBasicTypes.DOUBLE.getName());
        registerHibernateType(Types.BOOLEAN, StandardBasicTypes.BOOLEAN.getName());
        registerHibernateType(Types.DATE, StandardBasicTypes.DATE.getName());
        registerHibernateType(Types.TIMESTAMP, StandardBasicTypes.TIMESTAMP.getName());
    }

    @Override
    public void initializeFunctionRegistry(SqmFunctionRegistry registry) {
        registry.register("concat", new StandardSQLFunction("concat", StandardBasicTypes.STRING));
        registry.register("mod", new StandardSQLFunction("mod", StandardBasicTypes.INTEGER));
        registry.register("substr", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
        registry.register("substring", new StandardSQLFunction("substr", StandardBasicTypes.STRING));
    }

    @Override
    public void contributeTypes(TypeContributions typeContributions, ServiceRegistry serviceRegistry) {
        final TypeConfiguration typeConfiguration = typeContributions.getTypeConfiguration();
        // Aquí podrías registrar tipos adicionales si es necesario
    }

    @Override
    public boolean supportsIdentityColumns() {
        return true;
    }

    @Override
    public String getIdentityColumnString(int type) {
        return "integer";
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "select last_insert_rowid()";
    }
}
