package com.Cesde.concesionario.Servicio;

import com.Cesde.concesionario.Modelo.MCliente;
import com.Cesde.concesionario.Repositorio.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCliente {
    
    private ICliente iCliente;
    private IFactura iFactura;

    //Constructor
    public SCliente(ICliente iCliente, IFactura iFactura){
        this.iCliente = iCliente;
        this.iFactura = iFactura;   
    }
   
    // Adicionar un registro cliente
    public MCliente adicionarCliente(MCliente mCliente) throws Exception{
        try{
            return this.iCliente.save(mCliente);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general
    public List<MCliente> consultaGeneralCli() throws Exception{
        try{
            return this.iCliente.findAll(); // retorna una lista pero eso me lo dice el metodo del JPA no el programador
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    // Consulta individual por llave primaria
    public MCliente consultaIndividualCli(String idcliente) throws Exception{
        try{
            Optional<MCliente> clienteEncontrado = this.iCliente.findById(idcliente);
           if (clienteEncontrado.isPresent()) {
            return clienteEncontrado.get();
           }else{
            throw new Exception("Cliente no encontrado");
           }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    // Consulta por el nombre del cliente
    public List<MCliente> consultaNombreCli(String nomcliente) throws Exception{
        try{
            return this.iCliente.findByNomcliente(nomcliente); 
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    // Consulta de las facturas de un cliente
    public List<FacturasClienteDTO> buscarFacturasCliente(String idcliente) throws Exception{
        try{
            return this.iCliente.buscarFacturasCliente(idcliente);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }   
    // Modificar un registro cliente
    public MCliente modificarCliente(MCliente mCliente, String idCliente) throws Exception{
        try{
            Optional<MCliente> clienteEncontrado = this.iCliente.findById(idCliente);
            if (clienteEncontrado.isPresent()) {
                MCliente clienteNuevo = clienteEncontrado.get();
                clienteNuevo.setIdcliente(idCliente);
                clienteNuevo.setNomcliente(mCliente.getNomcliente());
                clienteNuevo.setDircliente(mCliente.getDircliente());
                clienteNuevo.setTelcliente(mCliente.getTelcliente());
                clienteNuevo.setActivo(mCliente.getActivo());
                return this.iCliente.save(clienteNuevo);
          
            }else 
                throw new Exception("No se puede modificar porque el cliente no esta registrado");
            
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    // Eliminar un registro cliente
    // Anular el registro de un cliente
}
