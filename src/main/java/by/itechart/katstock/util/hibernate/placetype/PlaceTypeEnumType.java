package by.itechart.katstock.util.hibernate.placetype;

import by.itechart.katstock.entity.PlaceType;
import by.itechart.katstock.util.hibernate.GenericEnumType;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
public class PlaceTypeEnumType extends GenericEnumType<String, PlaceType> {

    public PlaceTypeEnumType() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        super(PlaceType.class, PlaceType.values(), "getValue", Types.OTHER);
    }
    public Object nullSafeGet(ResultSet resultSet, String[] strings, SessionImplementor sessionImplementor, Object o) throws HibernateException, SQLException {

        return nullSafeGet(resultSet, strings, o);
    }

    public void nullSafeSet(PreparedStatement preparedStatement, Object o, int i, SessionImplementor sessionImplementor) throws HibernateException, SQLException {
        nullSafeSet(preparedStatement, o, i);
    }
}
