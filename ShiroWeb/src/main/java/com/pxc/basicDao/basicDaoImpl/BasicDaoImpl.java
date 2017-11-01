package com.pxc.basicDao.basicDaoImpl;

import com.pxc.basicDao.BasicDao;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;


import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by pxc on 2017/10/31.
 */
public class BasicDaoImpl<T> implements BasicDao<T> {
    @Resource
    private HibernateTemplate hibernateTemplate;

    private Class<T> entityClass;

    public BasicDaoImpl() {
        // 当该类被继承时，它的子类需要初始化T，通过该代码获取T的类型
        entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Serializable save(Object instance) {
        return hibernateTemplate.save(instance);
    }

    public void delete(Object instance) {
        hibernateTemplate.delete(instance);
    }

    public void update(Object instance) {
        hibernateTemplate.update(instance);
    }

    public void saveOrUpdate(Object instance) {
        hibernateTemplate.saveOrUpdate(instance);
    }

    public T findById(Serializable id) {
        return hibernateTemplate.get(entityClass, id);
    }

    public List findAll() {
        String hql = "from " + entityClass.getSimpleName();
        List<T> list = (List<T>) hibernateTemplate.find(hql);
        return list;
    }

    public List findByProperty(String propertyName, Object value) {
        return null;
    }

    public Object uniqueResult(String hql, Object... paras) {
        return hibernateTemplate.executeWithNativeSession(session -> {
            Query query = session.createQuery(hql);
            if (paras != null) {
                for (int i = 0; i < paras.length; i++) {
                    query.setParameter(i, paras[i]);
                }
            }
            return query.uniqueResult();
        });
    }

    public List findByHql(String hql, Object... paras) {
        return hibernateTemplate.find(hql, paras);
    }

    public Integer executeByHql(String hql, Object... paras) {
        return null;
    }

    public List findByHqlInCache(String hql, Object... paras) {
        return null;
    }

    public List findPage(String hql, int maxResult, int firstResult, Object... paras) {
        return hibernateTemplate.execute(session -> {
            Query query = session.createQuery(hql);
            query.setMaxResults(maxResult);
            query.setFirstResult(firstResult);
            if (paras != null) {
                for (int i = 0; i < paras.length; i++) {
                    query.setParameter(i, paras[i]);
                }
            }
            return query.list();
        });
    }

    public List findBySQLQuery(String sql, Object... paras) {
        return null;
    }
}
