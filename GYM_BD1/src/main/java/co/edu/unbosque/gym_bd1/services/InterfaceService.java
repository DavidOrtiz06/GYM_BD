package co.edu.unbosque.gym_bd1.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceService <T>{

    T registrar(T t) throws JsonProcessingException;
    List<T> listar();
}
