package com.yhp.service;

import com.yhp.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    public Type saveType(Type type);

    public Type getType(Long id);

    //分页查询
    public Page<Type> listType(Pageable pageable);

    public Type updateType(Long id, Type type);

    public void deleteType(Long id, Type Type);
}
