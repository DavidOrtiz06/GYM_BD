package co.edu.unbosque.gym_bd1.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface InterfaceService <T, S>{

    T registrar(T t) throws JsonProcessingException;
    List<T> listar() throws JsonProcessingException;
    T actualizar(T t, S id) throws JsonProcessingException;
    void eliminar(T t);
}
