package com.Cesde.concesionario.Servicio;

import com.Cesde.concesionario.Modelo.MCliente;
import com.Cesde.concesionario.Repositorio.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCliente {
    @Autowired
    ICliente iCliente;

    // Adicionar un registro cliente
    public MCliente adicionarCliente(MCliente mCliente) throws Exception{
        try{
            return this.iCliente.save(mCliente);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general
    // Consulta individual por llave primaria
    // Consulta por el nombre del cliente
    // Consulta de las facturas de un cliente
    // Modificar un registro cliente
    // Eliminar un registro cliente
    // Anular el registro de un cliente
}
