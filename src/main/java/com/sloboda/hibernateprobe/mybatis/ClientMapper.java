package com.sloboda.hibernateprobe.mybatis;

import com.sloboda.hibernateprobe.entity.article.Client;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClientMapper
{
    void insertUser(Client client);

    Client findUserById(Integer id);

    @Select("select id, first_name, last_name from clients")
    List<Client> findAllClients();
}