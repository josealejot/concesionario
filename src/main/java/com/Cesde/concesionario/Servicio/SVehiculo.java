package com.Cesde.concesionario.Servicio;

import org.springframework.stereotype.Service;

@Service
public class SVehiculo {

    //Adicionar un vehiculo
    public MVehiculo adicionarVehiculo(MVehiculo mVehiculo) throws Exception{
        try{
            return this.iVehi.save(mVehiculo);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }   
    //Consulta general
    public List<MVehiculo> consultaGeneralVeh() throws Exception{
        try{
            return this.iVehi.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Consulta individual
    public MVehiculo consultaIndividualVeh(String idvehiculo) throws Exception{
        try{
            Optional<MVehiculo> vehiculoEncontrado = this.iVehi.findById(idvehiculo);
            if (vehiculoEncontrado.isPresent()) {
                return vehiculoEncontrado.get();
            }else{
                throw new Exception("Vehiculo no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Consulta por marca
    public List<MVehiculo> consultaMarcaVeh(String marca) throws Exception{
        try{
            return this.iVehi.findByMarca(marca);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Consulta por modelo
    public List<MVehiculo> consultaModeloVeh(String modelo) throws Exception{
        try{
            return this.iVehi.findByModelo(modelo);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    //Actualizar un vehiculo
    public MVehiculo modificarVehiculo(MVehiculo mVehiculo, String idVehiculo) throws Exception{
        try{
            Optional<MVehiculo> vehiculoEncontrado = this.iVehi.findById(idVehiculo);
            if (vehiculoEncontrado.isPresent()) {
                MVehiculo vehiculoNuevo = vehiculoEncontrado.get();
                vehiculoNuevo.setIdvehiculo(idVehiculo);
                vehiculoNuevo.setMarca(mVehiculo.getMarca());
                vehiculoNuevo.setModelo(mVehiculo.getModelo());
                vehiculoNuevo.setPrecio(mVehiculo.getPrecio());
                vehiculoNuevo.setActivo(mVehiculo.getActivo());
                return this.iVehi.save(vehiculoNuevo);
          
            }else 
                throw new Exception("No se puede modificar porque el vehiculo no esta registrado");
            
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    


}